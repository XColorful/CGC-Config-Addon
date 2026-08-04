package dev.xcolorful.forge;

import dev.xcolorful.CgcConfig;
import dev.xcolorful.forgeclient.CgcConfigForgeClient;
import net.minecraftforge.fml.common.Mod;
import xiao.customgun.CustomGun;
import xiao.customgun.core.api.common.McSide;

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