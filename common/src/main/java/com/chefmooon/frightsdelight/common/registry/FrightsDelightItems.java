package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.FrightsDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class FrightsDelightItems {

    public static Item.Properties basicItem() {
        return new Item.Properties();
    }

    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food);
    }

    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.BOWL).stacksTo(16);
    }

    public static Item.Properties stickFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.STICK).stacksTo(16);
    }

    public static Item.Properties drinkItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
    }

    // TODO: Maybe use?
    public static final ResourceLocation FLESH_CRATE = FrightsDelight.res("flesh_crate");
    public static final ResourceLocation BONE_CRATE = FrightsDelight.res("bone_crate");
    public static final ResourceLocation PHANTOM_CRATE = FrightsDelight.res("phantom_crate");
    public static final ResourceLocation WEB_CRATE = FrightsDelight.res("web_crate");
    public static final ResourceLocation SPIDER_EYE_CRATE = FrightsDelight.res("spider_eye_crate");
    public static final ResourceLocation FERMENTED_SPIDER_EYE_CRATE = FrightsDelight.res("fermented_spider_eye_crate");
    public static final ResourceLocation POISONOUS_POTATO_CRATE = FrightsDelight.res("poisonous_potato_crate");
    public static final ResourceLocation ROTTEN_TOMATO_CRATE = FrightsDelight.res("rotten_tomato_crate");

    public static final ResourceLocation SOUL_BERRY = FrightsDelight.res("soul_berry");
    public static final ResourceLocation WITHER_BERRY = FrightsDelight.res("wither_berry");

    public static final ResourceLocation APPLE_SLIME = FrightsDelight.res("apple_slime");
    public static final ResourceLocation UNDEAD_KEBAB = FrightsDelight.res("undead_kebab");
    public static final ResourceLocation WEB_ON_STICK = FrightsDelight.res("web_on_stick");

    public static final ResourceLocation MONSTER_MASH = FrightsDelight.res("monster_mash");
    public static final ResourceLocation PASTA_WITH_SLIMEBALLS = FrightsDelight.res("pasta_with_slimeballs");
    public static final ResourceLocation SOUP_ROTTEN_FLESH = FrightsDelight.res("soup_rotten_flesh");
    public static final ResourceLocation SOUP_SPIDER_EYE = FrightsDelight.res("soup_spider_eye");
    public static final ResourceLocation SOUP_SLIME = FrightsDelight.res("soup_slime");

    public static final ResourceLocation COOKIE_SOUL_BERRY = FrightsDelight.res("cookie_soul_berry");
    public static final ResourceLocation COOKIE_ROTTEN_FLESH = FrightsDelight.res("cookie_flesh");
    public static final ResourceLocation COOKIE_SPIDER_EYE = FrightsDelight.res("cookie_spidereye");

    public static final ResourceLocation PUNCH_SLIMEAPPLE = FrightsDelight.res("punch_slimeapple");
    public static final ResourceLocation PUNCH_SPIDEREYE = FrightsDelight.res("punch_spidereye");
    public static final ResourceLocation PUNCH_GHASTTEAR = FrightsDelight.res("punch_ghasttear");
    public static final ResourceLocation PUNCH_SOUL_BERRY = FrightsDelight.res("punch_soul_berry");
    public static final ResourceLocation PUNCH_WITHER_BERRY = FrightsDelight.res("punch_wither_berry");

    public static final ResourceLocation PUNCHBOWL_SLIMEAPPLE = FrightsDelight.res("punchbowl_slimeapple");
    public static final ResourceLocation PUNCHBOWL_SPIDEREYE = FrightsDelight.res("punchbowl_spidereye");
    public static final ResourceLocation PUNCHBOWL_GHASTTEAR = FrightsDelight.res("punchbowl_ghasttear");
    public static final ResourceLocation PUNCHBOWL_SOUL_BERRY = FrightsDelight.res("punchbowl_soul_berry");
    public static final ResourceLocation PUNCHBOWL_WITHER_BERRY = FrightsDelight.res("punchbowl_wither_berry");

}
