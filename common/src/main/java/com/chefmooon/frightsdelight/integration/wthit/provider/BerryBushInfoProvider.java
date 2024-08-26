package com.chefmooon.frightsdelight.integration.wthit.provider;

import com.chefmooon.frightsdelight.common.block.FrightsDelightBushBlock;
import com.chefmooon.frightsdelight.common.block.SoulBerryBushBlock;
import com.chefmooon.frightsdelight.common.block.WitherBerryBushBlock;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import com.chefmooon.frightsdelight.integration.wthit.FrightsDelightWailiaPlugin;
import mcp.mobius.waila.api.IBlockAccessor;
import mcp.mobius.waila.api.IBlockComponentProvider;
import mcp.mobius.waila.api.IPluginConfig;
import mcp.mobius.waila.api.ITooltip;
import mcp.mobius.waila.api.component.PairComponent;
import net.minecraft.network.chat.Component;

public enum BerryBushInfoProvider implements IBlockComponentProvider {
    INSTANCE;
    @Override
    public void appendBody(ITooltip tooltip, IBlockAccessor accessor, IPluginConfig config) {
        if (config.getBoolean(FrightsDelightWailiaPlugin.Options.CROP_PROGRESS)) {
            if (accessor.getBlock() instanceof FrightsDelightBushBlock bush) {
                addGrowthProgressTooltip(tooltip, accessor.getBlockState().getValue(bush.getAgeProperty()) / (float) bush.getMaxAge());
            }
        }
        if (config.getBoolean(FrightsDelightWailiaPlugin.Options.BUSH_GROWTH_CONDITION)) {
            addBushGrowthConditionTooltip(tooltip, accessor);
        }
        if (config.getBoolean(FrightsDelightWailiaPlugin.Options.BUSH_TRANSFORM_CONDITION)) {
            addTransformConditionTooltip(tooltip, accessor);
        }
    }

    private static void addGrowthProgressTooltip(ITooltip tooltip, float growthValue) {
        growthValue *= 100.0F;
        if (growthValue < 100.0F) {
            tooltip.addLine(new PairComponent(Component.translatable("tooltip.waila.crop_growth"),
                    Component.literal(String.format("%.0f%%", growthValue))));
        } else {
            tooltip.addLine(new PairComponent(Component.translatable("tooltip.waila.crop_growth"),
                    Component.translatable("tooltip.waila.crop_mature")));
        }
    }

    private static void addBushGrowthConditionTooltip(ITooltip tooltip, IBlockAccessor accessor) {
        if (accessor.getBlock() instanceof FrightsDelightBushBlock frightsDelightBushBlock) {
            int lightLevel = accessor.getWorld().getRawBrightness(accessor.getPosition().above(), 0);
            boolean growthCondition = accessor.getBlockState().getValue(frightsDelightBushBlock.getGrowConditionProperty());
            if (frightsDelightBushBlock instanceof SoulBerryBushBlock) {
                addGrowthConditionTooltip(tooltip, growthCondition && SoulBerryBushBlock.hasGrowBrightness(lightLevel));
            } else if (frightsDelightBushBlock instanceof WitherBerryBushBlock) {
                addGrowthConditionTooltip(tooltip, growthCondition && WitherBerryBushBlock.hasGrowBrightness(lightLevel));
            }
        }
    }

    private static void addTransformConditionTooltip(ITooltip tooltip, IBlockAccessor accessor) {
        if (accessor.getBlock() instanceof FrightsDelightBushBlock frightsDelightBushBlock) {
            if (frightsDelightBushBlock instanceof SoulBerryBushBlock soulBerryBushBlock) {
                if (accessor.getBlockState().getValue(soulBerryBushBlock.getAgeProperty()) == 3) {
                    int lightLevel = accessor.getWorld().getRawBrightness(accessor.getPosition().above(), 0);
                    boolean transformCondition = accessor.getBlockState().getValue(soulBerryBushBlock.getTransformConditionProperty());
                    addBooleanTooltip(tooltip, "tooltip.waila.bush_transform", transformCondition && SoulBerryBushBlock.hasTransformBrightness(lightLevel));
                }
            }
        }
    }

    private static void addGrowthConditionTooltip(ITooltip tooltip, boolean growthCondition) {
        tooltip.addLine(new PairComponent(Component.translatable("tooltip.waila.crop_growable"),
                growthCondition ? Component.translatable("tooltip.waila.true") : Component.translatable("tooltip.waila.false")));
    }

    private static void addBooleanTooltip(ITooltip tooltip, String translationKey, boolean growthCondition) {
        tooltip.addLine(new PairComponent(TextUtils.getTranslatable(translationKey),
                growthCondition ? Component.translatable("tooltip.waila.true") : Component.translatable("tooltip.waila.false")));
    }
}
