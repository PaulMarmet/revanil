package net.pm.revanil.world.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class RItemGroups {

    public static void init() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((itemGroup) -> {
            itemGroup.insertBefore(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, RItems.IRON_UPGRADE_SMITHING_TEMPLATE, RItems.GOLD_UPGRADE_SMITHING_TEMPLATE, RItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE);
        });
    }
}
