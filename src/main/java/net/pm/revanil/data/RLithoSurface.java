package net.pm.revanil.data;

import dev.worldgen.lithostitched.api.registry.LithostitchedRegistries;
import dev.worldgen.lithostitched.api.worldgen.modifier.WorldgenModifier;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.pm.revanil.Revanil;
import net.pm.revanil.world.level.levelgen.RSurfaceRules;

public class RLithoSurface {
    public static ResourceKey<WorldgenModifier> overworld_modif = ResourceKey.create(LithostitchedRegistries.WORLDGEN_MODIFIER, Identifier.fromNamespaceAndPath(Revanil.MOD_ID, "overworld_modif"));
    
    private static final SurfaceRules.RuleSource
            AIR = makeStateRule(Blocks.AIR);
    private static final SurfaceRules.RuleSource
            BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource
            WHITE_TERRACOTTA = makeStateRule(Blocks.WHITE_TERRACOTTA);
    private static final SurfaceRules.RuleSource
            ORANGE_TERRACOTTA = makeStateRule(Blocks.ORANGE_TERRACOTTA);
    private static final SurfaceRules.RuleSource
            TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
    private static final SurfaceRules.RuleSource
            RED_SAND = makeStateRule(Blocks.RED_SAND);
    private static final SurfaceRules.RuleSource
            RED_SANDSTONE = makeStateRule(Blocks.RED_SANDSTONE);
    private static final SurfaceRules.RuleSource
            STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource
            DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final SurfaceRules.RuleSource
            DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource
            PODZOL = makeStateRule(Blocks.PODZOL);
    private static final SurfaceRules.RuleSource
            COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource
            MYCELIUM = makeStateRule(Blocks.MYCELIUM);
    private static final SurfaceRules.RuleSource
            GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource
            CALCITE = makeStateRule(Blocks.CALCITE);
    private static final SurfaceRules.RuleSource
            GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource
            SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource
            SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource
            PACKED_ICE = makeStateRule(Blocks.PACKED_ICE);
    private static final SurfaceRules.RuleSource
            SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final SurfaceRules.RuleSource
            MUD = makeStateRule(Blocks.MUD);
    private static final SurfaceRules.RuleSource
            POWDER_SNOW = makeStateRule(Blocks.POWDER_SNOW);
    private static final SurfaceRules.RuleSource
            ICE = makeStateRule(Blocks.ICE);
    private static final SurfaceRules.RuleSource
            WATER = makeStateRule(Blocks.WATER);
    private static final SurfaceRules.RuleSource
            LAVA = makeStateRule(Blocks.LAVA);
    private static final SurfaceRules.RuleSource
            NETHERRACK = makeStateRule(Blocks.NETHERRACK);
    private static final SurfaceRules.RuleSource
            SOUL_SAND = makeStateRule(Blocks.SOUL_SAND);
    private static final SurfaceRules.RuleSource
            SOUL_SOIL = makeStateRule(Blocks.SOUL_SOIL);
    private static final SurfaceRules.RuleSource
            BASALT = makeStateRule(Blocks.BASALT);
    private static final SurfaceRules.RuleSource
            BLACKSTONE = makeStateRule(Blocks.BLACKSTONE);
    private static final SurfaceRules.RuleSource
            WARPED_WART_BLOCK = makeStateRule(Blocks.WARPED_WART_BLOCK);
    private static final SurfaceRules.RuleSource
            WARPED_NYLIUM = makeStateRule(Blocks.WARPED_NYLIUM);
    private static final SurfaceRules.RuleSource
            NETHER_WART_BLOCK = makeStateRule(Blocks.NETHER_WART_BLOCK);
    private static final SurfaceRules.RuleSource
            CRIMSON_NYLIUM = makeStateRule(Blocks.CRIMSON_NYLIUM);
    private static final SurfaceRules.RuleSource
            ENDSTONE = makeStateRule(Blocks.END_STONE);

    //My blocks added
    private static final SurfaceRules.RuleSource
            ANDESITE = makeStateRule(Blocks.ANDESITE);
    private static final SurfaceRules.RuleSource
            CLAY = makeStateRule(Blocks.CLAY);
    private static final SurfaceRules.RuleSource
            DIORITE = makeStateRule(Blocks.DIORITE);
    private static final SurfaceRules.RuleSource
            DRIPSTONE = makeStateRule(Blocks.DRIPSTONE_BLOCK);
    private static final SurfaceRules.RuleSource
            GRANITE = makeStateRule(Blocks.GRANITE);
    private static final SurfaceRules.RuleSource
            MAGMA = makeStateRule(Blocks.MAGMA_BLOCK);
    private static final SurfaceRules.RuleSource
            OBSIDIAN = makeStateRule(Blocks.OBSIDIAN);
    private static final SurfaceRules.RuleSource
            PRISMARINE = makeStateRule(Blocks.PRISMARINE);
    private static final SurfaceRules.RuleSource
            SCULK = makeStateRule(Blocks.SCULK);
    private static final SurfaceRules.RuleSource
            SMOOTH_BASALT = makeStateRule(Blocks.SMOOTH_BASALT);
    private static final SurfaceRules.RuleSource
            TUFF = makeStateRule(Blocks.TUFF);

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    public static void bootstrap(BootstrapContext<WorldgenModifier> context) {
        WorldgenModifier.ModifierBuilder builder = WorldgenModifier.builder();

        //My stuff here.
        // https://github.com/Apollounknowndev/lithostitched/wiki/Worldgen-Modifier-Types#add_surface_rule
        //Base stone replacements
        SurfaceRules.RuleSource stoneBiomeR = SurfaceRules.sequence(
                //Dripstone Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(), DRIPSTONE),
                //Sandstone Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(), SANDSTONE),
                //Red Sandstone Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(), RED_SANDSTONE)
        );
        //Alternate stone selection
        SurfaceRules.RuleSource altStoneBiomeR = SurfaceRules.sequence(
                //Blackstone Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.BASALT_DELTAS,
                        Biomes.SOUL_SAND_VALLEY
                ), BLACKSTONE),
                //Magma Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.CRIMSON_FOREST,
                        Biomes.NETHER_WASTES,
                        Biomes.WARPED_FOREST
                ), MAGMA),
                //Obsidian Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.END_BARRENS,
                        Biomes.END_HIGHLANDS,
                        Biomes.END_MIDLANDS,
                        Biomes.SMALL_END_ISLANDS,
                        Biomes.THE_END
                ), OBSIDIAN),
                //Calcite Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.CHERRY_GROVE,
                        Biomes.FROZEN_PEAKS,
                        Biomes.GROVE,
                        Biomes.JAGGED_PEAKS,
                        Biomes.STONY_PEAKS
                ), CALCITE),
                //Prismarine Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.COLD_OCEAN,
                        Biomes.DEEP_COLD_OCEAN,
                        Biomes.DEEP_DARK,
                        Biomes.DEEP_FROZEN_OCEAN,
                        Biomes.DEEP_LUKEWARM_OCEAN,
                        Biomes.DEEP_OCEAN,
                        Biomes.FROZEN_OCEAN,
                        Biomes.LUKEWARM_OCEAN,
                        Biomes.MUSHROOM_FIELDS,
                        Biomes.OCEAN,
                        Biomes.WARM_OCEAN
                ), PRISMARINE),
                //Granite Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.BADLANDS,
                        Biomes.DESERT,
                        Biomes.DRIPSTONE_CAVES,
                        Biomes.ERODED_BADLANDS,
                        Biomes.JUNGLE,
                        Biomes.OLD_GROWTH_PINE_TAIGA,
                        Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                        Biomes.PLAINS,
                        Biomes.SAVANNA,
                        Biomes.SAVANNA_PLATEAU,
                        Biomes.SPARSE_JUNGLE,
                        Biomes.SUNFLOWER_PLAINS,
                        Biomes.WINDSWEPT_SAVANNA,
                        Biomes.WOODED_BADLANDS
                ), GRANITE),
                //Andesite Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.BAMBOO_JUNGLE,
                        Biomes.DARK_FOREST,
                        Biomes.FLOWER_FOREST,
                        Biomes.FOREST,
                        Biomes.FROZEN_RIVER,
                        Biomes.LUSH_CAVES,
                        Biomes.MANGROVE_SWAMP,
                        Biomes.MEADOW,
                        Biomes.RIVER,
                        Biomes.STONY_SHORE,
                        Biomes.SWAMP,
                        Biomes.TAIGA,
                        Biomes.WINDSWEPT_FOREST,
                        Biomes.WINDSWEPT_GRAVELLY_HILLS
                ), ANDESITE),
                //Diorite Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.BEACH,
                        Biomes.BIRCH_FOREST,
                        Biomes.ICE_SPIKES,
                        Biomes.OLD_GROWTH_BIRCH_FOREST,
                        Biomes.PALE_GARDEN,
                        Biomes.SNOWY_BEACH,
                        Biomes.SNOWY_PLAINS,
                        Biomes.SNOWY_SLOPES,
                        Biomes.SNOWY_TAIGA,
                        Biomes.WINDSWEPT_HILLS
                ), DIORITE)
        );
        SurfaceRules.RuleSource altDeepslateBiomeR = SurfaceRules.sequence(
                //Smooth Basalt Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.CHERRY_GROVE,
                        Biomes.FROZEN_PEAKS,
                        Biomes.GROVE,
                        Biomes.JAGGED_PEAKS,
                        Biomes.STONY_PEAKS
                ), SMOOTH_BASALT),
                //Obsidian Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.BASALT_DELTAS,
                        Biomes.CRIMSON_FOREST,
                        Biomes.END_BARRENS,
                        Biomes.END_HIGHLANDS,
                        Biomes.END_MIDLANDS,
                        Biomes.NETHER_WASTES,
                        Biomes.SMALL_END_ISLANDS,
                        Biomes.SOUL_SAND_VALLEY,
                        Biomes.THE_END,
                        Biomes.WARPED_FOREST
                ), OBSIDIAN),
                //Default
                TUFF
        );
        SurfaceRules.RuleSource altSoilSeamsBiomeR = SurfaceRules.sequence(
                //Air Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.END_BARRENS,
                        Biomes.END_HIGHLANDS,
                        Biomes.END_MIDLANDS,
                        Biomes.SMALL_END_ISLANDS,
                        Biomes.THE_END,
                        Biomes.THE_VOID
                ), AIR),
                //Sculk Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.DEEP_DARK
                ), SCULK),
                //Soul Sandstone Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.NETHER_WASTES,
                        Biomes.SOUL_SAND_VALLEY
                ), SOUL_SAND),
                //Sandstone Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.DESERT
                ), SANDSTONE),
                //Red Sandstone Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.BADLANDS,
                        Biomes.ERODED_BADLANDS,
                        Biomes.WOODED_BADLANDS
                ), RED_SANDSTONE),
                //Clay Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.DRIPSTONE_CAVES,
                        Biomes.LUSH_CAVES,
                        Biomes.MANGROVE_SWAMP,
                        Biomes.SWAMP
                ), CLAY),
                //Dirt Biomes
                SurfaceRules.ifTrue(SurfaceRules.isBiome(
                        Biomes.BAMBOO_JUNGLE,
                        Biomes.BIRCH_FOREST,
                        Biomes.CHERRY_GROVE,
                        Biomes.DARK_FOREST,
                        Biomes.FLOWER_FOREST,
                        Biomes.FOREST,
                        Biomes.GROVE,
                        Biomes.JUNGLE,
                        Biomes.MEADOW,
                        Biomes.OLD_GROWTH_BIRCH_FOREST,
                        Biomes.PLAINS,
                        Biomes.SAVANNA,
                        Biomes.SAVANNA_PLATEAU,
                        Biomes.SNOWY_TAIGA,
                        Biomes.SPARSE_JUNGLE,
                        Biomes.SUNFLOWER_PLAINS,
                        Biomes.TAIGA
                ), DIRT),
                //Default
                GRAVEL
        );

        //Alternate stone application rules.
        SurfaceRules.RuleSource altStoneR = SurfaceRules.sequence(
                SurfaceRules.ifTrue(RSurfaceRules.noise3dCondition(Noises.CALCITE, -0.0125, 0.0125), altStoneBiomeR),
                SurfaceRules.ifTrue(RSurfaceRules.noise3dCondition(Noises.CALCITE, -0.525, -0.5), altStoneBiomeR),
                SurfaceRules.ifTrue(RSurfaceRules.noise3dCondition(Noises.CALCITE, 0.5, 0.525), altStoneBiomeR)
        );
        SurfaceRules.RuleSource altDeepslateR = SurfaceRules.sequence(
                SurfaceRules.ifTrue(RSurfaceRules.noise3dCondition(Noises.CALCITE, -0.425, -0.4), altDeepslateBiomeR),
                SurfaceRules.ifTrue(RSurfaceRules.noise3dCondition(Noises.CALCITE, 0.4, 0.425), altDeepslateBiomeR)
        );
        //Soil Veins, to replace the dirt and gravel pockets
        SurfaceRules.RuleSource altSoilR = SurfaceRules.sequence(
                SurfaceRules.ifTrue(RSurfaceRules.noise3dCondition(Noises.GRAVEL, -0.02, 0.02), altSoilSeamsBiomeR)
        );

        SurfaceRules.RuleSource alts = SurfaceRules.sequence(
                altSoilR,
                altStoneR,
                altDeepslateR
        );

        context.register(overworld_modif,
                builder.appendSurfaceRule(LevelStem.OVERWORLD, alts));
    }
}
