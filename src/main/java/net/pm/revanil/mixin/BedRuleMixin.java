package net.pm.revanil.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.world.attribute.BedRule;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BedRule.class)
public class BedRuleMixin {

    @WrapMethod(method = "canSleep(Lnet/minecraft/world/level/Level;)Z")
    private boolean revanil$neverAlwaysSwitch(Level world, Operation<Boolean> original) {
        return original.call(world) || BedRule.Rule.NEVER == ((BedRule)(Object)this).canSleep();
    }

    @WrapMethod(method = "canSetSpawn(Lnet/minecraft/world/level/Level;)Z")
    private boolean revanil$neverSetSpawn(Level world, Operation<Boolean> original) {
        return false;
    }

    @WrapMethod(method = "explodes")
    private boolean revanil$neverExplode(Operation<Boolean> original) {
        return false;
    }
}
