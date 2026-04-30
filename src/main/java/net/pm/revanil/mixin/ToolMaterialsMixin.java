package net.pm.revanil.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ToolMaterial;
import net.pm.revanil.world.item.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(ToolMaterial.class)
public class ToolMaterialsMixin {
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/item/ToolMaterial;", ordinal = 0))
    private static ToolMaterial revanil$alterWood(ToolMaterial original) {
        return new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, Material.Durability.WOOD*64, 2.0F, 0.0F, Material.Enchant.WOOD, ItemTags.WOODEN_TOOL_MATERIALS);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/item/ToolMaterial;", ordinal = 1))
    private static ToolMaterial revanil$alterStone(ToolMaterial original) {
        return new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, Material.Durability.STONE*64, 4.0F, 1.0F, Material.Enchant.STONE, ItemTags.STONE_TOOL_MATERIALS);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/item/ToolMaterial;", ordinal = 2))
    private static ToolMaterial revanil$alterCopper(ToolMaterial original) {
        return new ToolMaterial(BlockTags.INCORRECT_FOR_COPPER_TOOL, Material.Durability.COPPER*64, 5.0F, 1.0F, Material.Enchant.COPPER, ItemTags.COPPER_TOOL_MATERIALS);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/item/ToolMaterial;", ordinal = 3))
    private static ToolMaterial revanil$alterIron(ToolMaterial original) {
        return new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, Material.Durability.IRON*64, 6.0F, 2.0F, Material.Enchant.IRON, ItemTags.IRON_TOOL_MATERIALS);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/item/ToolMaterial;", ordinal = 4))
    private static ToolMaterial revanil$alterDiamond(ToolMaterial original) {
        return new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, Material.Durability.DIAMOND*64, 8.0F, 3.0F, Material.Enchant.DIAMOND, ItemTags.DIAMOND_TOOL_MATERIALS);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/item/ToolMaterial;", ordinal = 5))
    private static ToolMaterial revanil$alterGold(ToolMaterial original) {
        return new ToolMaterial(BlockTags.INCORRECT_FOR_GOLD_TOOL, Material.Durability.GOLD*64, 12.0F, 1.0F, Material.Enchant.GOLD, ItemTags.GOLD_TOOL_MATERIALS);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/item/ToolMaterial;", ordinal = 6))
    private static ToolMaterial revanil$alterNetherite(ToolMaterial original) {
        return new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, Material.Durability.NETHERITE*64, 9.0F, 4.0F, Material.Enchant.NETHERITE, ItemTags.NETHERITE_TOOL_MATERIALS);
    }
}
