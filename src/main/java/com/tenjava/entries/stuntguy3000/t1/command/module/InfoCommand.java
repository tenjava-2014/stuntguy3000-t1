package com.tenjava.entries.stuntguy3000.t1.command.module;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.command.SubCommandModule;
import com.tenjava.entries.stuntguy3000.t1.object.AbilityType;
import com.tenjava.entries.stuntguy3000.t1.util.Message;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class InfoCommand implements SubCommandModule {
    @Override
    public boolean execute(final CommandSender commandSender, final Command command, final String s, final String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (args.length == 1) {
                String abilityName = args[0];

                AbilityType ability = FireFlight.getInstance().getAbilityHandler().getAbilityType(abilityName);
                if (ability == null) {
                    commandSender.sendMessage(Message.formulateConsole(Message.COMMAND_INFO_INVALID));
                } else {

                }
            } else {
                ItemStack item = p.getItemInHand();

                if (item == null || item.getType() == Material.BOW) {
                    p.sendMessage(Message.formulate(Message.ERROR_INVALID_SYNTAX, s, getName(), getUsage()));
                } else {

                }
            }
        } else {
            if (args.length == 1) {
                String abilityName = args[0];

                AbilityType ability = FireFlight.getInstance().getAbilityHandler().getAbilityType(abilityName);
                if (ability == null) {
                    commandSender.sendMessage(Message.formulateConsole(Message.COMMAND_INFO_INVALID));
                } else {

                }
            } else {
                commandSender.sendMessage(Message.formulateConsole(Message.ERROR_INVALID_SYNTAX, s, getName(), getUsage()));
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getUsage() {
        return "[ability (or hold bow in hand)]";
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
    