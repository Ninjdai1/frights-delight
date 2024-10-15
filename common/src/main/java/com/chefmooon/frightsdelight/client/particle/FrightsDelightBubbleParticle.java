package com.chefmooon.frightsdelight.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class FrightsDelightBubbleParticle extends TextureSheetParticle {
    protected FrightsDelightBubbleParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(level, x, y, z);
        this.scale(this.random.nextFloat() * 0.5F + 0.2F);
        this.setSize(0.25F, 0.25F);
        this.xd = xSpeed * 0.10000000298023224 + (this.random.nextDouble() * 0.6 - 0.3) * 0.01;
        this.yd = ySpeed * 0.20000000298023224 + this.random.nextDouble() * 0.009;
        this.zd = zSpeed * 0.10000000298023224 + (this.random.nextDouble() * 0.6 - 0.3) * 0.01;
        this.lifetime = this.random.nextInt(30) + 70;
        this.gravity = 3.0E-6F;
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ < this.lifetime && !(this.alpha <= 0.0F)) {
            this.xd += this.random.nextFloat() / 10000.0F * (float) (this.random.nextBoolean() ? 1 : -1);
            this.zd += this.random.nextFloat() / 10000.0F * (float) (this.random.nextBoolean() ? 1 : -1);
            this.yd -= this.gravity * 0.5;
            this.move(this.xd, this.yd, this.zd);
            if (this.age >= this.lifetime - 60 && this.alpha > 0.01F) {
                this.alpha -= 0.02F;
            }
        } else {
            this.remove();
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;
        public Factory(SpriteSet sprite) {
            this.spriteSet = sprite;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            FrightsDelightBubbleParticle particle = new FrightsDelightBubbleParticle(level, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.setAlpha(0.8F);
            particle.pickSprite(this.spriteSet);
            return particle;
        }
    }
}
