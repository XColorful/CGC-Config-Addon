package dev.xcolorful.cgcconfig.cloth.api.gui;

import dev.xcolorful.cgcconfig.cloth.gui.ClothClientModConfigScreen;
import dev.xcolorful.cgcconfig.cloth.gui.ClothModConfigScreen;
import net.minecraft.client.gui.screens.Screen;

import java.util.function.Function;

public enum ClothConfigType {
    CLIENT(ClothClientModConfigScreen::getClientConfigScreen),
    COMMON(ClothModConfigScreen::getCommonConfigScreen),
    SERVER(ClothModConfigScreen::getServerConfigScreen);

    private final Function<Screen, Screen> factory;
    ClothConfigType(Function<Screen, Screen> factory) {
        this.factory = factory;
    }

    public Screen create(Screen parent) {
        return factory.apply(parent);
    }
}
