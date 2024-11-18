package com.chefmooon.frightsdelight.common.utility;


import com.chefmooon.frightsdelight.FrightsDelight;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.List;
import java.util.function.Consumer;

public class TextUtils {
    private static final MutableComponent NO_EFFECTS = Component.translatable("effect.none").withStyle(ChatFormatting.GRAY);

    public static MutableComponent getTranslatable(String string, Object... args) {
        return Component.translatable(FrightsDelight.MOD_ID + "." + string, args);
    }

    public static ResourceLocation res(String string) {
        return ResourceLocation.fromNamespaceAndPath(FrightsDelight.MOD_ID, string);
    }

    public static void addFoodEffectTooltip(ItemStack itemIn, Consumer<Component> lores, float durationFactor, float tickRate) {
        addFoodEffectTooltipWithDetail(itemIn, lores, durationFactor, tickRate, false);
    }

    public static void addFoodEffectTooltipWithDetail(ItemStack itemIn, Consumer<Component> lores, float durationFactor, float tickRate) {
        addFoodEffectTooltipWithDetail(itemIn, lores, durationFactor, tickRate, true);
    }

    /**
     * Credits to vectorwing (Farmers Delight) for the implementation reference.
     * https://github.com/vectorwing/FarmersDelight
     */
    public static void addFoodEffectTooltipWithDetail(ItemStack stack, Consumer<Component> lores, float durationFactor, float tickRate, boolean detail) {
        FoodProperties foodStats = stack.get(DataComponents.FOOD);
        if (foodStats == null) {
            return;
        }
        List<FoodProperties.PossibleEffect> effectList = foodStats.effects();
        List<Pair<Holder<Attribute>, AttributeModifier>> attributeList = Lists.newArrayList();
        if (effectList.isEmpty()) {
            lores.accept(NO_EFFECTS);
        } else {
            for (FoodProperties.PossibleEffect possibleEffect : effectList) {
                MobEffectInstance instance = possibleEffect.effect();
                int effectChance = (int) (100 * possibleEffect.probability());
                MutableComponent iformattabletextcomponent = Component.translatable(instance.getDescriptionId());
                MobEffect effect = instance.getEffect().value();
                effect.createModifiers(instance.getAmplifier(), (attributeHolder, attributeModifier) -> {
                    attributeList.add(new Pair<>(attributeHolder, attributeModifier));
                });

                if (instance.getAmplifier() > 0) {
                    iformattabletextcomponent = Component.translatable("potion.withAmplifier", iformattabletextcomponent, Component.translatable("potion.potency." + instance.getAmplifier()));
                }

                if (instance.getDuration() > 20) {
                    iformattabletextcomponent = Component.translatable("potion.withDuration", iformattabletextcomponent, MobEffectUtil.formatDuration(instance, durationFactor, tickRate));
                }

                if (detail) {
                    iformattabletextcomponent = iformattabletextcomponent.append(Component.literal(" " + effectChance + "%"));
                }

                lores.accept(iformattabletextcomponent.withStyle(effect.getCategory().getTooltipFormatting()));
            }
        }

        if (!attributeList.isEmpty()) {
            lores.accept(CommonComponents.EMPTY);
            lores.accept((Component.translatable("potion.whenDrank")).withStyle(ChatFormatting.DARK_PURPLE));

            for (Pair<Holder<Attribute>, AttributeModifier> pair : attributeList) {
                AttributeModifier modifier = pair.getSecond();
                double amount = modifier.amount();
                double formattedAmount;
                if (modifier.operation() != AttributeModifier.Operation.ADD_MULTIPLIED_BASE && modifier.operation() != AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL) {
                    formattedAmount = modifier.amount();
                } else {
                    formattedAmount = modifier.amount() * 100.0D;
                }

                if (amount > 0.0D) {
                    lores.accept(Component.translatable("attribute.modifier.plus." + modifier.operation().id(), new Object[]{ItemAttributeModifiers.ATTRIBUTE_MODIFIER_FORMAT.format(formattedAmount), Component.translatable(((Attribute) ((Holder) pair.getFirst()).value()).getDescriptionId())}).withStyle(ChatFormatting.BLUE));
                } else if (amount < 0.0D) {
                    formattedAmount = formattedAmount * -1.0D;
                    lores.accept(Component.translatable("attribute.modifier.take." + modifier.operation().id(), new Object[]{ItemAttributeModifiers.ATTRIBUTE_MODIFIER_FORMAT.format(formattedAmount), Component.translatable(((Attribute) ((Holder) pair.getFirst()).value()).getDescriptionId())}).withStyle(ChatFormatting.RED));
                }
            }
        }

    }
}
