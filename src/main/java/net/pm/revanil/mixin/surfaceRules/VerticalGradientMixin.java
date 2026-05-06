package net.pm.revanil.mixin.surfaceRules;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SurfaceRules.VerticalGradientConditionSource.class)
public class VerticalGradientMixin {
	@Inject(method = "apply(Lnet/minecraft/world/level/levelgen/SurfaceRules$Context;)Lnet/minecraft/world/level/levelgen/SurfaceRules$Condition;", at = @At("TAIL"), cancellable = true)
	private void revanil$chunked(SurfaceRules.Context context, CallbackInfoReturnable<SurfaceRules.Condition> cir, @Local(name = "trueAtAndBelow") int bottomInc, @Local(name = "falseAtAndAbove") int topExc, @Local(name = "randomFactory") PositionalRandomFactory positionalRandomFactory) {
		// idk, seems to be working to me...
		class VerticalGradientCondition extends SurfaceRules.LazyYCondition {
			protected VerticalGradientCondition(SurfaceRules.Context context) {
				super(context);
			}

			@Override
			protected boolean compute() {
				int blockY = this.context.blockY;
				if (blockY <= bottomInc) {
					return true;
				} else if (blockY >= topExc) {
					return false;
				} else {
					//get the proportion to the top
					double d = Mth.clampedMap(blockY, bottomInc, topExc, 1.0, 0.0);
					//get random number from chunk pos & also bottomInc since we need a y
					//could change this to use some other stat later if we want it to be smooth
					ChunkAccess chunk = this.context.chunk;
					RandomSource random = positionalRandomFactory.at(chunk.getPos().x(), bottomInc, chunk.getPos().z());
					return random.nextFloat() < d;
				}
			}
		}
		cir.setReturnValue(new VerticalGradientCondition(context));
	}
}