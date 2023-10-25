package com.chefmooon.frightsdelight.tag;

import com.chefmooon.frightsdelight.util.TagUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

public class CompatibilityTags {

    public static final String CREATE = "create";
    public static final TagKey<Block> CREATE_FAN_HEATERS = TagUtil.getBlockTagKey(CREATE, "fan_heaters");
    public static final TagKey<Item> CREATE_UPRIGHT_ON_BELT = TagUtil.getItemTagKey(CREATE, "upright_on_belt");


    public static final String SUPPLEMENTARIES = "supplementaries";
    public static final TagKey<Item> SUPPLEMENTARIES_COOKIES = TagUtil.getItemTagKey(SUPPLEMENTARIES, "cookies");

}
