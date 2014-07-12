package com.tenjava.entries.stuntguy3000.t1.handler;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.HashMap;

public class FireCleanupHandler {
    private FireFlight plugin;

    private HashMap<Location, Integer> trackedFire = new HashMap<>();

    public FireCleanupHandler(FireFlight instance) {
        this.plugin = instance;
    }

    /**
     * Track fire at the specified location
     * @param l
     * @param timeout
     */
    public void trackFire(Location l, int timeout) {
        trackedFire.put(cleanLocation(l), timeout);
    }

    /**
     * Remove any unwanted fire at loc
     * @param loc
     */
    public void cleanup(final Location loc) {
        if (loc != null && loc.getWorld() != null && loc.getBlock() != null && loc.getBlock().getType() == Material.FIRE) {
            loc.getBlock().setType(Material.AIR);
        }

        trackedFire.remove(loc);
    }

    public HashMap<Location, Integer> getAllTimes() {
        return trackedFire;
    }

    /**
     * Determine if a Location is Tracked
     * @param location
     * @return
     */
    public boolean isTracked(final Location location) {
        return trackedFire.containsKey(cleanLocation(location.clone()));
    }

    public Location cleanLocation(Location original) {
        Location loc = original.clone();
        loc.setX((int) original.getX());
        loc.setY((int) original.getY());
        loc.setZ((int) original.getZ());
        loc.setYaw(0f);
        loc.setPitch(0f);
        return loc.clone();
    }

    /**
     *
     * @param trackedFireUpdated
     */
    public void updateTracked(final HashMap<Location, Integer> trackedFireUpdated) {
        trackedFire = (HashMap<Location, Integer>) trackedFireUpdated.clone();
    }
}
    