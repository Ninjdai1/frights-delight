package com.chefmooon.frightsdelight.integration.wthit.provider;

import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import com.chefmooon.frightsdelight.integration.wthit.FrightsDelightWailiaPlugin;
import mcp.mobius.waila.api.IBlockAccessor;
import mcp.mobius.waila.api.IBlockComponentProvider;
import mcp.mobius.waila.api.IPluginConfig;
import mcp.mobius.waila.api.ITooltip;

public enum DrinkableFeastProvider implements IBlockComponentProvider {
    INSTANCE;

    @Override
    public void appendBody(ITooltip tooltip, IBlockAccessor accessor, IPluginConfig config) {
        if (config.getBoolean(FrightsDelightWailiaPlugin.Options.PUNCHBOWL_SERVINGS)) {
            if (accessor.getBlock() instanceof DrinkableFeastBlock punchbowl) {
                addServingTooltip(tooltip, accessor.getBlockState().getValue(punchbowl.getServingsProperty()));
            }
        }
    }

    private static void addServingTooltip(ITooltip tooltip, int servings) {
        tooltip.addLine(TextUtils.getTranslatable("tooltip.waila.punchbowl_servings").append(": ")
                .append(String.valueOf(servings))
        );
    }
}
