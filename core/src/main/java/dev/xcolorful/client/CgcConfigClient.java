package dev.xcolorful.client;

public class CgcConfigClient {

    protected static boolean initialized;

    public static void init() {
        if (initialized) return;

        initialized = true;
    }
}
