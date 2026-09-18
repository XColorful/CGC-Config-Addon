package dev.xcolorful.cgcconfig.neoforge;

import dev.xcolorful.cgcconfig.CgcConfig;
import dev.xcolorful.cgcconfig.neoforgeclient.CgcConfigNeoforgeClient;
import dev.xcolorful.customgun.core.api.common.McSide;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;

@Mod(CgcConfig.MOD_ID)
public class CgcConfigNeoforge {

    public CgcConfigNeoforge() {
        Dist dist = FMLLoader.getDist();
        McSide mcSide = dist.isClient() ? McSide.CLIENT : McSide.DEDICATED_SERVER;

        CgcConfig.init();

        if (mcSide == McSide.CLIENT) {
            _CgcConfigNeoforgeClient.init();
        }
    }

    private static class _CgcConfigNeoforgeClient {
        public static void init() {
            CgcConfigNeoforgeClient.init();
        }
    }
}
