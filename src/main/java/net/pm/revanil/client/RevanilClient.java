package net.pm.revanil.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.FlameParticle;
import net.pm.revanil.client.particle.RParticles;

public class RevanilClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(RParticles.SPARK, FlameParticle.Provider::new);
    }
}
