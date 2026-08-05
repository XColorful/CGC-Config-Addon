package dev.xcolorful.cgcconfig.neoforgeclient.init;

import dev.xcolorful.cgcconfig.CgcConfig;
import dev.xcolorful.cgcconfig.client.init._ClientKeyMappingRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@EventBusSubscriber(value = Dist.CLIENT, modid = CgcConfig.MOD_ID)
public class _NeoClientKeyMappingRegistry {

    private static final _ClientKeyMappingRegistry CLIENT_KEY_MAPPING_REGISTRY = _ClientKeyMappingRegistry.get();

    @SubscribeEvent
    public static void onClientKeyMappingRegister(RegisterKeyMappingsEvent event) {
        CLIENT_KEY_MAPPING_REGISTRY.registerInputCategories((category) -> {});
        CLIENT_KEY_MAPPING_REGISTRY.registerKeyMappings(event::register);
    }
}
