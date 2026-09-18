package dev.xcolorful.cgcconfig.cloth.gui.cloth;

import dev.xcolorful.cgcconfig.cloth.init.ClothModConfig;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.Nullable;

public class ClothModConfigScreen {

    public static Screen getCommonConfigScreen(@Nullable Screen parent) {
        return ClothModConfig.CommonConfig.configBuilder.get()
                .setParentScreen(parent)
                .build();
    }

    public static Screen getServerConfigScreen(@Nullable Screen parent) {
        return ClothModConfig.ServerConfig.configBuilder.get()
                .setParentScreen(parent)
                .build();
    }
}
