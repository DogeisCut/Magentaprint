package io.github.dogeiscut.magentaprint.registry;

import io.github.dogeiscut.magentaprint.Magentaprint;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.PercentageAttribute;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MPAttributes {

    public static final DeferredRegister<Attribute> ATTRIBUTES  =
            DeferredRegister.create(Registries.ATTRIBUTE, Magentaprint.MOD_ID);

    public static final Holder<Attribute> TOTAL_DAMAGE_REDUCTION = ATTRIBUTES.register("total_damage_reduction", () -> new PercentageAttribute(
            "attributes.magentaprint.total_damage_reduction",
            0,
            0.0d,
            1.0d
    ));

    public static void register(IEventBus modEventBus) {
        ATTRIBUTES.register(modEventBus);
    }
}
