package com.tenjava.entries.stuntguy3000.t1.object;

public class AbilityHolder {
    private Ability ability;
    private String name;
    private String description;

    public AbilityHolder(final Ability ability, final String name, final String description) {
        this.ability = ability;
        this.name = name;
        this.description = description;
    }

    public Ability getAbility() {
        return ability;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setAbility(final Ability ability) {
        this.ability = ability;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
    