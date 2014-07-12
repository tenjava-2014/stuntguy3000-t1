package com.tenjava.entries.stuntguy3000.t1.object;

import java.util.Arrays;

public enum AbilityType {
    /**
     * Leaves a trail of fire behind and underneath a shot arrow
     */
    TRAIL(new Ability(null, "Trail", Arrays.asList("Leaves a trail of fire behind an arrow"))),

    /**
     * Destroys through blocks
     */
    BURNER(new Ability(null, "Burner", Arrays.asList("Allows arrows to burn through blocks"))),

    /**
     * When shot into an entity, the entity is thrown in the direction of the arrow
     */
    HOOK(new Ability(null, "Hook", Arrays.asList("Hooks entities onto an Arrow, making them follow the Arrow's path"))),

    /**
     * When used, a configurable amount of arrows are launched in multiple directions
     */
    SCATTER(new Ability(null, "Scatter", Arrays.asList("Launches multiple arrows in a scatter pattern"))),

    /**
     * Transfers active potion effects from one player to another on arrow contact
     */
    EFFECTOR(new Ability(null, "Effector", Arrays.asList("Passes on effects from the shooter to the receiver"))),

    /**
     * When hit, an explosion occurs.
     */
    MISSILE(new Ability(null, "Missile", Arrays.asList("Makes arrows explosive")));

    Ability ability;

    AbilityType(Ability type) {
        this.ability = type;
        ability.setAbility(this);
    }
}
