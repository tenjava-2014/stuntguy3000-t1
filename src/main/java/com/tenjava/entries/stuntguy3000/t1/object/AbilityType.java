package com.tenjava.entries.stuntguy3000.t1.object;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum AbilityType {
    /**
     * Leaves a trail of fire behind and underneath a shot arrow
     */
    TRAIL(new Ability(null, "Trail", "Leaves a trail of fire behind an arrow")),

    /**
     * Destroys through blocks
     */
    BURNER(new Ability(null, "Burner", "Allows arrows to burn through blocks")),

    /**
     * When shot into an entity, the entity is thrown in the direction of the arrow
     */
    HOOK(new Ability(null, "Hook", "Hooks entities onto an Arrow, making them follow the Arrow's path")),

    /**
     * When used, a configurable amount of arrows are launched in multiple directions
     */
    SCATTER(new Ability(null, "Scatter", "Launches multiple arrows in a scatter pattern")),

    /**
     * Transfers active potion effects from one player to another on arrow contact
     */
    EFFECTOR(new Ability(null, "Effector", "Passes on effects from the shooter to the receiver")),

    /**
     * When hit, an explosion occurs.
     */
    MISSILE(new Ability(null, "Missile", "Makes arrows explosive"));

    Ability ability;

    AbilityType(Ability type) {
        this.ability = type;
        ability.setAbility(this);
    }

    public ItemStack buildBow() {
        ItemStack is = new ItemStack(Material.BOW);
        ItemMeta im = is.getItemMeta();

        im.setDisplayName(ChatColor.GOLD + this.getAbility().getName());
        is.setItemMeta(im);

        return is;
    }

    public Ability getAbility() {
        return ability;
    }
}
