package dev.xcolorful.cgcconfig.cloth.gui.cloth;

import dev.xcolorful.cgcconfig.cloth.init.ClothClientModConfig;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.Nullable;

public class ClothClientModConfigScreen {

    public static Screen getClientConfigScreen(@Nullable Screen parent) {
        return ClothClientModConfig.ClientConfig.configBuilder.get()
                .setParentScreen(parent)
                .build();
    }
}
