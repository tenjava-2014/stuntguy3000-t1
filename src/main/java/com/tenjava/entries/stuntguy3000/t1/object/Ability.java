package com.tenjava.entries.stuntguy3000.t1.object;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public enum Ability {
    /**
     * Leaves a trail of fire behind and underneath a shot arrow
     */
    TRAIL(new AbilityHolder(null, "Trail", "Leaves a trail of fire behind an arrow")),

    /**
     * Destroys through blocks
     */
    BURNER(new AbilityHolder(null, "Burner", "Allows arrows to burn through blocks")),

    /**
     * When shot into an entity, the entity is thrown in the direction of the arrow
     */
    HOOK(new AbilityHolder(null, "Hook", "Hooks entities onto an Arrow, making them follow the Arrow's path")),

    /**
     * When used, a configurable amount of arrows are launched in multiple directions
     */
    SCATTER(new AbilityHolder(null, "Scatter", "Launches multiple arrows in a scatter pattern")),

    /**
     * Transfers active potion effects from one player to another on arrow contact
     */
    EFFECTOR(new AbilityHolder(null, "Effector", "Passes on effects from the shooter to the receiver")),

    /**
     * When hit, an explosion occurs.
     */
    MISSILE(new AbilityHolder(null, "Missile", "Makes arrows explosive"));

    AbilityHolder abilityHolder;

    Ability(AbilityHolder type) {
        this.abilityHolder = type;
        abilityHolder.setAbility(this);
    }

    public ItemStack buildBow() {
        ItemStack is = new ItemStack(Material.BOW);
        ItemMeta im = is.getItemMeta();

        im.setDisplayName(ChatColor.GOLD + this.getAbilityHolder().getName());
        im.setLore(Arrays.asList(ChatColor.YELLOW + this.getAbilityHolder().getDescription()));
        is.setItemMeta(im);

        return is;
    }

    public AbilityHolder getAbilityHolder() {
        return abilityHolder;
    }
}
