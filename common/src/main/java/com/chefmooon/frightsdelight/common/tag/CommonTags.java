package com.chefmooon.frightsdelight.common.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CommonTags {

    public static final TagKey<Item> C_TOOLS_KNIVES = getCommonItemTagKey("tools/knives");
    public static final TagKey<Block> C_MINEABLE_KNIFE = getCommonBlockTagKey("mineable/knife");

    public static final TagKey<Item> C_FOODS_VEGETABLE = getCommonItemTagKey("foods/vegetable");

    public static TagKey<Item> getCommonItemTagKey(String path) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", path));
    }
    public static TagKey<Block> getCommonBlockTagKey(String path) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", path));
    }

}
