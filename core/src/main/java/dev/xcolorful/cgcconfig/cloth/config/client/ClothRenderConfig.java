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
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.enable_laser_fade_out"), RenderConfig.ENABLE_LASER_FADE_OUT.get())
                        .setDefaultValue(true).setTooltip(Component.translatable("config.cgcconfig.render.enable_laser_fade_out.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.ENABLE_LASER_FADE_OUT.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startIntField(Component.translatable("config.cgcconfig.render.gun_lod_render_distance"), RenderConfig.GUN_LOD_RENDER_DISTANCE.get())
                        .setDefaultValue(0).setMin(0).setMax(Integer.MAX_VALUE).setTooltip(Component.translatable("config.cgcconfig.render.gun_lod_render_distance.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.GUN_LOD_RENDER_DISTANCE.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.disable_gun_tilting"), RenderConfig.DISABLE_GUN_TILTING.get())
                        .setDefaultValue(false).setTooltip(Component.translatable("config.cgcconfig.render.disable_gun_tilting.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.DISABLE_GUN_TILTING.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startIntField(Component.translatable("config.cgcconfig.render.bullet_hole_particle_life"), RenderConfig.BULLET_HOLE_PARTICLE_LIFE.get())
                        .setDefaultValue(400).setMin(0).setMax(Integer.MAX_VALUE).setTooltip(Component.translatable("config.cgcconfig.render.bullet_hole_particle_life.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.BULLET_HOLE_PARTICLE_LIFE.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startDoubleField(Component.translatable("config.cgcconfig.render.bullet_hole_particle_fade_threshold"), RenderConfig.BULLET_HOLE_PARTICLE_FADE_THRESHOLD.get())
                        .setDefaultValue(0.98).setMin(0.0).setMax(1.0).setTooltip(Component.translatable("config.cgcconfig.render.bullet_hole_particle_fade_threshold.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.BULLET_HOLE_PARTICLE_FADE_THRESHOLD.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.replace_vanilla_crosshair"), RenderConfig.REPLACE_VANILLA_CROSSHAIR.get())
                        .setDefaultValue(true).setTooltip(Component.translatable("config.cgcconfig.render.replace_vanilla_crosshair.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.REPLACE_VANILLA_CROSSHAIR.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startEnumSelector(Component.translatable("config.cgcconfig.render.crosshair_type"), CrosshairType.class, RenderConfig.CROSSHAIR_TYPE.get())
                        .setDefaultValue(CrosshairType.DEFAULT).setTooltip(Component.translatable("config.cgcconfig.render.crosshair_type.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.CROSSHAIR_TYPE.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startDoubleField(Component.translatable("config.cgcconfig.render.hit_marker_start_position"), RenderConfig.HIT_MARKET_START_POSITION.get())
                        .setDefaultValue(4.0).setMin(-1024.0).setMax(1024.0).setTooltip(Component.translatable("config.cgcconfig.render.hit_marker_start_position.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.HIT_MARKET_START_POSITION.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.head_shot_debug_hitbox"), RenderConfig.HEAD_SHOT_DEBUG_HITBOX.get())
                        .setDefaultValue(false).setTooltip(Component.translatable("config.cgcconfig.render.head_shot_debug_hitbox.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.HEAD_SHOT_DEBUG_HITBOX.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.gun_hud_enable"), RenderConfig.GUN_HUD_ENABLE.get())
                        .setDefaultValue(true).setTooltip(Component.translatable("config.cgcconfig.render.gun_hud_enable.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.GUN_HUD_ENABLE.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.kill_amount_enable"), RenderConfig.KILL_AMOUNT_ENABLE.get())
                        .setDefaultValue(true).setTooltip(Component.translatable("config.cgcconfig.render.kill_amount_enable.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.KILL_AMOUNT_ENABLE.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startDoubleField(Component.translatable("config.cgcconfig.render.kill_amount_duration_second"), RenderConfig.KILL_AMOUNT_DURATION_SECOND.get())
                        .setDefaultValue(3.0).setMin(0.0).setMax(Double.MAX_VALUE).setTooltip(Component.translatable("config.cgcconfig.render.kill_amount_duration_second.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.KILL_AMOUNT_DURATION_SECOND.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startIntField(Component.translatable("config.cgcconfig.render.target_render_distance"), RenderConfig.TARGET_RENDER_DISTANCE.get())
                        .setDefaultValue(128).setMin(0).setMax(Integer.MAX_VALUE).setTooltip(Component.translatable("config.cgcconfig.render.target_render_distance.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.TARGET_RENDER_DISTANCE.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.enable_first_person_bullet_tracer"), RenderConfig.ENABLE_FIRST_PERSON_BULLET_TRACER.get())
                        .setDefaultValue(true).setTooltip(Component.translatable("config.cgcconfig.render.enable_first_person_bullet_tracer.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.ENABLE_FIRST_PERSON_BULLET_TRACER.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.disable_interact_hud_text"), RenderConfig.DISABLE_INTERACT_HUD_TEXT.get())
                        .setDefaultValue(false).setTooltip(Component.translatable("config.cgcconfig.render.disable_interact_hud_text.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.DISABLE_INTERACT_HUD_TEXT.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.auto_select_gun_smith_table_filter"), RenderConfig.AUTO_SELECT_GUN_SMITH_TABLE_FILTER.get())
                        .setDefaultValue(true).setTooltip(Component.translatable("config.cgcconfig.render.auto_select_gun_smith_table_filter.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.AUTO_SELECT_GUN_SMITH_TABLE_FILTER.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startIntField(Component.translatable("config.cgcconfig.render.damage_counter_reset_time"), RenderConfig.DAMAGE_COUNTER_RESET_TIME.get())
                        .setDefaultValue(2000).setMin(10).setMax(Integer.MAX_VALUE).setTooltip(Component.translatable("config.cgcconfig.render.damage_counter_reset_time.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.DAMAGE_COUNTER_RESET_TIME.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.disable_movement_attribute_fov"), RenderConfig.DISABLE_MOVEMENT_ATTRIBUTE_FOV.get())
                        .setDefaultValue(true).setTooltip(Component.translatable("config.cgcconfig.render.disable_movement_attribute_fov.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.DISABLE_MOVEMENT_ATTRIBUTE_FOV.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.append_resource_location_in_tooltip"), RenderConfig.APPEND_RESOURCE_LOCATION_IN_TOOLTIP.get())
                        .setDefaultValue(true).setTooltip(Component.translatable("config.cgcconfig.render.append_resource_location_in_tooltip.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.APPEND_RESOURCE_LOCATION_IN_TOOLTIP.set(newValue))
                        .build()
        );
        renderConfig.addEntry(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.render.block_entity_translucent"), RenderConfig.BLOCK_ENTITY_TRANSLUCENT.get())
                        .setDefaultValue(false).setTooltip(Component.translatable("config.cgcconfig.render.block_entity_translucent.desc"))
                        .setSaveConsumer(newValue -> RenderConfig.BLOCK_ENTITY_TRANSLUCENT.set(newValue))
                        .build()
        );
    }
}