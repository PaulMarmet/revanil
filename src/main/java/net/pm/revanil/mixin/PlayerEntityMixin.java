package net.pm.revanil.mixin;

import net.minecraft.world.attribute.BedRule;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerEntityMixin {
    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;isSleeping()Z", shift = At.Shift.AFTER))
    private void revanil$preventTotalSleep(CallbackInfo ci) {
        if (((Player)(Object)this).sleepCounter > 90 &&
                ((Player)(Object)this).isSleeping() &&
                ((Player)(Object)this).level().environmentAttributes().getValue(EnvironmentAttributes.BED_RULE, ((Player)(Object)this).position()).canSleep() == BedRule.Rule.NEVER) {
            ((Player)(Object)this).sleepCounter = 80;
        }
    }
}
