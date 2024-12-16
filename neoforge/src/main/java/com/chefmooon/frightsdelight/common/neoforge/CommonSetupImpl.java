package com.chefmooon.frightsdelight.common.neoforge;

import com.chefmooon.frightsdelight.common.block.entity.dispenser.DrinkableFeastDispenseBehavior;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import com.chefmooon.frightsdelight.common.registry.neoforge.FrightsDelightItemsImpl;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetupImpl {

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
//            CommonSetup.init();
            registerDispenserBehaviors();
        });

//        CraftingHelper.register(new FrDVanillaCrateEnabledConditionImpl.Serializer());
    }

    public static void registerDispenserBehaviors() {
        DispenserBlock.registerProjectileBehavior(BuiltInRegistries.ITEM.get(FrightsDelightItems.BONE_SHARD));

        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH.get(), new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get(), new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get(), new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get(), new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get(), new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get(), new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_COBWEB.get(), new DrinkableFeastDispenseBehavior());
    }
}
