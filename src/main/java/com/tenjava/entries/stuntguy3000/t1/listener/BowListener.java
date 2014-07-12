package com.tenjava.entries.stuntguy3000.t1.listener;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class BowListener implements Listener {
    private FireFlight plugin;

    public BowListener(FireFlight instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onFire(EntityShootBowEvent event) {
        if (event.getEntity() instanceof Player && event.getProjectile() instanceof Arrow) {
            Player p = (Player) event.getEntity();
            Arrow arrow = (Arrow) event.getProjectile();

            plugin.getAbilityHandler().parseEvent(event.getBow(), arrow);
        }
    }
}
    