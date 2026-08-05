package dev.xcolorful.cgcconfig.neoforgeclient.init;

import dev.xcolorful.cgcconfig.CgcConfig;
import dev.xcolorful.cgcconfig.client.init._ClientSetup;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = CgcConfig.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class _NeoClientSetup {

    private static final  _ClientSetup CLIENT_SETUP = _ClientSetup.get();

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(CLIENT_SETUP::onClientSetup);
    }
}
