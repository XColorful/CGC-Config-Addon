/*
 * Copyright (c) 2026 XiaoColorful (https://github.com/XColorful)
 * SPDX-License-Identifier: GPL-3.0-only
 *
 * Source: https://github.com/XColorful/Custom-Gun-Continued
 */

package dev.xcolorful.core.api.minecraft.input;

import dev.xcolorful.CgcConfig;
import org.jetbrains.annotations.ApiStatus;

public class _CustomInputCategoryTag {

    // 1.21.10+会强行加上"key.category"前缀，并跟上RL的namespace
    public static final String PREFIX = "key.category." + CgcConfig.MOD_ID + "."; @ApiStatus.AvailableSince("1.21.10") public static final String PREFIX_OLD1 = "key.category." + CgcConfig.MOD_ID + ".";

    public static final String CONFIG = "config";
}
