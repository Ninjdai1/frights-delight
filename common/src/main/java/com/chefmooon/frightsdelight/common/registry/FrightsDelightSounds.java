package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.FrightsDelight;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class FrightsDelightSounds {

    public static final Supplier<SoundEvent> EFFECT_HYSTERIA_CLOSE = registerSound("effect_hysteria_close",
            () -> SoundEvent.createVariableRangeEvent(FrightsDelight.res("effect_hysteria_close")));
    public static final Supplier<SoundEvent> EFFECT_HYSTERIA_MID = registerSound("effect_hysteria_mid",
            () -> SoundEvent.createVariableRangeEvent(FrightsDelight.res("effect_hysteria_mid")));
    public static final Supplier<SoundEvent> EFFECT_HYSTERIA_FAR = registerSound("effect_hysteria_far",
            () -> SoundEvent.createVariableRangeEvent(FrightsDelight.res("effect_hysteria_far")));
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_ADD = registerSound("block_drinkable_feast_add",
            () -> SoundEvent.createVariableRangeEvent(FrightsDelight.res("block_drinkable_feast_add")));
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_REMOVE = registerSound("block_drinkable_feast_remove",
            () -> SoundEvent.createVariableRangeEvent(FrightsDelight.res("block_drinkable_feast_remove")));
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_BUBBLE = registerSound("block_drinkable_feast_bubble",
            () -> SoundEvent.createVariableRangeEvent(FrightsDelight.res("block_drinkable_feast_bubble")));

    @ExpectPlatform
    public static <T extends SoundEvent> Supplier<T> registerSound(String id, Supplier<T> supplier) {
        throw new AssertionError();
    }

    public static void init() {

    }
}
