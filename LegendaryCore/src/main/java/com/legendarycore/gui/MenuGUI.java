package com.legendarycore.gui;

import com.legendarycore.framework.items.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MenuGUI {

    public static void open(Player player) {

        Inventory gui = Bukkit.createInventory(null, 27, "§6Legendary Menu");

        ItemStack border = new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE)
                .name(" ")
                .build();

        for (int i = 0; i < 27; i++) {
            if (i < 9 || i > 17 || i == 9 || i == 17) {
                gui.setItem(i, border);
            }
        }

        gui.setItem(10, new ItemBuilder(Material.RED_BED)
                .name("§a🏠 Homes")
                .build());

        gui.setItem(12, new ItemBuilder(Material.EMERALD)
                .name("§6💰 Sell")
                .build());

        gui.setItem(14, new ItemBuilder(Material.CHEST)
                .name("§b🛒 Shop")
                .build());

        gui.setItem(16, new ItemBuilder(Material.PLAYER_HEAD)
                .name("§e👤 Profile")
                .build());

        if (player.isOp()) {
            gui.setItem(22, new ItemBuilder(Material.NETHER_STAR)
                    .name("§c⚙ Admin Panel")
                    .build());
        }

        gui.setItem(26, new ItemBuilder(Material.BARRIER)
                .name("§4✖ Close")
                .build());

        player.openInventory(gui);
    }
}