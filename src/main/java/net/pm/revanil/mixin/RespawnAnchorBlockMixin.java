package net.pm.revanil.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RespawnAnchorBlock.class)
public class RespawnAnchorBlockMixin {
    @WrapMethod(method = "isUsable")
    private static boolean revanil$always(ServerWorld world, BlockPos pos, Operation<Boolean> original) {
        return true;
    }
}
