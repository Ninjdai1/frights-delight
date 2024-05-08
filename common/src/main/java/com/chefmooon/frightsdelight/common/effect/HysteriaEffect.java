package com.chefmooon.frightsdelight.common.effect;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightEffects;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class HysteriaEffect extends MobEffect {
    public HysteriaEffect() {
        super(MobEffectCategory.HARMFUL, 0x5b4538);
    }

    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.getCommandSenderWorld().isClientSide() && livingEntity instanceof Player player) {
            if (!player.hasEffect(FrightsDelightEffects.FORTIFIED_MIND.get())) {
                Random random = new Random();
                int soundChance = 200 - player.getFoodData().getFoodLevel() * 5;
                if (random.nextInt(soundChance) == 0) {
                    int distance = random.nextInt(3);
                    Vec3 pos = player.position();
                    if (distance == 0) {
                        double range = 4;
                        double dx = pos.x() + ((random.nextDouble() * range) - range / 2);
                        double dy = pos.y() + 1;
                        double dz = pos.z() + ((random.nextDouble() * range) - range / 2);
                        player.playNotifySound(FrightsDelightSounds.EFFECT_HYSTERIA_CLOSE.get(), SoundSource.HOSTILE, 0.2f, 0.6f);
                    } else if (distance == 1) {
                        double range = 8;
                        double dx = pos.x() + ((random.nextDouble() * range) - range / 2);
                        double dy = pos.y() + 1;
                        double dz = pos.z() + ((random.nextDouble() * range) - range / 2);
                        player.playNotifySound(FrightsDelightSounds.EFFECT_HYSTERIA_MID.get(), SoundSource.HOSTILE, 0.2f, 0.6f);
                    } else{
                        double range = 16;
                        double dx = pos.x() + ((random.nextDouble() * range) - range / 2);
                        double dy = pos.y() + 1;
                        double dz = pos.z() + ((random.nextDouble() * range) - range / 2);
                        player.playNotifySound(FrightsDelightSounds.EFFECT_HYSTERIA_FAR.get(), SoundSource.HOSTILE, 0.2f, 0.6f);
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
