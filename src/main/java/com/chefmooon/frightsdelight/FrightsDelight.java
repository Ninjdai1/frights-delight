package com.chefmooon.frightsdelight;

import com.chefmooon.frightsdelight.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Set;

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
		ParticleEffectsRegistry.registerAll();

		registerLootTable();
	}

	private static void registerLootTable() {
		Set<Identifier> chestsId = Set.of(
				LootTables.BASTION_BRIDGE_CHEST,
				LootTables.BASTION_TREASURE_CHEST,
				LootTables.BASTION_OTHER_CHEST
		);

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			Identifier injectId = new Identifier(FrightsDelight.MOD_ID, "inject/" + id.getPath());

			if (chestsId.contains(id)) {
				tableBuilder.pool(LootPool.builder().with(LootTableEntry.builder(injectId).weight(1).quality(0)).build());
			}
		});
	}
}