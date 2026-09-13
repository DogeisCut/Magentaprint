package io.github.dogeiscut.magentaprint.content.entities.creative_creature;

import io.github.dogeiscut.magentaprint.Magentaprint;
import io.github.dogeiscut.magentaprint.MagentaprintClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CreativeCreatureRenderer extends MobRenderer<CreativeCreatureEntity, CreativeCreatureModel<CreativeCreatureEntity>> {
    private static final ResourceLocation CREATIVE_CREATURE_LOCATION = ResourceLocation.fromNamespaceAndPath(Magentaprint.MOD_ID, "textures/entity/creative_creature/creative_creature.png");

    public CreativeCreatureRenderer(EntityRendererProvider.Context context) {
        super(context, new CreativeCreatureModel<>(context.bakeLayer(MagentaprintClient.CREATIVE_CREATURE_LAYER)), 0.3f);

    }


    @Override
    public ResourceLocation getTextureLocation(CreativeCreatureEntity creativeCreatureEntity) {
        return CREATIVE_CREATURE_LOCATION;
    }
}