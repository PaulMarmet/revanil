package net.pm.revanil.client.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.pm.revanil.Revanil;

public class RParticles {
    public static final SimpleParticleType SPARK = Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(Revanil.MOD_ID, "spark"), FabricParticleTypes.simple());

    public static void init() {

    }
}
