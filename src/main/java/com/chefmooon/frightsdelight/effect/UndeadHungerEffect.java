package com.chefmooon.frightsdelight.effect;

import com.chefmooon.frightsdelight.registry.StatusEffectsRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class UndeadHungerEffect extends StatusEffect {
    public UndeadHungerEffect(int color) {
        super(StatusEffectCategory.NEUTRAL, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            if (player.hasStatusEffect(StatusEffectsRegistry.INFECTED.get())) {
                player.removeStatusEffect(StatusEffectsRegistry.INFECTED.get());
            } else if (player.hasStatusEffect(StatusEffects.HUNGER)) {
                player.removeStatusEffect(StatusEffects.HUNGER);
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int tickDuration, int amplifier) {
        return true;
    }
}
