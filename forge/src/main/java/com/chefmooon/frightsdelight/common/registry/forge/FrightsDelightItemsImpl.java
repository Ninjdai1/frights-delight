package com.chefmooon.frightsdelight.common.registry.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.FoodValues;
import com.chefmooon.frightsdelight.common.item.FrightsDelightConsumableItem;
import com.chefmooon.frightsdelight.common.item.FrightsDelightConsumableItemNameBlockItem;
import com.chefmooon.frightsdelight.common.item.FrightsDelightDrinkableItem;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
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
    
    public static final RegistryObject<Item> FLESH_CRATE = registerItemWithTab(FrightsDelightItems.FLESH_CRATE.getPath(),
            () -> new BlockItem(FrightsDelightBlocksImpl.FLESH_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> BONE_CRATE = registerItemWithTab(FrightsDelightItems.BONE_CRATE.getPath(),
            () -> new BlockItem(FrightsDelightBlocksImpl.BONE_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> PHANTOM_CRATE = registerItemWithTab(FrightsDelightItems.PHANTOM_CRATE.getPath(),
            () -> new BlockItem(FrightsDelightBlocksImpl.PHANTOM_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> WEB_CRATE = registerItemWithTab(FrightsDelightItems.WEB_CRATE.getPath(),
            () -> new BlockItem(FrightsDelightBlocksImpl.WEB_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> SPIDER_EYE_CRATE = registerItemWithTab(FrightsDelightItems.SPIDER_EYE_CRATE.getPath(),
            () -> new BlockItem(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> FERMENTED_SPIDER_EYE_CRATE = registerItemWithTab(FrightsDelightItems.FERMENTED_SPIDER_EYE_CRATE.getPath(),
            () -> new BlockItem(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> POISONOUS_POTATO_CRATE = registerItemWithTab(FrightsDelightItems.POISONOUS_POTATO_CRATE.getPath(),
            () -> new BlockItem(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> ROTTEN_TOMATO_CRATE = registerItemWithTab(FrightsDelightItems.ROTTEN_TOMATO_CRATE.getPath(),
            () -> new BlockItem(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE.get(), basicItem()));

    public static final RegistryObject<Item> SOUL_BERRY = registerItemWithTab(FrightsDelightItems.SOUL_BERRY.getPath(),
            () -> new FrightsDelightConsumableItemNameBlockItem(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get(), foodItem(FoodValues.SOUL_BERRY), true));
    public static final RegistryObject<Item> WITHER_BERRY = registerItemWithTab(FrightsDelightItems.WITHER_BERRY.getPath(),
            () -> new FrightsDelightConsumableItemNameBlockItem(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get(), foodItem(FoodValues.WITHER_BERRY), true));

    public static final RegistryObject<Item> APPLE_SLIME = registerItemWithTab(FrightsDelightItems.APPLE_SLIME.getPath(),
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.APPLE_SLIME), true));
    public static final RegistryObject<Item> UNDEAD_KEBAB = registerItemWithTab(FrightsDelightItems.UNDEAD_KEBAB.getPath(),
            () -> new FrightsDelightConsumableItem(stickFoodItem(FoodValues.UNDEAD_KEBAB), true));
    public static final RegistryObject<Item> WEB_ON_STICK = registerItemWithTab(FrightsDelightItems.WEB_ON_STICK.getPath(),
            () -> new FrightsDelightConsumableItem(stickFoodItem(FoodValues.WEB_ON_STICK), true));

    public static final RegistryObject<Item> MONSTER_MASH = registerItemWithTab(FrightsDelightItems.MONSTER_MASH.getPath(),
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.MONSTER_MASH), true));
    public static final RegistryObject<Item> PASTA_WITH_SLIMEBALLS = registerItemWithTab(FrightsDelightItems.PASTA_WITH_SLIMEBALLS.getPath(),
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.PASTA_WITH_SLIMEBALLS), true));
    public static final RegistryObject<Item> SOUP_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.SOUP_ROTTEN_FLESH.getPath(),
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.SOUP_ROTTEN_FLESH), true));
    public static final RegistryObject<Item> SOUP_SPIDER_EYE = registerItemWithTab(FrightsDelightItems.SOUP_SPIDER_EYE.getPath(),
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.SOUP_SPIDER_EYE), true));
    public static final RegistryObject<Item> SOUP_SLIME = registerItemWithTab(FrightsDelightItems.SOUP_SLIME.getPath(),
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.SOUP_SLIME), true));

    public static final RegistryObject<Item> COOKIE_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.COOKIE_SOUL_BERRY.getPath(),
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_SOUL_BERRY), true));
    public static final RegistryObject<Item> COOKIE_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.COOKIE_ROTTEN_FLESH.getPath(),
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_ROTTEN_FLESH), true));
    public static final RegistryObject<Item> COOKIE_SPIDER_EYE = registerItemWithTab(FrightsDelightItems.COOKIE_SPIDER_EYE.getPath(),
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_SPIDER_EYE), true));

    public static final RegistryObject<Item> PUNCH_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.PUNCH_SLIMEAPPLE.getPath(),
            () -> new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_SLIME_APPLE), true));
    public static final RegistryObject<Item> PUNCH_SPIDEREYE = registerItemWithTab(FrightsDelightItems.PUNCH_SPIDEREYE.getPath(),
            () -> new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_SPIDER_EYE), true));
    public static final RegistryObject<Item> PUNCH_GHASTTEAR = registerItemWithTab(FrightsDelightItems.PUNCH_GHASTTEAR.getPath(),
            () -> new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_GHAST_TEAR), true));
    public static final RegistryObject<Item> PUNCH_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.PUNCH_SOUL_BERRY.getPath(),
            () -> new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_SOUL_BERRY), true));
    public static final RegistryObject<Item> PUNCH_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.PUNCH_WITHER_BERRY.getPath(),
            () -> new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_WITHER_BERRY), true));

    public static final RegistryObject<Item> PUNCHBOWL_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_SLIMEAPPLE.getPath(),
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE.get(), basicItem()));
    public static final RegistryObject<Item> PUNCHBOWL_SPIDEREYE = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_SPIDEREYE.getPath(),
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE.get(), basicItem()));
    public static final RegistryObject<Item> PUNCHBOWL_GHASTTEAR = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_GHASTTEAR.getPath(),
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR.get(), basicItem()));
    public static final RegistryObject<Item> PUNCHBOWL_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_SOUL_BERRY.getPath(),
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY.get(), basicItem()));
    public static final RegistryObject<Item> PUNCHBOWL_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_WITHER_BERRY.getPath(),
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY.get(), basicItem()));

    public static RegistryObject<Item> registerItemWithTab(final String name, final Supplier<Item> supplier) {
        RegistryObject<Item> item = ITEMS.register(name, supplier);
        CREATIVE_TAB_ITEMS.add(item);
        return item;
    }
}
