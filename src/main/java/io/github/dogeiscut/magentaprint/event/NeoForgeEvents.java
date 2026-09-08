package io.github.dogeiscut.magentaprint.event;

import io.github.dogeiscut.magentaprint.Magentaprint;
import io.github.dogeiscut.magentaprint.registry.MPAttributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber(modid = Magentaprint.MOD_ID)
public final class NeoForgeEvents {

    private NeoForgeEvents() {
    }

    @SubscribeEvent
    public static void onLivingEntityDamage(LivingIncomingDamageEvent event) {
        LivingEntity livingEntity = event.getEntity();
        AttributeMap attributes = livingEntity.getAttributes();
        AttributeInstance instance = attributes.getInstance(MPAttributes.TOTAL_DAMAGE_REDUCTION);
        if (instance != null) {
            double damage_reduction = instance.getValue();
            if (damage_reduction >= 1.0d) {
                event.setCanceled(true);
                return;
            }
            event.setAmount((float) (event.getAmount() * damage_reduction));
        }
    }

}
