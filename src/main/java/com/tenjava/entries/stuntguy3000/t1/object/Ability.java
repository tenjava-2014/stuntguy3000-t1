package com.tenjava.entries.stuntguy3000.t1.object;

public class Ability {
    private AbilityType ability;
    private String name;
    private String description;

    public Ability(final AbilityType ability, final String name, final String description) {
        this.ability = ability;
        this.name = name;
        this.description = description;
    }

    public AbilityType getAbility() {
        return ability;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setAbility(final AbilityType ability) {
        this.ability = ability;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
    