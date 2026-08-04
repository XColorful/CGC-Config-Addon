package dev.xcolorful.forgeclient;

public class CgcConfigForgeClient {

    protected static boolean initialized;

    public static void init() {
        if (initialized) return;

        initialized = true;
    }
}
