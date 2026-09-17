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

import dev.xcolorful.customgun.client.api.textures.crosshair.CrosshairType;
import dev.xcolorful.customgun.client.config.RenderConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.network.chat.Component;

public class ClothRenderConfig {

    public static void init(ConfigBuilder builder, ConfigEntryBuilder entryBuilder) {
        ConfigCategory renderConfig = builder.getOrCreateCategory(Component.translatable("config.cgcconfig.render"));

        renderConfig.addEntry(
                entryBuilder.startIntField(Component.translatable("config.cgcconfig.render.gun_lod_render_distance"), RenderConfig.GUN_LOD_RENDER_DISTANCE.get())
                        .setTooltip(Component.translatable("config.cgcconfig.render.gun_lod_render_distance.desc"))
                        .setDefaultValue(0).setMin(0).setMax(Integer.MAX_VALUE)
                        .setSaveConsumer(newValue -> RenderConfig.GUN_LOD_RENDER_DISTANCE.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.disable_gun_tilting"), RenderConfig.DISABLE_GUN_TILTING.get())
                        .setTooltip(Component.translatable("config.cgcconfig.render.disable_gun_tilting.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> RenderConfig.DISABLE_GUN_TILTING.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.enable_first_person_bullet_tracer"), RenderConfig.ENABLE_FIRST_PERSON_BULLET_TRACER.get())
                        .setTooltip(Component.translatable("config.cgcconfig.render.enable_first_person_bullet_tracer.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> RenderConfig.ENABLE_FIRST_PERSON_BULLET_TRACER.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.replace_vanilla_crosshair"), RenderConfig.REPLACE_VANILLA_CROSSHAIR.get())
                        .setTooltip(Component.translatable("config.cgcconfig.render.replace_vanilla_crosshair.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> RenderConfig.REPLACE_VANILLA_CROSSHAIR.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startEnumSelector(Component.translatable("config.cgcconfig.render.crosshair_type"), CrosshairType.class, RenderConfig.CROSSHAIR_TYPE.get())
                        .setTooltip(Component.translatable("config.cgcconfig.render.crosshair_type.desc"))
                        .setDefaultValue(CrosshairType.DEFAULT)
                        .setSaveConsumer(newValue -> RenderConfig.CROSSHAIR_TYPE.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.enable_gun_hud"), RenderConfig.ENABLE_GUN_HUD.get())
                        .setTooltip(Component.translatable("config.cgcconfig.render.enable_gun_hud.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> RenderConfig.ENABLE_GUN_HUD.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.keep_display_gun_hud"), RenderConfig.KEEP_DISPLAY_GUN_HUD.get())
                        .setTooltip(Component.translatable("config.cgcconfig.render.keep_display_gun_hud.desc"))
                        .setDefaultValue(false)
                        .setSaveConsumer(newValue -> RenderConfig.KEEP_DISPLAY_GUN_HUD.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.force_display_gun_hud"), RenderConfig.FORCE_DISPLAY_GUN_HUD.get())
                        .setTooltip(Component.translatable("config.cgcconfig.render.force_display_gun_hud.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> RenderConfig.FORCE_DISPLAY_GUN_HUD.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.enable_shooter_operation_hud"), RenderConfig.ENABLE_SHOOTER_OPERATION_HUD.get())
                        .setTooltip(Component.translatable("config.cgcconfig.render.enable_shooter_operation_hud.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> RenderConfig.ENABLE_SHOOTER_OPERATION_HUD.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.append_resource_location_in_tooltip"), RenderConfig.APPEND_RESOURCE_LOCATION_IN_TOOLTIP.get())
                        .setTooltip(Component.translatable("config.cgcconfig.render.append_resource_location_in_tooltip.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> RenderConfig.APPEND_RESOURCE_LOCATION_IN_TOOLTIP.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.enable_laser_fade_out"), RenderConfig.ENABLE_LASER_FADE_OUT.get())
                        .setTooltip(Component.translatable("config.cgcconfig.render.enable_laser_fade_out.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> RenderConfig.ENABLE_LASER_FADE_OUT.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startIntField(Component.translatable("config.cgcconfig.render.bullet_hole_particle_life"), RenderConfig.BULLET_HOLE_PARTICLE_LIFE.get())
                        .setTooltip(Component.translatable("config.cgcconfig.render.bullet_hole_particle_life.desc"))
                        .setDefaultValue(400).setMin(0).setMax(Integer.MAX_VALUE)
                        .setSaveConsumer(newValue -> RenderConfig.BULLET_HOLE_PARTICLE_LIFE.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startDoubleField(Component.translatable("config.cgcconfig.render.bullet_hole_particle_fade_threshold"), RenderConfig.BULLET_HOLE_PARTICLE_FADE_THRESHOLD.get())
                        .setTooltip(Component.translatable("config.cgcconfig.render.bullet_hole_particle_fade_threshold.desc"))
                        .setDefaultValue(0.98).setMin(0.0).setMax(1.0)
                        .setSaveConsumer(newValue -> RenderConfig.BULLET_HOLE_PARTICLE_FADE_THRESHOLD.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.disable_movement_attribute_fov"), RenderConfig.DISABLE_MOVEMENT_ATTRIBUTE_FOV.get())
                        .setTooltip(Component.translatable("config.cgcconfig.render.disable_movement_attribute_fov.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> RenderConfig.DISABLE_MOVEMENT_ATTRIBUTE_FOV.set(newValue))
                        .build()
        );
    }
}