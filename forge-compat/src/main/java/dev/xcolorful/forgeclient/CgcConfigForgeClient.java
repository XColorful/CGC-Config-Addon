package dev.xcolorful.forgeclient;

import dev.xcolorful.client.CgcConfigClient;

public class CgcConfigForgeClient {

    protected static boolean initialized;

    public static void init() {
        if (initialized) return;

        CgcConfigClient.init();
        initialized = true;
    }
}
