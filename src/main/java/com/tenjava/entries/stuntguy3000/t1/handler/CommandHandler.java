package com.tenjava.entries.stuntguy3000.t1.handler;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.command.SubCommandModule;
import com.tenjava.entries.stuntguy3000.t1.command.module.GiveBowCommand;
import com.tenjava.entries.stuntguy3000.t1.command.module.InfoCommand;
import com.tenjava.entries.stuntguy3000.t1.command.module.SelectBowCommand;

import java.util.*;

public class CommandHandler {
    private FireFlight plugin;

    private HashMap<List<String>, SubCommandModule> subCommands = new HashMap<>();

    public CommandHandler(FireFlight instance) {
        this.plugin = instance;
    }

    public SubCommandModule getModule(final String module) {
        for (Map.Entry<List<String>, SubCommandModule> subCommandModule : subCommands.entrySet()) {
            if (subCommandModule.getKey().contains(module.toLowerCase())) {
                return subCommandModule.getValue();
            }
        }
        return null;
    }

    public Collection<SubCommandModule> getModules() {
        return subCommands.values();
    }

    /**
     * Registers all CommandModules
     */
    public void registerModules() {
        registerModule(new InfoCommand());
        registerModule(new GiveBowCommand());
        registerModule(new SelectBowCommand());
    }

    /**
     * Register a {@link com.tenjava.entries.stuntguy3000.t1.command.SubCommandModule}
     * @param subCommandModule Module to be registered
     */
    private void registerModule(SubCommandModule subCommandModule) {
        if (subCommandModule != null) {
            List<String> validNames = new ArrayList<>();
            if (subCommandModule.getName() != null && !subCommandModule.getName().isEmpty()) {
                validNames.add(subCommandModule.getName().toLowerCase());
            } else {
                throw new IllegalArgumentException("Invalid command module, no name specified!");
            }

            if (subCommandModule.getAliases() != null && !subCommandModule.getAliases().isEmpty()) {
                for (String alias : subCommandModule.getAliases()) {
                    validNames.add(alias.toLowerCase());
                }
            }

            subCommands.put(validNames, subCommandModule);
        }
    }
}
    