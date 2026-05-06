package net.pm.revanil.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.particle.FlameParticle;
import net.pm.revanil.client.particle.RParticles;

public class RevanilClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ParticleProviderRegistry.getInstance().register(RParticles.SPARK, FlameParticle.Provider::new);
    }
}
