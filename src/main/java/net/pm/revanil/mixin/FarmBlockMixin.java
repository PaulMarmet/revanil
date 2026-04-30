package net.pm.revanil.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static net.minecraft.world.level.block.FarmBlock.MOISTURE;

@Mixin(FarmBlock.class)
public class FarmBlockMixin {
    @WrapOperation(method = "fallOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/FarmBlock;turnToDirt(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)V"))
    private void revanil$onlyIfWatered(Entity entity, BlockState blockState, Level level, BlockPos blockPos, Operation<Void> original) {
        if (blockState.getValue(MOISTURE) <= 0) {
            original.call(entity, blockState, level, blockPos);
        }
    }

    @ModifyArg(method = "isNearWater", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/BlockPos;offset(III)Lnet/minecraft/core/BlockPos;", ordinal = 0), index = 1)
    private static int revanil$extendWaterRegion(int y) {
        return -1;
    }

}
