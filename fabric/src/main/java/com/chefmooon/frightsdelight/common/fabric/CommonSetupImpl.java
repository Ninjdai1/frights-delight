package com.chefmooon.frightsdelight.common.fabric;

import com.chefmooon.frightsdelight.common.CommonSetup;
import com.chefmooon.frightsdelight.common.block.entity.dispenser.DrinkableFeastDispenseBehavior;
import com.chefmooon.frightsdelight.common.crafting.condition.fabric.FrDVanillaCrateEnabledConditionImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.DispenserBlock;

public class CommonSetupImpl {

    public static void init() {
//        CommonSetup.init();
        CommonSetup.registerCompostables();
        registerDispenserBehaviors();

        ResourceConditions.register(FrDVanillaCrateEnabledConditionImpl.TYPE);
    }

    public static void registerDispenserBehaviors() {
        DispenserBlock.registerProjectileBehavior(BuiltInRegistries.ITEM.get(FrightsDelightItems.BONE_SHARD));

        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH, new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE, new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_SPIDEREYE, new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_GHASTTEAR, new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY, new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY, new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_COBWEB, new DrinkableFeastDispenseBehavior());
    }
}
