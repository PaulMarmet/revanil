package net.pm.revanil.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.world.World;
import net.minecraft.world.attribute.BedRule;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BedRule.class)
public class BedRuleMixin {

    @WrapMethod(method = "canSleep(Lnet/minecraft/world/World;)Z")
    private boolean revanil$neverAlwaysSwitch(World world, Operation<Boolean> original) {
        return original.call(world) || BedRule.Condition.NEVER == ((BedRule)(Object)this).canSleep();
    }

    @WrapMethod(method = "canSetSpawn(Lnet/minecraft/world/World;)Z")
    private boolean revanil$neverSetSpawn(World world, Operation<Boolean> original) {
        return false;
    }

    @WrapMethod(method = "explodes")
    private boolean revanil$neverExplode(Operation<Boolean> original) {
        return false;
    }
}
