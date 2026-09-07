package io.github.dogeiscut.magentaprint.registry;

import io.github.dogeiscut.magentaprint.Magentaprint;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class MPCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Magentaprint.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAGENTAPRINT = CREATIVE_MODE_TABS.register(
            "magentaprint",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + Magentaprint.MOD_ID))
                    .icon(() -> new ItemStack(Items.MAGENTA_DYE))
                    .displayItems((params, output) -> MPItems.ITEMS.getEntries()
                            .forEach(holder -> output.accept(holder.get())))
                    .build()
    );

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
