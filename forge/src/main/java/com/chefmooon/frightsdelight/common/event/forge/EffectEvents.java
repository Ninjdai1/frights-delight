package com.chefmooon.frightsdelight.common.event.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightEffects;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FrightsDelight.MOD_ID)
public class EffectEvents {

    @SubscribeEvent
    public static void onMobEffectAdded(MobEffectEvent.Added event) {
        if (event.getEffectInstance().getEffect() == FrightsDelightEffects.CHILLS.get()) {
            LivingEntity entity = event.getEntity();
            if (entity instanceof Player player) {
                if (player.hasEffect(FrightsDelightEffects.CHILLS.get())) {
                    player.displayClientMessage(TextUtils.getTranslatable("effect.chills.start"), true);
                }
            }
        }
    }
}
