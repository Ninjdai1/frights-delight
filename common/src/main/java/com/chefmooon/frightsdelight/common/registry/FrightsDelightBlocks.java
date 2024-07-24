package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.resources.ResourceLocation;

public class FrightsDelightBlocks {

    public static final ResourceLocation SOUL_BERRY_BUSH = block("soul_berry_bush");
    public static final ResourceLocation WITHER_BERRY_BUSH = block("wither_berry_bush");

    public static final ResourceLocation FLESH_CRATE = block("flesh_crate");
    public static final ResourceLocation BONE_CRATE = block("bone_crate");
    public static final ResourceLocation PHANTOM_CRATE = block("phantom_crate");
    public static final ResourceLocation WEB_CRATE = block("web_crate");
    public static final ResourceLocation SPIDER_EYE_CRATE = block("spider_eye_crate");
    public static final ResourceLocation FERMENTED_SPIDER_EYE_CRATE = block("fermented_spider_eye_crate");
    public static final ResourceLocation POISONOUS_POTATO_CRATE = block("poisonous_potato_crate");
    public static final ResourceLocation ROTTEN_TOMATO_CRATE = block("rotten_tomato_crate");

    public static final ResourceLocation PUNCHBOWL_SLIMEAPPLE = block("punchbowl_slimeapple");
    public static final ResourceLocation PUNCHBOWL_SPIDEREYE = block("punchbowl_spidereye");
    public static final ResourceLocation PUNCHBOWL_GHASTTEAR = block("punchbowl_ghasttear");
    public static final ResourceLocation PUNCHBOWL_SOUL_BERRY = block("punchbowl_soul_berry");
    public static final ResourceLocation PUNCHBOWL_WITHER_BERRY = block("punchbowl_wither_berry");

    private static ResourceLocation block(String string) {
        return TextUtils.res(string);
    }

}
