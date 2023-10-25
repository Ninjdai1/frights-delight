package com.chefmooon.frightsdelight.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class SlimeWalk extends StatusEffect {
    public SlimeWalk() {
        super(StatusEffectCategory.HARMFUL, 0);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player && player.getHungerManager().getSaturationLevel() > 0.0) {

        }
    }

    @Override
    public boolean canApplyUpdateEffect(int tickDuration, int amplifier) {
        return true;
    }
}
