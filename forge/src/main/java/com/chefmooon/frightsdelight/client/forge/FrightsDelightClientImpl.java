package com.chefmooon.frightsdelight.client.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.client.FrightsDelightClient;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.forgespi.language.IModFileInfo;
import net.minecraftforge.forgespi.locating.IModFile;
import net.minecraftforge.resource.PathPackResources;

public class FrightsDelightClientImpl {
    public static void init(final FMLClientSetupEvent event) {
        FrightsDelightClient.init();
    }

    public static void onBuiltinPackRegistration(AddPackFindersEvent event) {
        if (isModLoaded("presencefootsteps")) {
            registerBuiltinResourcePack(event, Component.literal(FrightsDelight.MOD_ID + "/frdpresencefootsteps"), "frdpresencefootsteps");
        }
    }

    private static void registerBuiltinResourcePack(AddPackFindersEvent event, MutableComponent name, String folder) {
        IModFileInfo modFileInfo = ModList.get().getModFileById(FrightsDelight.MOD_ID);
        if (modFileInfo == null) {
            return;
        }
        String path = TextUtils.res(folder).toString();
        IModFile modFile = modFileInfo.getFile();
        event.addRepositorySource((consumer) -> {
            consumer.accept(Pack.create(
                    path, // Pack ID
                    name, // Pack name
                    false,
                    (p) -> new PathPackResources(path, true, modFile.findResource("resourcepacks/" + folder)), // Your custom resource pack provider
                    new Pack.Info(Component.literal(FrightsDelight.MOD_ID + "/" + folder), 15, FeatureFlagSet.of()), // Pack description and compatibility version
                    PackType.CLIENT_RESOURCES,
                    Pack.Position.TOP,
                    false,
                    PackSource.BUILT_IN
            ));
        });
    }

    public static boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }
}
