package com.chefmooon.frightsdelight.common.registry.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.block.SlimeAppleDrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.block.SoulBerryBushBlock;
import com.chefmooon.frightsdelight.common.block.WitherBerryBushBlock;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class FrightsDelightBlocksImpl {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, FrightsDelight.MOD_ID);

    public static final RegistryObject<Block> SOUL_BERRY_BUSH = BLOCKS.register(FrightsDelightBlocks.SOUL_BERRY_BUSH.getPath(), SoulBerryBushBlock::new);
    public static final RegistryObject<Block> WITHER_BERRY_BUSH = BLOCKS.register(FrightsDelightBlocks.WITHER_BERRY_BUSH.getPath(), WitherBerryBushBlock::new);

    public static final RegistryObject<Block> FLESH_CRATE = BLOCKS.register(FrightsDelightBlocks.FLESH_CRATE.getPath(),
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BONE_CRATE = BLOCKS.register(FrightsDelightBlocks.BONE_CRATE.getPath(),
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PHANTOM_CRATE = BLOCKS.register(FrightsDelightBlocks.PHANTOM_CRATE.getPath(),
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WEB_CRATE = BLOCKS.register(FrightsDelightBlocks.WEB_CRATE.getPath(),
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SPIDER_EYE_CRATE = BLOCKS.register(FrightsDelightBlocks.SPIDER_EYE_CRATE.getPath(),
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> FERMENTED_SPIDER_EYE_CRATE = BLOCKS.register(FrightsDelightBlocks.FERMENTED_SPIDER_EYE_CRATE.getPath(),
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> POISONOUS_POTATO_CRATE = BLOCKS.register(FrightsDelightBlocks.POISONOUS_POTATO_CRATE.getPath(),
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ROTTEN_TOMATO_CRATE = BLOCKS.register(FrightsDelightBlocks.ROTTEN_TOMATO_CRATE.getPath(),
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PUNCHBOWL_SLIMEAPPLE = BLOCKS.register(FrightsDelightBlocks.PUNCHBOWL_SLIMEAPPLE.getPath(),
            () -> new SlimeAppleDrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE,
                    Block.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PUNCHBOWL_SPIDEREYE = BLOCKS.register(FrightsDelightBlocks.PUNCHBOWL_SPIDEREYE.getPath(),
            () -> new DrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_SPIDEREYE,
                    Block.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PUNCHBOWL_GHASTTEAR = BLOCKS.register(FrightsDelightBlocks.PUNCHBOWL_GHASTTEAR.getPath(),
            () -> new DrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_GHASTTEAR,
                    Block.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PUNCHBOWL_SOUL_BERRY = BLOCKS.register(FrightsDelightBlocks.PUNCHBOWL_SOUL_BERRY.getPath(),
            () -> new DrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY,
                    Block.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PUNCHBOWL_WITHER_BERRY = BLOCKS.register(FrightsDelightBlocks.PUNCHBOWL_WITHER_BERRY.getPath(),
            () -> new DrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY,
                    Block.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
}
