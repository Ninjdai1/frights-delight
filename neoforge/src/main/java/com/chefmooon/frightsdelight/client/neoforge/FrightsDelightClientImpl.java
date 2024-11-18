package com.chefmooon.frightsdelight.client.neoforge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.client.FrightsDelightClient;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.SharedConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.KnownPack;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.neoforged.fml.ModList;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.resource.EmptyPackResources;
import net.neoforged.neoforgespi.language.IModFileInfo;
import net.neoforged.neoforgespi.locating.IModFile;

import java.util.Optional;

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
            consumer.accept(Pack.readMetaAndCreate(
                    new PackLocationInfo(
                            path, // Pack ID
                            name, // Pack name
                            PackSource.DEFAULT,
                            Optional.of(new KnownPack(FrightsDelight.MOD_ID, modFile.findResource("resourcepacks/" + folder).toString(), "15"))),
                    new EmptyPackResources.EmptyResourcesSupplier(new PackMetadataSection(Component.literal(FrightsDelight.MOD_ID + "/" + folder),
                            SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES))),
    // todo - test this, from ubes delight
//                    path, // Pack ID
//                    name, // Pack name
//                    false,
//                    (p) -> new PathPackResources(path, true, modFile.findResource("resourcepacks/" + folder)), // Your custom resource pack provider
//                    new Pack.Info(Component.literal(FrightsDelight.MOD_ID + "/" + folder), 15, FeatureFlagSet.of()), // Pack description and compatibility version
                    PackType.CLIENT_RESOURCES,
                    new PackSelectionConfig(
                            false,
                            Pack.Position.TOP,
                            false
                    )
            ));
        });
    }

    public static boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }
}
