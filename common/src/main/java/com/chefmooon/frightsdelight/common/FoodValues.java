package com.chefmooon.frightsdelight.common;


import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.utility.MobEffectInfo;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

import java.util.List;

public class FoodValues {
    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes

    private static final MobEffect COMFORT = BuiltInRegistries.MOB_EFFECT.get(new ResourceLocation("farmersdelight", "comfort"));
    private static final MobEffect NOURISHMENT = BuiltInRegistries.MOB_EFFECT.get(new ResourceLocation("farmersdelight", "nourishment"));

    private static final MobEffect FORTIFIED_MIND = BuiltInRegistries.MOB_EFFECT.get(FrightsDelight.res("fortified_mind"));
    private static final MobEffect CHILLS = BuiltInRegistries.MOB_EFFECT.get(FrightsDelight.res("chills"));
    private static final MobEffect INFECTED = BuiltInRegistries.MOB_EFFECT.get(FrightsDelight.res("infected"));
    private static final MobEffect UNDEAD_HUNGER = BuiltInRegistries.MOB_EFFECT.get(FrightsDelight.res("undead_hunger"));
    private static final MobEffect HYSTERIA = BuiltInRegistries.MOB_EFFECT.get(FrightsDelight.res("hysteria"));
    private static final MobEffect COBWEBBED = BuiltInRegistries.MOB_EFFECT.get(FrightsDelight.res("cobwebbed"));
    private static final MobEffect SLIMED = BuiltInRegistries.MOB_EFFECT.get(FrightsDelight.res("slimed"));

    public static final FoodProperties SOUL_BERRY = foodProperty(2, 0.4f,
            List.of(new MobEffectInfo(FORTIFIED_MIND, BRIEF_DURATION, 1.f)));

    public static final FoodProperties WITHER_BERRY = foodProperty(2, 0.4f,
            List.of(new MobEffectInfo(UNDEAD_HUNGER, BRIEF_DURATION, 1.f),
                    new MobEffectInfo(HYSTERIA, BRIEF_DURATION,  1.f)));

    public static final FoodProperties APPLE_SLIME = foodProperty(5, 0.4f,
            List.of(new MobEffectInfo(SLIMED, BRIEF_DURATION, 1.f)));

    public static final FoodProperties UNDEAD_KEBAB = foodProperty(7, 0.6f,true, false, false,
            List.of(new MobEffectInfo(INFECTED, BRIEF_DURATION, .8f),
                    new MobEffectInfo(HYSTERIA, BRIEF_DURATION, .8f)));

    public static final FoodProperties WEB_ON_STICK = foodProperty(6, 0.5f,
            List.of(new MobEffectInfo(COBWEBBED, BRIEF_DURATION, .8f)));

    public static final FoodProperties MONSTER_MASH = foodProperty(10, 0.6f, true, false, false,
            List.of(new MobEffectInfo(INFECTED, MEDIUM_DURATION, .5f),
                    new MobEffectInfo(NOURISHMENT, LONG_DURATION, 1.f)));
    public static final FoodProperties PASTA_WITH_SLIMEBALLS = foodProperty(10, 0.6f,
            List.of(new MobEffectInfo(SLIMED, MEDIUM_DURATION, .5f),
                    new MobEffectInfo(NOURISHMENT, LONG_DURATION, 1.f)));
    public static final FoodProperties SOUP_ROTTEN_FLESH = foodProperty(8, 0.7f, true, false, false,
            List.of(new MobEffectInfo(INFECTED, MEDIUM_DURATION, .5f),
                    new MobEffectInfo(COMFORT, LONG_DURATION, 1.f)));
    public static final FoodProperties SOUP_SPIDER_EYE = foodProperty(8, 0.7f, true, false, false,
            List.of(new MobEffectInfo(HYSTERIA, MEDIUM_DURATION, .5f),
                    new MobEffectInfo(COMFORT, LONG_DURATION, 1.f)));
    public static final FoodProperties SOUP_SLIME = foodProperty(2, 0.7f,
            List.of(new MobEffectInfo(SLIMED, MEDIUM_DURATION, .5f),
                    new MobEffectInfo(COMFORT, LONG_DURATION, 1.f)));

    public static final FoodProperties COOKIE_SOUL_BERRY = foodProperty(2, 0.1f,
            List.of(new MobEffectInfo(FORTIFIED_MIND, SHORT_DURATION, 1.f)));
    public static final FoodProperties COOKIE_ROTTEN_FLESH = foodProperty(2, 0.1f, true, false, false,
            List.of(new MobEffectInfo(INFECTED, SHORT_DURATION, .75f)));
    public static final FoodProperties COOKIE_SPIDER_EYE = foodProperty(2, 0.1f,  true, false, false,
            List.of(new MobEffectInfo(HYSTERIA, SHORT_DURATION, .75f)));
    public static final FoodProperties PUNCH_SLIME_APPLE = foodProperty(4, 0.4f,
            List.of(new MobEffectInfo(MobEffects.GLOWING, MEDIUM_DURATION, .5f)));
    public static final FoodProperties PUNCH_SPIDER_EYE = foodProperty(4, 0.4f,
            List.of(new MobEffectInfo(HYSTERIA, BRIEF_DURATION, .5f)));
    public static final FoodProperties PUNCH_GHAST_TEAR = foodProperty(4, 0.4f,
            List.of(new MobEffectInfo(CHILLS, BRIEF_DURATION, .5f)));

    public static final FoodProperties PUNCH_SOUL_BERRY = foodProperty(4, 0.4f, false, false, true,
            List.of(new MobEffectInfo(FORTIFIED_MIND, MEDIUM_DURATION, 1.0f)));

    public static final FoodProperties PUNCH_WITHER_BERRY = foodProperty(4, 0.4f, false, false, true,
            List.of(new MobEffectInfo(UNDEAD_HUNGER, MEDIUM_DURATION, 1.0f)));

    public static FoodProperties foodProperty(int nutrition, float saturation, List<MobEffectInfo> effects) {
        return foodProperty(nutrition, saturation, false, false, false, effects);
    }
    @ExpectPlatform
    public static FoodProperties foodProperty(int nutrition, float saturation, boolean isMeat, boolean isFast, boolean alwaysEat, List<MobEffectInfo> effects) {
        throw new AssertionError();
    }

    // In Dev only? stops null pointer before effects are fully registered, I think.
    // TODO: needs more testing, possible bug.
    public static MobEffect nonNullEffect(MobEffect effect) {
        return effect != null ? effect : MobEffects.HEAL;
    }
}
