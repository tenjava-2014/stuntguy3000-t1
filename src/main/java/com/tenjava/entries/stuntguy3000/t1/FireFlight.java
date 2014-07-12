package com.tenjava.entries.stuntguy3000.t1;

import com.tenjava.entries.stuntguy3000.t1.command.FireFlightCommand;
import com.tenjava.entries.stuntguy3000.t1.handler.AbilityHandler;
import com.tenjava.entries.stuntguy3000.t1.handler.ArrowHandler;
import com.tenjava.entries.stuntguy3000.t1.handler.ArrowHandlerTask;
import com.tenjava.entries.stuntguy3000.t1.handler.CommandHandler;
import com.tenjava.entries.stuntguy3000.t1.listener.BowListener;
import org.bukkit.plugin.java.JavaPlugin;

public class FireFlight extends JavaPlugin {

    private static FireFlight instance;

    private ArrowHandler arrowHandler;
    private CommandHandler commandHandler;
    private AbilityHandler abilityHandler;

    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        registerHandlers();
        registerListeners();

        this.getCommand("FireFlight").setExecutor(new FireFlightCommand(this));

        new ArrowHandlerTask(this).runTaskTimer(this, 10l, 10l);
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
        abilityHandler.load();
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
     * Get the instance of {@link FireFlight}
     *
     * @return instance
     */
    public static FireFlight getInstance() {
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
