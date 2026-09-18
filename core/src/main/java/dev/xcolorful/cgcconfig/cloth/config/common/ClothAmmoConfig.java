package dev.xcolorful.cgcconfig.cloth.config.common;

import dev.xcolorful.customgun.core.config.AmmoConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;

public class ClothAmmoConfig {

    public static void init(ConfigBuilder builder, ConfigEntryBuilder entryBuilder) {
        ConfigCategory ammoConfig = builder.getOrCreateCategory(Component.translatable("config.cgcconfig.ammo"));

        ammoConfig.addEntry(
                entryBuilder.startStrList(Component.translatable("config.cgcconfig.ammo.pass_through_blocks"), AmmoConfig.PASS_THROUGH_BLOCKS.get())
                        .setTooltip(Component.translatable("config.cgcconfig.ammo.pass_through_blocks.desc"))
                        .setDefaultValue(ArrayList::new)
                        .setSaveConsumer(newValue -> AmmoConfig.PASS_THROUGH_BLOCKS.set(newValue))
                        .build()
        );
        ammoConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.ammo.destroy_glass"), AmmoConfig.DESTROY_GLASS.get())
                        .setTooltip(Component.translatable("config.cgcconfig.ammo.destroy_glass.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> AmmoConfig.DESTROY_GLASS.set(newValue))
                        .build()
        );
        ammoConfig.addEntry(
                entryBuilder.startDoubleField(Component.translatable("config.cgcconfig.ammo.global_bullet_speed_modifier"), AmmoConfig.GLOBAL_BULLET_SPEED_MODIFIER.get())
                        .setTooltip(Component.translatable("config.cgcconfig.ammo.global_bullet_speed_modifier.desc"))
                        .setDefaultValue(1.0).setMin(0.01).setMax(20.0)
                        .setSaveConsumer(newValue -> AmmoConfig.GLOBAL_BULLET_SPEED_MODIFIER.set(newValue))
                        .build()
        );
        ammoConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.ammo.ignite_block"), AmmoConfig.IGNITE_BLOCK.get())
                        .setTooltip(Component.translatable("config.cgcconfig.ammo.ignite_block.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> AmmoConfig.IGNITE_BLOCK.set(newValue))
                        .build()
        );
        ammoConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.ammo.ignite_entity"), AmmoConfig.IGNITE_ENTITY.get())
                        .setTooltip(Component.translatable("config.cgcconfig.ammo.ignite_entity.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> AmmoConfig.IGNITE_ENTITY.set(newValue))
                        .build()
        );
        ammoConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.ammo.explosive_ammo_destroys_block"), AmmoConfig.EXPLOSIVE_AMMO_DESTROYS_BLOCK.get())
                        .setTooltip(Component.translatable("config.cgcconfig.ammo.explosive_ammo_destroys_block.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> AmmoConfig.EXPLOSIVE_AMMO_DESTROYS_BLOCK.set(newValue))
                        .build()
        );
        ammoConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.ammo.explosive_ammo_fire"), AmmoConfig.EXPLOSIVE_AMMO_FIRE.get())
                        .setTooltip(Component.translatable("config.cgcconfig.ammo.explosive_ammo_fire.desc"))
                        .setDefaultValue(false)
                        .setSaveConsumer(newValue -> AmmoConfig.EXPLOSIVE_AMMO_FIRE.set(newValue))
                        .build()
        );
        ammoConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.ammo.explosive_ammo_knock_back"), AmmoConfig.EXPLOSIVE_AMMO_KNOCK_BACK.get())
                        .setTooltip(Component.translatable("config.cgcconfig.ammo.explosive_ammo_knock_back.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> AmmoConfig.EXPLOSIVE_AMMO_KNOCK_BACK.set(newValue))
                        .build()
        );
        ammoConfig.addEntry(
                entryBuilder.startIntField(Component.translatable("config.cgcconfig.ammo.explosive_ammo_visible_distance"), AmmoConfig.EXPLOSIVE_AMMO_VISIBLE_DISTANCE.get())
                        .setTooltip(Component.translatable("config.cgcconfig.ammo.explosive_ammo_visible_distance.desc"))
                        .setDefaultValue(192).setMin(0).setMax(Integer.MAX_VALUE)
                        .setSaveConsumer(newValue -> AmmoConfig.EXPLOSIVE_AMMO_VISIBLE_DISTANCE.set(newValue))
                        .build()
        );
    }
}