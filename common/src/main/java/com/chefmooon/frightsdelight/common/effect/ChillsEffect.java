package com.chefmooon.frightsdelight.common.effect;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.Objects;
import java.util.Random;

public class ChillsEffect extends MobEffect {
    public ChillsEffect() {
        super(MobEffectCategory.HARMFUL, 0x000000);
    }

    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.getCommandSenderWorld().isClientSide() && livingEntity instanceof Player player) {
            if (!player.hasEffect(FrightsDelightEffects.FORTIFIED_MIND.get())) {
                if (new Random().nextInt(800) == 0) {
                    if (new Random().nextInt(50) == 0) {
                        player.displayClientMessage(FrightsDelight.tooltip("effect.chills.encounter"), true);
                    } else {
                        player.displayClientMessage(FrightsDelight.tooltip("effect.chills.chance"), true);
                    }
                }
            }
            if (player.hasEffect(FrightsDelightEffects.CHILLS.get())) {
                int duration = Objects.requireNonNull(player.getEffect(FrightsDelightEffects.CHILLS.get())).getDuration();
                if (duration == 600) {
                    player.displayClientMessage(FrightsDelight.tooltip("effect.chills.start"), true);
                }
                if (duration == 1) {
                    player.displayClientMessage(FrightsDelight.tooltip("effect.chills.end"), true);
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
