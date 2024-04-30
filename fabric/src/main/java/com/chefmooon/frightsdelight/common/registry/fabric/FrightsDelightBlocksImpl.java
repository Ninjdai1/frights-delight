package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.block.SlimeAppleDrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.block.SoulBerryBushBlock;
import com.chefmooon.frightsdelight.common.block.WitherBerryBushBlock;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class FrightsDelightBlocksImpl {
    public static final LazyRegistrar<Block> BLOCKS = LazyRegistrar.create(BuiltInRegistries.BLOCK, FrightsDelight.MOD_ID);

    public static final Supplier<Block> SOUL_BERRY_BUSH = BLOCKS.register("soul_berry_bush", SoulBerryBushBlock::new);
    public static final Supplier<Block> WITHER_BERRY_BUSH = BLOCKS.register("wither_berry_bush", WitherBerryBushBlock::new);

    public static final Supplier<Block> FLESH_CRATE = BLOCKS.register("flesh_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> BONE_CRATE = BLOCKS.register("bone_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> PHANTOM_CRATE = BLOCKS.register("phantom_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> WEB_CRATE = BLOCKS.register("web_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> SPIDER_EYE_CRATE = BLOCKS.register("spider_eye_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> FERMENTED_SPIDER_EYE_CRATE = BLOCKS.register("fermented_spider_eye_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> POISONOUS_POTATO_CRATE = BLOCKS.register("poisonous_potato_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> ROTTEN_TOMATO_CRATE = BLOCKS.register("rotten_tomato_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final Supplier<Block> PUNCHBOWL_SLIMEAPPLE = BLOCKS.register("punchbowl_slimeapple",
            () -> new SlimeAppleDrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE, BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> PUNCHBOWL_SPIDEREYE = BLOCKS.register("punchbowl_spidereye",
            () -> new DrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_SPIDEREYE, BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> PUNCHBOWL_GHASTTEAR = BLOCKS.register("punchbowl_ghasttear",
            () -> new DrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_GHASTTEAR, BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> PUNCHBOWL_SOUL_BERRY = BLOCKS.register("punchbowl_soul_berry",
            () -> new DrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY, BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> PUNCHBOWL_WITHER_BERRY = BLOCKS.register("punchbowl_wither_berry",
            () -> new DrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY, BlockBehaviour.Properties.copy(Blocks.GLASS)));
}
