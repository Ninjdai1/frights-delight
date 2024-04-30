package com.chefmooon.frightsdelight.common.fabric;

import com.chefmooon.frightsdelight.common.FoodValues;
import com.chefmooon.frightsdelight.common.utility.MobEffectInfo;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

import java.util.List;

public class FoodValuesImpl {

    public static FoodProperties foodProperty(int nutrition, float saturation, boolean isMeat, boolean isFast, boolean alwaysEat, List<MobEffectInfo> effects) {
        FoodProperties.Builder builder = new FoodProperties.Builder()
                .nutrition(nutrition)
                .saturationMod(saturation);

        for (MobEffectInfo effectInfo : effects) {
            builder.effect(new MobEffectInstance(FoodValues.nonNullEffect(effectInfo.getEffect()), effectInfo.getDuration()), effectInfo.getProbability());
        }

        if (isMeat) {
            builder.meat();
        }

        if (isFast) {
            builder.fast();
        }

        if (alwaysEat) {
            builder.alwaysEat();
        }

        return builder.build();
    }
}
