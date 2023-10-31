package com.chefmooon.frightsdelight.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.particle.DefaultParticleType;

public class SlimeApplePunch extends DrinkableFeastBlock{
    public SlimeApplePunch(Item servingItem, DefaultParticleType particle) {
        super(servingItem, particle, FabricBlockSettings.copyOf(Blocks.GLASS).luminance(10));
    }

    /*
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        VoxelShape voxelShape = this.getOutlineShape(state, world, pos, ShapeContext.absent());
        Vec3d vec3d = voxelShape.getBoundingBox().getCenter();
        double d = (double)pos.getX() + vec3d.x;
        double e = (double)pos.getY() + (state.get(SERVINGS) / 6.0);
        double f = (double)pos.getZ() + vec3d.z;

        for(int i = 0; i < 3; ++i) {
            if (random.nextBoolean()) {
                world.addParticle(ParticleEffectsRegistry.SLIME_BUBBLE.get(), d + (random.nextDouble() - 0.5) / 2.0, e + ((1.0 - random.nextDouble()) / 8.0), f + (random.nextDouble() - 0.5) / 2.0, 0.0, 0.0, 0.0);

                //world.addParticle(ParticleEffectsRegistry.SLIME_BUBBLE.get(), true, d + (random.nextDouble() - 0.5) / 2.0, e + ((1.0 - random.nextDouble()) / 2), f + (random.nextDouble() - 0.5) / 2.0, 0.0, 0.0, 0.0);

                //if (random.nextBoolean()) {
                //    world.addParticle(ParticleEffectsRegistry.SLIME_BUBBLE_POP.get(), true, d + (random.nextDouble() - 0.5) / 2.0, e + ((1.0 - random.nextDouble()) / 2), f + (random.nextDouble() - 0.5) / 2.0, 0.0, 0.0, 0.0);
                //} else {
                //
                //}
            }
        }

    }

     */
}
