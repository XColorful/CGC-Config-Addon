package dev.xcolorful.cgcconfig.cloth;

import dev.xcolorful.cgcconfig.cloth.init.ClothClientModConfig;
import dev.xcolorful.cgcconfig.cloth.init.ClothModConfig;

public class CgcConfigCloth {

    protected static boolean initialized;

    public static void init() {
        if (initialized) return;

        ClothModConfig.init();
        ClothClientModConfig.init();

        initialized = true;
    }
}
