package net.pm.revanil.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.pm.revanil.data.*;

public class RevanilDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(RBlockTags::new);
        pack.addProvider(RItemTags::new);
        pack.addProvider(Lang::new);
        pack.addProvider(Models::new);
        pack.addProvider(Recipes::new);
    }
}
