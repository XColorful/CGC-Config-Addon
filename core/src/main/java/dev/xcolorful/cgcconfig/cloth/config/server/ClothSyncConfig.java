package dev.xcolorful.cgcconfig.cloth.config.server;

import dev.xcolorful.customgun.core.config.SyncConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.impl.builders.SubCategoryBuilder;
import net.minecraft.network.chat.Component;

import java.util.Collections;

/**
 * 服务端配置需要同步
 */
public class ClothSyncConfig {

    public static void init(ConfigBuilder builder, ConfigEntryBuilder entryBuilder) {
        ConfigCategory syncConfig = builder.getOrCreateCategory(Component.translatable("config.cgcconfig.sync"));

        SubCategoryBuilder interactKey = entryBuilder.startSubCategory(Component.translatable("config.cgcconfig.sync.interact_key"));
        interactKey.add(
                entryBuilder.startStrList(Component.translatable("config.cgcconfig.sync.interact_key.interact_key_whitelist_blocks"), SyncConfig.INTERACT_KEY_WHITELIST_BLOCKS.get())
                        .setTooltip(Component.translatable("config.cgcconfig.sync.interact_key.interact_key_whitelist_blocks.desc"))
                        .setDefaultValue(Collections.emptyList())
                        .setSaveConsumer(newValue -> SyncConfig.INTERACT_KEY_WHITELIST_BLOCKS.set(newValue))
                        .build()
        );
        interactKey.add(
                entryBuilder.startStrList(Component.translatable("config.cgcconfig.sync.interact_key.interact_key_whitelist_entities"), SyncConfig.INTERACT_KEY_WHITELIST_ENTITIES.get())
                        .setTooltip(Component.translatable("config.cgcconfig.sync.interact_key.interact_key_whitelist_entities.desc"))
                        .setDefaultValue(Collections.emptyList())
                        .setSaveConsumer(newValue -> SyncConfig.INTERACT_KEY_WHITELIST_ENTITIES.set(newValue))
                        .build()
        );
        interactKey.add(
                entryBuilder.startStrList(Component.translatable("config.cgcconfig.sync.interact_key.interact_key_blacklist_blocks"), SyncConfig.INTERACT_KEY_BLACKLIST_BLOCKS.get())
                        .setTooltip(Component.translatable("config.cgcconfig.sync.interact_key.interact_key_blacklist_blocks.desc"))
                        .setDefaultValue(Collections.emptyList())
                        .setSaveConsumer(newValue -> SyncConfig.INTERACT_KEY_BLACKLIST_BLOCKS.set(newValue))
                        .build()
        );
        interactKey.add(
                entryBuilder.startStrList(Component.translatable("config.cgcconfig.sync.interact_key.interact_key_blacklist_entities"), SyncConfig.INTERACT_KEY_BLACKLIST_ENTITIES.get())
                        .setTooltip(Component.translatable("config.cgcconfig.sync.interact_key.interact_key_blacklist_entities.desc"))
                        .setDefaultValue(Collections.emptyList())
                        .setSaveConsumer(newValue -> SyncConfig.INTERACT_KEY_BLACKLIST_ENTITIES.set(newValue))
                        .build()
        );
        syncConfig.addEntry(interactKey.build());

        SubCategoryBuilder baseMultiplier = entryBuilder.startSubCategory(Component.translatable("config.cgcconfig.sync.base_multiplier"));
        baseMultiplier.add(
                entryBuilder.startDoubleField(Component.translatable("config.cgcconfig.sync.base_multiplier.damage_base_multiplier"), SyncConfig.DAMAGE_BASE_MULTIPLIER.get())
                        .setTooltip(Component.translatable("config.cgcconfig.sync.base_multiplier.damage_base_multiplier.desc"))
                        .setDefaultValue(1.0).setMin(0.0).setMax(Double.MAX_VALUE)
                        .setSaveConsumer(newValue -> SyncConfig.DAMAGE_BASE_MULTIPLIER.set(newValue))
                        .build()
        );
        baseMultiplier.add(
                entryBuilder.startDoubleField(Component.translatable("config.cgcconfig.sync.base_multiplier.armor_ignore_base_multiplier"), SyncConfig.ARMOR_IGNORE_BASE_MULTIPLIER.get())
                        .setTooltip(Component.translatable("config.cgcconfig.sync.base_multiplier.armor_ignore_base_multiplier.desc"))
                        .setDefaultValue(1.0).setMin(0.0).setMax(Double.MAX_VALUE)
                        .setSaveConsumer(newValue -> SyncConfig.ARMOR_IGNORE_BASE_MULTIPLIER.set(newValue))
                        .build()
        );
        baseMultiplier.add(
                entryBuilder.startDoubleField(Component.translatable("config.cgcconfig.sync.base_multiplier.head_shot_base_multiplier"), SyncConfig.HEAD_SHOT_BASE_MULTIPLIER.get())
                        .setTooltip(Component.translatable("config.cgcconfig.sync.base_multiplier.head_shot_base_multiplier.desc"))
                        .setDefaultValue(1.0).setMin(0.0).setMax(Double.MAX_VALUE)
                        .setSaveConsumer(newValue -> SyncConfig.HEAD_SHOT_BASE_MULTIPLIER.set(newValue))
                        .build()
        );
        baseMultiplier.add(
                entryBuilder.startDoubleField(Component.translatable("config.cgcconfig.sync.base_multiplier.weight_speed_multiplier"), SyncConfig.WEIGHT_SPEED_MULTIPLIER.get())
                        .setTooltip(Component.translatable("config.cgcconfig.sync.base_multiplier.weight_speed_multiplier.desc"))
                        .setDefaultValue(0.015).setMin(-1.0).setMax(Double.MAX_VALUE)
                        .setSaveConsumer(newValue -> SyncConfig.WEIGHT_SPEED_MULTIPLIER.set(newValue))
                        .build()
        );
        syncConfig.addEntry(baseMultiplier.build());

        SubCategoryBuilder misc = entryBuilder.startSubCategory(Component.translatable("config.cgcconfig.sync.misc"));
        misc.add(
                entryBuilder.startStrList(Component.translatable("config.cgcconfig.sync.misc.head_shot_aabb"), SyncConfig.HEAD_SHOT_AABB.get())
                        .setTooltip(Component.translatable("config.cgcconfig.sync.misc.head_shot_aabb.desc"))
                        .setDefaultValue(Collections.emptyList())
                        .setSaveConsumer(newValue -> SyncConfig.HEAD_SHOT_AABB.set(newValue))
                        .build()
        );
        misc.add(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.sync.misc.hide_entity_hitbox"), SyncConfig.HIDE_ENTITY_HITBOX.get())
                        .setTooltip(Component.translatable("config.cgcconfig.sync.misc.hide_entity_hitbox.desc"))
                        .setDefaultValue(false)
                        .setSaveConsumer(newValue -> SyncConfig.HIDE_ENTITY_HITBOX.set(newValue))
                        .build()
        );
        misc.add(
                entryBuilder.startIntField(Component.translatable("config.cgcconfig.sync.misc.ammo_box_stack_size"), SyncConfig.AMMO_BOX_STACK_SIZE.get())
                        .setTooltip(Component.translatable("config.cgcconfig.sync.misc.ammo_box_stack_size.desc"))
                        .setDefaultValue(3).setMin(1).setMax(Integer.MAX_VALUE)
                        .setSaveConsumer(newValue -> SyncConfig.AMMO_BOX_STACK_SIZE.set(newValue))
                        .build()
        );
        misc.add(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.sync.misc.enable_prone"), SyncConfig.ENABLE_PRONE.get())
                        .setTooltip(Component.translatable("config.cgcconfig.sync.misc.enable_prone.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> SyncConfig.ENABLE_PRONE.set(newValue))
                        .build()
        );
        misc.add(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.sync.misc.server_shoot_network_v"), SyncConfig.SERVER_SHOOT_NETWORK_V.get())
                        .setTooltip(Component.translatable("config.cgcconfig.sync.misc.server_shoot_network_v.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> SyncConfig.SERVER_SHOOT_NETWORK_V.set(newValue))
                        .build()
        );
        misc.add(
                entryBuilder.startBooleanToggle(Component.translatable("config.cgcconfig.sync.misc.server_shoot_cooldown_v"), SyncConfig.SERVER_SHOOT_COOLDOWN_V.get())
                        .setTooltip(Component.translatable("config.cgcconfig.sync.misc.server_shoot_cooldown_v.desc"))
                        .setDefaultValue(true)
                        .setSaveConsumer(newValue -> SyncConfig.SERVER_SHOOT_COOLDOWN_V.set(newValue))
                        .build()
        );
        syncConfig.addEntry(misc.build());
    }
}