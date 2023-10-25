package com.chefmooon.frightsdelight.tag;

import com.chefmooon.frightsdelight.util.TagUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

public class CommonTags {

    public static final TagKey<Item> C_TOOLS_KNIVES = TagUtil.registerCommonItem("tools/knives");
    public static final TagKey<Block> C_MINEABLE_KNIFE = TagUtil.registerCommonBlock("mineable/knife");
}
