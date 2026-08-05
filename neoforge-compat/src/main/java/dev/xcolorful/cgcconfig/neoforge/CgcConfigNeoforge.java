package dev.xcolorful.cgcconfig.neoforge;

import dev.xcolorful.cgcconfig.CgcConfig;
import dev.xcolorful.cgcconfig.neoforgeclient.CgcConfigNeoforgeClient;
import dev.xcolorful.customgun.CustomGun;
import dev.xcolorful.customgun.core.api.common.McSide;
import net.neoforged.fml.common.Mod;

@Mod(CgcConfig.MOD_ID)
public class CgcConfigNeoforge {

    public CgcConfigNeoforge() {
        McSide mcSide = CustomGun.getMcSide();

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
