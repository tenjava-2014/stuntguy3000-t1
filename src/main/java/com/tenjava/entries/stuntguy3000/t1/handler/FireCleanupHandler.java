package com.tenjava.entries.stuntguy3000.t1.handler;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.HashMap;

public class FireCleanupHandler {
    private FireFlight plugin;

    private HashMap<Location, Integer> fire = new HashMap<>();

    public FireCleanupHandler(FireFlight instance) {
        this.plugin = instance;
    }

    public void trackFire(Location l, int timeout) {
        fire.put(l.clone(), timeout);
    }

    public void cleanup(final Location loc) {
        if (loc != null && loc.getWorld() != null && loc.getBlock() != null && loc.getBlock().getType() == Material.FIRE) {
            loc.getBlock().setType(Material.AIR);
        }

        fire.remove(loc);
    }

    public HashMap<Location, Integer> getAllTimes() {
        return fire;
    }

    public boolean isTracked(final Location location) {
        return fire.containsKey(location.clone());
    }
}
    