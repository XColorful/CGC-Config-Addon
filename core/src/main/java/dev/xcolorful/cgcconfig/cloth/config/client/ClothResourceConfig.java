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

import dev.xcolorful.customgun.client.config.ResourceConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.network.chat.Component;

public class ClothResourceConfig {

    public static void init(ConfigBuilder builder, ConfigEntryBuilder entryBuilder) {
        ConfigCategory resourceConfig = builder.getOrCreateCategory(Component.translatable("config.cgcconfig.resource"));

        resourceConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.resource.enable_lazy_client_asset_load"), ResourceConfig.ENABLE_LAZY_CLIENT_ASSET_LOAD.get())
                        .setDefaultValue(true).setTooltip(Component.translatable("config.cgcconfig.resource.enable_lazy_client_asset_load.desc"))
                        .setSaveConsumer(newValue -> ResourceConfig.ENABLE_LAZY_CLIENT_ASSET_LOAD.set(newValue))
                        .build()
        );
    }
}