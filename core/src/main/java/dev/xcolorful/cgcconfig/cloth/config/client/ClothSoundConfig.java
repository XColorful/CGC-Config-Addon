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

import dev.xcolorful.customgun.client.config.SoundConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.network.chat.Component;

public class ClothSoundConfig {

    public static void init(ConfigBuilder builder, ConfigEntryBuilder entryBuilder) {
        ConfigCategory soundConfig = builder.getOrCreateCategory(Component.translatable("config.cgcconfig.sound"));

        soundConfig.addEntry(
                entryBuilder.startIntField(Component.translatable("config.cgcconfig.sound.hit_sound_concurrency_limit"), SoundConfig.HIT_SOUND_CONCURRENCY_LIMIT.get())
                        .setDefaultValue(1).setMin(0).setMax(128).setTooltip(Component.translatable("config.cgcconfig.sound.hit_sound_concurrency_limit.desc"))
                        .setSaveConsumer(newValue -> SoundConfig.HIT_SOUND_CONCURRENCY_LIMIT.set(newValue))
                        .build()
        );
        soundConfig.addEntry(
                entryBuilder.startIntField(Component.translatable("config.cgcconfig.sound.default_sound_concurrency_limit"), SoundConfig.DEFAULT_SOUND_CONCURRENCY_LIMIT.get())
                        .setDefaultValue(2).setMin(0).setMax(128).setTooltip(Component.translatable("config.cgcconfig.sound.default_sound_concurrency_limit.desc"))
                        .setSaveConsumer(newValue -> SoundConfig.DEFAULT_SOUND_CONCURRENCY_LIMIT.set(newValue))
                        .build()
        );
        soundConfig.addEntry(
                entryBuilder.startIntField(Component.translatable("config.cgcconfig.sound.high_frequency_sound_concurrency_limit"), SoundConfig.HIGH_FREQUENCY_SOUND_CONCURRENCY_LIMIT.get())
                        .setDefaultValue(4).setMin(0).setMax(128).setTooltip(Component.translatable("config.cgcconfig.sound.high_frequency_sound_concurrency_limit.desc"))
                        .setSaveConsumer(newValue -> SoundConfig.HIGH_FREQUENCY_SOUND_CONCURRENCY_LIMIT.set(newValue))
                        .build()
        );
        soundConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.sound.first_person_animation_sound_tracking"), SoundConfig.FIRST_PERSON_ANIMATION_SOUND_TRACKING.get())
                        .setDefaultValue(false).setTooltip(Component.translatable("config.cgcconfig.sound.first_person_animation_sound_tracking.desc"))
                        .setSaveConsumer(newValue -> SoundConfig.FIRST_PERSON_ANIMATION_SOUND_TRACKING.set(newValue))
                        .build()
        );
    }
}
