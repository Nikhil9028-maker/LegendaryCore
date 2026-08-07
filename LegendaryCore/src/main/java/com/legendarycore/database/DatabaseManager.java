package com.legendarycore.database;

import com.legendarycore.LegendaryCore;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private Connection connection;

    public void connect() {

        try {

            File folder = LegendaryCore.getInstance().getDataFolder();

            if (!folder.exists()) {
                folder.mkdirs();
            }

            File database = new File(folder, "legendarycore.db");

            connection = DriverManager.getConnection("jdbc:sqlite:" + database.getAbsolutePath());

            LegendaryCore.getInstance().getLogger().info("SQLite connected!");

            createTables();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTables() {

        try (Statement statement = connection.createStatement()) {

            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS homes(
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        uuid TEXT NOT NULL,
                        name TEXT NOT NULL,
                        world TEXT NOT NULL,
                        x REAL,
                        y REAL,
                        z REAL,
                        yaw REAL,
                        pitch REAL
                    );
                    """);

            LegendaryCore.getInstance().getLogger().info("Homes table loaded!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {

        try {

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}