package io.github.dogeiscut.magentaprint.registry;

import io.github.dogeiscut.magentaprint.Magentaprint;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class MPEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, Magentaprint.MOD_ID);

    public static <T extends Entity> Supplier<EntityType<T>> entity(
            String name,
            EntityType.EntityFactory<T> factory,
            MobCategory category,
            float width,
            float height
    ) {
        return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, category)
                .sized(width, height)
                .build(name));
    }

    public static <T extends Entity> Supplier<EntityType<T>> entity(
            String name,
            EntityType.EntityFactory<T> factory,
            MobCategory category,
            java.util.function.UnaryOperator<EntityType.Builder<T>> customizer
    ) {
        return ENTITY_TYPES.register(name, () -> customizer
                .apply(EntityType.Builder.of(factory, category))
                .build(name));
    }

    public static void register(IEventBus modEventBus) {
        ENTITY_TYPES.register(modEventBus);
    }
}
