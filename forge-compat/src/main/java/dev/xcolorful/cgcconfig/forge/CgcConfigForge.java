package dev.xcolorful.cgcconfig.forge;

import dev.xcolorful.cgcconfig.CgcConfig;
import dev.xcolorful.cgcconfig.forgeclient.CgcConfigForgeClient;
import dev.xcolorful.customgun.CustomGun;
import dev.xcolorful.customgun.core.api.common.McSide;
import net.minecraftforge.fml.common.Mod;

@Mod(CgcConfig.MOD_ID)
public class CgcConfigForge {

    public CgcConfigForge() {
        McSide mcSide = CustomGun.getMcSide();

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