package dev.xcolorful.cgcconfig.neoforgeclient.init;

import dev.xcolorful.cgcconfig.CgcConfig;
import dev.xcolorful.cgcconfig.client.init._ClientKeyMappingRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = CgcConfig.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class _NeoClientKeyMappingRegistry {

    private static final _ClientKeyMappingRegistry CLIENT_KEY_MAPPING_REGISTRY = _ClientKeyMappingRegistry.get();

    @SubscribeEvent
    public static void onClientKeyMappingRegister(RegisterKeyMappingsEvent event) {
        CLIENT_KEY_MAPPING_REGISTRY.registerInputCategories((category) -> {});
        CLIENT_KEY_MAPPING_REGISTRY.registerKeyMappings(event::register);
    }
}
