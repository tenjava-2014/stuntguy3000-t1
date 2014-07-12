package com.tenjava.entries.stuntguy3000.t1.handler;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.object.Ability;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Arrow;

import java.util.HashMap;
import java.util.UUID;

public class ArrowHandler {
    private FireFlight plugin;

    private HashMap<UUID, Ability> trackedArrows = new HashMap<>();
    private HashMap<UUID, String> trackedArrowWorlds = new HashMap<>();

    public ArrowHandler(FireFlight instance) {
        this.plugin = instance;
    }

    /**
     * Get the AbilityType of a Arrow
     *
     * @param arrow the shot arrow
     * @return the AbilityType of the arrow
     */
    public Ability getAbilityType(Arrow arrow) {
        return trackedArrows.get(arrow.getUniqueId());
    }

    /**
     * Gets the stored world where an UUID (of an Entity) is
     * @param uuid
     * @return
     */
    public World getWorld(final UUID uuid) {
        if (trackedArrowWorlds.containsKey(uuid)) {
            return Bukkit.getWorld(trackedArrowWorlds.get(uuid));
        } else {
            return null;
        }
    }

    /**
     * Enables tracking of an Arrow
     *
     * @param arrow
     * @param ability
     */
    public void track(final Arrow arrow, Ability ability) {
        trackedArrows.put(arrow.getUniqueId(), ability);
        trackedArrowWorlds.put(arrow.getUniqueId(), arrow.getWorld().getName());
    }

    /**
     * Removes tracking of an arrow
     * @param uuid
     */
    public void untrackUUID(UUID uuid) {
        trackedArrows.remove(uuid);
        trackedArrowWorlds.remove(uuid);
    }

    /**
     * Returns a HashMap of all tracked arrows
     * @return
     */
    public HashMap<UUID, Ability> getAllTrackedArrows() {
        return trackedArrows;
    }
}
    