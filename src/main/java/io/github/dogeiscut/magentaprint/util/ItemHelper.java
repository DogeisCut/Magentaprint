package io.github.dogeiscut.magentaprint.util;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.Unbreakable;

public final class ItemHelper {

    private ItemHelper() {
    }

    public static Item.Properties creativeProperties() {
        return new Item.Properties()
                .component(DataComponents.UNBREAKABLE, new Unbreakable(false))
                .rarity(Rarity.EPIC);
    }
}
