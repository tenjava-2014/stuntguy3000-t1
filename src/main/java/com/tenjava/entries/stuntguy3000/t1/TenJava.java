package com.tenjava.entries.stuntguy3000.t1;

import com.tenjava.entries.stuntguy3000.t1.handler.ArrowHandler;
import com.tenjava.entries.stuntguy3000.t1.handler.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {

    private TenJava instance;

    private ArrowHandler arrowHandler;
    private CommandHandler commandHandler;

    public void onEnable() {
        instance = this;

        registerHandlers();
    }

    /**
     * Initialize all Handlers
     */
    private void registerHandlers() {
        arrowHandler = new ArrowHandler(this);
        commandHandler = new CommandHandler(this);

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
