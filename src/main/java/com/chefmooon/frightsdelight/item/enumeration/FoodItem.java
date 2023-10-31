package com.chefmooon.frightsdelight.item.enumeration;

import com.chefmooon.frightsdelight.item.FrDConsumableItem;
import com.chefmooon.frightsdelight.registry.StatusEffectsRegistry;
import com.nhoryzon.mc.farmersdelight.registry.EffectsRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

import java.util.function.Supplier;

public enum FoodItem {

    SOUL_BERRY(2, .4f, () -> new StatusEffectInstance(StatusEffectsRegistry.FORTIFIED_MIND.get(), FrDConsumableItem.BRIEF_DURATION, 0),1.f),
    WITHER_BERRY(2, .4f,
            () -> new StatusEffectInstance(StatusEffectsRegistry.UNDEAD_HUNGER.get(), FrDConsumableItem.BRIEF_DURATION, 0),1.f,
            () -> new StatusEffectInstance(StatusEffectsRegistry.HYSTERIA.get(), FrDConsumableItem.BRIEF_DURATION, 0),1.f,
            false, false, false),

    APPLE_SLIME(5, .4f, () -> new StatusEffectInstance(StatusEffectsRegistry.SLIMED.get(), FrDConsumableItem.BRIEF_DURATION, 0),1.f),
    UNDEAD_KEBAB(7, .6f,
            () -> new StatusEffectInstance(StatusEffectsRegistry.INFECTED.get(), FrDConsumableItem.BRIEF_DURATION, 0),.8f,
            () -> new StatusEffectInstance(StatusEffectsRegistry.HYSTERIA.get(), FrDConsumableItem.BRIEF_DURATION, 0),.8f,
            true, false, false),
    WEB_ON_STICK(6, .5f, () -> new StatusEffectInstance(StatusEffectsRegistry.COBWEBBED.get(), FrDConsumableItem.BRIEF_DURATION, 0),.8f),

    MONSTER_MASH(10, .6f,
            () -> new StatusEffectInstance(EffectsRegistry.NOURISHMENT.get(), FrDConsumableItem.LONG_DURATION, 0),1.f,
            () -> new StatusEffectInstance(StatusEffectsRegistry.INFECTED.get(), FrDConsumableItem.MEDIUM_DURATION, 0),.5f,
            true, false, false),
    PASTA_WITH_SLIMEBALLS(10, .6f,
            () -> new StatusEffectInstance(EffectsRegistry.NOURISHMENT.get(), FrDConsumableItem.LONG_DURATION, 0),1.f,
            () -> new StatusEffectInstance(StatusEffectsRegistry.SLIMED.get(), FrDConsumableItem.MEDIUM_DURATION, 0),.5f,
            false, false, false),
    SOUP_ROTTEN_FLESH(8, .7f,
            () -> new StatusEffectInstance(EffectsRegistry.COMFORT.get(), FrDConsumableItem.LONG_DURATION, 0),1.f,
            () -> new StatusEffectInstance(StatusEffectsRegistry.INFECTED.get(), FrDConsumableItem.MEDIUM_DURATION, 0),.5f,
            true, false, false),
    SOUP_SPIDER_EYE(8, .7f,
            () -> new StatusEffectInstance(EffectsRegistry.COMFORT.get(), FrDConsumableItem.LONG_DURATION, 0),1.f,
            () -> new StatusEffectInstance(StatusEffectsRegistry.HYSTERIA.get(), FrDConsumableItem.MEDIUM_DURATION, 0),.5f,
            true, false, false),
    SOUP_SLIME(8, .7f,
            () -> new StatusEffectInstance(EffectsRegistry.COMFORT.get(), FrDConsumableItem.MEDIUM_DURATION, 0),1.f,
            () -> new StatusEffectInstance(StatusEffectsRegistry.SLIMED.get(), FrDConsumableItem.LONG_DURATION, 0),.5f,
            false, false, false),


    COOKIE_SOUL_BERRY(2, .1f, () -> new StatusEffectInstance(StatusEffectsRegistry.FORTIFIED_MIND.get(), FrDConsumableItem.SHORT_DURATION, 0),1.f),
    COOKIE_FLESH(2, .1f, () -> new StatusEffectInstance(StatusEffectsRegistry.INFECTED.get(), FrDConsumableItem.BRIEF_DURATION, 0),.75f, true, false, false),
    COOKIE_SPIDEREYE(2, .1f, () -> new StatusEffectInstance(StatusEffectsRegistry.HYSTERIA.get(), FrDConsumableItem.BRIEF_DURATION, 0),.75f, true, false, false),

    PUNCH_SLIMEAPPLE(4, .4f, () -> new StatusEffectInstance(StatusEffects.GLOWING, FrDConsumableItem.MEDIUM_DURATION, 0), .5f, false, false, true),
    PUNCH_SPIDEREYE(4, .4f, () -> new StatusEffectInstance(StatusEffectsRegistry.HYSTERIA.get(), FrDConsumableItem.BRIEF_DURATION, 0),.5f, false, false, false),
    PUNCH_GHASTTEAR(4, .4f, () -> new StatusEffectInstance(StatusEffectsRegistry.CHILLS.get(), FrDConsumableItem.BRIEF_DURATION, 0),.5f, false, false, false),
    PUNCH_SOUL_BERRY(4, .4f, () -> new StatusEffectInstance(StatusEffectsRegistry.FORTIFIED_MIND.get(), FrDConsumableItem.SHORT_DURATION, 0),1.f, false, false, true),
    PUNCH_WITHER_BERRY(4, .4f, () -> new StatusEffectInstance(StatusEffectsRegistry.UNDEAD_HUNGER.get(), FrDConsumableItem.SHORT_DURATION, 0),1.f, false, false, true)
    ;
    private final Supplier<FoodComponent> food;
    FoodItem(int hunger, float saturation) {
        this(hunger, saturation, null, .0f, null, .0f, false, false, false);
    }

    FoodItem(int hunger, float saturation, Supplier<StatusEffectInstance> effect, float effectChance) {
        this(hunger, saturation, effect, effectChance, null, .0f, false, false, false);
    }

    FoodItem(int hunger, float saturation, Supplier<StatusEffectInstance> effect, float effectChance, boolean isMeat, boolean isFastToEat, boolean alwaysEdible) {
        this(hunger, saturation, effect, effectChance, null, .0f, isMeat, false, false);
    }

    FoodItem(int hunger, float saturation, Supplier<StatusEffectInstance> effect, float effectChance,
             Supplier<StatusEffectInstance> effect2, float effect2Chance,
             boolean isMeat, boolean isFastToEat, boolean alwaysEdible) {
        food = () -> {
            FoodComponent.Builder builder = new FoodComponent.Builder();
            builder.hunger(hunger).saturationModifier(saturation);
            if (effect != null) {
                builder.statusEffect(effect.get(), effectChance);
            }
            if (effect2 != null) {
                builder.statusEffect(effect2.get(), effect2Chance);
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
