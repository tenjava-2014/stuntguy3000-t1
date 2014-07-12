package com.tenjava.entries.stuntguy3000.t1.runnable;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.object.Ability;
import com.tenjava.entries.stuntguy3000.t1.util.Util;
import org.bukkit.Material;
import org.bukkit.World;
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
                Util.getBlockUnderneathLocation(arrow.getLocation()).add(0, 1, 0).getBlock().setType(Material.FIRE);
                Util.getBlockUnderneathLocation(arrow.getLocation().add(1, 0, 0)).add(0, 1, 0).getBlock().setType(Material.FIRE);
                Util.getBlockUnderneathLocation(arrow.getLocation().add(1, 0, 1)).add(0, 1, 0).getBlock().setType(Material.FIRE);
                Util.getBlockUnderneathLocation(arrow.getLocation().add(0, 0, 1)).add(0, 1, 0).getBlock().setType(Material.FIRE);
            }
        }
    }
}
    