package io.github.dogeiscut.magentaprint.content.entities.creative_creature;

import io.github.dogeiscut.magentaprint.registry.MPEntities;
import io.github.dogeiscut.magentaprint.registry.MPItems;
import net.minecraft.client.model.ChickenModel;
import net.minecraft.client.renderer.entity.ChickenRenderer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class CreativeCreatureEntity extends Animal {
    public CreativeCreatureEntity(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(MPItems.CREATIVE_COOKIE.get());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4));
        this.goalSelector.addGoal(2, new BreedGoal(this, (double)1.0F));
        this.goalSelector.addGoal(3, new TemptGoal(this, (double)1.0F, (itemStack) -> itemStack.is(MPItems.CREATIVE_COOKIE.get()), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, (double)1.0F));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier createAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 2.0d)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .build();
    }

    private boolean bypassHealthFloor = false;

    @Override
    protected void actuallyHurt(DamageSource damageSource, float amount) {
        this.bypassHealthFloor = damageSource.is(DamageTypes.FELL_OUT_OF_WORLD)
                || damageSource.is(DamageTypes.GENERIC_KILL);
        super.actuallyHurt(damageSource, amount);
        this.bypassHealthFloor = false;
    }

    @Override
    public void setHealth(float health) {
        if (this.bypassHealthFloor) {
            super.setHealth(health);
        } else {
            super.setHealth(Math.max(health, 1.0F));
        }
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return MPEntities.CREATIVE_CREATURE.get().create(serverLevel);
    }
}
