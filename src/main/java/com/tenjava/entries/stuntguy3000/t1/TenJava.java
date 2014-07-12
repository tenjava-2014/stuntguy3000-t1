package com.tenjava.entries.stuntguy3000.t1;

import com.tenjava.entries.stuntguy3000.t1.handler.ArrowHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {

    private TenJava instance;

    private ArrowHandler arrowHandler;

    public void onEnable() {
        instance = this;
    }

    /**
     * Get the instance of {@link ArrowHandler}
     *
     * @return arrowHandler
     */
    public ArrowHandler getArrowHandler() {
        return arrowHandler;
    }

    /**
     * Get the instance of {@link TenJava}
     *
     * @return instance
     */
    public TenJava getInstance() {
        return instance;
    }
}
