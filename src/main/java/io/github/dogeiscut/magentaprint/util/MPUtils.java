package io.github.dogeiscut.magentaprint.util;

import io.github.dogeiscut.magentaprint.Magentaprint;
import net.minecraft.resources.ResourceLocation;

public final class MPUtils {

    private MPUtils() {
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(Magentaprint.MOD_ID, path);
    }
}
