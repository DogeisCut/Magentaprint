package io.github.dogeiscut.magentaprint.util;

import io.github.dogeiscut.magentaprint.registry.MPAttributes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Unbreakable;

public final class ItemHelper {

    private ItemHelper() {
    }

    public static Item.Properties creativeProperties() {
        return new Item.Properties()
                .component(DataComponents.UNBREAKABLE, new Unbreakable(false))
                .rarity(Rarity.EPIC);
    }

    public static Item.Properties creativeProperties(Item.Properties properties) {
        return properties
                .component(DataComponents.UNBREAKABLE, new Unbreakable(false))
                .rarity(Rarity.EPIC);
    }

    public static Item.Properties creativeArmorProperties(Item.Properties properties, EquipmentSlotGroup equipmentSlotGroup, String id, double damageReduction) {
        return creativeProperties(properties)
                .stacksTo(1)
                .attributes(
                        ItemAttributeModifiers.builder()
                                .add(
                                        MPAttributes.TOTAL_DAMAGE_REDUCTION,
                                        new AttributeModifier(
                                                MPUtils.id(id),
                                                damageReduction,
                                                AttributeModifier.Operation.ADD_VALUE
                                        ),
                                        equipmentSlotGroup
                                )
                                .build()
                );
    }
}
