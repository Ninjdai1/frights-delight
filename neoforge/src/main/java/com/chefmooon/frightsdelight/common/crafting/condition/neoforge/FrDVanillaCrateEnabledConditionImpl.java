package com.chefmooon.frightsdelight.common.crafting.condition.neoforge;

import com.chefmooon.frightsdelight.common.Configuration;
import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.conditions.ICondition;

public class FrDVanillaCrateEnabledConditionImpl implements ICondition {
    public static final MapCodec<FrDVanillaCrateEnabledConditionImpl> CODEC = MapCodec.unit(new FrDVanillaCrateEnabledConditionImpl());

    public FrDVanillaCrateEnabledConditionImpl() {
    }

    @Override
    public boolean test(IContext iContext) {
        return Configuration.isEnableFrDCrates();
    }

    @Override
    public MapCodec<? extends ICondition> codec() {
        return CODEC;
    }
}
