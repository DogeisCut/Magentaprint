package io.github.dogeiscut.magentaprint;

import io.github.dogeiscut.magentaprint.content.entities.creative_creature.CreativeCreatureModel;
import io.github.dogeiscut.magentaprint.content.entities.creative_creature.CreativeCreatureRenderer;
import io.github.dogeiscut.magentaprint.registry.MPEntities;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = Magentaprint.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MagentaprintClient {

    public MagentaprintClient(IEventBus modEventBus) {
    }

    public static final ModelLayerLocation CREATIVE_CREATURE_LAYER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Magentaprint.MOD_ID, "creative_creature"), "main");

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CREATIVE_CREATURE_LAYER, CreativeCreatureModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(MPEntities.CREATIVE_CREATURE.get(), CreativeCreatureRenderer::new);
    }
}
