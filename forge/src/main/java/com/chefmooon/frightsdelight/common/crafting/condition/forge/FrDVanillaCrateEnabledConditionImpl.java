package com.chefmooon.frightsdelight.common.crafting.condition.forge;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.crafting.condition.FrDVanillaCrateEnabledCondition;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class FrDVanillaCrateEnabledConditionImpl implements ICondition {

    private final ResourceLocation location;

    public FrDVanillaCrateEnabledConditionImpl(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext iContext) {
        return Configuration.isEnableFrDCrates();
    }

    public static class Serializer implements IConditionSerializer<FrDVanillaCrateEnabledConditionImpl> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = FrDVanillaCrateEnabledCondition.ID;
        }

        @Override
        public void write(JsonObject jsonObject, FrDVanillaCrateEnabledConditionImpl iCondition) {

        }

        @Override
        public FrDVanillaCrateEnabledConditionImpl read(JsonObject jsonObject) {
            return new FrDVanillaCrateEnabledConditionImpl(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
