package com.chefmooon.frightsdelight.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class CobwebbedEffect extends MobEffect {
    public CobwebbedEffect() {
        super(MobEffectCategory.HARMFUL, 0xe4e9e9);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.05, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }
}
