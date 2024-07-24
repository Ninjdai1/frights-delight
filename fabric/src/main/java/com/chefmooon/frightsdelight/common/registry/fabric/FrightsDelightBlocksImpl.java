package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.block.SlimeAppleDrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.block.SoulBerryBushBlock;
import com.chefmooon.frightsdelight.common.block.WitherBerryBushBlock;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FrightsDelightBlocksImpl {
    public static final Block SOUL_BERRY_BUSH = registerBlock(FrightsDelightBlocks.SOUL_BERRY_BUSH.getPath(), new SoulBerryBushBlock());
    public static final Block WITHER_BERRY_BUSH = registerBlock(FrightsDelightBlocks.WITHER_BERRY_BUSH.getPath(), new WitherBerryBushBlock());

    public static final Block FLESH_CRATE = registerBlock(FrightsDelightBlocks.FLESH_CRATE.getPath(),
            new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block BONE_CRATE = registerBlock(FrightsDelightBlocks.BONE_CRATE.getPath(),
            new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block PHANTOM_CRATE = registerBlock(FrightsDelightBlocks.PHANTOM_CRATE.getPath(),
            new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block WEB_CRATE = registerBlock(FrightsDelightBlocks.WEB_CRATE.getPath(),
            new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block SPIDER_EYE_CRATE = registerBlock(FrightsDelightBlocks.SPIDER_EYE_CRATE.getPath(),
            new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block FERMENTED_SPIDER_EYE_CRATE = registerBlock(FrightsDelightBlocks.FERMENTED_SPIDER_EYE_CRATE.getPath(),
            new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block POISONOUS_POTATO_CRATE = registerBlock(FrightsDelightBlocks.POISONOUS_POTATO_CRATE.getPath(),
            new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block ROTTEN_TOMATO_CRATE = registerBlock(FrightsDelightBlocks.ROTTEN_TOMATO_CRATE.getPath(),
            new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final Block PUNCHBOWL_SLIMEAPPLE = registerBlock(FrightsDelightBlocks.PUNCHBOWL_SLIMEAPPLE.getPath(),
            new SlimeAppleDrinkableFeastBlock(() -> FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE,
                    BlockBehaviour.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS).lightLevel(value -> 10)));
    public static final Block PUNCHBOWL_SPIDEREYE = registerBlock(FrightsDelightBlocks.PUNCHBOWL_SPIDEREYE.getPath(),
            new DrinkableFeastBlock(() -> FrightsDelightItemsImpl.PUNCH_SPIDEREYE,
                    BlockBehaviour.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final Block PUNCHBOWL_GHASTTEAR = registerBlock(FrightsDelightBlocks.PUNCHBOWL_GHASTTEAR.getPath(),
            new DrinkableFeastBlock(() -> FrightsDelightItemsImpl.PUNCH_GHASTTEAR,
                    BlockBehaviour.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final Block PUNCHBOWL_SOUL_BERRY = registerBlock(FrightsDelightBlocks.PUNCHBOWL_SOUL_BERRY.getPath(),
            new DrinkableFeastBlock(() -> FrightsDelightItemsImpl.PUNCH_SOUL_BERRY,
                    BlockBehaviour.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final Block PUNCHBOWL_WITHER_BERRY = registerBlock(FrightsDelightBlocks.PUNCHBOWL_WITHER_BERRY.getPath(),
            new DrinkableFeastBlock(() -> FrightsDelightItemsImpl.PUNCH_WITHER_BERRY,
                    BlockBehaviour.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));

    public static Block registerBlock(final String name, final Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, FrightsDelight.res(name), block);
    }

    public static void register() {

    }
}
