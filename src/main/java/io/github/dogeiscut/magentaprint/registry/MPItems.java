package io.github.dogeiscut.magentaprint.registry;

import io.github.dogeiscut.magentaprint.Magentaprint;
import io.github.dogeiscut.magentaprint.util.ItemHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public final class MPItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Magentaprint.MOD_ID);

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
