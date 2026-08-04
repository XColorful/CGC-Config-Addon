/*
 * Copyright (c) 2024-2026 MCModderAnchor (https://github.com/MCModderAnchor)
 * SPDX-License-Identifier: GPL-3.0-only
 *
 * Source: https://github.com/MCModderAnchor/TACZ
 */

package dev.xcolorful.cgcconfig.cloth.gui;

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
