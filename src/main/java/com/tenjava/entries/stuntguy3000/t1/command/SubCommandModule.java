package com.tenjava.entries.stuntguy3000.t1.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface SubCommandModule {
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] strings);
}
    