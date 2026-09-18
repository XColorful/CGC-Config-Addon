package dev.xcolorful.cgcconfig.cloth.config.client;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.network.chat.Component;

public class ClothResourceConfig {

    public static void init(ConfigBuilder builder, ConfigEntryBuilder entryBuilder) {
        builder.getOrCreateCategory(Component.translatable("config.cgcconfig.resource"));
    }
}