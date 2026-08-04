/*
 * Copyright (c) 2024-2026 MCModderAnchor (https://github.com/MCModderAnchor)
 * SPDX-License-Identifier: GPL-3.0-only
 *
 * Source: https://github.com/MCModderAnchor/TACZ
 */

package dev.xcolorful.cgcconfig.cloth.gui;

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
