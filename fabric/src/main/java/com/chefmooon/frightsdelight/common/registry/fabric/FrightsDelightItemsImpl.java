package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.common.FoodValues;
import com.chefmooon.frightsdelight.common.item.FrightsDelightConsumableItem;
import com.chefmooon.frightsdelight.common.item.FrightsDelightConsumableItemNameBlockItem;
import com.chefmooon.frightsdelight.common.item.FrightsDelightDrinkableItem;
import com.chefmooon.frightsdelight.common.item.fabric.BoneShardItemImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import static com.chefmooon.frightsdelight.common.registry.FrightsDelightItems.*;

public class FrightsDelightItemsImpl {

    public static Item.Properties boneFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(FrightsDelightItemsImpl.BONE_SHARD).stacksTo(16);
    }

    public static final Item FLESH_CRATE = registerItemWithTab(FrightsDelightItems.FLESH_CRATE,
            new BlockItem(FrightsDelightBlocksImpl.FLESH_CRATE, basicItem()));
    public static final Item BONE_CRATE = registerItemWithTab(FrightsDelightItems.BONE_CRATE,
            new BlockItem(FrightsDelightBlocksImpl.BONE_CRATE, basicItem()));
    public static final Item PHANTOM_CRATE = registerItemWithTab(FrightsDelightItems.PHANTOM_CRATE,
            new BlockItem(FrightsDelightBlocksImpl.PHANTOM_CRATE, basicItem()));
    public static final Item WEB_CRATE = registerItemWithTab(FrightsDelightItems.WEB_CRATE,
            new BlockItem(FrightsDelightBlocksImpl.WEB_CRATE, basicItem()));
    public static final Item SPIDER_EYE_CRATE = registerItemWithTab(FrightsDelightItems.SPIDER_EYE_CRATE,
            new BlockItem(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE, basicItem()));
    public static final Item FERMENTED_SPIDER_EYE_CRATE = registerItemWithTab(FrightsDelightItems.FERMENTED_SPIDER_EYE_CRATE,
            new BlockItem(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE, basicItem()));
    public static final Item POISONOUS_POTATO_CRATE = registerItemWithTab(FrightsDelightItems.POISONOUS_POTATO_CRATE,
            new BlockItem(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE, basicItem()));
    public static final Item ROTTEN_TOMATO_CRATE = registerItemWithTab(FrightsDelightItems.ROTTEN_TOMATO_CRATE,
            new BlockItem(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE, basicItem()));

    public static final Item BONE_SHARD = registerItemWithTab(FrightsDelightItems.BONE_SHARD,
            new BoneShardItemImpl(basicItem()));

    public static final Item SOUL_BERRY = registerItemWithTab(FrightsDelightItems.SOUL_BERRY,
            new FrightsDelightConsumableItemNameBlockItem(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH, foodItem(FoodValues.SOUL_BERRY), true));
    public static final Item WITHER_BERRY = registerItemWithTab(FrightsDelightItems.WITHER_BERRY,
            new FrightsDelightConsumableItemNameBlockItem(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH, foodItem(FoodValues.WITHER_BERRY), true));

    public static final Item APPLE_SLIME = registerItemWithTab(FrightsDelightItems.APPLE_SLIME,
            new FrightsDelightConsumableItem(foodItem(FoodValues.APPLE_SLIME), true));
    public static final Item UNDEAD_KEBAB = registerItemWithTab(FrightsDelightItems.UNDEAD_KEBAB,
            new FrightsDelightConsumableItem(boneFoodItem(FoodValues.UNDEAD_KEBAB), true));

    public static final Item BONE_KEBAB_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_ROTTEN_FLESH,
            new FrightsDelightConsumableItem(boneFoodItem(FoodValues.BONE_KEBAB_ROTTEN_FLESH), true));
    public static final Item BONE_KEBAB_SPIDER_EYE = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_SPIDER_EYE,
            new FrightsDelightConsumableItem(boneFoodItem(FoodValues.BONE_KEBAB_SPIDER_EYE), true));
    public static final Item BONE_KEBAB_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_SLIMEAPPLE,
            new FrightsDelightConsumableItem(boneFoodItem(FoodValues.BONE_KEBAB_SLIMEAPPLE), true));
    public static final Item BONE_KEBAB_SLIME = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_SLIME,
            new FrightsDelightConsumableItem(boneFoodItem(FoodValues.BONE_KEBAB_SLIME), true));
    public static final Item WEB_ON_STICK = registerItemWithTab(FrightsDelightItems.WEB_ON_STICK,
            new FrightsDelightConsumableItem(boneFoodItem(FoodValues.WEB_ON_STICK), true));
    public static final Item BONE_KEBAB_GHAST_TEAR = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_GHAST_TEAR,
            new FrightsDelightConsumableItem(boneFoodItem(FoodValues.BONE_KEBAB_GHAST_TEAR), true));

    public static final Item BONE_KEBAB_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_SOUL_BERRY,
            new FrightsDelightConsumableItem(boneFoodItem(FoodValues.BONE_KEBAB_SOUL_BERRY), true));
    public static final Item BONE_KEBAB_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_WITHER_BERRY,
            new FrightsDelightConsumableItem(boneFoodItem(FoodValues.BONE_KEBAB_WITHER_BERRY), true));

    public static final Item MONSTER_MASH = registerItemWithTab(FrightsDelightItems.MONSTER_MASH,
            new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.MONSTER_MASH), true));
    public static final Item PASTA_WITH_SLIMEBALLS = registerItemWithTab(FrightsDelightItems.PASTA_WITH_SLIMEBALLS,
            new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.PASTA_WITH_SLIMEBALLS), true));

    public static final Item SOUP_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.SOUP_ROTTEN_FLESH,
            new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.SOUP_ROTTEN_FLESH), true));
    public static final Item SOUP_SPIDER_EYE = registerItemWithTab(FrightsDelightItems.SOUP_SPIDER_EYE,
            new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.SOUP_SPIDER_EYE), true));
    public static final Item SOUP_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.SOUP_SLIMEAPPLE,
            new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.SOUP_SLIME), true));
    public static final Item SOUP_COBWEB = registerItemWithTab(FrightsDelightItems.SOUP_COBWEB,
            new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.SOUP_COBWEB), true));
    public static final Item SOUP_GHAST_TEAR = registerItemWithTab(FrightsDelightItems.SOUP_GHAST_TEAR,
            new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.SOUP_GHAST_TEAR), true));
    public static final Item SOUP_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.SOUP_SOUL_BERRY,
            new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.SOUP_SOUL_BERRY), true));
    public static final Item SOUP_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.SOUP_WITHER_BERRY,
            new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.SOUP_WITHER_BERRY), true));

    public static final Item COOKIE_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.COOKIE_ROTTEN_FLESH,
            new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_ROTTEN_FLESH), true));
    public static final Item COOKIE_SPIDER_EYE = registerItemWithTab(FrightsDelightItems.COOKIE_SPIDER_EYE,
            new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_SPIDER_EYE), true));
    public static final Item COOKIE_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.COOKIE_SLIMEAPPLE,
            new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_SLIMEAPPLE), true));
    public static final Item COOKIE_SLIME = registerItemWithTab(FrightsDelightItems.COOKIE_SLIME,
            new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_SLIME), true));
    public static final Item COOKIE_COBWEB = registerItemWithTab(FrightsDelightItems.COOKIE_COBWEB,
            new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_COBWEB), true));
    public static final Item COOKIE_GHAST_TEAR = registerItemWithTab(FrightsDelightItems.COOKIE_GHAST_TEAR,
            new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_GHAST_TEAR), true));
    public static final Item COOKIE_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.COOKIE_SOUL_BERRY,
            new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_SOUL_BERRY), true));
    public static final Item COOKIE_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.COOKIE_WITHER_BERRY,
            new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_WITHER_BERRY), true));

    public static final Item PUNCH_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.PUNCH_ROTTEN_FLESH,
            new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_ROTTEN_FLESH),
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.ZOMBIE_AMBIENT.getLocation()),true));
    public static final Item PUNCH_SPIDEREYE = registerItemWithTab(FrightsDelightItems.PUNCH_SPIDEREYE,
            new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_SPIDER_EYE),
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.SPIDER_AMBIENT.getLocation()),true));
    public static final Item PUNCH_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.PUNCH_SLIMEAPPLE,
            new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_SLIME_APPLE),
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.SLIME_SQUISH.getLocation()),true));
    public static final Item PUNCH_COBWEB = registerItemWithTab(FrightsDelightItems.PUNCH_COBWEB,
            new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_COBWEB),
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.SPIDER_AMBIENT.getLocation()),true));
    public static final Item PUNCH_GHASTTEAR = registerItemWithTab(FrightsDelightItems.PUNCH_GHASTTEAR,
            new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_GHAST_TEAR),
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.GHAST_AMBIENT.getLocation()),true));
    public static final Item PUNCH_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.PUNCH_SOUL_BERRY,
            new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_SOUL_BERRY), true));
    public static final Item PUNCH_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.PUNCH_WITHER_BERRY,
            new FrightsDelightDrinkableItem(drinkItem(FoodValues.PUNCH_WITHER_BERRY), true));


    public static final Item PUNCHBOWL_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_ROTTEN_FLESH,
            new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_ROTTEN_FLESH, noStack()));
    public static final Item PUNCHBOWL_SPIDEREYE = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_SPIDEREYE,
            new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE, noStack()));
    public static final Item PUNCHBOWL_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_SLIMEAPPLE,
            new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE, noStack()));
    public static final Item PUNCHBOWL_COBWEB = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_COBWEB,
            new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_COBWEB, noStack()));
    public static final Item PUNCHBOWL_GHASTTEAR = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_GHASTTEAR,
            new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR, noStack()));
    public static final Item PUNCHBOWL_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_SOUL_BERRY,
            new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY, noStack()));
    public static final Item PUNCHBOWL_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_WITHER_BERRY,
            new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY, noStack()));


    public static Item registerItemWithTab(final ResourceLocation location, final Item item) {
        Registry.register(BuiltInRegistries.ITEM, location, item);
        ItemGroupEvents.modifyEntriesEvent(FrightsDelightCreativeTabs.ITEM_GROUP).register(entries -> entries.accept(item));
        return item;
    }

    public static void register() {

    }
}
