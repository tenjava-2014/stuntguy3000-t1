package com.tenjava.entries.stuntguy3000.t1.handler;

import com.tenjava.entries.stuntguy3000.t1.FireFlight;
import com.tenjava.entries.stuntguy3000.t1.object.Ability;
import com.tenjava.entries.stuntguy3000.t1.object.AbilityHolder;
import com.tenjava.entries.stuntguy3000.t1.object.EventType;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.Vector;

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
    public void parseEvent(Arrow arrow, final EventType eventType, Object... extras) {
        if (eventType == EventType.ENTITY_SHOOT_BOW) {
            if (extras != null && extras[0] instanceof ItemStack && extras[1] instanceof Float) {
                ItemStack bow = (ItemStack) extras[0];
                if (arrow == null || bow.getItemMeta() == null || !bow.getItemMeta().hasDisplayName() || !bow.getItemMeta().hasLore()) {
                    return;
                }

                ItemMeta itemMeta = bow.getItemMeta();
                String name = ChatColor.stripColor(itemMeta.getDisplayName());

                if (bowNames.containsKey(name.toLowerCase())) {
                    AbilityHolder abilityHolder = bowNames.get(name.toLowerCase()).getAbilityHolder();
                    if (abilityHolder != null) {
                        if (bow.getItemMeta().getLore().contains(ChatColor.YELLOW + abilityHolder.getDescription())) {
                            plugin.getArrowHandler().track(arrow, abilityHolder.getAbility());
                            runAbility(abilityHolder, arrow, extras);
                        }
                    }
                }
            }
        } else if (eventType == EventType.PROJECTILE_HIT) {
            Ability ability = plugin.getArrowHandler().getAbilityType(arrow);
            if (ability != null) {
                if (ability == Ability.MISSILE) {
                    Location loc = arrow.getLocation();
                    arrow.remove();
                    loc.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 4f, false, true);
                }
            }
        } else if (eventType == EventType.ENTITY_DAMAGE_ARROW) {
            Ability ability = plugin.getArrowHandler().getAbilityType(arrow);
            if (ability != null && ability == Ability.EFFECTOR) {
                if (extras != null && extras[0] instanceof Player) {
                    Player shooter = (Player) arrow.getShooter();
                    Player target = (Player) extras[0];

                    if (shooter.getActivePotionEffects() == null || shooter.getActivePotionEffects().isEmpty()) {
                        return;
                    }

                    List<PotionEffect> shooterPotions = new ArrayList<>(shooter.getActivePotionEffects());
                    for (PotionEffect potionEffect : shooterPotions) {
                        shooter.removePotionEffect(potionEffect.getType());
                        target.addPotionEffect(potionEffect);
                    }
                }
            } else if (ability != null && ability == Ability.HOOK) {
                if (extras != null && extras[0] instanceof Entity) {
                    Entity target = (Entity) extras[0];

                    target.setVelocity(arrow.getVelocity().multiply(2));
                }
            }
        }
    }

    private void runAbility(AbilityHolder abilityHolder, Arrow arrow, Object... extras) {
        if (abilityHolder.getAbility() == Ability.SCATTER) {
            Location location = arrow.getLocation();
            Vector arrowVector = arrow.getVelocity();

            spawnSpreadArrow(arrowVector, arrow, location, (Float) extras[1], 12);
        }
    }

    private void spawnSpreadArrow(final Vector arrowVector, Arrow arrow, final Location location, final float speed, final int spread) {
        location.getWorld().spawnArrow(location, arrowVector.add(arrowVector.multiply(0.15D)), speed, spread);
        location.getWorld().spawnArrow(location, arrowVector.add(arrowVector.multiply(0.20D)), speed, spread);
        location.getWorld().spawnArrow(location, arrowVector.add(arrowVector.multiply(0.25D)), speed, spread);
        location.getWorld().spawnArrow(location, arrowVector.add(arrowVector.multiply(0.30D)), speed, spread);
        location.getWorld().spawnArrow(location, arrowVector.add(arrowVector.multiply(0.35D)), speed, spread);
    }
}
    