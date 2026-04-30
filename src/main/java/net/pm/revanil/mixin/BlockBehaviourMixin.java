package net.pm.revanil.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.class)
public class BlockBehaviourMixin {
    @Inject(method = "getCollisionShape", at = @At(value="RETURN"), cancellable = true)
    public void revanil$modifyShape(CallbackInfoReturnable<VoxelShape> cir, @Local(argsOnly = true) CollisionContext collisionContext) {
        cir.setReturnValue(cir.getReturnValue());
    }

    @Inject(method = "isRandomlyTicking", at = @At(value = "RETURN"), cancellable = true)
    public void revanil$isRandomlyTickingOverride(BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
    }

    @Inject(method = "randomTick", at = @At(value = "HEAD"))
    public void revanil$randomTickOverride(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource, CallbackInfo ci) {
    }
}
