package net.pm.revanil.mixin;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BundleContents;
import org.apache.commons.lang3.math.Fraction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BundleContents.class)
public class BundleContentsMixin {
    @Inject(method = "getWeight", at = @At(value = "RETURN"), cancellable = true)
    private static void revanil$lowerMaxWeight(ItemStack itemStack, CallbackInfoReturnable<Fraction> cir) {
        if ((Fraction.getFraction(1, 8).compareTo(cir.getReturnValue()) < 0) && !itemStack.is(ItemTags.BUNDLES)) {
            cir.setReturnValue(Fraction.getFraction(1, 8));
        }
    }
}
