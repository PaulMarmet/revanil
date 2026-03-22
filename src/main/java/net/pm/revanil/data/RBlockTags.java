package net.pm.revanil.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.ItemLike;
import java.util.concurrent.CompletableFuture;

public class RBlockTags extends FabricTagProvider.BlockTagProvider {
    public RBlockTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .setReplace(true);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .forceAddTag(BlockTags.NEEDS_IRON_TOOL)
                .forceAddTag(BlockTags.NEEDS_STONE_TOOL)
                .setReplace(true);
    }

    public Identifier id(ItemLike item) {
        return BuiltInRegistries.ITEM.getKey(item.asItem());
    }
}
