package com.tenjava.entries.stuntguy3000.t1.command;

import com.tenjava.entries.stuntguy3000.t1.TenJava;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FireFlightCommand implements CommandExecutor {
    private TenJava plugin;

    public FireFlightCommand(TenJava instance) {
        this.plugin = instance;
    }

    @Override
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] strings) {
        return false;
    }
}
    