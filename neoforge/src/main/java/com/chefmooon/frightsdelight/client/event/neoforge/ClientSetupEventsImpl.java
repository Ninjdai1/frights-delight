package com.chefmooon.frightsdelight.client.event.neoforge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.client.gui.neoforge.FrightsDelightGUIImpl;
import com.chefmooon.frightsdelight.client.particle.FrightsDelightBubbleParticle;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightParticleTypes;
import com.chefmooon.frightsdelight.common.registry.neoforge.FrightsDelightEntityTypesImpl;
import eu.midnightdust.lib.config.MidnightConfig;
import eu.midnightdust.lib.util.MidnightColorUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = FrightsDelight.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEventsImpl {
//    public static void registerClientTick(TickEvent.ClientTickEvent event) {
//        MidnightColorUtil.tick();
//    }
//
//    @SubscribeEvent
//    public static void onPostInit(final FMLClientSetupEvent event) {
//        MinecraftForge.EVENT_BUS.addListener(ClientSetupEventsImpl::registerClientTick);
//        ModList.get().forEachModContainer((modid, modContainer) -> {
//            if (MidnightConfig.configClass.containsKey(modid)) {
//                modContainer.registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
//                        new ConfigScreenHandler.ConfigScreenFactory((client, parent) -> MidnightConfig.getScreen(parent, modid)));
//            }
//        });
//
//    }
    // todo - midnight lib init?

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.SLIME_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.ROTTEN_FLESH_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.SPIDER_EYE_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.SOUL_BERRY_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.WITHER_BERRY_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.COBWEB_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.GHAST_TEAR_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
    }

    @SubscribeEvent
    public static void onEntityRendererRegister(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(FrightsDelightEntityTypesImpl.BONE_SHARD.get(), ThrownItemRenderer::new);
    }

    @SubscribeEvent
    public static void registerGuiLayers(RegisterGuiLayersEvent event) {
        FrightsDelightGUIImpl.register(event);
    }
}
