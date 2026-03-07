package net.pm.revanil.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.attribute.BedRule;
import net.minecraft.world.attribute.EnvironmentAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isSleeping()Z", shift = At.Shift.AFTER))
    private void revanil$preventTotalSleep(CallbackInfo ci) {
        if (((PlayerEntity)(Object)this).sleepTimer > 90 &&
                ((PlayerEntity)(Object)this).isSleeping() &&
                ((PlayerEntity)(Object)this).getEntityWorld().getEnvironmentAttributes().getAttributeValue(EnvironmentAttributes.BED_RULE_GAMEPLAY, ((PlayerEntity)(Object)this).getEntityPos()).canSleep() == BedRule.Condition.NEVER) {
            ((PlayerEntity)(Object)this).sleepTimer = 80;
        }
    }
}
