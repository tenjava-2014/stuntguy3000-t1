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

    public void addAbility(Arrow arrow, Ability ability) {
        trackedArrows.put(arrow.getUniqueId(), ability);
        trackedArrowWorlds.put(arrow.getUniqueId(), arrow.getLocation().getWorld().getName());
    }

    public World getWorld(final UUID uuid) {
        if (trackedArrowWorlds.containsKey(uuid)) {
            return Bukkit.getWorld(trackedArrowWorlds.get(uuid));
        } else {
            return null;
        }
    }

    public void track(final Arrow arrow, Ability ability) {

    }

    public void untrackUUID(UUID u) {
        trackedArrows.remove(u);
        trackedArrowWorlds.remove(u);
    }

    public HashMap<UUID, Ability> getAllTrackedArrows() {
        return trackedArrows;
    }

    public void setAllTrackedArrows(HashMap<UUID, Ability> tracked) {
        trackedArrows = tracked;
    }
}
    