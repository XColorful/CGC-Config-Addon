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

package dev.xcolorful.cgcconfig.client.input.config;

import com.mojang.blaze3d.platform.InputConstants;
import dev.xcolorful.cgcconfig.CgcConfig;
import dev.xcolorful.cgcconfig.client.api.minecraft.input._CustomInputKey;
import dev.xcolorful.cgcconfig.client.init.registry._ClientInputCategory;
import dev.xcolorful.cgcconfig.cloth.api.gui.ClothConfigType;
import me.shedaniel.clothconfig2.api.ConfigScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import xiao.customgun.CustomGun;
import xiao.customgun.client.api.event.IClientTickEvent;
import xiao.customgun.client.api.event.IInputKeyEvent;
import xiao.customgun.client.api.event.IMouseButtonEvent;
import xiao.customgun.client.api.input.IInputKeyManager;
import xiao.customgun.client.api.input.IKeyConflictContext;
import xiao.customgun.client.api.input.IKeyMapping;
import xiao.customgun.client.api.input.IKeyModifier;
import xiao.customgun.client.input.InputKey;
import xiao.customgun.client.util.ClientGuiUtils;
import xiao.customgun.client.util.ClientInputUtils;
import xiao.customgun.core.api.event.*;

public final class ConfigKey extends InputKey implements IEventHandler {

    private static final class ConfigKeyHolder {
        private static final ConfigKey INSTANCE = new ConfigKey();
    }

    public static ConfigKey get() {
        return ConfigKeyHolder.INSTANCE;
    }

    private ConfigKey() {
        super(_CustomInputKey.CONFIG);
    }
    @Override protected IKeyMapping createKeyMapping(IKeyMapping.Creator creator) {
        return creator.create(this.key.getCategoryLang().getString(),
                IKeyConflictContext.Type.IN_GAME,
                IKeyModifier.Type.ALT,
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_T,
                _ClientInputCategory.CONFIG);
    }

    public static final String _MANAGER_NAME = String.format("%s:%s", CgcConfig.MOD_ID, ConfigKey.class.getSimpleName());
    @Override public String getManagerName() {
        return _MANAGER_NAME;
    }

    @Override
    public boolean registerEventHandler() {
        ICustomEventRegister customEventRegister = CustomGun.getEventRegister();
        customEventRegister.register(this, EventType.CLIENT_TICK_EVENT, EventPriority.NORMAL, false);
        return true;
    }
    @Override
    public boolean unregisterEventHandler() {
        ICustomEventRegister customEventRegister = CustomGun.getEventRegister();
        customEventRegister.unregister(this, EventType.CLIENT_TICK_EVENT, EventPriority.NORMAL, false);
        return true;
    }

    @Override public String getEventHandlerName() {
        return this.getClass().getName();
    }
    @Override
    public void handleEvent(EventType eventType, IEvent event) {
        if (eventType == EventType.CLIENT_TICK_EVENT) {
            onClientTick((IClientTickEvent) event);
        } else {
            onReceiveWrongEvent(eventType);
        }
    }

    // --------IInputHandler--------

    @Override
    public void onKeyInput(IInputKeyManager inputKeyManager, IInputKeyEvent event) {
        this.onConfigKeyInput(event.getAction());
    }
    @Override
    public void onMouseInput(IInputKeyManager inputKeyManager, IMouseButtonEvent event) {
        this.onConfigKeyInput(event.getAction());
    }
    private void onConfigKeyInput(int action) {
        if (action != GLFW.GLFW_PRESS) return;

        if (!ClientInputUtils.isInGameWorld()) return; // 不在游戏界面

        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null) return;

        this.onSetScreen(mc);
    }

    private final ClothConfigType[] CLOTH_CONFIG_TYPES = ClothConfigType.values();
    private int lastConfigIndex = 0;
    private @Nullable Screen lastScreen = null; // 当前打开的cloth screen

    private void onSetScreen(Minecraft mc) {
        @Nullable Screen currentScreen = ClientGuiUtils.getCurrentScreen(mc);
        if (currentScreen instanceof ConfigScreen configScreen) {
            // 当前是cloth的screen，需要先保存
            boolean openOtherScreens = false;
            configScreen.saveAll(openOtherScreens);

            if (lastScreen != null) {
                // 上次的没关闭，切换到下个循环
                this.lastConfigIndex = (this.lastConfigIndex + 1) % CLOTH_CONFIG_TYPES.length;
                Screen newScreen = CLOTH_CONFIG_TYPES[this.lastConfigIndex]
                        .create(null); // 循环切换的时候算作一个层级，不然一次esc退不出去
                ClientGuiUtils.setCurrentScreen(mc, newScreen);
                this.lastScreen = newScreen;
                return;
            }
        }

        // 打开上次的screen
        Screen newScreen = CLOTH_CONFIG_TYPES[this.lastConfigIndex].create(currentScreen);
        ClientGuiUtils.setCurrentScreen(mc, newScreen);
        this.lastScreen = newScreen;
    }

    /**
     * 检测上次的screen是否还处于打开状态
     */
    private void onClientTick(IClientTickEvent event) {
        // 只检测自己的，避免反复读screen
        if (this.lastScreen == null) return;

        Minecraft mc = Minecraft.getInstance();
        @Nullable Screen currentScreen = ClientGuiUtils.getCurrentScreen(mc);
        if (this.lastScreen != currentScreen) {
            this.lastScreen = null;
        }
    }
}
