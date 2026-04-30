package net.pm.revanil.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Blocks.class)
public abstract class BlocksMixin {
    @WrapOperation(method = "<clinit>", slice = @Slice(from = @At(value="CONSTANT", args="stringValue=torchflower", ordinal = 0)), at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;of()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", ordinal = 0))
    private static BlockBehaviour.Properties revanil$torchflowerGlow(Operation<BlockBehaviour.Properties> original) {
        return original.call().lightLevel(state -> 15);
    }

    @WrapOperation(method = "<clinit>", slice = @Slice(from = @At(value="CONSTANT", args="stringValue=potted_torchflower", ordinal = 0)), at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Blocks;flowerPotProperties()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", ordinal = 0))
    private static BlockBehaviour.Properties revanil$pottedTorchflowerGlow(Operation<BlockBehaviour.Properties> original) {
        return original.call().lightLevel(state -> 15);
    }

    @WrapOperation(method = "<clinit>", slice = @Slice(from = @At(value="CONSTANT", args="stringValue=cave_vines_plant", ordinal = 0)), at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;of()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", ordinal = 0))
    private static BlockBehaviour.Properties revanil$caveVineRandomTicks(Operation<BlockBehaviour.Properties> original) {
        return original.call().randomTicks();
    }

}
