package com.chefmooon.frightsdelight.registry;

import com.chefmooon.frightsdelight.FrightsDelight;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public enum SoundsRegistry {

    EFFECT_HYSTERIA_CLOSE("effect_hysteria_close"),
    EFFECT_HYSTERIA_MID("effect_hysteria_mid"),
    EFFECT_HYSTERIA_FAR("effect_hysteria_far"),
    BLOCK_DRINKABLE_FEAST_ADD("block_drinkable_feast_add"),
    BLOCK_DRINKABLE_FEAST_REMOVE("block_drinkable_feast_remove"),
    BLOCK_DRINKABLE_FEAST_BUBBLE("block_drinkable_feast_bubble")
    ;
    private final String pathName;
    private final SoundEvent soundEvent;

    SoundsRegistry(String pathName) {
        this.pathName = pathName;
        this.soundEvent = SoundEvent.of(new Identifier(FrightsDelight.MOD_ID, this.pathName));
    }

    public static void registerAll() {
        for (SoundsRegistry value : values()) {
            Registry.register(Registries.SOUND_EVENT, new Identifier(FrightsDelight.MOD_ID, value.pathName), value.soundEvent);
        }
    }

    public SoundEvent get() {
        return soundEvent;
    }
}
