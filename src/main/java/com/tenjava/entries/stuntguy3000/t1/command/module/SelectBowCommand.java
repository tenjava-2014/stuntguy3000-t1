package com.tenjava.entries.stuntguy3000.t1.command.module;

import com.tenjava.entries.stuntguy3000.t1.command.SubCommandModule;
import com.tenjava.entries.stuntguy3000.t1.object.Ability;
import com.tenjava.entries.stuntguy3000.t1.util.Message;
import com.tenjava.entries.stuntguy3000.t1.util.Perm;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectBowCommand implements SubCommandModule {
    @Override
    public boolean execute(final CommandSender commandSender, final Command command, final String s, final String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            Inventory inventory = Bukkit.createInventory(p, 9, Message.formulateRaw(Message.INVENTORY_TITLE));

            int slot = 0;
            for (Ability ability : Ability.values()) {
                ItemStack display = ability.buildBow();
                ItemMeta meta = display.getItemMeta();
                List<String> lore = meta.getLore();
                if (lore == null) {
                    lore = new ArrayList<>();
                }

                lore.add(ChatColor.AQUA + "---------------");
                lore.add((p.hasPermission(Perm.formulate(Perm.GENERAL_BOW_USE, ability.name().toLowerCase())) ?
                        ChatColor.GREEN + "You can select this Bow." : ChatColor.RED + "You cannot select this Bow."));
                meta.setLore(lore);
                display.setItemMeta(meta);

                inventory.setItem(slot, display);
                slot++;
            }

            p.openInventory(inventory);
        } else {
            commandSender.sendMessage(Message.formulateConsole(Message.ERROR_COMMAND_UNSUPPORTED_CONSOLE));
        }
        return true;
    }

    @Override
    public String getName() {
        return "select";
    }

    @Override
    public String getUsage() {
        return null;
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("sb", "s");
    }

    @Override
    public String getDescription() {
        return "Select a Bow to give to yourself";
    }
}