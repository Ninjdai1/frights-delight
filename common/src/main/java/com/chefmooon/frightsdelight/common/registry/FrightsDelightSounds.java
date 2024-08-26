package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.utility.TextUtils;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class FrightsDelightSounds {

    public static final Supplier<SoundEvent> EFFECT_HYSTERIA_CLOSE = registerSound("effect_hysteria_close");
    public static final Supplier<SoundEvent> EFFECT_HYSTERIA_MID = registerSound("effect_hysteria_mid");
    public static final Supplier<SoundEvent> EFFECT_HYSTERIA_FAR = registerSound("effect_hysteria_far");
    public static final Supplier<SoundEvent> EFFECT_SLIMED = registerSound("effect_slimed");
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_ADD = registerSound("block_drinkable_feast_add");
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_REMOVE = registerSound("block_drinkable_feast_remove");
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_BUBBLE = registerSound("block_drinkable_feast_bubble");

    private static Supplier<SoundEvent> registerSound(String string) {
        return registerSound(TextUtils.res(string), () -> SoundEvent.createVariableRangeEvent(TextUtils.res(string)));
    }

    @ExpectPlatform
    public static <T extends SoundEvent> Supplier<T> registerSound(ResourceLocation id, Supplier<T> supplier) {
        throw new AssertionError();
    }

    public static void init() {

    }
}
