package dev.xcolorful.cgcconfig.forgeclient.init;

import dev.xcolorful.cgcconfig.CgcConfig;
import dev.xcolorful.cgcconfig.client.init._ClientSetup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = CgcConfig.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class _ForgeClientSetup {

    private static final  _ClientSetup CLIENT_SETUP = _ClientSetup.get();

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(CLIENT_SETUP::onClientSetup);
    }
}
