package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.effect.*;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.effect.MobEffect;

import java.util.function.Supplier;

public class FrightsDelightEffects {

    public static final Supplier<MobEffect> FORTIFIED_MIND = registerEffect("fortified_mind", FortifiedMindEffect::new);
    public static final Supplier<MobEffect> CHILLS = registerEffect("chills", ChillsEffect::new);
    public static final Supplier<MobEffect> INFECTED = registerEffect("infected", InfectedEffect::new);
    public static final Supplier<MobEffect> UNDEAD_HUNGER = registerEffect("undead_hunger", UndeadHungerEffect::new);
    public static final Supplier<MobEffect> HYSTERIA = registerEffect("hysteria", HysteriaEffect::new);
    public static final Supplier<MobEffect> COBWEBBED = registerEffect("cobwebbed", CobwebbedEffect::new);
    public static final Supplier<MobEffect> SLIMED = registerEffect("slimed", SlimedEffect::new);

    @ExpectPlatform
    public static <T extends MobEffect> Supplier<T> registerEffect(String id, Supplier<T> supplier) {
        throw new AssertionError();
    }

    public static void init() {

    }
}
