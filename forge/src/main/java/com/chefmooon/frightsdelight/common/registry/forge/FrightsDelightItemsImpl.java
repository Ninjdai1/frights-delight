package com.chefmooon.frightsdelight.common.registry.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.FoodValues;
import com.chefmooon.frightsdelight.common.item.FrightsDelightConsumableItem;
import com.chefmooon.frightsdelight.common.item.FrightsDelightConsumableItemNameBlockItem;
import com.chefmooon.frightsdelight.common.item.FrightsDelightDrinkableItem;
import com.google.common.collect.Sets;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

import static com.chefmooon.frightsdelight.common.registry.FrightsDelightItems.*;

public class FrightsDelightItemsImpl {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, FrightsDelight.MOD_ID);
    public static LinkedHashSet<Supplier<Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();
    
    public static final RegistryObject<Item> FLESH_CRATE = registerItemWithTab("flesh_crate",
            () -> new BlockItem(FrightsDelightBlocksImpl.FLESH_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> BONE_CRATE = registerItemWithTab("bone_crate",
            () -> new BlockItem(FrightsDelightBlocksImpl.BONE_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> PHANTOM_CRATE = registerItemWithTab("phantom_crate",
            () -> new BlockItem(FrightsDelightBlocksImpl.PHANTOM_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> WEB_CRATE = registerItemWithTab("web_crate",
            () -> new BlockItem(FrightsDelightBlocksImpl.WEB_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> SPIDER_EYE_CRATE = registerItemWithTab("spider_eye_crate",
            () -> new BlockItem(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> FERMENTED_SPIDER_EYE_CRATE = registerItemWithTab("fermented_spider_eye_crate",
            () -> new BlockItem(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> POISONOUS_POTATO_CRATE = registerItemWithTab("poisonous_potato_crate",
            () -> new BlockItem(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> ROTTEN_TOMATO_CRATE = registerItemWithTab("rotten_tomato_crate",
            () -> new BlockItem(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE.get(), basicItem()));

    public static final RegistryObject<Item> SOUL_BERRY = registerItemWithTab("soul_berry",
            () -> new FrightsDelightConsumableItemNameBlockItem(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get(), foodItem(FoodValues.SOUL_BERRY), true));
    public static final RegistryObject<Item> WITHER_BERRY = registerItemWithTab("wither_berry",
            () -> new FrightsDelightConsumableItemNameBlockItem(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get(), foodItem(FoodValues.WITHER_BERRY), true));

    public static final RegistryObject<Item> APPLE_SLIME = registerItemWithTab("apple_slime",
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.APPLE_SLIME), true));
    public static final RegistryObject<Item> UNDEAD_KEBAB = registerItemWithTab("undead_kebab",
            () -> new FrightsDelightConsumableItem(stickFoodItem(FoodValues.UNDEAD_KEBAB), true));
    public static final RegistryObject<Item> WEB_ON_STICK = registerItemWithTab("web_on_stick",
            () -> new FrightsDelightConsumableItem(stickFoodItem(FoodValues.WEB_ON_STICK), true));

    public static final RegistryObject<Item> MONSTER_MASH = registerItemWithTab("monster_mash",
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.MONSTER_MASH), true));
    public static final RegistryObject<Item> PASTA_WITH_SLIMEBALLS = registerItemWithTab("pasta_with_slimeballs",
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.PASTA_WITH_SLIMEBALLS), true));
    public static final RegistryObject<Item> SOUP_ROTTEN_FLESH = registerItemWithTab("soup_rotten_flesh",
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.SOUP_ROTTEN_FLESH), true));
    public static final RegistryObject<Item> SOUP_SPIDER_EYE = registerItemWithTab("soup_spider_eye",
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.SOUP_SPIDER_EYE), true));
    public static final RegistryObject<Item> SOUP_SLIME = registerItemWithTab("soup_slime",
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.SOUP_SLIME), true));

    public static final RegistryObject<Item> COOKIE_SOUL_BERRY = registerItemWithTab("cookie_soul_berry",
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_SOUL_BERRY), true));
    public static final RegistryObject<Item> COOKIE_ROTTEN_FLESH = registerItemWithTab("cookie_flesh",
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_ROTTEN_FLESH), true));
    public static final RegistryObject<Item> COOKIE_SPIDER_EYE = registerItemWithTab("cookie_spidereye",
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_SPIDER_EYE), true));

    public static final RegistryObject<Item> PUNCH_SLIMEAPPLE = registerItemWithTab("punch_slimeapple",
            () -> new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_SLIME_APPLE), true));
    public static final RegistryObject<Item> PUNCH_SPIDEREYE = registerItemWithTab("punch_spidereye",
            () -> new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_SPIDER_EYE), true));
    public static final RegistryObject<Item> PUNCH_GHASTTEAR = registerItemWithTab("punch_ghasttear",
            () -> new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_GHAST_TEAR), true));
    public static final RegistryObject<Item> PUNCH_SOUL_BERRY = registerItemWithTab("punch_soul_berry",
            () -> new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_SOUL_BERRY), true));
    public static final RegistryObject<Item> PUNCH_WITHER_BERRY = registerItemWithTab("punch_wither_berry",
            () -> new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_WITHER_BERRY), true));

    public static final RegistryObject<Item> PUNCHBOWL_SLIMEAPPLE = registerItemWithTab("punchbowl_slimeapple",
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE.get(), basicItem()));
    public static final RegistryObject<Item> PUNCHBOWL_SPIDEREYE = registerItemWithTab("punchbowl_spidereye",
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE.get(), basicItem()));
    public static final RegistryObject<Item> PUNCHBOWL_GHASTTEAR = registerItemWithTab("punchbowl_ghasttear",
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR.get(), basicItem()));
    public static final RegistryObject<Item> PUNCHBOWL_SOUL_BERRY = registerItemWithTab("punchbowl_soul_berry",
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY.get(), basicItem()));
    public static final RegistryObject<Item> PUNCHBOWL_WITHER_BERRY = registerItemWithTab("punchbowl_wither_berry",
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY.get(), basicItem()));

    public static RegistryObject<Item> registerItemWithTab(final String name, final Supplier<Item> supplier) {
        RegistryObject<Item> item = ITEMS.register(name, supplier);
        CREATIVE_TAB_ITEMS.add(item);
        return item;
    }
}
