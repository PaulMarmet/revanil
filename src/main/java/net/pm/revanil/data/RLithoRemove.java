package net.pm.revanil.data;

import dev.worldgen.lithostitched.api.registry.LithostitchedRegistries;
import dev.worldgen.lithostitched.api.worldgen.modifier.WorldgenModifier;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.pm.revanil.Revanil;

public class RLithoRemove {
    public static ResourceKey<WorldgenModifier> removals = ResourceKey.create(LithostitchedRegistries.WORLDGEN_MODIFIER, Identifier.fromNamespaceAndPath(Revanil.MOD_ID, "removals"));

    public static void bootstrap(BootstrapContext<WorldgenModifier> context) {
        HolderGetter<Biome> biomeHolder = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedHolder = context.lookup(Registries.PLACED_FEATURE);


        context.register(removals,
                WorldgenModifier.builder().removeFeatures(
                        biomeHolder.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(
                                placedHolder.getOrThrow(OrePlacements.ORE_DIRT),
                                placedHolder.getOrThrow(OrePlacements.ORE_GRAVEL),
                                placedHolder.getOrThrow(OrePlacements.ORE_TUFF),
                                placedHolder.getOrThrow(OrePlacements.ORE_GRANITE_LOWER),
                                placedHolder.getOrThrow(OrePlacements.ORE_DIORITE_LOWER),
                                placedHolder.getOrThrow(OrePlacements.ORE_ANDESITE_LOWER),
                                placedHolder.getOrThrow(OrePlacements.ORE_GRANITE_UPPER),
                                placedHolder.getOrThrow(OrePlacements.ORE_DIORITE_UPPER),
                                placedHolder.getOrThrow(OrePlacements.ORE_ANDESITE_UPPER),
                                placedHolder.getOrThrow(OrePlacements.ORE_INFESTED)
                        ),
                        GenerationStep.Decoration.UNDERGROUND_ORES));
    }
}
