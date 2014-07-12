package com.tenjava.entries.stuntguy3000.t1.runnable;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class FireCleanupHandlerTask extends BukkitRunnable {

    private FireFlight plugin;

    public FireCleanupHandlerTask(FireFlight instance) {
        this.plugin = instance;
    }

    @Override
    public void run() {
        HashMap<Location, Integer> cleanupTimer = (HashMap<Location, Integer>) plugin.getFireCleanupHandler().getAllTimes().clone();
        HashMap<Location, Integer> stillBurning = new HashMap<>();
        for (Map.Entry<Location, Integer> cleanupSet : cleanupTimer.entrySet()) {
            Location loc = cleanupSet.getKey();
            int time = cleanupSet.getValue() - 1;

            if (time == 0) {
                plugin.getFireCleanupHandler().cleanup(loc);
            } else {
                stillBurning.put(loc, time);
            }
        }

        plugin.getFireCleanupHandler().updateTracked(stillBurning);
    }
}
    