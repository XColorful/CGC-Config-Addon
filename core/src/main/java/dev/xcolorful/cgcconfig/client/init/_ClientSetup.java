package dev.xcolorful.cgcconfig.client.init;

import dev.xcolorful.cgcconfig.cloth.CgcConfigCloth;

public class _ClientSetup {

    private static final _ClientSetup INSTANCE = new _ClientSetup();
    public static _ClientSetup get() {
        return INSTANCE;
    }
    private _ClientSetup() {}

    public void onClientSetup() {
        CgcConfigCloth.init();
    }
}
