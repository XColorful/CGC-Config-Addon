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
import xiao.customgun.client.config.KeyConfig;

public class ClothKeyConfig {

    public static void init(ConfigBuilder builder, ConfigEntryBuilder entryBuilder) {
        ConfigCategory keyConfig = builder.getOrCreateCategory(Component.translatable("config.cgcconfig.key"));

        keyConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.key.hold_to_aim"), KeyConfig.HOLD_TO_AIM.get())
                        .setDefaultValue(true).setTooltip(Component.translatable("config.cgcconfig.key.hold_to_aim.desc"))
                        .setSaveConsumer(newValue -> KeyConfig.HOLD_TO_AIM.set(newValue))
                        .build()
        );
        keyConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.key.hold_to_prone"), KeyConfig.HOLD_TO_PRONE.get())
                        .setDefaultValue(true).setTooltip(Component.translatable("config.cgcconfig.key.hold_to_prone.desc"))
                        .setSaveConsumer(newValue -> KeyConfig.HOLD_TO_PRONE.set(newValue))
                        .build()
        );
        keyConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.key.auto_reload"), KeyConfig.AUTO_RELOAD.get())
                        .setDefaultValue(false).setTooltip(Component.translatable("config.cgcconfig.key.auto_reload.desc"))
                        .setSaveConsumer(newValue -> KeyConfig.AUTO_RELOAD.set(newValue))
                        .build()
        );
    }
}
