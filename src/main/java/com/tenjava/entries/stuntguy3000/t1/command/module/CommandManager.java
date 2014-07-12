package com.tenjava.entries.stuntguy3000.t1.command.module;

import com.tenjava.entries.stuntguy3000.t1.TenJava;
import com.tenjava.entries.stuntguy3000.t1.command.SubCommandModule;

import java.util.HashMap;

public class CommandManager {
    private TenJava plugin;

    private HashMap<String, Class<SubCommandModule>> subCommands = new HashMap<>();

    public CommandManager(TenJava instance) {
        this.plugin = instance;
    }

    public void register() {

    }
}
    