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

    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_ROTTEN_FLESH_BUBBLE = registerSound("block_drinkable_feast_rotten_flesh_bubble");
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_SPIDER_EYE_BUBBLE = registerSound("block_drinkable_feast_spider_eye_bubble");
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_SLIMEAPPLE_BUBBLE = registerSound("block_drinkable_feast_slimeapple_bubble");
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_COBWEB_BUBBLE = registerSound("block_drinkable_feast_cobweb_bubble");
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_GHAST_TEAR_BUBBLE = registerSound("block_drinkable_feast_ghast_tear_bubble");
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_SOUL_BERRY_BUBBLE = registerSound("block_drinkable_feast_soul_berry_bubble");
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_WITHER_BERRY_BUBBLE = registerSound("block_drinkable_feast_wither_berry_bubble");

    public static final Supplier<SoundEvent> ENTITY_BONE_SHARD_THROW = registerSound("entity.bone_shard.throw");
    public static final Supplier<SoundEvent> ENTITY_BONE_SHARD_HIT = registerSound("entity.bone_shard.hit");

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
