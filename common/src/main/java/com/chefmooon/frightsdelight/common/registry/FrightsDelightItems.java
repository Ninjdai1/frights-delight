package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.utility.TextUtils;
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

    public static final ResourceLocation FLESH_CRATE = item("flesh_crate");
    public static final ResourceLocation BONE_CRATE = item("bone_crate");
    public static final ResourceLocation PHANTOM_CRATE = item("phantom_crate");
    public static final ResourceLocation WEB_CRATE = item("web_crate");
    public static final ResourceLocation SPIDER_EYE_CRATE = item("spider_eye_crate");
    public static final ResourceLocation FERMENTED_SPIDER_EYE_CRATE = item("fermented_spider_eye_crate");
    public static final ResourceLocation POISONOUS_POTATO_CRATE = item("poisonous_potato_crate");
    public static final ResourceLocation ROTTEN_TOMATO_CRATE = item("rotten_tomato_crate");

    public static final ResourceLocation SOUL_BERRY = item("soul_berry");
    public static final ResourceLocation WITHER_BERRY = item("wither_berry");

    public static final ResourceLocation APPLE_SLIME = item("apple_slime");
    public static final ResourceLocation UNDEAD_KEBAB = item("undead_kebab");
    public static final ResourceLocation WEB_ON_STICK = item("web_on_stick");

    public static final ResourceLocation MONSTER_MASH = item("monster_mash");
    public static final ResourceLocation PASTA_WITH_SLIMEBALLS = item("pasta_with_slimeballs");
    public static final ResourceLocation SOUP_ROTTEN_FLESH = item("soup_rotten_flesh");
    public static final ResourceLocation SOUP_SPIDER_EYE = item("soup_spider_eye");
    public static final ResourceLocation SOUP_SLIME = item("soup_slime");

    public static final ResourceLocation COOKIE_SOUL_BERRY = item("cookie_soul_berry");
    public static final ResourceLocation COOKIE_ROTTEN_FLESH = item("cookie_flesh");
    public static final ResourceLocation COOKIE_SPIDER_EYE = item("cookie_spidereye");

    public static final ResourceLocation PUNCH_SLIMEAPPLE = item("punch_slimeapple");
    public static final ResourceLocation PUNCH_SPIDEREYE = item("punch_spidereye");
    public static final ResourceLocation PUNCH_GHASTTEAR = item("punch_ghasttear");
    public static final ResourceLocation PUNCH_SOUL_BERRY = item("punch_soul_berry");
    public static final ResourceLocation PUNCH_WITHER_BERRY = item("punch_wither_berry");

    public static final ResourceLocation PUNCHBOWL_SLIMEAPPLE = item("punchbowl_slimeapple");
    public static final ResourceLocation PUNCHBOWL_SPIDEREYE = item("punchbowl_spidereye");
    public static final ResourceLocation PUNCHBOWL_GHASTTEAR = item("punchbowl_ghasttear");
    public static final ResourceLocation PUNCHBOWL_SOUL_BERRY = item("punchbowl_soul_berry");
    public static final ResourceLocation PUNCHBOWL_WITHER_BERRY = item("punchbowl_wither_berry");

    private static ResourceLocation item(String string) {
        return TextUtils.res(string);
    }

}
