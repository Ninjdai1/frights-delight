package com.chefmooon.frightsdelight.client.event.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.client.particle.SlimeBubbleParticle;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightParticleTypes;
import eu.midnightdust.lib.config.MidnightConfig;
import eu.midnightdust.lib.util.MidnightColorUtil;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = FrightsDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEventsImpl {
    public static void registerClientTick(TickEvent.ClientTickEvent event) {
        MidnightColorUtil.tick();
    }

    @SubscribeEvent
    public static void onPostInit(FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.addListener(ClientSetupEventsImpl::registerClientTick);
        ModList.get().forEachModContainer((modid, modContainer) -> {
            if (MidnightConfig.configClass.containsKey(modid)) {
                modContainer.registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
                        new ConfigScreenHandler.ConfigScreenFactory((client, parent) -> MidnightConfig.getScreen(parent, modid)));
            }
        });

    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.SLIME_BUBBLE.get(), SlimeBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.ROTTEN_FLESH_BUBBLE.get(), SlimeBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.SPIDER_EYE_BUBBLE.get(), SlimeBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.SOUL_BERRY_BUBBLE.get(), SlimeBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.WITHER_BERRY_BUBBLE.get(), SlimeBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.COBWEB_BUBBLE.get(), SlimeBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.GHAST_TEAR_BUBBLE.get(), SlimeBubbleParticle.Factory::new);
    }
}
