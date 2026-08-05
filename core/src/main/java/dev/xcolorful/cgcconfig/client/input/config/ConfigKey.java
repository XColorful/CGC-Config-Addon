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
import dev.xcolorful.cgcconfig.cloth.gui.ClothScreenManager;
import dev.xcolorful.customgun.client.api.event.IInputKeyEvent;
import dev.xcolorful.customgun.client.api.event.IMouseButtonEvent;
import dev.xcolorful.customgun.client.api.input.IInputKeyManager;
import dev.xcolorful.customgun.client.api.input.IKeyConflictContext;
import dev.xcolorful.customgun.client.api.input.IKeyMapping;
import dev.xcolorful.customgun.client.api.input.IKeyModifier;
import dev.xcolorful.customgun.client.input.InputKey;
import dev.xcolorful.customgun.client.util.ClientInputUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import org.lwjgl.glfw.GLFW;

public final class ConfigKey extends InputKey {

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
        return true;
    }
    @Override
    public boolean unregisterEventHandler() {
        return true;
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

        ClothScreenManager.INSTANCE.onSetScreen(mc);
    }
}
