package dev.xcolorful;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public class CgcConfig {
    public static final String MOD_ID = "cgcconfig";
    public static final Logger LOGGER = LogUtils.getLogger();

    protected static boolean initialized;

    public static void init() {
        if (initialized) return;

        initialized = true;
    }
}
