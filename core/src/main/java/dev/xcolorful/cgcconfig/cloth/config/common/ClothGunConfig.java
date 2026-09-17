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

import dev.xcolorful.customgun.core.config.GunConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.network.chat.Component;

public class ClothGunConfig {

    public static void init(ConfigBuilder builder, ConfigEntryBuilder entryBuilder) {
        ConfigCategory gunConfig = builder.getOrCreateCategory(Component.translatable("config.cgcconfig.gun"));

        gunConfig.addEntry(
                entryBuilder.startIntField(Component.translatable("config.cgcconfig.gun.default_gun_fire_sound_distance"), GunConfig.DEFAULT_GUN_FIRE_SOUND_DISTANCE.get())
                        .setTooltip(Component.translatable("config.cgcconfig.gun.default_gun_fire_sound_distance.desc"))
                        .setDefaultValue(320).setMin(0).setMax(Integer.MAX_VALUE)
                        .setSaveConsumer(newValue -> GunConfig.DEFAULT_GUN_FIRE_SOUND_DISTANCE.set(newValue))
                        .build()
        );
        gunConfig.addEntry(
                entryBuilder.startIntField(Component.translatable("config.cgcconfig.gun.default_gun_silence_sound_distance"), GunConfig.DEFAULT_GUN_SILENCE_SOUND_DISTANCE.get())
                        .setTooltip(Component.translatable("config.cgcconfig.gun.default_gun_silence_sound_distance.desc"))
                        .setDefaultValue(256).setMin(0).setMax(Integer.MAX_VALUE)
                        .setSaveConsumer(newValue -> GunConfig.DEFAULT_GUN_SILENCE_SOUND_DISTANCE.set(newValue))
                        .build()
        );
        gunConfig.addEntry(
                entryBuilder.startIntField(Component.translatable("config.cgcconfig.gun.default_gun_other_sound_distance"), GunConfig.DEFAULT_GUN_OTHER_SOUND_DISTANCE.get())
                        .setTooltip(Component.translatable("config.cgcconfig.gun.default_gun_other_sound_distance.desc"))
                        .setDefaultValue(16).setMin(0).setMax(Integer.MAX_VALUE)
                        .setSaveConsumer(newValue -> GunConfig.DEFAULT_GUN_OTHER_SOUND_DISTANCE.set(newValue))
                        .build()
        );
        gunConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.gun.creative_player_consume_ammo"), GunConfig.CREATIVE_PLAYER_CONSUME_AMMO.get())
                        .setTooltip(Component.translatable("config.cgcconfig.gun.creative_player_consume_ammo.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> GunConfig.CREATIVE_PLAYER_CONSUME_AMMO.set(newValue))
                        .build()
        );
        gunConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.gun.auto_reload_when_respawn"), GunConfig.AUTO_RELOAD_WHEN_RESPAWN.get())
                        .setTooltip(Component.translatable("config.cgcconfig.gun.auto_reload_when_respawn.desc"))
                        .setDefaultValue(false)
                        .setSaveConsumer(newValue -> GunConfig.AUTO_RELOAD_WHEN_RESPAWN.set(newValue))
                        .build()
        );
    }
}