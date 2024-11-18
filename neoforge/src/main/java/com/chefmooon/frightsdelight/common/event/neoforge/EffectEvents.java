package com.chefmooon.frightsdelight.common.event.neoforge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightEffects;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

@EventBusSubscriber(modid = FrightsDelight.MOD_ID)
public class EffectEvents {

    @SubscribeEvent
    public static void onMobEffectAdded(MobEffectEvent.Added event) {
        if (event.getEffectInstance().getEffect() == FrightsDelightEffects.CHILLS) {
            LivingEntity entity = event.getEntity();
            if (entity instanceof Player player) {
                if (player.hasEffect(FrightsDelightEffects.CHILLS)) {
                    player.displayClientMessage(TextUtils.getTranslatable("effect.chills.start"), true);
                }
            }
        }
    }
}
