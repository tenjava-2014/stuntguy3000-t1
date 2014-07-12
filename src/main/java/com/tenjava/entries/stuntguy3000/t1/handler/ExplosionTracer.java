package com.tenjava.entries.stuntguy3000.t1.handler;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class ExplosionTracer {
    private FireFlight plugin;

    private List<Location> explosions = new ArrayList<>();

    public ExplosionTracer(FireFlight instance) {
        this.plugin = instance;
    }

    public boolean removeIfTracked(Location location) {
        return explosions.remove(location);
    }

    public void track(Location location) {
        explosions.add(location);
    }
}
    