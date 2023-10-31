package com.chefmooon.frightsdelight.registry;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.block.SlimeApplePunch;
import com.chefmooon.frightsdelight.block.SoulBerryBushBlock;
import com.chefmooon.frightsdelight.block.WitherBerryBushBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public enum BlocksRegistry {

    SOUL_BERRY_BUSH("soul_berry_bush", SoulBerryBushBlock::new, true, flammable(100,60)),
    WITHER_BERRY_BUSH("wither_berry_bush", WitherBerryBushBlock::new, true, flammable(100,60)),

    FLESH_CRATE("flesh_crate", () -> new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD))),
    BONE_CRATE("bone_crate", () -> new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD))),
    PHANTOM_CRATE("phantom_crate", () -> new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD))),
    WEB_CRATE("web_crate", () -> new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD))),
    SPIDER_EYE_CRATE("spider_eye_crate", () -> new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD))),
    FERMENTED_SPIDER_EYE_CRATE("fermented_spider_eye_crate", () -> new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD))),
    POISONOUS_POTATO_CRATE("poisonous_potato_crate", () -> new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD))),
    ROTTEN_TOMATO_CRATE("rotten_tomato_crate", () -> new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD))),

    PUNCHBOWL_SLIMEAPPLE("punchbowl_slimeapple", () -> new SlimeApplePunch(ItemsRegistry.PUNCH_SLIMEAPPLE.get(), ParticleEffectsRegistry.SLIME_BUBBLE.get()), true),
    PUNCHBOWL_SPIDEREYE("punchbowl_spidereye", () -> new DrinkableFeastBlock(ItemsRegistry.PUNCH_SPIDEREYE.get()), true),
    PUNCHBOWL_GHASTTEAR("punchbowl_ghasttear", () -> new DrinkableFeastBlock(ItemsRegistry.PUNCH_GHASTTEAR.get()), true),
    PUNCHBOWL_SOUL_BERRY("punchbowl_soul_berry", () -> new DrinkableFeastBlock(ItemsRegistry.PUNCH_SOUL_BERRY.get()), true),
    PUNCHBOWL_WITHER_BERRY("punchbowl_wither_berry", () -> new DrinkableFeastBlock(ItemsRegistry.PUNCH_WITHER_BERRY.get()), true)
    ;

    private static FlammableBlockRegistry.Entry flammable(int burnChance, @SuppressWarnings("SameParameterValue") int spreadChance) {
        return new FlammableBlockRegistry.Entry(burnChance, spreadChance);
    }

    private static boolean isValidFlammableEntry(FlammableBlockRegistry.Entry flammableRate) {
        return flammableRate != null && flammableRate.getBurnChance() > 0 && flammableRate.getSpreadChance() > 0;
    }

    private final String pathName;
    private final Supplier<Block> blockSupplier;
    private final FlammableBlockRegistry.Entry flammableRate;
    private final boolean isCutout;
    private Block block;

    BlocksRegistry(String pathName, Supplier<Block> blockSupplier) {
        this(pathName, blockSupplier, false, new FlammableBlockRegistry.Entry(0, 0));
    }

    BlocksRegistry(String pathName, Supplier<Block> blockSupplier, boolean isCutout) {
        this(pathName, blockSupplier, isCutout, new FlammableBlockRegistry.Entry(0, 0));
    }

    BlocksRegistry(String pathName, Supplier<Block> blockSupplier, boolean isCutout, FlammableBlockRegistry.Entry flammableRate) {
        this.pathName = pathName;
        this.blockSupplier = blockSupplier;
        this.flammableRate = flammableRate;
        this.isCutout = isCutout;
    }
    public static void registerAll() {
        for (BlocksRegistry value : values()) {
            Block block = value.get();
            Registry.register(Registries.BLOCK, new Identifier(FrightsDelight.MOD_ID, value.pathName), block);
            if (isValidFlammableEntry(value.flammableRate)) {
                FlammableBlockRegistry.getDefaultInstance().add(block, value.flammableRate);
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public static void registerRenderLayer() {
        for (BlocksRegistry value : values()) {
            if (value.isCutout) {
                BlockRenderLayerMap.INSTANCE.putBlock(value.get(), RenderLayer.getCutout());
            }
        }
    }

    public Block get() {
        if (block == null) {
            block = blockSupplier.get();
        }

        return block;
    }

    public String getId() {
        return Registries.BLOCK.getId(get()).toString();
    }

    public String getPathName() {
        return pathName;
    }
}
