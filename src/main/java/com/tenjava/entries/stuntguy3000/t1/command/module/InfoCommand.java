package com.tenjava.entries.stuntguy3000.t1.command.module;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.command.SubCommandModule;
import com.tenjava.entries.stuntguy3000.t1.object.Ability;
import com.tenjava.entries.stuntguy3000.t1.object.AbilityHolder;
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

                Ability ability = FireFlight.getInstance().getAbilityHandler().getAbilityType(abilityName);
                if (ability == null) {
                    commandSender.sendMessage(Message.formulate(Message.COMMAND_INFO_INVALID));
                } else {
                    AbilityHolder abilityHolder = ability.getAbilityHolder();
                    commandSender.sendMessage(Message.formulate(Message.COMMAND_INFO_NAME, abilityHolder.getName()));
                    commandSender.sendMessage(Message.formulate(Message.COMMAND_INFO_DESCRIPTION, abilityHolder.getDescription()));
                }
            } else {
                ItemStack item = p.getItemInHand();

                if (item == null || item.getType() != Material.BOW || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
                    p.sendMessage(Message.formulate(Message.ERROR_INVALID_SYNTAX, s, getName(), getUsage()));
                } else {
                    String name = item.getItemMeta().getDisplayName();
                    Ability ability = FireFlight.getInstance().getAbilityHandler().getAbilityType(name);

                    if (ability == null) {
                        commandSender.sendMessage(Message.formulate(Message.COMMAND_INFO_INVALID));
                    } else {
                        AbilityHolder abilityHolder = ability.getAbilityHolder();
                        commandSender.sendMessage(Message.formulate(Message.COMMAND_INFO_NAME, abilityHolder.getName()));
                        commandSender.sendMessage(Message.formulate(Message.COMMAND_INFO_DESCRIPTION, abilityHolder.getDescription()));
                    }
                }
            }
        } else {
            if (args.length == 1) {
                String abilityName = args[0];

                Ability ability = FireFlight.getInstance().getAbilityHandler().getAbilityType(abilityName);
                if (ability == null) {
                    commandSender.sendMessage(Message.formulateConsole(Message.COMMAND_INFO_INVALID));
                } else {
                    AbilityHolder abilityHolder = ability.getAbilityHolder();
                    commandSender.sendMessage(Message.formulateConsole(Message.COMMAND_INFO_NAME, abilityHolder.getName()));
                    commandSender.sendMessage(Message.formulateConsole(Message.COMMAND_INFO_DESCRIPTION, abilityHolder.getDescription()));
                }
            } else {
                commandSender.sendMessage(Message.formulateConsole(Message.ERROR_INVALID_SYNTAX, s, getName(), getUsage()));
            }
        }
        return false;
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("i", "information");
    }

    @Override
    public String getDescription() {
        return "View the information about an Ability";
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getUsage() {
        return "[ability (or hold bow in hand)]";
    }
}
    