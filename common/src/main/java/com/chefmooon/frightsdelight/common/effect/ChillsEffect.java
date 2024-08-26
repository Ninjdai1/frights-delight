package com.chefmooon.frightsdelight.common.effect;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightEffects;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
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
        if (livingEntity.hasEffect(FrightsDelightEffects.FORTIFIED_MIND.get())) {
            return;
        }
        if (!livingEntity.getCommandSenderWorld().isClientSide() && livingEntity instanceof Player player) {
            int duration = Objects.requireNonNull(player.getEffect(FrightsDelightEffects.CHILLS.get())).getDuration();
            if (duration == 1) {
                player.displayClientMessage(TextUtils.getTranslatable("effect.chills.end"), true);
            }
            if (duration >= 100) { // Buffer so encounters don't get cut off by the end
                if (new Random().nextInt(800) == 0) {
                    if (new Random().nextInt(50) == 0) {
                        player.displayClientMessage(TextUtils.getTranslatable("effect.chills.encounter"), true);
                    } else {
                        player.displayClientMessage(TextUtils.getTranslatable("effect.chills.chance"), true);
                    }
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
