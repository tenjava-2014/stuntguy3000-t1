package com.tenjava.entries.stuntguy3000.t1.handler;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.object.Ability;
import com.tenjava.entries.stuntguy3000.t1.util.Config;

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

        // This is a poor way to do it, but it works
        switch (ability) {
            case BOMBER: { if (!Config.BOMBER_RELOAD) return true; break; }
            case CONFUSER: { if (!Config.CONFUSER_RELOAD) return true; break; }
            case EFFECTOR: { if (!Config.EFFECTOR_RELOAD) return true; break; }
            case HOOK: { if (!Config.HOOK_RELOAD) return true; break; }
            case MISSILE: { if (!Config.MISSILE_RELOAD) return true; break; }
            case SCATTER: { if (!Config.SCATTER_RELOAD) return true; break; }
            case TRAIL: { if (!Config.TRAIL_RELOAD) return true; break; }
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
            switch (ability) {
                case BOMBER: { reloadTimes.put(ability, Config.BOMBER_RELOAD_TIME); break; }
                case CONFUSER: { reloadTimes.put(ability, Config.CONFUSER_RELOAD_TIME); break; }
                case EFFECTOR: { reloadTimes.put(ability, Config.EFFECTOR_RELOAD_TIME); break; }
                case HOOK: { reloadTimes.put(ability, Config.HOOK_RELOAD_TIME); break; }
                case MISSILE: { reloadTimes.put(ability, Config.MISSILE_RELOAD_TIME); break; }
                case SCATTER: { reloadTimes.put(ability, Config.SCATTER_RELOAD_TIME); break; }
                case TRAIL: { reloadTimes.put(ability, Config.TRAIL_RELOAD_TIME); break; }
            }
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