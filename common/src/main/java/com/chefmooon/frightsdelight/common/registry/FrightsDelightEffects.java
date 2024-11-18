package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.effect.*;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

import java.util.function.Supplier;

public class FrightsDelightEffects {

    public static final Holder<MobEffect> FORTIFIED_MIND = mobEffect("fortified_mind", FortifiedMindEffect::new);
    public static final Holder<MobEffect> CHILLS = mobEffect("chills", ChillsEffect::new);
    public static final Holder<MobEffect> INFECTED = mobEffect("infected", InfectedEffect::new);
    public static final Holder<MobEffect> UNDEAD_HUNGER = mobEffect("undead_hunger", UndeadHungerEffect::new);
    public static final Holder<MobEffect> HYSTERIA = mobEffect("hysteria", HysteriaEffect::new);
    public static final Holder<MobEffect> COBWEBBED = mobEffect("cobwebbed", CobwebbedEffect::new);
    public static final Holder<MobEffect> SLIMED = mobEffect("slimed", SlimedEffect::new);

    private static Holder<MobEffect> mobEffect(String string, Supplier<MobEffect> supplier) {
        return registerEffect(TextUtils.res(string), supplier);
    }

    @ExpectPlatform
    public static Holder<MobEffect> registerEffect(ResourceLocation location, Supplier<MobEffect> supplier) {
        throw new AssertionError();
    }

    public static void init() {

    }
}
