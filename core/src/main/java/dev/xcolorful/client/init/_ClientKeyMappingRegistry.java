/*
 * Copyright (c) 2026 XiaoColorful (https://github.com/XColorful)
 * SPDX-License-Identifier: GPL-3.0-only
 *
 * Source: https://github.com/XColorful/Custom-Gun-Continued
 */

package dev.xcolorful.client.init;

import dev.xcolorful.client.init.registry._ClientInputCategory;
import dev.xcolorful.client.input.config.ConfigKey;
import net.minecraft.client.KeyMapping;
import org.jetbrains.annotations.ApiStatus;

import java.util.function.Consumer;

public class _ClientKeyMappingRegistry {

    private static final _ClientKeyMappingRegistry INSTANCE = new _ClientKeyMappingRegistry();
    public static _ClientKeyMappingRegistry get() {
        return INSTANCE;
    }
    private _ClientKeyMappingRegistry() {}

    public void registerKeyMappings(Consumer<KeyMapping> register) {
        // config
        register.accept(ConfigKey.get().getKeyMapping().get());
    }
    @ApiStatus.AvailableSince("1.21.10")
    public void registerInputCategories(Consumer<String> register) { // Consumer<KeyMapping.Category> register
        register.accept(_ClientInputCategory.CONFIG);
    }
}
