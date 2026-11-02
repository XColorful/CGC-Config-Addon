package dev.xcolorful.cgcconfig.cloth.config.client;

import dev.xcolorful.customgun.client.config.KeyConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.network.chat.Component;

public class ClothKeyConfig {

    public static void init(ConfigBuilder builder, ConfigEntryBuilder entryBuilder) {
        ConfigCategory keyConfig = builder.getOrCreateCategory(Component.translatable("config.cgcconfig.key"));

        keyConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.key.hold_to_aim"), KeyConfig.HOLD_TO_AIM.get())
                        .setTooltip(Component.translatable("config.cgcconfig.key.hold_to_aim.desc"))
                        .setDefaultValue(false)
                        .setSaveConsumer(newValue -> KeyConfig.HOLD_TO_AIM.set(newValue))
                        .build()
        );
        keyConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.key.aim_switch_to_first_person"), KeyConfig.AIM_SWITCH_TO_FIRST_PERSON.get())
                        .setTooltip(Component.translatable("config.cgcconfig.key.aim_switch_to_first_person.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> KeyConfig.AIM_SWITCH_TO_FIRST_PERSON.set(newValue))
                        .build()
        );
        keyConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.key.revert_aim_perspective"), KeyConfig.REVERT_AIM_PERSPECTIVE.get())
                        .setTooltip(Component.translatable("config.cgcconfig.key.revert_aim_perspective.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> KeyConfig.REVERT_AIM_PERSPECTIVE.set(newValue))
                        .build()
        );
        keyConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.key.hold_to_prone"), KeyConfig.HOLD_TO_PRONE.get())
                        .setTooltip(Component.translatable("config.cgcconfig.key.hold_to_prone.desc"))
                        .setDefaultValue(false)
                        .setSaveConsumer(newValue -> KeyConfig.HOLD_TO_PRONE.set(newValue))
                        .build()
        );
        keyConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.key.hold_shoot_prevent_bolt"), KeyConfig.HOLD_SHOOT_PREVENT_BOLT.get())
                        .setTooltip(Component.translatable("config.cgcconfig.key.hold_shoot_prevent_bolt.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> KeyConfig.HOLD_SHOOT_PREVENT_BOLT.set(newValue))
                        .build()
        );
        keyConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.key.auto_reload"), KeyConfig.AUTO_RELOAD.get())
                        .setTooltip(Component.translatable("config.cgcconfig.key.auto_reload.desc"))
                        .setDefaultValue(false)
                        .setSaveConsumer(newValue -> KeyConfig.AUTO_RELOAD.set(newValue))
                        .build()
        );
        keyConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.key.shoot_to_reload"), KeyConfig.SHOOT_TO_RELOAD.get())
                        .setTooltip(Component.translatable("config.cgcconfig.key.shoot_to_reload.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> KeyConfig.SHOOT_TO_RELOAD.set(newValue))
                        .build()
        );
    }
}