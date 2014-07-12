package com.tenjava.entries.stuntguy3000.t1.command;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.util.Message;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FireFlightCommand implements CommandExecutor {
    private FireFlight plugin;

    public FireFlightCommand(FireFlight instance) {
        this.plugin = instance;
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        if (args.length == 0) {
            // Display help menu
            boolean player = (sender instanceof Player);
            if (player) {
                sender.sendMessage(Message.formulate(Message.COMMAND_HELP_TLTE));
                for (SubCommandModule module : plugin.getCommandHandler().getModules()) {
                    sender.sendMessage(Message.formulate(Message.COMMAND_HELP, s, module.getName(), module.getUsage(), module.getDescription()));
                }
            } else {
                sender.sendMessage(Message.formulateConsole(Message.COMMAND_HELP_TLTE));
                for (SubCommandModule module : plugin.getCommandHandler().getModules()) {
                    sender.sendMessage(Message.formulateConsole(Message.COMMAND_HELP, s, module.getName(), module.getUsage(), module.getDescription()));
                }
            }
        } else {
            // Attempt to execute sub-command
            String module = args[0];
            SubCommandModule moduleHandler = plugin.getCommandHandler().getModule(module);

            if (moduleHandler == null) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    p.sendMessage(Message.formulate(Message.ERROR_INVALID_COMMAND));
                } else {
                    sender.sendMessage(Message.formulateConsole(Message.ERROR_INVALID_COMMAND));
                }
            } else {
                return moduleHandler.execute(sender, command, s, (String[]) ArrayUtils.removeElement(args, module));
            }
        }
        return false;
    }
}
    