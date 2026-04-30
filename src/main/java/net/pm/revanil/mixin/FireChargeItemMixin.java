package net.pm.revanil.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.hurtingprojectile.SmallFireball;
import net.minecraft.world.item.FireChargeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FireChargeItem.class)
public class FireChargeItemMixin extends ItemMixin{
	protected void revanil$useItem(Level level, Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir) {
        if (cir.getReturnValue() != InteractionResult.SUCCESS) {
            Projectile projectile = this.asProjectile(level, player.getEyePosition(), player.getItemInHand(interactionHand), player.getHeadLookAngle());
            projectile.setOwner(player);

            boolean bl = level.addFreshEntity(projectile);

            if (bl) {
                Vec3 pos = player.getEyePosition();
                ((FireChargeItem)((Object)this)).playSound(level, new BlockPos((int) pos.x, (int) pos.y, (int) pos.z));
                level.gameEvent(player, GameEvent.PROJECTILE_SHOOT, player.getEyePosition());
                player.getItemInHand(interactionHand).shrink(1);
                player.getCooldowns().addCooldown(player.getItemInHand(interactionHand), 20);
                cir.setReturnValue(InteractionResult.SUCCESS);
            }
        }
	}

    //the actual method uses "Direction" which is way too restrictive for this purpose...
    @Unique
    Projectile asProjectile(Level level, Position position, ItemStack itemStack, Vec3 direction) {
        RandomSource randomSource = level.getRandom();
        double d = randomSource.triangle(direction.x(), 0.11485000000000001);
        double e = randomSource.triangle(direction.y(), 0.11485000000000001);
        double f = randomSource.triangle(direction.z(), 0.11485000000000001);
        Vec3 vec3 = new Vec3(d, e, f);
        SmallFireball smallFireball = new SmallFireball(level, position.x(), position.y(), position.z(), vec3.normalize());
        smallFireball.setItem(itemStack);
        return smallFireball;
    }
}