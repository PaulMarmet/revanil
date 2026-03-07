package net.pm.revanil.data;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.pm.revanil.item.RItems;

public class Models extends FabricModelProvider {

    public Models(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(RItems.IRON_UPGRADE_TEMPLATE, net.minecraft.client.data.Models.GENERATED);
        itemModelGenerator.register(RItems.GOLD_UPGRADE_TEMPLATE, net.minecraft.client.data.Models.GENERATED);
    }
}
