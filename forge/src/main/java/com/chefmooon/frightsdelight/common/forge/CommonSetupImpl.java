package com.chefmooon.frightsdelight.common.forge;

import com.chefmooon.frightsdelight.common.CommonSetup;
import com.chefmooon.frightsdelight.common.block.entity.dispenser.DrinkableFeastDispenseBehavior;
import com.chefmooon.frightsdelight.common.crafting.condition.forge.FrDVanillaCrateEnabledConditionImpl;
import com.chefmooon.frightsdelight.common.entity.forge.BoneShardEntityImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import com.chefmooon.frightsdelight.common.registry.forge.FrightsDelightItemsImpl;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetupImpl {

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CommonSetup.init();
            registerDispenserBehaviors();
        });

        CraftingHelper.register(new FrDVanillaCrateEnabledConditionImpl.Serializer());
    }

    public static void registerDispenserBehaviors() {
        DispenserBlock.registerBehavior(BuiltInRegistries.ITEM.get(FrightsDelightItems.BONE_SHARD), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level level, Position position, ItemStack stack) {
                return new BoneShardEntityImpl(level, position.x(), position.y(), position.z());
            }
        });

        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH.get(), new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get(), new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get(), new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get(), new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get(), new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get(), new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_COBWEB.get(), new DrinkableFeastDispenseBehavior());
    }
}
