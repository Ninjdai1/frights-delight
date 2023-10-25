package com.chefmooon.frightsdelight.registry;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.effect.SlimeWalk;
import com.chefmooon.frightsdelight.effect.UndeadHunger;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public enum StatusEffectsRegistry {

    UNDEAD_HUNGER("undead_hunger", new UndeadHunger()),
    SLIME_WALK("slime_walk", new SlimeWalk().addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.05000000596046448, EntityAttributeModifier.Operation.MULTIPLY_TOTAL))
    ;

    private final String pathName;
    private final StatusEffect effect;

    StatusEffectsRegistry(String pathName, StatusEffect effect) {
        this.pathName = pathName;
        this.effect = effect;
    }

    public static void registerAll() {
        for (StatusEffectsRegistry value : values()) {
            Registry.register(Registries.STATUS_EFFECT, new Identifier(FrightsDelight.MOD_ID, value.pathName), value.effect);
        }
    }

    public StatusEffect get() {
        return effect;
    }
}
