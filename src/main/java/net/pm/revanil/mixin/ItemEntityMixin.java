package net.pm.revanil.mixin;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin {
	@Inject(method = "ignoreExplosion", at = @At(value="RETURN"), cancellable = true)
	public void revanil$ignoreExplosion(CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(true);
	}

	@Shadow
	public abstract ItemStack getItem();

//	// Currently Unused
//	@Inject(method = "fireImmune", at = @At(value="RETURN"), cancellable = true)
//	public void revanil$fireImmune(CallbackInfoReturnable<Boolean> cir) {
//		boolean hasTag = this.getItem().is(RItemTags.FIREPROOF);
//		cir.setReturnValue(cir.getReturnValue() || hasTag);
//	}

}