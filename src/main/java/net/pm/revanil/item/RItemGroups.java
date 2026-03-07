package net.pm.revanil.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class RItemGroups {

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> {
            itemGroup.addBefore(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, RItems.IRON_UPGRADE_TEMPLATE, RItems.GOLD_UPGRADE_TEMPLATE);
        });
    }
}
