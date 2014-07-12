package com.tenjava.entries.stuntguy3000.t1.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public interface SubCommandModule {
    public boolean execute(final CommandSender commandSender, final Command command, final String s, final String[] strings);
    public String getName();
    public String getUsage();
    public List<String> getAliases();
    public String getDescription();
}
    