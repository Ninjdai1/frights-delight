package com.chefmooon.frightsdelight.item.enumeration;

import com.chefmooon.frightsdelight.item.FrDConsumableItem;
import com.nhoryzon.mc.farmersdelight.registry.EffectsRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

import java.util.function.Supplier;

public enum FoodItem {

    SOUL_BERRY(2, .4f),
    WITHER_BERRY(2, .4f),

    APPLE_SLIME(5, .6f),
    UNDEAD_KEBAB(7, .7f),
    WEB_ON_STICK(6, .6f),

    MONSTER_MASH(2, .4f, () -> new StatusEffectInstance(EffectsRegistry.NOURISHMENT.get(), FrDConsumableItem.LONG_DURATION, 0),1.f, true, false, false),
    PASTA_WITH_SLIMEBALLS(2, .4f, () -> new StatusEffectInstance(EffectsRegistry.NOURISHMENT.get(), FrDConsumableItem.LONG_DURATION, 0),1.f, true, false, false),
    SOUP_ROTTEN_FLESH(2, .4f, () -> new StatusEffectInstance(EffectsRegistry.COMFORT.get(), FrDConsumableItem.LONG_DURATION, 0),1.f, true, false, false),
    SOUP_SPIDER_EYE(2, .4f, () -> new StatusEffectInstance(EffectsRegistry.COMFORT.get(), FrDConsumableItem.LONG_DURATION, 0),1.f, true, false, false),
    SOUP_SLIME(2, .4f, () -> new StatusEffectInstance(EffectsRegistry.COMFORT.get(), FrDConsumableItem.LONG_DURATION, 0),1.f, true, false, false),


    COOKIE_SOUL_BERRY(2, .1f),
    COOKIE_FLESH(2, .1f),
    COOKIE_SPIDEREYE(2, .1f),

    PUNCH_SLIMEAPPLE(2, .4f, () -> new StatusEffectInstance(StatusEffects.GLOWING, 3600, 0), 1.f, false, false, true),
    PUNCH_SPIDEREYE(2, .4f),
    PUNCH_GHASTTEAR(2, .2f),
    PUNCH_SOUL_BERRY(2, .4f),
    PUNCH_WITHER_BERRY(2, .4f)
    ;
    private final Supplier<FoodComponent> food;
    FoodItem(int hunger, float saturation) {
        this(hunger, saturation, null, .0f, false, false, false);
    }

    FoodItem(int hunger, float saturation, boolean isMeat) {
        this(hunger, saturation, null, .0f, isMeat, false, false);
    }

    FoodItem(int hunger, float saturation, Supplier<StatusEffectInstance> effect, float effectChance) {
        this(hunger, saturation, effect, effectChance, false, false, false);
    }

    FoodItem(int hunger, float saturation, Supplier<StatusEffectInstance> effect, float effectChance, boolean isMeat) {
        this(hunger, saturation, effect, effectChance, isMeat, false, false);
    }
    FoodItem(int hunger, float saturation, Supplier<StatusEffectInstance> effect, float effectChance, boolean isMeat, boolean isFastToEat, boolean alwaysEdible) {
        food = () -> {
            FoodComponent.Builder builder = new FoodComponent.Builder();
            builder.hunger(hunger).saturationModifier(saturation);
            if (effect != null) {
                builder.statusEffect(effect.get(), effectChance);
            }
            if (isMeat) {
                builder.meat();
            }
            if (isFastToEat) {
                builder.snack();
            }
            if (alwaysEdible) {
                builder.alwaysEdible();
            }
            return builder.build();
        };
    }

    public FoodComponent get() {
        return food.get();
    }
}
