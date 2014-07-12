package com.tenjava.entries.stuntguy3000.t1.handler;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.object.Ability;
import com.tenjava.entries.stuntguy3000.t1.object.AbilityHolder;
import com.tenjava.entries.stuntguy3000.t1.object.EventType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
     * @param arrow the shot Arrow
     * @param eventType
     */
    public void parseEvent(Arrow arrow, final EventType eventType, Object... otherItem) {
        if (eventType == EventType.ENTITY_SHOOT_BOW) {
            if (otherItem != null && otherItem[0] instanceof ItemStack) {
                ItemStack bow = (ItemStack) otherItem[0];
                if (arrow == null || bow.getItemMeta() == null || !bow.getItemMeta().hasDisplayName()) {
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
        } else if (eventType == EventType.PROJECTILE_HIT) {
            Ability ability = plugin.getArrowHandler().getAbilityType(arrow);
            if (ability != null) {

            }
        } else if (eventType == EventType.ENTITY_DAMAGE_ARROW) {
            Ability ability = plugin.getArrowHandler().getAbilityType(arrow);
            if (ability != null && ability == Ability.EFFECTOR) {
                if (otherItem != null && otherItem[0] instanceof Player) {
                    Player shooter = (Player) arrow.getShooter();
                    Player target = (Player) otherItem[0];

                    if (shooter.getActivePotionEffects() == null || shooter.getActivePotionEffects().isEmpty()) {
                        return;
                    }

                    List<PotionEffect> shooterPotions = new ArrayList<>(shooter.getActivePotionEffects());
                    for (PotionEffect potionEffect : shooterPotions) {
                        shooter.removePotionEffect(potionEffect.getType());
                        target.addPotionEffect(potionEffect);
                    }
                }
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
    