package net.pm.revanil.mixin.surfaceRules;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.pm.revanil.world.level.levelgen.RSurfaceRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SurfaceRules.ConditionSource.class)
public interface ConditionSourceMixin {

    @Inject(method = "bootstrap", at = @At(value = "TAIL"))
    private static void revanil$bootstrapAdder(Registry<MapCodec<? extends SurfaceRules.ConditionSource>> registry, CallbackInfoReturnable<MapCodec<? extends SurfaceRules.ConditionSource>> cir) {
        Registry.register(registry, "noise3d", RSurfaceRules.NoiseThresholdConditionSource3d.CODEC.codec());
    }
}
