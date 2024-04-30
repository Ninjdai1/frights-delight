package com.chefmooon.frightsdelight.common.utility.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;

import java.util.Optional;

public class FrightsDelightModels {
    public static final ModelTemplate TEMPLATE_DRINK_FEAST_LEFTOVER = block("template_drink_feast_leftover",
            FrightsDelightTextureSlots.DRINK_FEAST_INSIDE, FrightsDelightTextureSlots.PUNCH_BOWL, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_DRINK_FEAST_STAGE0 = block("template_drink_feast_stage0",
            FrightsDelightTextureSlots.DRINK_FEAST_INSIDE, FrightsDelightTextureSlots.PUNCH_BOWL, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_DRINK_FEAST_STAGE1 = block("template_drink_feast_stage1",
            FrightsDelightTextureSlots.DRINK_FEAST_INSIDE, FrightsDelightTextureSlots.PUNCH_BOWL, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_DRINK_FEAST_STAGE2 = block("template_drink_feast_stage2",
            FrightsDelightTextureSlots.DRINK_FEAST_INSIDE, FrightsDelightTextureSlots.PUNCH_BOWL, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_DRINK_FEAST_STAGE3 = block("template_drink_feast_stage3",
            FrightsDelightTextureSlots.DRINK_FEAST_INSIDE, FrightsDelightTextureSlots.PUNCH_BOWL, TextureSlot.PARTICLE);

    public static final ModelTemplate TEMPLATE_CROP_CROSS = block("template_crop_cross", TextureSlot.CROSS);

    private static ModelTemplate block(String parent, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(FrightsDelight.res("block/" + parent)), Optional.empty(), textureSlots);
    }
}
