package com.tenjava.entries.stuntguy3000.t1.handler;

import com.tenjava.entries.stuntguy3000.t1.TenJava;
import com.tenjava.entries.stuntguy3000.t1.object.BowAbility;
import org.bukkit.entity.Arrow;

import java.util.HashMap;
import java.util.UUID;

public class ArrowHandler {
    private TenJava plugin;

    private HashMap<UUID, BowAbility> trackedArrows = new HashMap<>();

    public ArrowHandler(TenJava instance) {
        this.plugin = instance;
    }

    public BowAbility getAbility(Arrow arrow) {
        return trackedArrows.remove(arrow.getUniqueId());
    }

    public void addAbility(Arrow arrow, BowAbility ability) {
        trackedArrows.put(arrow.getUniqueId(), ability);
    }
}
    