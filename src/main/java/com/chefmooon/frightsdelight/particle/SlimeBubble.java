package com.chefmooon.frightsdelight.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class SlimeBubble extends SpriteBillboardParticle {
    private final SpriteProvider spriteProvider;
    public SlimeBubble(ClientWorld clientWorld, double xCoord, double yCoord, double zCoord, SpriteProvider spriteSet, double xd, double yd, double zd) {
        super(clientWorld, xCoord, yCoord, zCoord, xd, yd, zd);

        //this.velocityMultiplier = 0.4F;
        this.x = xd;
        this.y = yd;
        this.z = zd;
        //this.scale *= 0.75F;
        //this.maxAge = 30;

        this.setBoundingBoxSpacing(0.02F, 0.02F);
        this.scale *= this.random.nextFloat() * 0.5F + 0.2F;
        this.velocityX = xd * 0.10000000298023224 + (Math.random() * 0.6 - 0.3) * 0.015;
        //this.velocityY = yd * 0.20000000298023224 + (Math.random() * 2.0 - 1.0) * 0.019999999552965164;
        this.velocityY = yd * 0.20000000298023224 + (Math.random()) * 0.008;
        this.velocityZ = zd * 0.10000000298023224 + (Math.random() * 0.6 - 0.3) * 0.015;
        this.maxAge = (int)(20.0 / (Math.random() * 0.8 + 0.2));

        this.spriteProvider = spriteSet;
        this.setSpriteForAge(spriteProvider);

        this.red = 1f;
        this.green = 1f;
        this.blue = 1f;
    }

    @Override
    public void tick() {
        super.tick();
        fadeOut();
    }

    private void fadeOut() {
        this.alpha = (-(1/(float)maxAge) * age + 1);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld level, double x, double y, double z, double dx, double dy, double dz) {
            return new SlimeBubble(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }
}
