package com.tenjava.entries.stuntguy3000.t1.listener;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.object.EventType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

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

            plugin.getAbilityHandler().parseEvent(arrow, EventType.ENTITY_SHOOT_BOW, event.getBow(), event.getForce());
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getEntity();

            plugin.getAbilityHandler().parseEvent(arrow, EventType.PROJECTILE_HIT);
        }
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        if (event.getEntity() != null && event.getDamager() instanceof Arrow && ((Arrow) event.getDamager()).getShooter() instanceof Player) {
            Arrow arrow = (Arrow) event.getDamager();

            plugin.getAbilityHandler().parseEvent(arrow, EventType.ENTITY_DAMAGE_ARROW, event.getEntity());
        }
    }

    @EventHandler
    public void onExplode(EntityExplodeEvent event) {
        Bukkit.broadcastMessage(event.getEntityType().name());
    }
}
    