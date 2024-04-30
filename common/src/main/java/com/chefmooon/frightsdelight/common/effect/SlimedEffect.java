package com.chefmooon.frightsdelight.common.effect;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

import java.util.Random;

public class SlimedEffect extends MobEffect {
    public SlimedEffect() {
        super(MobEffectCategory.HARMFUL, 0x76be6d);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.05, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.getCommandSenderWorld().isClientSide() && livingEntity instanceof Player player && player.onGround() && player.getSpeed() > 0) {
            if (new Random().nextInt(400) == 0) {
                player.playNotifySound(SoundEvents.SLIME_SQUISH, SoundSource.HOSTILE, 0.3f, 0.6f);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
