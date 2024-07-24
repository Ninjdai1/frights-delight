package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.effect.*;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

import java.util.function.Supplier;

public class FrightsDelightEffects {

    public static final Supplier<MobEffect> FORTIFIED_MIND = mobEffect("fortified_mind", FortifiedMindEffect::new);
    public static final Supplier<MobEffect> CHILLS = mobEffect("chills", ChillsEffect::new);
    public static final Supplier<MobEffect> INFECTED = mobEffect("infected", InfectedEffect::new);
    public static final Supplier<MobEffect> UNDEAD_HUNGER = mobEffect("undead_hunger", UndeadHungerEffect::new);
    public static final Supplier<MobEffect> HYSTERIA = mobEffect("hysteria", HysteriaEffect::new);
    public static final Supplier<MobEffect> COBWEBBED = mobEffect("cobwebbed", CobwebbedEffect::new);
    public static final Supplier<MobEffect> SLIMED = mobEffect("slimed", SlimedEffect::new);

    private static <T extends MobEffect> Supplier<T> mobEffect(String string, Supplier<T> supplier) {
        return registerEffect(TextUtils.res(string), supplier);
    }

    @ExpectPlatform
    public static <T extends MobEffect> Supplier<T> registerEffect(ResourceLocation location, Supplier<T> supplier) {
        throw new AssertionError();
    }

    public static void init() {

    }
}
