package dev.xcolorful.cgcconfig.forge;

import dev.xcolorful.cgcconfig.CgcConfig;
import dev.xcolorful.cgcconfig.forgeclient.CgcConfigForgeClient;
import dev.xcolorful.customgun.core.api.common.McSide;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLLoader;

@Mod(CgcConfig.MOD_ID)
public class CgcConfigForge {

    public CgcConfigForge() {
        Dist dist = FMLLoader.getDist();
        McSide mcSide = dist.isClient() ? McSide.CLIENT : McSide.DEDICATED_SERVER;

        CgcConfig.init();

        if (mcSide == McSide.CLIENT) {
            _CgcConfigForgeClient.init();
        }
    }

    private static class _CgcConfigForgeClient {
        public static void init() {
            CgcConfigForgeClient.init();
        }
    }
}