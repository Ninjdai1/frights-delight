package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class FrightsDelightCreativeTabs {
    public static final LazyRegistrar<CreativeModeTab> CREATIVE_MODE_TAB = LazyRegistrar.create(Registries.CREATIVE_MODE_TAB, FrightsDelight.MOD_ID);
    public static final Supplier<CreativeModeTab> TAB_FRIGHTS_DELIGHT = CREATIVE_MODE_TAB.register(FrightsDelight.MOD_ID,
            () -> FabricItemGroup.builder()
                    .title(Component.translatable("itemGroup." + FrightsDelight.MOD_ID))
                    .icon(() -> new ItemStack(FrightsDelightItemsImpl.APPLE_SLIME.get()))
                    .displayItems((parameters, output) -> FrightsDelightItemsImpl.CREATIVE_TAB_ITEMS.forEach((item) -> output.accept(item.get())))
                    .build());
}
