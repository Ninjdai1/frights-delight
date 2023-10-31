package com.chefmooon.frightsdelight.effect;

import com.chefmooon.frightsdelight.registry.StatusEffectsRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class InfectedEffect extends StatusEffect {
    public InfectedEffect(int color) {
        super(StatusEffectCategory.HARMFUL, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            if (!player.hasStatusEffect(StatusEffectsRegistry.UNDEAD_HUNGER.get())) {
                ((PlayerEntity)entity).addExhaustion(0.01F * (float)(amplifier + 1));
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int tickDuration, int amplifier) {
        return true;
    }
}
