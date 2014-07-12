package com.tenjava.entries.stuntguy3000.t1.listener;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.object.Ability;
import com.tenjava.entries.stuntguy3000.t1.util.Message;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener {
    private FireFlight plugin;

    public InventoryListener(FireFlight instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onFire(InventoryClickEvent event) {
        if (event.getInventory().getTitle().equalsIgnoreCase(Message.formulateRaw(Message.INVENTORY_TITLE))) {
            event.setCancelled(true);
            if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.BOW) {
                Ability ability = plugin.getAbilityHandler().getAbilityType(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
                if (ability != null) {
                    ItemStack item = ability.buildBow();
                    event.getWhoClicked().getInventory().addItem(item);
                    event.getWhoClicked().closeInventory();
                }
            }
        }
    }
}
    