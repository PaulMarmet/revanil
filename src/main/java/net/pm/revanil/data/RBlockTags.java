package net.pm.revanil.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class RBlockTags extends FabricTagProvider.BlockTagProvider {
    public RBlockTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .setReplace(true);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .forceAddTag(BlockTags.NEEDS_IRON_TOOL)
                .forceAddTag(BlockTags.NEEDS_STONE_TOOL)
                .setReplace(true);
    }

    public Identifier id(ItemConvertible item) {
        return Registries.ITEM.getId(item.asItem());
    }
}
