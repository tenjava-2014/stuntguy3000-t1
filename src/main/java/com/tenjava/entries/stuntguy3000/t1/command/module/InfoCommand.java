package com.tenjava.entries.stuntguy3000.t1.command.module;

import com.tenjava.entries.stuntguy3000.t1.command.SubCommandModule;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class InfoCommand implements SubCommandModule {
    @Override
    public boolean execute(final CommandSender commandSender, final Command command, final String s, final String[] strings) {
        return false;
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getUsage() {
        return "[ability]";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("i", "information");
    }

    @Override
    public String getDescription() {
        return "View the information about an Ability";
    }
}
    