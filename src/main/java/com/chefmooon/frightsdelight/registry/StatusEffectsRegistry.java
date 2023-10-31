package com.chefmooon.frightsdelight.registry;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.effect.*;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public enum StatusEffectsRegistry {

    FORTIFIED_MIND("fortified_mind", new FortifiedMindEffect(0x66d0e9)),
    CHILLS("chills", new ChillsEffect(0x000000)),
    INFECTED("infected", new InfectedEffect(0x4f8c29)),
    UNDEAD_HUNGER("undead_hunger", new UndeadHungerEffect(0x6f4d1b).addAttributeModifier(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, "7107DE5E-7CE8-4030-940E-514C1F160890", 0.5, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)),
    HYSTERIA("hysteria", new HysteriaEffect(0x5b4538)),
    COBWEBBED("cobwebbed", new CobwebbedEffect(0xe4e9e9).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.05, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)),
    SLIMED("slimed", new SlimedEffect(0x76be6d).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.05, EntityAttributeModifier.Operation.MULTIPLY_TOTAL))
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
