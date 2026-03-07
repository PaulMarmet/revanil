package net.pm.revanil.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.pm.revanil.Revanil;

import java.util.function.Function;

public class RItems {

    public static final Item IRON_UPGRADE_SMITHING_TEMPLATE = register("iron_upgrade_smithing_template", SmithingTemplateItems::createIronUpgrade, new Item.Settings());
    public static final Item GOLD_UPGRADE_SMITHING_TEMPLATE = register("gold_upgrade_smithing_template", SmithingTemplateItems::createGoldUpgrade, new Item.Settings());
    public static final Item DIAMOND_UPGRADE_SMITHING_TEMPLATE = register("diamond_upgrade_smithing_template", SmithingTemplateItems::createDiamondUpgrade, new Item.Settings());

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        return register(Identifier.of(Revanil.MOD_ID, name), itemFactory, settings);
    }

    public static Item register(Identifier id, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void init() {
    }
}
