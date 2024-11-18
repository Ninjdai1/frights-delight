package com.chefmooon.frightsdelight.common.tag;

import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class FrightsDelightTags {
    public static final TagKey<Block> SOUL_BERRY_BUSH_GROW_CONDITIION = getFrightsDelightBlockTagKey("soul_berry_bush_grow_condition");
    public static final TagKey<Block> WITHER_BERRY_BUSH_GROW_CONDITIION = getFrightsDelightBlockTagKey("wither_berry_bush_grow_condition");

    public static TagKey<Item> getFrightsDelightItemTagKey(String path) {
        return TagKey.create(Registries.ITEM, TextUtils.res(path));
    }
    public static TagKey<Block> getFrightsDelightBlockTagKey(String path) {
        return TagKey.create(Registries.BLOCK, TextUtils.res(path));
    }

    public static final TagKey<Biome> WILD_SOUL_BERRY_BUSH_WHITELIST = getFrightsDelightBiomeTag("wild_soul_berry_bush_whitelist");
    public static final TagKey<Biome> WILD_SOUL_BERRY_BUSH_BLACKLIST = getFrightsDelightBiomeTag("wild_soul_berry_bush_blacklist");

    private static TagKey<Biome> getFrightsDelightBiomeTag(String path) {
        return TagKey.create(Registries.BIOME, TextUtils.res(path));
    }
}
