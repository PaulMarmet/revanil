package net.pm.revanil.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SnowLayerBlock.class)
public abstract class SnowLayerBlockMixin {
    @WrapMethod(method = "randomTick")
    private void revanil$dontMeltWhenCold(BlockState blockState, ServerLevel level, BlockPos blockPos, RandomSource randomSource, Operation<Void> original) {
        if (!level.getBiome(blockPos).is(BiomeTags.SPAWNS_COLD_VARIANT_FROGS)) {
            original.call(blockState, level, blockPos, randomSource);
        }
    }

}
