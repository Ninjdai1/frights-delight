package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.FoodValues;
import com.chefmooon.frightsdelight.common.item.FrightsDelightConsumableItem;
import com.chefmooon.frightsdelight.common.item.FrightsDelightConsumableItemNameBlockItem;
import com.chefmooon.frightsdelight.common.item.FrightsDelightDrinkableItem;
import com.chefmooon.frightsdelight.common.item.fabric.FrightsDelightConsumableItemImpl;
import com.chefmooon.frightsdelight.common.item.fabric.FrightsDelightConsumableItemNameBlockItemImpl;
import com.chefmooon.frightsdelight.common.item.fabric.FrightsDelightDrinkableItemImpl;
import com.google.common.collect.Sets;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

import static com.chefmooon.frightsdelight.common.registry.FrightsDelightItems.*;

public class FrightsDelightItemsImpl {
    public static final LazyRegistrar<Item> ITEMS = LazyRegistrar.create(BuiltInRegistries.ITEM, FrightsDelight.MOD_ID);
    public static LinkedHashSet<Supplier<Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

    public static final Supplier<Item> FLESH_CRATE = registerItemWithTab("flesh_crate",
            () -> new BlockItem(FrightsDelightBlocksImpl.FLESH_CRATE.get(), basicItem()));
    public static final Supplier<Item> BONE_CRATE = registerItemWithTab("bone_crate",
            () -> new BlockItem(FrightsDelightBlocksImpl.BONE_CRATE.get(), basicItem()));
    public static final Supplier<Item> PHANTOM_CRATE = registerItemWithTab("phantom_crate",
            () -> new BlockItem(FrightsDelightBlocksImpl.PHANTOM_CRATE.get(), basicItem()));
    public static final Supplier<Item> WEB_CRATE = registerItemWithTab("web_crate",
            () -> new BlockItem(FrightsDelightBlocksImpl.WEB_CRATE.get(), basicItem()));
    public static final Supplier<Item> SPIDER_EYE_CRATE = registerItemWithTab("spider_eye_crate",
            () -> new BlockItem(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE.get(), basicItem()));
    public static final Supplier<Item> FERMENTED_SPIDER_EYE_CRATE = registerItemWithTab("fermented_spider_eye_crate",
            () -> new BlockItem(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE.get(), basicItem()));
    public static final Supplier<Item> POISONOUS_POTATO_CRATE = registerItemWithTab("poisonous_potato_crate",
            () -> new BlockItem(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE.get(), basicItem()));
    public static final Supplier<Item> ROTTEN_TOMATO_CRATE = registerItemWithTab("rotten_tomato_crate",
            () -> new BlockItem(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE.get(), basicItem()));

    public static final Supplier<Item> SOUL_BERRY = registerItemWithTab("soul_berry",
            () -> new FrightsDelightConsumableItemNameBlockItemImpl(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get(), foodItem(FoodValues.SOUL_BERRY), true));
    public static final Supplier<Item> WITHER_BERRY = registerItemWithTab("wither_berry",
            () -> new FrightsDelightConsumableItemNameBlockItemImpl(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get(), foodItem(FoodValues.WITHER_BERRY), true));

    public static final Supplier<Item> APPLE_SLIME = registerItemWithTab("apple_slime",
            () -> new FrightsDelightConsumableItemImpl(foodItem(FoodValues.APPLE_SLIME), true));
    public static final Supplier<Item> UNDEAD_KEBAB = registerItemWithTab("undead_kebab",
            () -> new FrightsDelightConsumableItemImpl(stickFoodItem(FoodValues.UNDEAD_KEBAB), true));
    public static final Supplier<Item> WEB_ON_STICK = registerItemWithTab("web_on_stick",
            () -> new FrightsDelightConsumableItemImpl(stickFoodItem(FoodValues.WEB_ON_STICK), true));

    public static final Supplier<Item> MONSTER_MASH = registerItemWithTab("monster_mash",
            () -> new FrightsDelightConsumableItemImpl(bowlFoodItem(FoodValues.MONSTER_MASH), true));
    public static final Supplier<Item> PASTA_WITH_SLIMEBALLS = registerItemWithTab("pasta_with_slimeballs",
            () -> new FrightsDelightConsumableItemImpl(bowlFoodItem(FoodValues.PASTA_WITH_SLIMEBALLS), true));
    public static final Supplier<Item> SOUP_ROTTEN_FLESH = registerItemWithTab("soup_rotten_flesh",
            () -> new FrightsDelightConsumableItemImpl(bowlFoodItem(FoodValues.SOUP_ROTTEN_FLESH), true));
    public static final Supplier<Item> SOUP_SPIDER_EYE = registerItemWithTab("soup_spider_eye",
            () -> new FrightsDelightConsumableItemImpl(bowlFoodItem(FoodValues.SOUP_SPIDER_EYE), true));
    public static final Supplier<Item> SOUP_SLIME = registerItemWithTab("soup_slime",
            () -> new FrightsDelightConsumableItemImpl(bowlFoodItem(FoodValues.SOUP_SLIME), true));

    public static final Supplier<Item> COOKIE_SOUL_BERRY = registerItemWithTab("cookie_soul_berry",
            () -> new FrightsDelightConsumableItemImpl(foodItem(FoodValues.COOKIE_SOUL_BERRY), true));
    public static final Supplier<Item> COOKIE_ROTTEN_FLESH = registerItemWithTab("cookie_flesh",
            () -> new FrightsDelightConsumableItemImpl(foodItem(FoodValues.COOKIE_ROTTEN_FLESH), true));
    public static final Supplier<Item> COOKIE_SPIDER_EYE = registerItemWithTab("cookie_spidereye",
            () -> new FrightsDelightConsumableItemImpl(foodItem(FoodValues.COOKIE_SPIDER_EYE), true));

    public static final Supplier<Item> PUNCH_SLIMEAPPLE = registerItemWithTab("punch_slimeapple",
            () -> new FrightsDelightDrinkableItemImpl(drinkItem(FoodValues.PUNCH_SLIME_APPLE), true));
    public static final Supplier<Item> PUNCH_SPIDEREYE = registerItemWithTab("punch_spidereye",
            () -> new FrightsDelightDrinkableItemImpl(drinkItem(FoodValues.PUNCH_SPIDER_EYE), true));
    public static final Supplier<Item> PUNCH_GHASTTEAR = registerItemWithTab("punch_ghasttear",
            () -> new FrightsDelightDrinkableItemImpl(drinkItem(FoodValues.PUNCH_GHAST_TEAR), true));
    public static final Supplier<Item> PUNCH_SOUL_BERRY = registerItemWithTab("punch_soul_berry",
            () -> new FrightsDelightDrinkableItemImpl(drinkItem(FoodValues.PUNCH_SOUL_BERRY), true));
    public static final Supplier<Item> PUNCH_WITHER_BERRY = registerItemWithTab("punch_wither_berry",
            () -> new FrightsDelightDrinkableItemImpl(drinkItem(FoodValues.PUNCH_WITHER_BERRY), true));

    public static final Supplier<Item> PUNCHBOWL_SLIMEAPPLE = registerItemWithTab("punchbowl_slimeapple",
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE.get(), basicItem()));
    public static final Supplier<Item> PUNCHBOWL_SPIDEREYE = registerItemWithTab("punchbowl_spidereye",
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE.get(), basicItem()));
    public static final Supplier<Item> PUNCHBOWL_GHASTTEAR = registerItemWithTab("punchbowl_ghasttear",
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR.get(), basicItem()));
    public static final Supplier<Item> PUNCHBOWL_SOUL_BERRY = registerItemWithTab("punchbowl_soul_berry",
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY.get(), basicItem()));
    public static final Supplier<Item> PUNCHBOWL_WITHER_BERRY = registerItemWithTab("punchbowl_wither_berry",
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY.get(), basicItem()));

    public static Supplier<Item> registerItemWithTab(final String name, final Supplier<Item> supplier) {
        Supplier<Item> item = ITEMS.register(name, supplier);
        CREATIVE_TAB_ITEMS.add(item);
        return item;
    }
}
