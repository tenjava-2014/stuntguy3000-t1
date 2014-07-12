package com.tenjava.entries.stuntguy3000.t1;

import com.tenjava.entries.stuntguy3000.t1.handler.AbilityHandler;
import com.tenjava.entries.stuntguy3000.t1.handler.ArrowHandler;
import com.tenjava.entries.stuntguy3000.t1.handler.CommandHandler;
import com.tenjava.entries.stuntguy3000.t1.listener.BowListener;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {

    private TenJava instance;

    private ArrowHandler arrowHandler;
    private CommandHandler commandHandler;
    private AbilityHandler abilityHandler;

    public void onEnable() {
        instance = this;

        registerHandlers();
        registerListeners();
    }

    /**
     * Register all listeners
     */
    private void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new BowListener(this), this);
    }

    public AbilityHandler getAbilityHandler() {
        return abilityHandler;
    }

    /**
     * Initialize all Handlers
     */
    private void registerHandlers() {
        arrowHandler = new ArrowHandler(this);
        commandHandler = new CommandHandler(this);
        abilityHandler = new AbilityHandler(this);

        commandHandler.registerModules();
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

    /**
     * Get the instance of {@link CommandHandler}
     *
     * @return commandHandler
     */
    public CommandHandler getCommandHandler() {
        return commandHandler;
    }
}
