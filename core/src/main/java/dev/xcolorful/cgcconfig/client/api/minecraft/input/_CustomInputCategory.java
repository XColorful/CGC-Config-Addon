/*
 * Copyright (c) 2026 XiaoColorful (https://github.com/XColorful)
 * SPDX-License-Identifier: GPL-3.0-only
 *
 * Source: https://github.com/XColorful/Custom-Gun-Continued
 */

package dev.xcolorful.cgcconfig.client.api.minecraft.input;

import dev.xcolorful.cgcconfig.CgcConfig;
import dev.xcolorful.cgcconfig.core.api.minecraft.input._CustomInputCategoryTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import xiao.customgun.CustomGun;
import xiao.customgun.client.api.minecraft.input.CustomInputCategory;
import xiao.customgun.client.api.minecraft.input.ICustomInputCategory;

public enum _CustomInputCategory implements ICustomInputCategory {
    CONFIG(_CustomInputCategoryTag.CONFIG);

    public final String tagName;
    public final String categoryName;
    public final String registryName;
    public final ResourceLocation registryLocation;
    public final Component categoryLang;
    _CustomInputCategory(String category) {
        this(_CustomInputCategoryTag.PREFIX, category);
    }
    _CustomInputCategory(String prefix, String category) {
        this.tagName = category;
        this.categoryName = category;
        this.registryLocation = CustomGun.getMcRegistry().createResourceLocation(String.format("%s:%s", CgcConfig.MOD_ID, prefix + category));
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
        for (_CustomInputCategory category : values()) {
            CustomInputCategory.registerInputCategory(category);
        }
    }

    public static @Nullable ICustomInputCategory fromString(String name) {
        return CustomInputCategory.fromString(name);
    }

    @Override
    public String toString() {
        return this.categoryName;
    }
}
