package com.tenjava.entries.stuntguy3000.t1.handler;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.object.Ability;
import com.tenjava.entries.stuntguy3000.t1.object.AbilityHolder;
import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class AbilityHandler {
    private FireFlight plugin;

    private HashMap<String, Ability> bowNames = new HashMap<>();

    public AbilityHandler(FireFlight instance) {
        this.plugin = instance;
    }

    public void load() {
        for (Ability type : Ability.values()) {
            bowNames.put(type.getAbilityHolder().getName().toLowerCase(), type);
        }
    }

    public Ability getAbilityType(final String abilityName) {
        for (Ability type : Ability.values()) {
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
            AbilityHolder abilityHolder = bowNames.get(name.toLowerCase()).getAbilityHolder();
            if (abilityHolder != null) {
                plugin.getArrowHandler().track(arrow, abilityHolder.getAbility());
                runAbility(abilityHolder, arrow);
            }
        }
    }

    /**
     * Run the specified ability
     *
     * @param abilityHolder
     * @param arrow
     */
    private void runAbility(AbilityHolder abilityHolder, Arrow arrow) {
        if (abilityHolder.getAbility() == Ability.BURNER) {

        }
    }
}
    