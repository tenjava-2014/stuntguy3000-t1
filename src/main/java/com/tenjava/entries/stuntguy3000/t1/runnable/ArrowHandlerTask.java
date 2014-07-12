package com.tenjava.entries.stuntguy3000.t1.runnable;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.object.Ability;
import com.tenjava.entries.stuntguy3000.t1.util.Util;
import org.bukkit.*;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ArrowHandlerTask extends BukkitRunnable {
    private FireFlight plugin;

    public ArrowHandlerTask(FireFlight instance) {
        this.plugin = instance;
    }

    @Override
    public void run() {
        HashMap<UUID, Ability> arrowMapUpdated = (HashMap<UUID, Ability>) plugin.getArrowHandler().getAllTrackedArrows().clone();
        for (Map.Entry<UUID, Ability> arrowMap : arrowMapUpdated.entrySet()) {
            UUID uuid = arrowMap.getKey();
            Ability ability = arrowMap.getValue();
            World world = plugin.getArrowHandler().getWorld(uuid);
            Arrow arrow = null;

            if (world == null || uuid == null) {
                plugin.getArrowHandler().untrackUUID(uuid);
                continue;
            }

            for (Entity e : world.getEntities()) {
                if (uuid == e.getUniqueId() && e instanceof Arrow) {
                    arrow = (Arrow) e;
                }
            }

            if (arrow == null || ability == null) {
                plugin.getArrowHandler().untrackUUID(uuid);
                continue;
            }

            if (ability == Ability.TRAIL) {
                Location one = Util.getBlockUnderneathLocation(arrow.getLocation()).add(0, 1, 0);
                Location two = Util.getBlockUnderneathLocation(arrow.getLocation()).add(1, 1, 0);
                Location three = Util.getBlockUnderneathLocation(arrow.getLocation()).add(0, 1, 1);
                Location four = Util.getBlockUnderneathLocation(arrow.getLocation()).add(1, 1, 1);

                one.getBlock().setType(Material.FIRE);
                two.getBlock().setType(Material.FIRE);
                three.getBlock().setType(Material.FIRE);
                four.getBlock().setType(Material.FIRE);

                world.playEffect(arrow.getLocation(), Effect.MOBSPAWNER_FLAMES, 10);
                world.playEffect(arrow.getLocation().add(3, 0, 3), Effect.MOBSPAWNER_FLAMES, 10);
                world.playEffect(arrow.getLocation().add(3, 0, 0), Effect.MOBSPAWNER_FLAMES, 10);
                world.playEffect(arrow.getLocation().add(0, 0, 3), Effect.MOBSPAWNER_FLAMES, 10);
            } else if (ability == Ability.BOMBER) {
                world.playEffect(arrow.getLocation(), Effect.SMOKE, 5);
                world.playEffect(arrow.getLocation(), Effect.SMOKE, 10);
                world.playEffect(arrow.getLocation(), Effect.SMOKE, 15);
                world.playEffect(arrow.getLocation(), Effect.SMOKE, 5);
                world.playEffect(arrow.getLocation(), Effect.SMOKE, 10);
                world.playEffect(arrow.getLocation(), Effect.SMOKE, 15);
            } else if (ability == Ability.CONFUSER) {
                world.playSound(arrow.getLocation(), Sound.NOTE_PLING, 2F, 1.5F);
                world.playSound(arrow.getLocation(), Sound.NOTE_PLING, 2F, 1F);
                world.playSound(arrow.getLocation(), Sound.NOTE_PLING, 2F, 0.5F);
            }

            if (arrow.isDead() || arrow.isOnGround()) {
                arrow.remove();
                plugin.getArrowHandler().untrackUUID(uuid);
            }
        }
    }
}
    