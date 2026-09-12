package io.github.dogeiscut.magentaprint.registry;

import io.github.dogeiscut.magentaprint.Magentaprint;
import io.github.dogeiscut.magentaprint.util.ItemHelper;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public final class MPItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Magentaprint.MOD_ID);

    public static final Supplier<Item> CREATIVE_COOKIE = item("creative_cookie",
            properties -> new Item(ItemHelper.creativeProperties().food(
                    new FoodProperties.Builder()
                            .nutrition(20)
                            .saturationModifier(100.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, -1, 0, false, false, false), 1.0f)
                            .alwaysEdible()
                            .build()
            ))
    );

    public static final Supplier<Item> RAW_CREATIVE_ORE = creativeItem("raw_creative_ore");
    public static final Supplier<Item> CREATIVE_ORE_INGOT = creativeItem("creative_ore_ingot");

    public static final Supplier<ArmorItem> CREATIVE_HELMET = item("creative_helmet",
            properties -> new ArmorItem(MPArmorMaterials.CREATIVE, ArmorItem.Type.HELMET, ItemHelper.creativeArmorProperties(
                    properties,
                    EquipmentSlotGroup.HEAD,
                    "creative_helmet",
                    0.25d
            ))
    );
    public static final Supplier<ArmorItem> CREATIVE_CHESTPLATE = item("creative_chestplate",
            properties -> new ArmorItem(MPArmorMaterials.CREATIVE, ArmorItem.Type.CHESTPLATE, ItemHelper.creativeArmorProperties(
                    properties,
                    EquipmentSlotGroup.CHEST,
                    "creative_chestplate",
                    0.25d
            ))
    );
    public static final Supplier<ArmorItem> CREATIVE_LEGGINGS = item("creative_leggings",
            properties -> new ArmorItem(MPArmorMaterials.CREATIVE, ArmorItem.Type.LEGGINGS, ItemHelper.creativeArmorProperties(
                    properties,
                    EquipmentSlotGroup.LEGS,
                    "creative_leggings",
                    0.25d
            ))
    );public static final Supplier<ArmorItem> CREATIVE_BOOTS = item("creative_boots",
            properties -> new ArmorItem(MPArmorMaterials.CREATIVE, ArmorItem.Type.BOOTS, ItemHelper.creativeArmorProperties(
                    properties,
                    EquipmentSlotGroup.FEET,
                    "creative_boots",
                    0.25d
            ))
    );


    public static Supplier<Item> basicItem(String name) {
        return ITEMS.registerSimpleItem(name);
    }

    public static Supplier<Item> basicItem(String name, Item.Properties properties) {
        return ITEMS.registerSimpleItem(name, properties);
    }

    public static Supplier<Item> creativeItem(String name) {
        return ITEMS.registerSimpleItem(name, ItemHelper.creativeProperties());
    }

    public static <T extends Item> Supplier<T> item(String name, Function<Item.Properties, T> factory) {
        return ITEMS.registerItem(name, factory);
    }

    public static <T extends Item> Supplier<T> item(String name, Function<Item.Properties, T> factory, Item.Properties properties) {
        return ITEMS.registerItem(name, factory, properties);
    }

    public static <T extends Block> Supplier<net.minecraft.world.item.BlockItem> blockItem(DeferredBlock<T> block) {
        return ITEMS.registerSimpleBlockItem(block);
    }

    public static <T extends Block> Supplier<net.minecraft.world.item.BlockItem> blockItem(DeferredBlock<T> block, Item.Properties properties) {
        return ITEMS.registerSimpleBlockItem(block, properties);
    }

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
