package com.chefmooon.frightsdelight.common.effect;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import net.minecraft.resources.ResourceLocation;
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
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.withDefaultNamespace("effect.slowness"), -0.05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.getCommandSenderWorld().isClientSide() && livingEntity instanceof Player player && player.onGround()) {
            if (new Random().nextInt(400) == 0) {
                player.playNotifySound(FrightsDelightSounds.EFFECT_SLIMED.get(), SoundSource.HOSTILE, 0.3f, 0.6f);
            }
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
