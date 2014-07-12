package com.tenjava.entries.stuntguy3000.t1;

import com.tenjava.entries.stuntguy3000.t1.command.FireFlightCommand;
import com.tenjava.entries.stuntguy3000.t1.handler.*;
import com.tenjava.entries.stuntguy3000.t1.listener.BowListener;
import com.tenjava.entries.stuntguy3000.t1.listener.FireListener;
import com.tenjava.entries.stuntguy3000.t1.listener.InventoryListener;
import com.tenjava.entries.stuntguy3000.t1.listener.ReloadListener;
import com.tenjava.entries.stuntguy3000.t1.runnable.ArrowHandlerTask;
import com.tenjava.entries.stuntguy3000.t1.runnable.FireCleanupHandlerTask;
import com.tenjava.entries.stuntguy3000.t1.runnable.ReloadHandlerTask;
import org.bukkit.plugin.java.JavaPlugin;

public class FireFlight extends JavaPlugin {

    private static FireFlight instance;
    private AbilityHandler abilityHandler;
    private ArrowHandler arrowHandler;
    private CommandHandler commandHandler;
    private ExplosionTracer explosionTracker;
    private FireCleanupHandler fireCleanupHandler;
    private ReloadHandler reloadHandler;

    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        registerHandlers();
        registerListeners();

        this.getCommand("FireFlight").setExecutor(new FireFlightCommand(this));

        new ArrowHandlerTask(this).runTaskTimer(this, 1l, 1l);
        new ReloadHandlerTask(this).runTaskTimer(this, 20l, 20l);
        new FireCleanupHandlerTask(this).runTaskTimer(this, 20l, 20l);
    }

    /**
     * Get the instance of {@link AbilityHandler}
     *
     * @return
     */
    public AbilityHandler getAbilityHandler() {
        return abilityHandler;
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
     * Get the instance of {@link CommandHandler}
     *
     * @return commandHandler
     */
    public CommandHandler getCommandHandler() {
        return commandHandler;
    }

    /**
     * Get the instance of {@link ExplosionTracer}
     *
     * @return
     */
    public ExplosionTracer getExplosionTracker() {
        return explosionTracker;
    }

    /**
     * Get the instance of {@link FireCleanupHandler}
     *
     * @return
     */
    public FireCleanupHandler getFireCleanupHandler() {
        return fireCleanupHandler;
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
     * Get the instance of {@link ReloadHandler}
     *
     * @return
     */
    public ReloadHandler getReloadHandler() {
        return reloadHandler;
    }

    /**
     * Initialize all Handlers
     */
    private void registerHandlers() {
        arrowHandler = new ArrowHandler(this);
        commandHandler = new CommandHandler(this);
        abilityHandler = new AbilityHandler(this);
        explosionTracker = new ExplosionTracer(this);
        reloadHandler = new ReloadHandler(this);
        fireCleanupHandler = new FireCleanupHandler(this);

        commandHandler.registerModules();
        abilityHandler.load();
        reloadHandler.load();
    }

    /**
     * Register all listeners
     */
    private void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new BowListener(this), this);
        this.getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
        this.getServer().getPluginManager().registerEvents(new ReloadListener(this), this);
        this.getServer().getPluginManager().registerEvents(new FireListener(this), this);
    }
}
