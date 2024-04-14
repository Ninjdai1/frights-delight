package com.chefmooon.frightsdelight.registry;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.item.FrDConsumableItem;
import com.chefmooon.frightsdelight.item.FrDDrinkableItem;
import com.chefmooon.frightsdelight.item.enumeration.FoodItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public enum ItemsRegistry {
    FLESH_CRATE("flesh_crate", () -> new BlockItem(BlocksRegistry.FLESH_CRATE.get(), base())),
    BONE_CRATE("bone_crate", () -> new BlockItem(BlocksRegistry.BONE_CRATE.get(), base())),
    PHANTOM_CRATE("phantom_crate", () -> new BlockItem(BlocksRegistry.PHANTOM_CRATE.get(), base())),
    WEB_CRATE("web_crate", () -> new BlockItem(BlocksRegistry.WEB_CRATE.get(), base())),
    SPIDER_EYE_CRATE("spider_eye_crate", () -> new BlockItem(BlocksRegistry.SPIDER_EYE_CRATE.get(), base())),
    FERMENTED_SPIDER_EYE_CRATE("fermented_spider_eye_crate", () -> new BlockItem(BlocksRegistry.FERMENTED_SPIDER_EYE_CRATE.get(), base())),
    POISONOUS_POTATO_CRATE("poisonous_potato_crate", () -> new BlockItem(BlocksRegistry.POISONOUS_POTATO_CRATE.get(), base())),
    ROTTEN_TOMATO_CRATE("rotten_tomato_crate", () -> new BlockItem(BlocksRegistry.ROTTEN_TOMATO_CRATE.get(), base())),

    SOUL_BERRY("soul_berry", () -> new AliasedBlockItem(BlocksRegistry.SOUL_BERRY_BUSH.get(), food(FoodItem.SOUL_BERRY.get())), null, .3f),
    WITHER_BERRY("wither_berry", () -> new AliasedBlockItem(BlocksRegistry.WITHER_BERRY_BUSH.get(), food(FoodItem.WITHER_BERRY.get())), null, .3f),

    APPLE_SLIME("apple_slime", () -> new FrDConsumableItem(food(FoodItem.APPLE_SLIME.get()), true)),
    UNDEAD_KEBAB("undead_kebab", () -> new FrDConsumableItem(food(FoodItem.UNDEAD_KEBAB.get(), Items.STICK, 16), true)),
    WEB_ON_STICK("web_on_stick", () -> new FrDConsumableItem(food(FoodItem.WEB_ON_STICK.get(), Items.STICK, 16), true)),

    MONSTER_MASH("monster_mash", () -> new FrDConsumableItem(food(FoodItem.MONSTER_MASH.get(), Items.BOWL, 16), true)),
    PASTA_WITH_SLIMEBALLS("pasta_with_slimeballs", () -> new FrDConsumableItem(food(FoodItem.PASTA_WITH_SLIMEBALLS.get(), Items.BOWL, 16), true)),
    SOUP_ROTTEN_FLESH("soup_rotten_flesh", () -> new FrDConsumableItem(food(FoodItem.SOUP_ROTTEN_FLESH.get(), Items.BOWL, 16), true)),
    SOUP_SPIDER_EYE("soup_spider_eye", () -> new FrDConsumableItem(food(FoodItem.SOUP_SPIDER_EYE.get(), Items.BOWL, 16), true)),
    SOUP_SLIME("soup_slime", () -> new FrDConsumableItem(food(FoodItem.SOUP_SLIME.get(), Items.BOWL, 16), true)),

    COOKIE_SOUL_BERRY("cookie_soul_berry", () -> new FrDConsumableItem(food(FoodItem.COOKIE_SOUL_BERRY.get()), true), null, .85f),
    COOKIE_FLESH("cookie_flesh", () -> new FrDConsumableItem(food(FoodItem.COOKIE_FLESH.get()), true), null, .85f),
    COOKIE_SPIDEREYE("cookie_spidereye", () -> new FrDConsumableItem(food(FoodItem.COOKIE_SPIDEREYE.get()), true), null, .85f),

    PUNCH_SLIMEAPPLE("punch_slimeapple", () -> new FrDDrinkableItem(food(FoodItem.PUNCH_SLIMEAPPLE.get(), Items.GLASS_BOTTLE, 16), SoundEvents.ENTITY_SLIME_SQUISH, 4, true)),
    PUNCH_SPIDEREYE("punch_spidereye", () -> new FrDDrinkableItem(food(FoodItem.PUNCH_SPIDEREYE.get(), Items.GLASS_BOTTLE, 16), SoundEvents.ENTITY_SPIDER_AMBIENT, 6, true)),
    PUNCH_GHASTTEAR("punch_ghasttear", () -> new FrDDrinkableItem(food(FoodItem.PUNCH_GHASTTEAR.get(), Items.GLASS_BOTTLE, 16), SoundEvents.ENTITY_GHAST_AMBIENT, 4, true)),
    PUNCH_SOUL_BERRY("punch_soul_berry", () -> new FrDDrinkableItem(food(FoodItem.PUNCH_SOUL_BERRY.get(), Items.GLASS_BOTTLE, 16), true)),
    PUNCH_WITHER_BERRY("punch_wither_berry", () -> new FrDDrinkableItem(food(FoodItem.PUNCH_WITHER_BERRY.get(), Items.GLASS_BOTTLE, 16), true)),

    PUNCHBOWL_SLIMEAPPLE("punchbowl_slimeapple", () -> new BlockItem(BlocksRegistry.PUNCHBOWL_SLIMEAPPLE.get(), noStack())),
    PUNCHBOWL_SPIDEREYE("punchbowl_spidereye", () -> new BlockItem(BlocksRegistry.PUNCHBOWL_SPIDEREYE.get(), noStack())),
    PUNCHBOWL_GHASTTEAR("punchbowl_ghasttear", () -> new BlockItem(BlocksRegistry.PUNCHBOWL_GHASTTEAR.get(), noStack())),
    PUNCHBOWL_SOUL_BERRY("punchbowl_soul_berry", () -> new BlockItem(BlocksRegistry.PUNCHBOWL_SOUL_BERRY.get(), noStack())),
    PUNCHBOWL_WITHER_BERRY("punchbowl_wither_berry", () -> new BlockItem(BlocksRegistry.PUNCHBOWL_WITHER_BERRY.get(), noStack()))
    ;

    private final String pathName;
    private final Supplier<Item> itemSupplier;
    private final Integer burnTime;
    private final Float compostingChance;
    private final Boolean obtainable;
    private Item item;

    ItemsRegistry(String pathName, Supplier<Item> itemSupplier) {
        this(pathName, itemSupplier, null, null, true);
    }
    ItemsRegistry(String pathName, Supplier<Item> itemSupplier, Integer burnTime, Float compostingChance) {
        this(pathName, itemSupplier, burnTime, compostingChance, true);
    }

    ItemsRegistry(String pathName, Supplier<Item> itemSupplier, Boolean obtainable) {
        this(pathName, itemSupplier, null, null, obtainable);
    }

    ItemsRegistry(String pathName, Supplier<Item> itemSupplier, Integer burnTime, Float compostingChance, Boolean obtainable) {
        this.pathName = pathName;
        this.itemSupplier = itemSupplier;
        this.burnTime = burnTime;
        this.compostingChance = compostingChance;
        this.obtainable = obtainable;
    }

    public static void registerAll() {
        for (ItemsRegistry value : values()) {
            Registry.register(Registries.ITEM, new Identifier(FrightsDelight.MOD_ID, value.pathName), value.get());
            if (value.obtainable) {
                ItemGroupEvents.modifyEntriesEvent(FrightsDelight.ITEM_GROUP).register(entries -> entries.add(value.get()));
            }
            if (value.burnTime != null && value.burnTime > 0) {
                FuelRegistry.INSTANCE.add(value.get(), value.burnTime);
            }
            if (value.compostingChance != null && value.compostingChance > .0f && value.compostingChance <= 1.f) {
                CompostingChanceRegistry.INSTANCE.add(value.get(), value.compostingChance);
            }
        }
    }

    public Item get() {
        if (item == null) {
            item = itemSupplier.get();
        }
        return item;
    }

    public String getId() {
        return Registries.ITEM.getId(get()).toString();
    }

    private static FabricItemSettings base() {
        return new FabricItemSettings();
    }
    private static FabricItemSettings noStack() {
        return new FabricItemSettings().maxCount(1);
    }
    private static FabricItemSettings food(FoodComponent food) {
        return new FabricItemSettings().food(food);
    }
    private static FabricItemSettings food(FoodComponent food, Item remainder) {
        return new FabricItemSettings().food(food).recipeRemainder(remainder);
    }
    private static FabricItemSettings food(FoodComponent food, Item remainder, int maxCount) {
        return new FabricItemSettings().food(food).recipeRemainder(remainder).maxCount(maxCount);
    }
}
