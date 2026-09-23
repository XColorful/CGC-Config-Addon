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
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.gun.bypass_gun_fire_consumption"), GunConfig.BYPASS_GUN_FIRE_CONSUMPTION.get())
                        .setTooltip(Component.translatable("config.cgcconfig.gun.bypass_gun_fire_consumption.desc"))
                        .setDefaultValue(false)
                        .setSaveConsumer(newValue -> GunConfig.BYPASS_GUN_FIRE_CONSUMPTION.set(newValue))
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