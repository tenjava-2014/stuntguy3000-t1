package com.tenjava.entries.stuntguy3000.t1.command.module;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.command.SubCommandModule;
import com.tenjava.entries.stuntguy3000.t1.object.AbilityType;
import com.tenjava.entries.stuntguy3000.t1.util.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class GiveBowCommand implements SubCommandModule {
    @Override
    public boolean execute(final CommandSender commandSender, final Command command, final String s, final String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (args.length == 1) {
                String abilityName = args[0];

                AbilityType ability = FireFlight.getInstance().getAbilityHandler().getAbilityType(abilityName);
            } else {
                p.sendMessage(Message.formulate(Message.ERROR_INVALID_SYNTAX, s, getName(), getUsage()));
            }
        } else {
            commandSender.sendMessage(Message.formulateConsole(Message.ERROR_COMMAND_UNSUPPORTED_CONSOLE));
        }
        return true;
    }

    @Override
    public String getName() {
        return "givebow";
    }

    @Override
    public String getUsage() {
        return "<name>";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("g", "gb", "give", "giveb");
    }

    @Override
    public String getDescription() {
        return "Give yourself a Bow with a Ability attached to it";
    }
}