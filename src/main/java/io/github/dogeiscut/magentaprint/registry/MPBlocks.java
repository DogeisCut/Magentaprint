package io.github.dogeiscut.magentaprint.registry;

import io.github.dogeiscut.magentaprint.Magentaprint;
import io.github.dogeiscut.magentaprint.util.ItemHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public final class MPBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Magentaprint.MOD_ID);

    public static final DeferredBlock<Block> CREATIVE_DIRT = blockWithItem("creative_dirt", BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT), ItemHelper.creativeProperties());

    public static DeferredBlock<Block> block(String name, BlockBehaviour.Properties properties) {
        return BLOCKS.registerSimpleBlock(name, properties);
    }

    public static <T extends Block> DeferredBlock<T> block(String name, Function<BlockBehaviour.Properties, T> factory, BlockBehaviour.Properties properties) {
        return BLOCKS.registerBlock(name, factory, properties);
    }

    public static DeferredBlock<Block> blockWithItem(String name, BlockBehaviour.Properties properties) {
        DeferredBlock<Block> block = block(name, properties);
        MPItems.blockItem(block);
        return block;
    }

    public static DeferredBlock<Block> blockWithItem(String name, BlockBehaviour.Properties blockProperties, Item.Properties itemProperties) {
        DeferredBlock<Block> block = block(name, blockProperties);
        MPItems.blockItem(block, itemProperties);
        return block;
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
