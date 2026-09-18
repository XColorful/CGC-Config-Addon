package dev.xcolorful.cgcconfig.client.init.registry;

import dev.xcolorful.cgcconfig.client.api.minecraft.input._CustomInputCategory;
import net.minecraft.client.KeyMapping;

public class _ClientInputCategory {
    public static final KeyMapping.Category CONFIG = new KeyMapping.Category(_CustomInputCategory.CONFIG.getRegistryLocation());
}
