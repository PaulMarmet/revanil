package net.pm.revanil.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class RItemGroups {

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register((itemGroup) -> {
            itemGroup.addBefore(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, RItems.IRON_UPGRADE_SMITHING_TEMPLATE, RItems.GOLD_UPGRADE_SMITHING_TEMPLATE, RItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE);
        });
    }
}
