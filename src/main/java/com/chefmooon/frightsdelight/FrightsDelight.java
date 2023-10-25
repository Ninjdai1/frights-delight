package com.chefmooon.frightsdelight;

import com.chefmooon.frightsdelight.registry.BlocksRegistry;
import com.chefmooon.frightsdelight.registry.ItemsRegistry;
import com.chefmooon.frightsdelight.registry.SoundsRegistry;
import com.chefmooon.frightsdelight.registry.StatusEffectsRegistry;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrightsDelight implements ModInitializer {
	public static final String MOD_ID = "frightsdelight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID));

	public static MutableText tooltip(String key, Object... args) {
		return Text.translatable(MOD_ID + "." + key, args);
	}

	@Override
	public void onInitialize() {

		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
				.displayName(Text.translatable("itemGroup.frightsdelight.group"))
				.icon(() -> new ItemStack(ItemsRegistry.APPLE_SLIME.get()))
				.build());

		ItemsRegistry.registerAll();
		BlocksRegistry.registerAll();
		SoundsRegistry.registerAll();
		StatusEffectsRegistry.registerAll();
	}
}