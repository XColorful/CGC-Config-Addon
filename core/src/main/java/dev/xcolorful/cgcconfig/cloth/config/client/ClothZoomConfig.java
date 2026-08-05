/*
 * Copyright (c) 2024-2026 MCModderAnchor (https://github.com/MCModderAnchor)
 * SPDX-License-Identifier: GPL-3.0-only
 *
 * Source: https://github.com/MCModderAnchor/TACZ
 */

/*
 * Copyright (c) 2026 XiaoColorful (https://github.com/XColorful)
 * SPDX-License-Identifier: GPL-3.0-only
 *
 * Source: https://github.com/XColorful/Custom-Gun-Continued
 */

package dev.xcolorful.cgcconfig.cloth.config.client;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.network.chat.Component;
import xiao.customgun.client.config.ZoomConfig;

public class ClothZoomConfig {

    public static void init(ConfigBuilder builder, ConfigEntryBuilder entryBuilder) {
        ConfigCategory zoomConfig = builder.getOrCreateCategory(Component.translatable("config.cgcconfig.zoom"));

        zoomConfig.addEntry(
                entryBuilder.startDoubleField(Component.translatable("config.cgcconfig.zoom.screen_distance_coefficient"), ZoomConfig.SCREEN_DISTANCE_COEFFICIENT.get())
                        .setDefaultValue(1.33).setMin(0.0).setMax(3.0).setTooltip(Component.translatable("config.cgcconfig.zoom.screen_distance_coefficient.desc"))
                        .setSaveConsumer(newValue -> ZoomConfig.SCREEN_DISTANCE_COEFFICIENT.set(newValue))
                        .build()
        );
        zoomConfig.addEntry(
                entryBuilder.startDoubleField(Component.translatable("config.cgcconfig.zoom.zoom_sensitivity_base_multiplier"), ZoomConfig.ZOOM_SENSITIVITY_BASE_MULTIPLIER.get())
                        .setDefaultValue(1.0).setMin(0.0).setMax(2.0).setTooltip(Component.translatable("config.cgcconfig.zoom.zoom_sensitivity_base_multiplier.desc"))
                        .setSaveConsumer(newValue -> ZoomConfig.ZOOM_SENSITIVITY_BASE_MULTIPLIER.set(newValue))
                        .build()
        );
    }
}