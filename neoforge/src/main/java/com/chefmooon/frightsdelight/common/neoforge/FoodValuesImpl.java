package com.chefmooon.frightsdelight.common.neoforge;

import com.chefmooon.frightsdelight.common.FoodValues;
import com.chefmooon.frightsdelight.common.utility.MobEffectInfo;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.List;

public class FoodValuesImpl {

    public static FoodProperties foodProperty(int nutrition, float saturation, boolean isFast, boolean alwaysEat, List<MobEffectInfo> effects) {
        FoodProperties.Builder builder = new FoodProperties.Builder()
                .nutrition(nutrition)
                .saturationModifier(saturation);

        for (MobEffectInfo effectInfo : effects) {
            builder.effect(() -> new MobEffectInstance(FoodValues.nonNullEffect(effectInfo.effect()), effectInfo.duration()), effectInfo.probability());
        }

        if (isFast) {
            builder.fast();
        }

        if (alwaysEat) {
            builder.alwaysEdible();
        }

        return builder.build();
    }

    public static Holder<MobEffect> getComfort() {
        return ModEffects.COMFORT;
    }

    public static Holder<MobEffect> getNourishment() {
        return ModEffects.NOURISHMENT;
    }
}
