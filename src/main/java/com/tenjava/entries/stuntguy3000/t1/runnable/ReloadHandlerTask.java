package com.tenjava.entries.stuntguy3000.t1.runnable;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.object.Ability;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ReloadHandlerTask extends BukkitRunnable {

    private FireFlight plugin;

    public ReloadHandlerTask(FireFlight instance) {
        this.plugin = instance;
    }

    @Override
    public void run() {
        HashMap<UUID, HashMap<Ability, Integer>> reloadTimer = (HashMap<UUID, HashMap<Ability, Integer>>) plugin.getReloadHandler().getAllTimes().clone();

        for (Map.Entry<UUID, HashMap<Ability, Integer>> userReloads : reloadTimer.entrySet()) {
            UUID user = userReloads.getKey();
            HashMap<Ability, Integer> times = userReloads.getValue();
            HashMap<Ability, Integer> timesNew = new HashMap<>();

            for (Map.Entry<Ability, Integer> ability : times.entrySet()) {
                int time = ability.getValue() - 1;
                if (time == 0) {
                    continue;
                }

                timesNew.put(ability.getKey(), time);
            }

            plugin.getReloadHandler().setTimers(user, timesNew);
        }
    }
}
    