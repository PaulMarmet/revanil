package net.pm.revanil.mixin;

import com.google.common.collect.Maps;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.pm.revanil.item.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Map;

@Mixin(ArmorMaterials.class)
public interface ArmorMaterialsMixin {
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/item/equipment/ArmorMaterial;", ordinal = 0))
    private static ArmorMaterial revanil$alterLeather(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.LEATHER,
                createDefenseMap(Material.Defense.LEATHER),
                Material.Enchant.LEATHER,
                SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                0.0F, 0.0F,
                ItemTags.REPAIRS_LEATHER_ARMOR,
                EquipmentAssetKeys.LEATHER);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/item/equipment/ArmorMaterial;", ordinal = 1))
    private static ArmorMaterial revanil$alterCopper(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.COPPER,
                createDefenseMap(Material.Defense.COPPER),
                Material.Enchant.COPPER,
                SoundEvents.ITEM_ARMOR_EQUIP_COPPER,
                0.0F, 0.0F,
                ItemTags.REPAIRS_COPPER_ARMOR,
                EquipmentAssetKeys.COPPER);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/item/equipment/ArmorMaterial;", ordinal = 2))
    private static ArmorMaterial revanil$alterChain(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.CHAIN,
                createDefenseMap(Material.Defense.CHAIN),
                Material.Enchant.CHAIN,
                SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
                1.0F, 0.0F,
                ItemTags.REPAIRS_CHAIN_ARMOR,
                EquipmentAssetKeys.CHAINMAIL);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/item/equipment/ArmorMaterial;", ordinal = 3))
    private static ArmorMaterial revanil$alterIron(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.IRON,
                createDefenseMap(Material.Defense.IRON),
                Material.Enchant.IRON,
                SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                0.0F, 0.0F,
                ItemTags.REPAIRS_IRON_ARMOR,
                EquipmentAssetKeys.IRON);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/item/equipment/ArmorMaterial;", ordinal = 4))
    private static ArmorMaterial revanil$alterGold(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.GOLD,
                createDefenseMap(Material.Defense.GOLD),
                Material.Enchant.GOLD,
                SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
                0.0F, 0.0F,
                ItemTags.REPAIRS_GOLD_ARMOR,
                EquipmentAssetKeys.GOLD);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/item/equipment/ArmorMaterial;", ordinal = 5))
    private static ArmorMaterial revanil$alterDiamond(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.DIAMOND,
                createDefenseMap(Material.Defense.DIAMOND),
                Material.Enchant.DIAMOND,
                SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                2.0F, 0.0F,
                ItemTags.REPAIRS_DIAMOND_ARMOR,
                EquipmentAssetKeys.DIAMOND);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/item/equipment/ArmorMaterial;", ordinal = 6))
    private static ArmorMaterial revanil$alterTurtleScute(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.TURTLE,
                createDefenseMap(Material.Defense.TURTLE),
                Material.Enchant.TURTLE,
                SoundEvents.ITEM_ARMOR_EQUIP_TURTLE,
                0.0F, 0.25F,
                ItemTags.REPAIRS_TURTLE_HELMET,
                EquipmentAssetKeys.TURTLE_SCUTE);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/item/equipment/ArmorMaterial;", ordinal = 7))
    private static ArmorMaterial revanil$alterNetherite(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.NETHERITE,
                createDefenseMap(Material.Defense.NETHERITE),
                Material.Enchant.NETHERITE,
                SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
                3.0F, 0.1F,
                ItemTags.REPAIRS_NETHERITE_ARMOR,
                EquipmentAssetKeys.NETHERITE);
    }
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/item/equipment/ArmorMaterial;", ordinal = 8))
    private static ArmorMaterial revanil$alterArmadilloScute(ArmorMaterial original) {
        return new ArmorMaterial(
                Material.Durability.ARMADILLO,
                createDefenseMap(Material.Defense.ARMADILLO, 10),
                Material.Enchant.ARMADILLO,
                SoundEvents.ITEM_ARMOR_EQUIP_WOLF,
                0.0F, 0.0F,
                ItemTags.REPAIRS_WOLF_ARMOR,
                EquipmentAssetKeys.ARMADILLO_SCUTE);
    }

    @Unique
    private static Map<EquipmentType, Integer> createDefenseMap(int partDefense) {
        return Maps.newEnumMap(Map.of(EquipmentType.BOOTS, partDefense, EquipmentType.LEGGINGS, partDefense, EquipmentType.CHESTPLATE, partDefense, EquipmentType.HELMET, partDefense, EquipmentType.BODY, partDefense*3));
    }
    @Unique
    private static Map<EquipmentType, Integer> createDefenseMap(int partDefense, int bodyDefense) {
        return Maps.newEnumMap(Map.of(EquipmentType.BOOTS, partDefense, EquipmentType.LEGGINGS, partDefense, EquipmentType.CHESTPLATE, partDefense, EquipmentType.HELMET, partDefense, EquipmentType.BODY, bodyDefense));
    }
}
