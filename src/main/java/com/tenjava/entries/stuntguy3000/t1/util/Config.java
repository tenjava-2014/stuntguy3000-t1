package com.tenjava.entries.stuntguy3000.t1.util;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import org.bukkit.Material;

import java.util.HashMap;

public class Config {
    public static boolean BOMBER_RELOAD = true;
    public static boolean BOMBER_REMOVE_FIRE = true;
    public static HashMap<Material, Integer> BURNER_BLOCK_RESTIANCE = new HashMap<>();
    public static boolean HOOK_RELOAD = true;
    public static int HOOK_TIME = 15;
    public static double HOOK_VELOCITY_MULTIPLIER = 2.0;

    public static boolean MISSILE_BLOCK_DROPS = false;
    public static boolean MISSILE_DAMAGE_BLOCKS = true;
    public static int MISSILE_POWER = 4;

    public static int SCATTER_ARROWS = 5;
    public static boolean SCATTER_RELOAD = true;
    public static int SCATTER_RELOAD_TIME = 15;

    public static boolean TRAIL_RELOAD = true;
    public static boolean TRAIL_REMOVE_FIRE = true;
    public static int TRAIL_REMOVE_FIRE_AFTER = 15;
    public static int TRAIL_TIME = 15;

    private FireFlight plugin;

    public Config(FireFlight instance) {
        this.plugin = instance;
    }
}
    