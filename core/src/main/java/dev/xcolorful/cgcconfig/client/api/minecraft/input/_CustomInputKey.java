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

package dev.xcolorful.cgcconfig.client.api.minecraft.input;

import dev.xcolorful.cgcconfig.core.api.minecraft.input._CustomInputKeyTag;
import dev.xcolorful.customgun.CustomGun;
import dev.xcolorful.customgun.client.api.minecraft.input.CustomInputKey;
import dev.xcolorful.customgun.client.api.minecraft.input.ICustomInputKey;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public enum _CustomInputKey implements ICustomInputKey {
    // config
    CONFIG(_CustomInputKeyTag.CONFIG);

    public final String tagName;
    public final String categoryName;
    public final String registryName;
    public final ResourceLocation registryLocation;
    public final Component categoryLang;
    _CustomInputKey(String name) {
        this(_CustomInputKeyTag.PREFIX, name);
    }
    _CustomInputKey(String prefix, String name) {
        this.tagName = name;
        this.categoryName = name;
        this.registryLocation = CustomGun.getMcRegistry().createResourceLocation(prefix + name);
        this.registryName = registryLocation.toString();
        this.categoryLang = Component.translatable(this.registryLocation.getPath());
    }
    @Override public String getTagName() {
        return this.tagName;
    }
    @Override public String getCategoryName() {
        return this.categoryName;
    }
    @Override public String getRegistryName() {
        return this.registryName;
    }
    @Override public ResourceLocation getRegistryLocation() {
        return this.registryLocation;
    }

    @Override
    public Component getCategoryLang() {
        return this.categoryLang;
    }

    static {
        for (ICustomInputKey key : values()) {
            CustomInputKey.registerInputKey(key);
        }
    }

    public static @Nullable ICustomInputKey fromString(String name) {
        return CustomInputKey.fromString(name);
    }

    @Override
    public String toString() {
        return this.categoryName;
    }
}
