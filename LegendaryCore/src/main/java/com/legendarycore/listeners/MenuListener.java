package com.legendarycore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (!event.getView().getTitle().equals("§6Legendary Menu")) {
            return;
        }

        event.setCancelled(true);

        if (!(event.getWhoClicked() instanceof Player player)) {
            return;
        }

        if (event.getCurrentItem() == null) {
            return;
        }

        switch (event.getCurrentItem().getType()) {

            case RED_BED:
                player.sendMessage("§aHomes coming soon!");
                break;

            case EMERALD:
                player.sendMessage("§6Sell GUI coming soon!");
                break;

            case CHEST:
                player.closeInventory();
                Bukkit.dispatchCommand(player, "shop");
                break;

            case PLAYER_HEAD:
                player.sendMessage("§eProfile coming soon!");
                break;

            case NETHER_STAR:
                if (player.isOp()) {
                    player.sendMessage("§cAdmin Panel coming soon!");
                }
                break;

            case BARRIER:
                player.closeInventory();
                break;

            default:
                break;
        }
    }
}