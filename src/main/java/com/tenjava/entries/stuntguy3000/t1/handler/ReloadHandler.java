package com.tenjava.entries.stuntguy3000.t1.handler;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.object.Ability;

import java.util.HashMap;
import java.util.UUID;

public class ReloadHandler {
    private FireFlight plugin;

    private HashMap<UUID, HashMap<Ability, Integer>> reloadTimer = new HashMap<>();
    private HashMap<Ability, Integer> reloadTimes = new HashMap<>();

    public ReloadHandler(final FireFlight instance) {
        this.plugin = instance;
    }

    private void addTimer(final UUID user, final Ability ability, final Integer time) {
        HashMap<Ability, Integer> times = reloadTimer.get(user);

        if (times == null) {
            times = new HashMap<>();
        }

        times.put(ability, time);
        reloadTimer.put(user, times);
    }

    /**
     * Check if User can use Ability
     *
     * @param user
     * @param ability
     * @return true if user can, false if they cannot
     */
    public boolean canUse(UUID user, Ability ability) {
        if (!reloadTimes.containsKey(ability)) {
            return true;
        }

        if (!reloadTimer.containsKey(user)) {
            addTimer(user, ability, reloadTimes.get(ability));
            return true;
        } else {
            HashMap<Ability, Integer> times = reloadTimer.get(user);

            if (times.containsKey(ability)) {
                return false;
            } else {
                addTimer(user, ability, reloadTimes.get(ability));
                return true;
            }
        }
    }

    /**
     * Return a Hashmap of all the active reload times
     *
     * @return
     */
    public HashMap<UUID, HashMap<Ability, Integer>> getAllTimes() {
        return reloadTimer;
    }

    /**
     * Returns how many seconds left until the item has reloaded
     *
     * @param uuid
     * @param ability
     * @return
     */
    public int getTimeLeft(final UUID uuid, final Ability ability) {
        return reloadTimer.get(uuid).get(ability);
    }

    /**
     * Loads all Abilitys into the reloadTimes Map
     */
    public void load() {
        for (Ability ability : Ability.values()) {
            reloadTimes.put(ability, 20);
        }
    }

    /**
     * Update the timers map for a User
     *
     * @param user
     * @param timesNew
     */
    public void setTimers(final UUID user, final HashMap<Ability, Integer> timesNew) {
        reloadTimer.put(user, timesNew);
    }
}