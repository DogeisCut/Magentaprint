package io.github.dogeiscut.magentaprint.registry;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public final class MPTiers {

    public static final Tier CREATIVE = new SimpleTier(
            MPTags.Blocks.INCORRECT_FOR_CREATIVE_TOOL,
            Integer.MAX_VALUE,
            1_000_000f,
            50f,
            25,
            () -> Ingredient.EMPTY
    );

    private MPTiers() {
    }
}
