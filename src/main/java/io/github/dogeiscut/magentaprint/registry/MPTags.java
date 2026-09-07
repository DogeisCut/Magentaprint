package io.github.dogeiscut.magentaprint.registry;

import io.github.dogeiscut.magentaprint.util.MPUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class MPTags {

    private MPTags() {
    }

    public static final class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_CREATIVE_TOOL =
                TagKey.create(BuiltInRegistries.BLOCK.key(), MPUtils.id("incorrect_for_creative_tool"));

        private Blocks() {
        }
    }

    public static final class Items {
        private Items() {
        }
    }
}
