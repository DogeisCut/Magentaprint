package io.github.dogeiscut.magentaprint;

import com.mojang.logging.LogUtils;
import io.github.dogeiscut.magentaprint.registry.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.slf4j.Logger;

@Mod(Magentaprint.MOD_ID)
public class Magentaprint {

    public static final String MOD_ID = "magentaprint";

    public static final Logger LOGGER = LogUtils.getLogger();

    public Magentaprint(IEventBus modEventBus, ModContainer modContainer) {

        MPDataComponents.register(modEventBus);
        MPAttributes.register(modEventBus);
        MPArmorMaterials.register(modEventBus);
        MPItems.register(modEventBus);
        MPBlocks.register(modEventBus);
        MPBlockEntities.register(modEventBus);
        MPEntities.register(modEventBus);
        MPParticles.register(modEventBus);
        MPSounds.register(modEventBus);
        MPCreativeTabs.register(modEventBus);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        }
    }
}
