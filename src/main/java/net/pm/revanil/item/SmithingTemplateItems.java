package net.pm.revanil.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.pm.revanil.data.Lang;

import java.util.List;

public class SmithingTemplateItems {
    private static final Component IRON_UPGRADE_APPLIES_TO_TEXT;
    private static final Component IRON_UPGRADE_INGREDIENTS_TEXT;
    private static final Component IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT;
    private static final Component IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT;
    private static final Component GOLD_UPGRADE_APPLIES_TO_TEXT;
    private static final Component GOLD_UPGRADE_INGREDIENTS_TEXT;
    private static final Component GOLD_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT;
    private static final Component GOLD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT;
    private static final Component DIAMOND_UPGRADE_APPLIES_TO_TEXT;
    private static final Component DIAMOND_UPGRADE_INGREDIENTS_TEXT;
    private static final Component DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT;
    private static final Component DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT;

    public static SmithingTemplateItem createIronUpgrade(Item.Properties settings) {
        return new SmithingTemplateItem(IRON_UPGRADE_APPLIES_TO_TEXT, IRON_UPGRADE_INGREDIENTS_TEXT, IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT, getUpgradeEmptyBaseSlotTextures(), getIngotUpgradeEmptyAdditionsSlotTextures(), settings);
    }
    public static SmithingTemplateItem createGoldUpgrade(Item.Properties settings) {
        return new SmithingTemplateItem(GOLD_UPGRADE_APPLIES_TO_TEXT, GOLD_UPGRADE_INGREDIENTS_TEXT, GOLD_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, GOLD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT, getUpgradeEmptyBaseSlotTextures(), getIngotUpgradeEmptyAdditionsSlotTextures(), settings);
    }
    public static SmithingTemplateItem createDiamondUpgrade(Item.Properties settings) {
        return new SmithingTemplateItem(DIAMOND_UPGRADE_APPLIES_TO_TEXT, DIAMOND_UPGRADE_INGREDIENTS_TEXT, DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT, getUpgradeEmptyBaseSlotTextures(), getIngotUpgradeEmptyAdditionsSlotTextures(), settings);
    }

    private static List<Identifier> getUpgradeEmptyBaseSlotTextures() {
        return List.of(SmithingTemplateItem.EMPTY_SLOT_HELMET, SmithingTemplateItem.EMPTY_SLOT_SWORD, SmithingTemplateItem.EMPTY_SLOT_CHESTPLATE, SmithingTemplateItem.EMPTY_SLOT_PICKAXE, SmithingTemplateItem.EMPTY_SLOT_LEGGINGS, SmithingTemplateItem.EMPTY_SLOT_AXE, SmithingTemplateItem.EMPTY_SLOT_BOOTS, SmithingTemplateItem.EMPTY_SLOT_HOE, SmithingTemplateItem.EMPTY_SLOT_SHOVEL);
    }

    private static List<Identifier> getIngotUpgradeEmptyAdditionsSlotTextures() {
        return List.of(SmithingTemplateItem.EMPTY_SLOT_INGOT);
    }

    static {
        IRON_UPGRADE_APPLIES_TO_TEXT = Component.translatable(Lang.IRON_UPGRADE_APPLIES_TO).withStyle(SmithingTemplateItem.DESCRIPTION_FORMAT);
        IRON_UPGRADE_INGREDIENTS_TEXT = Component.translatable(Lang.IRON_UPGRADE_INGREDIENTS).withStyle(SmithingTemplateItem.DESCRIPTION_FORMAT);
        IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Component.translatable(Lang.IRON_UPGRADE_BASE_SLOT_DESCRIPTION);
        IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Component.translatable(Lang.IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION);
        GOLD_UPGRADE_APPLIES_TO_TEXT = Component.translatable(Lang.GOLD_UPGRADE_APPLIES_TO).withStyle(SmithingTemplateItem.DESCRIPTION_FORMAT);
        GOLD_UPGRADE_INGREDIENTS_TEXT = Component.translatable(Lang.GOLD_UPGRADE_INGREDIENTS).withStyle(SmithingTemplateItem.DESCRIPTION_FORMAT);
        GOLD_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Component.translatable(Lang.GOLD_UPGRADE_BASE_SLOT_DESCRIPTION);
        GOLD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Component.translatable(Lang.GOLD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION);
        DIAMOND_UPGRADE_APPLIES_TO_TEXT = Component.translatable(Lang.DIAMOND_UPGRADE_APPLIES_TO).withStyle(SmithingTemplateItem.DESCRIPTION_FORMAT);
        DIAMOND_UPGRADE_INGREDIENTS_TEXT = Component.translatable(Lang.DIAMOND_UPGRADE_INGREDIENTS).withStyle(SmithingTemplateItem.DESCRIPTION_FORMAT);
        DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Component.translatable(Lang.DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION);
        DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Component.translatable(Lang.DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION);
    }
}
