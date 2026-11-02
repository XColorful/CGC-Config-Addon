package dev.xcolorful.cgcconfig.cloth.config.common;

import dev.xcolorful.customgun.core.config.ShooterConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.network.chat.Component;

public class ClothShooterConfig {

    public static void init(ConfigBuilder builder, ConfigEntryBuilder entryBuilder) {
        ConfigCategory shooterConfig = builder.getOrCreateCategory(Component.translatable("config.cgcconfig.shooter"));

        shooterConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.shooter.creative_mode_infinite_feed"), ShooterConfig.CREATIVE_MODE_INFINITE_FEED.get())
                        .setTooltip(Component.translatable("config.cgcconfig.shooter.creative_mode_infinite_feed.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> ShooterConfig.CREATIVE_MODE_INFINITE_FEED.set(newValue))
                        .build()
        );
    }
}