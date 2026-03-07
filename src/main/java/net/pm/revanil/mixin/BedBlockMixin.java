package net.pm.revanil.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.BedBlock;
import net.minecraft.world.attribute.BedRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BedBlock.class)
public class BedBlockMixin {
    //Probably not required anymore, but just to be safe.
    @WrapOperation(method = "onUse", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/attribute/BedRule;explodes()Z"))
    private boolean revanil$noExplode(BedRule instance, Operation<Boolean> original) {
        return false;
    }
}
