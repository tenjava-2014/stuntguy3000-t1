package com.tenjava.entries.stuntguy3000.t1.listener;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockSpreadEvent;

public class FireListener implements Listener {
    private FireFlight plugin;

    public FireListener(FireFlight instance) {
        this.plugin = instance;
    }

    public void onBurn(BlockSpreadEvent event) {
        if (plugin.getFireCleanupHandler().isTracked(event.getSource().getLocation())) {
            event.setCancelled(true);
        }
    }
}
    