package net.pm.revanil.mixin;

import net.minecraft.world.item.equipment.ArmorType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(ArmorType.class)
public class ArmorTypeMixin {
    //TODO: Fix this ig
//    //They're all 32 now. This is balanced by the fact that the base durability values are about half of what they were before.
//    @ModifyArgs(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/equipment/EquipmentType;<init>(Ljava/lang/String;ILnet/minecraft/entity/EquipmentSlot;ILjava/lang/String;)V"))
//    private static void revanil$alter(Args args) {
//        args.set(3, 32);
//    }
}
