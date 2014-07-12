package com.tenjava.entries.stuntguy3000.t1.listener;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.object.Ability;
import com.tenjava.entries.stuntguy3000.t1.util.Message;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ReloadListener implements Listener {
    private FireFlight plugin;

    public ReloadListener(FireFlight instance) {
        this.plugin = instance;
    }

    // Note: It is set to Lowest, as it will fire FIRST
    //       Which is clearly important for a Reload manager
    @EventHandler(priority = EventPriority.LOWEST)
    public void onBowInteract(PlayerInteractEvent event) {
        if (event.getItem() != null && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            if (event.getItem().getType() == Material.BOW && event.getItem().hasItemMeta() && event.getItem().getItemMeta().hasDisplayName() && event.getItem().getItemMeta().hasLore()) {
                String name = event.getItem().getItemMeta().getDisplayName();
                Ability ability = plugin.getAbilityHandler().getAbilityType(ChatColor.stripColor(name));
                if (ability != null) {
                    // It's a match!
                    Player p = event.getPlayer();
                    if (!plugin.getReloadHandler().canUse(p.getUniqueId(), ability)) {
                        p.sendMessage(Message.formulate(Message.ERROR_COOLDOWN, plugin.getReloadHandler().getTimeLeft(p.getUniqueId(), ability)));
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
    