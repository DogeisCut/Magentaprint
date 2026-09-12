package io.github.dogeiscut.magentaprint.event;

import io.github.dogeiscut.magentaprint.Magentaprint;
import io.github.dogeiscut.magentaprint.registry.MPAttributes;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber(modid = Magentaprint.MOD_ID)
public final class NeoForgeEvents {

    private NeoForgeEvents() {
    }

    @SubscribeEvent
    public static void onEntityAttributeModification(EntityAttributeModificationEvent event) {
        for (EntityType<? extends LivingEntity> type : event.getTypes()) {
            if (!event.has(type, MPAttributes.TOTAL_DAMAGE_REDUCTION)) {
                event.add(type, MPAttributes.TOTAL_DAMAGE_REDUCTION);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingEntityDamage(LivingIncomingDamageEvent event) {
        DamageSource damageSource = event.getSource();
        if (damageSource.is(DamageTypes.OUTSIDE_BORDER)) return;
        if (damageSource.is(DamageTypes.FELL_OUT_OF_WORLD)) return;
        if (damageSource.is(DamageTypes.GENERIC_KILL)) return;
        LivingEntity livingEntity = event.getEntity();
        AttributeMap attributes = livingEntity.getAttributes();
        AttributeInstance instance = attributes.getInstance(MPAttributes.TOTAL_DAMAGE_REDUCTION);
        if (instance != null) {
            double damage_reduction = instance.getValue();
            if (damage_reduction - Mth.EPSILON <= 0.0d) {
                event.setCanceled(false);
                return;
            }
            if (damage_reduction + Mth.EPSILON >= 1.0d) {
                event.setCanceled(true);
                return;
            }
            event.setAmount((float) (event.getAmount() * (1.0f - damage_reduction)));
        }
    }

}
