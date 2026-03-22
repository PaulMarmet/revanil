package net.pm.revanil.mixin;

import com.google.common.collect.Maps;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.pm.revanil.item.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Map;

@Mixin(ArmorMaterials.class)
public interface ArmorMaterialsMixin {
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/item/equipment/ArmorMaterial;", ordinal = 0))
    private static ArmorMaterial revanil$alterLeather(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.LEATHER,
                createDefenseMap(Material.Defense.LEATHER),
                Material.Enchant.LEATHER,
                SoundEvents.ARMOR_EQUIP_LEATHER,
                0.0F, 0.0F,
                ItemTags.REPAIRS_LEATHER_ARMOR,
                EquipmentAssets.LEATHER);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/item/equipment/ArmorMaterial;", ordinal = 1))
    private static ArmorMaterial revanil$alterCopper(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.COPPER,
                createDefenseMap(Material.Defense.COPPER),
                Material.Enchant.COPPER,
                SoundEvents.ARMOR_EQUIP_COPPER,
                0.0F, 0.0F,
                ItemTags.REPAIRS_COPPER_ARMOR,
                EquipmentAssets.COPPER);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/item/equipment/ArmorMaterial;", ordinal = 2))
    private static ArmorMaterial revanil$alterChain(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.CHAIN,
                createDefenseMap(Material.Defense.CHAIN),
                Material.Enchant.CHAIN,
                SoundEvents.ARMOR_EQUIP_CHAIN,
                1.0F, 0.0F,
                ItemTags.REPAIRS_CHAIN_ARMOR,
                EquipmentAssets.CHAINMAIL);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/item/equipment/ArmorMaterial;", ordinal = 3))
    private static ArmorMaterial revanil$alterIron(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.IRON,
                createDefenseMap(Material.Defense.IRON),
                Material.Enchant.IRON,
                SoundEvents.ARMOR_EQUIP_IRON,
                0.0F, 0.0F,
                ItemTags.REPAIRS_IRON_ARMOR,
                EquipmentAssets.IRON);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/item/equipment/ArmorMaterial;", ordinal = 4))
    private static ArmorMaterial revanil$alterGold(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.GOLD,
                createDefenseMap(Material.Defense.GOLD),
                Material.Enchant.GOLD,
                SoundEvents.ARMOR_EQUIP_GOLD,
                0.0F, 0.0F,
                ItemTags.REPAIRS_GOLD_ARMOR,
                EquipmentAssets.GOLD);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/item/equipment/ArmorMaterial;", ordinal = 5))
    private static ArmorMaterial revanil$alterDiamond(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.DIAMOND,
                createDefenseMap(Material.Defense.DIAMOND),
                Material.Enchant.DIAMOND,
                SoundEvents.ARMOR_EQUIP_DIAMOND,
                2.0F, 0.0F,
                ItemTags.REPAIRS_DIAMOND_ARMOR,
                EquipmentAssets.DIAMOND);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/item/equipment/ArmorMaterial;", ordinal = 6))
    private static ArmorMaterial revanil$alterTurtleScute(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.TURTLE,
                createDefenseMap(Material.Defense.TURTLE),
                Material.Enchant.TURTLE,
                SoundEvents.ARMOR_EQUIP_TURTLE,
                0.0F, 0.25F,
                ItemTags.REPAIRS_TURTLE_HELMET,
                EquipmentAssets.TURTLE_SCUTE);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/item/equipment/ArmorMaterial;", ordinal = 7))
    private static ArmorMaterial revanil$alterNetherite(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.NETHERITE,
                createDefenseMap(Material.Defense.NETHERITE),
                Material.Enchant.NETHERITE,
                SoundEvents.ARMOR_EQUIP_NETHERITE,
                3.0F, 0.1F,
                ItemTags.REPAIRS_NETHERITE_ARMOR,
                EquipmentAssets.NETHERITE);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/item/equipment/ArmorMaterial;", ordinal = 8))
    private static ArmorMaterial revanil$alterArmadilloScute(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.ARMADILLO,
                createDefenseMap(Material.Defense.ARMADILLO, 10),
                Material.Enchant.ARMADILLO,
                SoundEvents.ARMOR_EQUIP_WOLF,
                0.0F, 0.0F,
                ItemTags.REPAIRS_WOLF_ARMOR,
                EquipmentAssets.ARMADILLO_SCUTE);
    }

    @Unique
    private static Map<ArmorType, Integer> createDefenseMap(int partDefense) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, partDefense, ArmorType.LEGGINGS, partDefense, ArmorType.CHESTPLATE, partDefense, ArmorType.HELMET, partDefense, ArmorType.BODY, partDefense*3));
    }
    @Unique
    private static Map<ArmorType, Integer> createDefenseMap(int partDefense, int bodyDefense) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, partDefense, ArmorType.LEGGINGS, partDefense, ArmorType.CHESTPLATE, partDefense, ArmorType.HELMET, partDefense, ArmorType.BODY, bodyDefense));
    }
}
