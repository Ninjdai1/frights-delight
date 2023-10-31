package com.chefmooon.frightsdelight.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

import java.util.Random;

public class SlimedEffect extends StatusEffect {
    public SlimedEffect(int color) {
        super(StatusEffectCategory.HARMFUL, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player && player.isOnGround()) {
            if (new Random().nextInt(400) == 0) {
                ((PlayerEntity)entity).playSound(SoundEvents.ENTITY_SLIME_SQUISH, SoundCategory.PLAYERS, 0.3f, 0.6f);
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int tickDuration, int amplifier) {
        return true;
    }
}
