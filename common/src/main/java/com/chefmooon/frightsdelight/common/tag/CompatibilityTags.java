package com.chefmooon.frightsdelight.common.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CompatibilityTags {
    public static final String CREATE = "create";
    public static final TagKey<Block> CREATE_FAN_HEATERS = getBlockTagKey(CREATE, "fan_heaters");
    public static final TagKey<Item> CREATE_UPRIGHT_ON_BELT = getItemTagKey(CREATE, "upright_on_belt");

    public static final String SUPPLEMENTARIES = "supplementaries";
    public static final TagKey<Item> SUPPLEMENTARIES_COOKIES = getItemTagKey(SUPPLEMENTARIES, "cookies");

    public static final String DEHYDRATION = "dehydration";
    public static final TagKey<Item> DEHYDRATION_HYDRATING_DRINKS = getItemTagKey(DEHYDRATION, "hydrating_drinks");
    public static final TagKey<Item> DEHYDRATION_HYDRATING_STEW = getItemTagKey(DEHYDRATION, "hydrating_stew");

    public static final String ORIGINS = "origins";
    public static final TagKey<Item> ORIGINS_MEAT = getItemTagKey(ORIGINS, "meat");
    public static final TagKey<Item> ORIGINS_IGNORE_DIET = getItemTagKey(ORIGINS, "ignore_diet");

    public static final String CREATE_ADDITION = "createaddition";
    public static final TagKey<Item> CREATE_ADDITION_PLANT_FOODS = getItemTagKey(CREATE_ADDITION, "plant_foods");

    public static TagKey<Item> getItemTagKey(String namespace, String path) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(namespace, path));
    }
    public static TagKey<Block> getBlockTagKey(String namespace, String path) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(namespace, path));
    }
}
