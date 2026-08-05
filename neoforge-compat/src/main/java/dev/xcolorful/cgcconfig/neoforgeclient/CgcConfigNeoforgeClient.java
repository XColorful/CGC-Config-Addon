package dev.xcolorful.cgcconfig.neoforgeclient;

import dev.xcolorful.cgcconfig.client.CgcConfigClient;

public class CgcConfigNeoforgeClient {

    protected static boolean initialized;

    public static void init() {
        if (initialized) return;

        CgcConfigClient.init();
        initialized = true;
    }
}
