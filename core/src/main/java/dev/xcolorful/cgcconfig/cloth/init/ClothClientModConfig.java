package dev.xcolorful.cgcconfig.cloth.init;

import dev.xcolorful.cgcconfig.cloth.config.client.*;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.network.chat.Component;

import java.util.function.Supplier;

public class ClothClientModConfig {

    public static void init() {
        ClientConfig.init();
    }

    public static class ClientConfig {
        public static Supplier<ConfigBuilder> configBuilder;

        private static void init() {
            ClientConfig.configBuilder = ClientConfig::getConfigBuilder;
        }
        private static ConfigBuilder getConfigBuilder() {
            ConfigBuilder builder = ConfigBuilder.create()
                    .setTitle(Component.translatable("config.category.cgcconfig.client")); {
                ConfigEntryBuilder entryBuilder = builder.entryBuilder();

                ClothKeyConfig.init(builder, entryBuilder);
                ClothRenderConfig.init(builder, entryBuilder);
                ClothResourceConfig.init(builder, entryBuilder);
                ClothSoundConfig.init(builder, entryBuilder);
                ClothZoomConfig.init(builder, entryBuilder);
            }

            builder.setGlobalized(true);
            builder.setGlobalizedExpanded(false);

            return builder;
        }
    }
}
