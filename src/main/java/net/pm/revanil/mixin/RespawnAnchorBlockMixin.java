package net.pm.revanil.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.RespawnAnchorBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RespawnAnchorBlock.class)
public class RespawnAnchorBlockMixin {
    @WrapMethod(method = "canSetSpawn")
    private static boolean revanil$always(ServerLevel world, BlockPos pos, Operation<Boolean> original) {
        return true;
    }
}
