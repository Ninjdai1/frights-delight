package com.chefmooon.frightsdelight.common.tag;

import com.chefmooon.frightsdelight.FrightsDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class FrightsDelightTags {
    public static final TagKey<Block> SOUL_BERRY_BUSH_GROW_CONDITIION = getFrightsDelightBlockTagKey("soul_berry_bush_grow_condition");
    public static final TagKey<Block> WITHER_BERRY_BUSH_GROW_CONDITIION = getFrightsDelightBlockTagKey("wither_berry_bush_grow_condition");

    public static TagKey<Item> getFrightsDelightItemTagKey(String path) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(FrightsDelight.MOD_ID, path));
    }
    public static TagKey<Block> getFrightsDelightBlockTagKey(String path) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(FrightsDelight.MOD_ID, path));
    }
}
