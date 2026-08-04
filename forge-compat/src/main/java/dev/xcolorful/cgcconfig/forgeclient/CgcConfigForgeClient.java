package dev.xcolorful.cgcconfig.forgeclient;

import dev.xcolorful.cgcconfig.client.CgcConfigClient;

public class CgcConfigForgeClient {

    protected static boolean initialized;

    public static void init() {
        if (initialized) return;

        CgcConfigClient.init();
        initialized = true;
    }
}
