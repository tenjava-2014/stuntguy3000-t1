package com.tenjava.entries.stuntguy3000.t1.handler;

import com.tenjava.entries.stuntguy3000.t1.TenJava;
import com.tenjava.entries.stuntguy3000.t1.object.AbilityType;
import org.bukkit.entity.Arrow;

import java.util.HashMap;
import java.util.UUID;

public class ArrowHandler {
    private TenJava plugin;

    private HashMap<UUID, AbilityType> trackedArrows = new HashMap<>();

    public ArrowHandler(TenJava instance) {
        this.plugin = instance;
    }

    public AbilityType getAbility(Arrow arrow) {
        return trackedArrows.remove(arrow.getUniqueId());
    }

    public void addAbility(Arrow arrow, AbilityType ability) {
        trackedArrows.put(arrow.getUniqueId(), ability);
    }
}
    