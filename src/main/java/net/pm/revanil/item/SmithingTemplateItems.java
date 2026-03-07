package net.pm.revanil.item;

import net.minecraft.item.Item;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pm.revanil.data.Lang;

import java.util.List;

public class SmithingTemplateItems {
    private static final Text IRON_UPGRADE_APPLIES_TO_TEXT;
    private static final Text IRON_UPGRADE_INGREDIENTS_TEXT;
    private static final Text IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT;
    private static final Text IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT;
    private static final Text GOLD_UPGRADE_APPLIES_TO_TEXT;
    private static final Text GOLD_UPGRADE_INGREDIENTS_TEXT;
    private static final Text GOLD_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT;
    private static final Text GOLD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT;
    private static final Text DIAMOND_UPGRADE_APPLIES_TO_TEXT;
    private static final Text DIAMOND_UPGRADE_INGREDIENTS_TEXT;
    private static final Text DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT;
    private static final Text DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT;

    public static SmithingTemplateItem createIronUpgrade(Item.Settings settings) {
        return new SmithingTemplateItem(IRON_UPGRADE_APPLIES_TO_TEXT, IRON_UPGRADE_INGREDIENTS_TEXT, IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT, getUpgradeEmptyBaseSlotTextures(), getIngotUpgradeEmptyAdditionsSlotTextures(), settings);
    }
    public static SmithingTemplateItem createGoldUpgrade(Item.Settings settings) {
        return new SmithingTemplateItem(GOLD_UPGRADE_APPLIES_TO_TEXT, GOLD_UPGRADE_INGREDIENTS_TEXT, GOLD_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, GOLD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT, getUpgradeEmptyBaseSlotTextures(), getIngotUpgradeEmptyAdditionsSlotTextures(), settings);
    }
    public static SmithingTemplateItem createDiamondUpgrade(Item.Settings settings) {
        return new SmithingTemplateItem(DIAMOND_UPGRADE_APPLIES_TO_TEXT, DIAMOND_UPGRADE_INGREDIENTS_TEXT, DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT, getUpgradeEmptyBaseSlotTextures(), getIngotUpgradeEmptyAdditionsSlotTextures(), settings);
    }

    private static List<Identifier> getUpgradeEmptyBaseSlotTextures() {
        return List.of(SmithingTemplateItem.EMPTY_ARMOR_SLOT_HELMET_TEXTURE, SmithingTemplateItem.EMPTY_SLOT_SWORD_TEXTURE, SmithingTemplateItem.EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, SmithingTemplateItem.EMPTY_SLOT_PICKAXE_TEXTURE, SmithingTemplateItem.EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, SmithingTemplateItem.EMPTY_SLOT_AXE_TEXTURE, SmithingTemplateItem.EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, SmithingTemplateItem.EMPTY_SLOT_HOE_TEXTURE, SmithingTemplateItem.EMPTY_SLOT_SHOVEL_TEXTURE);
    }

    private static List<Identifier> getIngotUpgradeEmptyAdditionsSlotTextures() {
        return List.of(SmithingTemplateItem.EMPTY_SLOT_INGOT_TEXTURE);
    }

    static {
        IRON_UPGRADE_APPLIES_TO_TEXT = Text.translatable(Lang.IRON_UPGRADE_APPLIES_TO).formatted(SmithingTemplateItem.DESCRIPTION_FORMATTING);
        IRON_UPGRADE_INGREDIENTS_TEXT = Text.translatable(Lang.IRON_UPGRADE_INGREDIENTS).formatted(SmithingTemplateItem.DESCRIPTION_FORMATTING);
        IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(Lang.IRON_UPGRADE_BASE_SLOT_DESCRIPTION);
        IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(Lang.IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION);
        GOLD_UPGRADE_APPLIES_TO_TEXT = Text.translatable(Lang.GOLD_UPGRADE_APPLIES_TO).formatted(SmithingTemplateItem.DESCRIPTION_FORMATTING);
        GOLD_UPGRADE_INGREDIENTS_TEXT = Text.translatable(Lang.GOLD_UPGRADE_INGREDIENTS).formatted(SmithingTemplateItem.DESCRIPTION_FORMATTING);
        GOLD_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(Lang.GOLD_UPGRADE_BASE_SLOT_DESCRIPTION);
        GOLD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(Lang.GOLD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION);
        DIAMOND_UPGRADE_APPLIES_TO_TEXT = Text.translatable(Lang.DIAMOND_UPGRADE_APPLIES_TO).formatted(SmithingTemplateItem.DESCRIPTION_FORMATTING);
        DIAMOND_UPGRADE_INGREDIENTS_TEXT = Text.translatable(Lang.DIAMOND_UPGRADE_INGREDIENTS).formatted(SmithingTemplateItem.DESCRIPTION_FORMATTING);
        DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(Lang.DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION);
        DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(Lang.DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION);
    }
}
