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

package dev.xcolorful.cgcconfig.cloth.config.common;

import dev.xcolorful.customgun.core.config.OtherConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.network.chat.Component;

public class ClothOtherConfig {

    public static void init(ConfigBuilder builder, ConfigEntryBuilder entryBuilder) {
        ConfigCategory otherConfig = builder.getOrCreateCategory(Component.translatable("config.cgcconfig.other"));

        otherConfig.addEntry(
                entryBuilder.startDoubleField(Component.translatable("config.cgcconfig.other.server_hitbox_offset"), OtherConfig.SERVER_HITBOX_OFFSET.get())
                        .setTooltip(Component.translatable("config.cgcconfig.other.server_hitbox_offset.desc"))
                        .setDefaultValue(3.0).setMin(-Double.MAX_VALUE).setMax(Double.MAX_VALUE)
                        .setSaveConsumer(newValue -> OtherConfig.SERVER_HITBOX_OFFSET.set(newValue))
                        .build()
        );
        otherConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.other.server_hitbox_latency_fix"), OtherConfig.SERVER_HITBOX_LATENCY_FIX.get())
                        .setTooltip(Component.translatable("config.cgcconfig.other.server_hitbox_latency_fix.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> OtherConfig.SERVER_HITBOX_LATENCY_FIX.set(newValue))
                        .build()
        );
        otherConfig.addEntry(
                entryBuilder.startDoubleField(Component.translatable("config.cgcconfig.other.server_hitbox_latency_max_save_ms"), OtherConfig.SERVER_HITBOX_LATENCY_MAX_SAVE_MS.get())
                        .setTooltip(Component.translatable("config.cgcconfig.other.server_hitbox_latency_max_save_ms.desc"))
                        .setDefaultValue(1000.0).setMin(250.0).setMax(Double.MAX_VALUE)
                        .setSaveConsumer(newValue -> OtherConfig.SERVER_HITBOX_LATENCY_MAX_SAVE_MS.set(newValue))
                        .build()
        );
    }
}