package com.tenjava.entries.stuntguy3000.t1.command.module;

import com.tenjava.entries.stuntguy3000.t1.TenJava;
import com.tenjava.entries.stuntguy3000.t1.command.SubCommandModule;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class InfoCommand implements SubCommandModule {
    private TenJava plugin;

    public InfoCommand(TenJava instance) {
        this.plugin = instance;
    }

    @Override
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] strings) {
        return false;
    }
}
    