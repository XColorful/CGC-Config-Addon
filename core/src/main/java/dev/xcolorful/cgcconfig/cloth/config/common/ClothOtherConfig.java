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
                entryBuilder.startIntField(Component.translatable("config.cgcconfig.other.target_sound_distance"), OtherConfig.TARGET_SOUND_DISTANCE.get())
                        .setDefaultValue(128).setMin(0).setMax(Integer.MAX_VALUE).setTooltip(Component.translatable("config.cgcconfig.other.target_sound_distance.desc"))
                        .setSaveConsumer(newValue -> OtherConfig.TARGET_SOUND_DISTANCE.set(newValue))
                        .build()
        );
        otherConfig.addEntry(
                entryBuilder.startDoubleField(Component.translatable("config.cgcconfig.other.server_hitbox_offset"), OtherConfig.SERVER_HITBOX_OFFSET.get())
                        .setDefaultValue(3.0).setMin(-Double.MAX_VALUE).setMax(Double.MAX_VALUE).setTooltip(Component.translatable("config.cgcconfig.other.server_hitbox_offset.desc"))
                        .setSaveConsumer(newValue -> OtherConfig.SERVER_HITBOX_OFFSET.set(newValue))
                        .build()
        );
        otherConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.other.server_hitbox_latency_fix"), OtherConfig.SERVER_HITBOX_LATENCY_FIX.get())
                        .setDefaultValue(true).setTooltip(Component.translatable("config.cgcconfig.other.server_hitbox_latency_fix.desc"))
                        .setSaveConsumer(newValue -> OtherConfig.SERVER_HITBOX_LATENCY_FIX.set(newValue))
                        .build()
        );
        otherConfig.addEntry(
                entryBuilder.startDoubleField(Component.translatable("config.cgcconfig.other.server_hitbox_latency_max_save_ms"), OtherConfig.SERVER_HITBOX_LATENCY_MAX_SAVE_MS.get())
                        .setDefaultValue(1000.0).setMin(250.0).setMax(Double.MAX_VALUE).setTooltip(Component.translatable("config.cgcconfig.other.server_hitbox_latency_max_save_ms.desc"))
                        .setSaveConsumer(newValue -> OtherConfig.SERVER_HITBOX_LATENCY_MAX_SAVE_MS.set(newValue))
                        .build()
        );
    }
}