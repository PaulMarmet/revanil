package net.pm.revanil.mixin;

import com.mojang.serialization.DataResult;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.component.BundleContents;
import org.apache.commons.lang3.math.Fraction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BundleContents.class)
public class BundleContentsMixin {
    @Inject(method = "getWeight", at = @At(value = "RETURN"), cancellable = true)
    private static void revanil$lowerMaxWeight(ItemInstance item, CallbackInfoReturnable<DataResult<Fraction>> cir) {
        if ((Fraction.getFraction(1, 8).compareTo(cir.getReturnValue().getOrThrow()) < 0) && item.get(DataComponents.BUNDLE_CONTENTS) == null) {
            cir.setReturnValue(DataResult.success(Fraction.getFraction(1, 8)));
        }
    }
}
