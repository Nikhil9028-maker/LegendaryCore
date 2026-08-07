package com.legendarycore;

import com.legendarycore.commands.MenuCommand;
import com.legendarycore.database.DatabaseManager;
import com.legendarycore.listeners.MenuListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class LegendaryCore extends JavaPlugin {

    private static LegendaryCore instance;
    private DatabaseManager databaseManager;

    @Override
    public void onEnable() {

        instance = this;

        // Database
        databaseManager = new DatabaseManager();
        databaseManager.connect();

        // Commands
        getCommand("menu").setExecutor(new MenuCommand());

        // Events
        getServer().getPluginManager().registerEvents(new MenuListener(), this);

        getLogger().info("=================================");
        getLogger().info("LegendaryCore Enabled!");
        getLogger().info("=================================");
    }

    @Override
    public void onDisable() {

        if (databaseManager != null) {
            databaseManager.disconnect();
        }

        getLogger().info("LegendaryCore Disabled!");
    }

    public static LegendaryCore getInstance() {
        return instance;
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }
}