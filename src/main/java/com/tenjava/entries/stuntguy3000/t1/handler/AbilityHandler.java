package com.tenjava.entries.stuntguy3000.t1.handler;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.object.Ability;
import com.tenjava.entries.stuntguy3000.t1.object.AbilityType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class AbilityHandler {
    private FireFlight plugin;

    private HashMap<String, AbilityType> bowNames = new HashMap<>();

    public AbilityHandler(FireFlight instance) {
        this.plugin = instance;
    }

    public void load() {
        for (AbilityType type : AbilityType.values()) {
            bowNames.put(ChatColor.GOLD + type.getAbility().getName(), type);
        }
    }

    public AbilityType getAbilityType(final String abilityName) {
        for (AbilityType type : AbilityType.values()) {
            if (abilityName.toUpperCase().equals(type.name())) {
                return type;
            }
        }
        return null;
    }

    /**
     * Parse an Event, deciding if any FireFlight action should occur
     *
     * @param bow item used
     * @param arrow the shot Arrow
     */
    public void parseEvent(ItemStack bow, Arrow arrow) {
        if (bow == null || arrow == null ||
            bow.getItemMeta() == null || !bow.getItemMeta().hasDisplayName()) {
            return;
        }

        ItemMeta itemMeta = bow.getItemMeta();
        String name = ChatColor.stripColor(itemMeta.getDisplayName());

        if (bowNames.containsKey(name.toLowerCase())) {
            Ability ability = bowNames.get(name).getAbility();
            if (ability != null) {
                runAbility(ability, arrow);
            }
        }
    }

    /**
     * Run the specified ability
     *
     * @param ability
     * @param arrow
     */
    private void runAbility(Ability ability, Arrow arrow) {
        if (ability.getAbility() == AbilityType.BURNER) {

        }
    }
}
    