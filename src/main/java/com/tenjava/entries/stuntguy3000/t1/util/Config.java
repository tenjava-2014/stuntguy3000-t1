package com.tenjava.entries.stuntguy3000.t1.util;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;

public class Config {
    /**
     * Bomber Configuration Settings
     */
    public static boolean BOMBER_RELOAD = true;
    public static int BOMBER_RELOAD_TIME = 15;

    /**
     * Confuser Configuration Settings
     */
    public static boolean CONFUSER_RELOAD = true;
    public static int CONFUSER_RELOAD_TIME = 15;

    /**
     * Effector Configuration Settings
     */
    public static boolean EFFECTOR_RELOAD = true;
    public static int EFFECTOR_RELOAD_TIME = 15;

    /**
     * Hook Configuration Settings
     */
    public static boolean HOOK_RELOAD = true;
    public static int HOOK_RELOAD_TIME = 15;
    public static double HOOK_VELOCITY_MULTIPLIER = 2.0;

    /**
     * Missile Configuration Settings
     */
    public static boolean MISSILE_BLOCK_DROPS = false;
    public static boolean MISSILE_DAMAGE_BLOCKS = true;
    public static int MISSILE_POWER = 4;
    public static boolean MISSILE_RELOAD = true;
    public static int MISSILE_RELOAD_TIME = 15;

    /**
     * Scatter Configuration Settings
     */
    public static int SCATTER_ARROWS_SET = 2;
    public static boolean SCATTER_RELOAD = true;
    public static int SCATTER_RELOAD_TIME = 15;

    /**
     * Trail Configuration Settings
     */
    public static boolean TRAIL_RELOAD = true;
    public static int TRAIL_RELOAD_TIME = 15;
    public static boolean TRAIL_REMOVE_FIRE = true;
    public static int TRAIL_REMOVE_FIRE_AFTER = 15;

    private FireFlight plugin;

    public Config(FireFlight instance) {
        this.plugin = instance;
    }
}
    