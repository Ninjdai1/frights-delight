package com.chefmooon.frightsdelight.effect;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.registry.StatusEffectsRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Random;

public class ChillsEffect extends StatusEffect {
    public ChillsEffect(int color) {
        super(StatusEffectCategory.HARMFUL, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            if (!player.hasStatusEffect(StatusEffectsRegistry.FORTIFIED_MIND.get())) {
                if (new Random().nextInt(800) == 0) {
                    if (new Random().nextInt(50) == 0) {
                        player.sendMessage(FrightsDelight.tooltip("effect.chills.encounter"), true);
                    } else {
                        player.sendMessage(FrightsDelight.tooltip("effect.chills.chance"), true);
                    }
                }
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int tickDuration, int amplifier) {
        return true;
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            player.sendMessage(FrightsDelight.tooltip("effect.chills.end"), true);
        }
        super.onRemoved(entity, attributes, amplifier);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            player.sendMessage(FrightsDelight.tooltip("effect.chills.start"), true);
        }
        super.onApplied(entity, attributes, amplifier);
    }
}
