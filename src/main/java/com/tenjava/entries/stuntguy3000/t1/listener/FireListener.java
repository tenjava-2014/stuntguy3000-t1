package com.tenjava.entries.stuntguy3000.t1.listener;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockSpreadEvent;

public class FireListener implements Listener {
    private FireFlight plugin;

    public FireListener(FireFlight instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onBurn(BlockSpreadEvent event) {
        if (plugin.getFireCleanupHandler().isTracked(event.getSource().getLocation())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBurn(BlockBurnEvent event) {
        if (plugin.getFireCleanupHandler().isTracked(event.getBlock().getLocation())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBurn(BlockIgniteEvent event) {
        if (event.getIgnitingBlock() == null) {
            return;
        }

        if (plugin.getFireCleanupHandler().isTracked(event.getIgnitingBlock().getLocation()) || plugin.getFireCleanupHandler().isTracked(event.getBlock().getLocation())) {
            event.setCancelled(true);
        }
    }
}
    