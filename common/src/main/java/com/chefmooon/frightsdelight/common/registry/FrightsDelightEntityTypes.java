package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.resources.ResourceLocation;

public class FrightsDelightEntityTypes {
    public static final ResourceLocation BONE_SHARD = entityType("bone_shard");

    private static ResourceLocation entityType(String string) {
        return TextUtils.res(string);
    }
}
