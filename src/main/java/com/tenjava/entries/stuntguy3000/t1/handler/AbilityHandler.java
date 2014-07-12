package com.tenjava.entries.stuntguy3000.t1.handler;

import com.tenjava.entries.stuntguy3000.t1.TenJava;
import com.tenjava.entries.stuntguy3000.t1.object.Ability;
import com.tenjava.entries.stuntguy3000.t1.object.AbilityType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class AbilityHandler {
    private TenJava plugin;

    private HashMap<AbilityType, Ability> abilitys = new HashMap<>();
    private HashMap<String, AbilityType> bowNames = new HashMap<>();

    public AbilityHandler(TenJava instance) {
        this.plugin = instance;
    }

    /**
     * Parse an Event, deciding if any FireFlight action should occur
     *
     * @param bow item used
     * @param shooter Player who shot the arrow
     */
    public void parseEvent(ItemStack bow, Arrow arrow) {
        if (bow == null || arrow == null ||
            bow.getItemMeta() == null || !bow.getItemMeta().hasDisplayName()) {
            return;
        }

        ItemMeta itemMeta = bow.getItemMeta();
        String name = ChatColor.stripColor(itemMeta.getDisplayName());

        if (bowNames.containsKey(name.toLowerCase())) {
            Ability ability = getAbility(bowNames.get(name));
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

    }

    /**
     * Get an {@link Ability} from an {@link AbilityType}
     *
     * @param ability {@link AbilityType} to match
     * @return matched {@link Ability}
     */
    public Ability getAbility(AbilityType ability) {
        return abilitys.get(ability);
    }
}
    