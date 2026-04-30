package net.pm.revanil.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(IceBlock.class)
public abstract class IceBlockMixin {
    @WrapOperation(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/IceBlock;melt(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)V"))
    private void revanil$dontMeltWhenCold(IceBlock instance, BlockState blockState, Level level, BlockPos blockPos, Operation<Void> original) {
        if (!level.getBiome(blockPos).is(BiomeTags.SPAWNS_COLD_VARIANT_FROGS)) {
            original.call(instance, blockState, level, blockPos);
        }
    }

}
