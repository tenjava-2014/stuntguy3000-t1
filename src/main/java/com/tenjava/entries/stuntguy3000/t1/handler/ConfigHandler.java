package com.tenjava.entries.stuntguy3000.t1.handler;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.util.Config;
import org.bukkit.configuration.ConfigurationSection;

public class ConfigHandler {
    private FireFlight plugin;

    public ConfigHandler(FireFlight instance) {
        this.plugin = instance;
    }

    /**
     * A poor unorganized method used for loading Configuration values
     */
    public void load() {
        ConfigurationSection configuration = plugin.getConfig().getConfigurationSection("abilities");

        ConfigurationSection bomber = configuration.getConfigurationSection("bomber");
        ConfigurationSection confuser = configuration.getConfigurationSection("confuser");
        ConfigurationSection effector = configuration.getConfigurationSection("effector");
        ConfigurationSection hook = configuration.getConfigurationSection("hook");
        ConfigurationSection missile = configuration.getConfigurationSection("missile");
        ConfigurationSection scatter = configuration.getConfigurationSection("scatter");
        ConfigurationSection trail = configuration.getConfigurationSection("trail");

        Config.BOMBER_RELOAD = bomber.getBoolean("reload", true);
        Config.BOMBER_RELOAD_TIME = bomber.getInt("reloadTime", 15);
        Config.CONFUSER_RELOAD = confuser.getBoolean("reload", true);
        Config.CONFUSER_RELOAD_TIME = confuser.getInt("reloadTime", 15);
        Config.EFFECTOR_RELOAD = effector.getBoolean("reload", true);
        Config.EFFECTOR_RELOAD_TIME = effector.getInt("reloadTime", 15);
        Config.HOOK_RELOAD = hook.getBoolean("reload", true);
        Config.HOOK_RELOAD_TIME = hook.getInt("reloadTime", 15);
        Config.MISSILE_RELOAD = missile.getBoolean("reload", true);
        Config.MISSILE_RELOAD_TIME = missile.getInt("reloadTime", 15);
        Config.SCATTER_RELOAD = scatter.getBoolean("reload", true);
        Config.SCATTER_RELOAD_TIME = scatter.getInt("reloadTime", 15);
        Config.SCATTER_ARROWS_SET = scatter.getInt("arrowsSet", 15);
        Config.TRAIL_RELOAD = trail.getBoolean("reload", true);
        Config.TRAIL_RELOAD_TIME = trail.getInt("reloadTime", 15);
        Config.TRAIL_REMOVE_FIRE = trail.getBoolean("removeFire", true);
        Config.TRAIL_REMOVE_FIRE_AFTER = trail.getInt("removeFireAfter", 15);
    }
}
    