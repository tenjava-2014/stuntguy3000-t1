package com.tenjava.entries.stuntguy3000.t1.object;

import java.util.List;

public class Ability {
    private AbilityType ability;
    private String name;
    private List<String> description;

    public Ability(final AbilityType ability, final String name, final List<String> description) {
        this.ability = ability;
        this.name = name;
        this.description = description;
    }

    public AbilityType getAbility() {
        return ability;
    }

    public List<String> getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setAbility(final AbilityType ability) {
        this.ability = ability;
    }

    public void setDescription(final List<String> description) {
        this.description = description;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
    