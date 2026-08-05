package dev.xcolorful.cgcconfig.cloth.gui;

import dev.xcolorful.cgcconfig.cloth.api.gui.ClothConfigType;
import me.shedaniel.clothconfig2.api.ConfigScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.Nullable;
import xiao.customgun.CustomGun;
import xiao.customgun.client.api.event.IClientTickEvent;
import xiao.customgun.client.util.ClientGuiUtils;
import xiao.customgun.core.api.event.EventPriority;
import xiao.customgun.core.api.event.EventType;
import xiao.customgun.core.api.event.IEvent;
import xiao.customgun.core.api.event.IEventHandler;

public class ClothScreenManager implements IEventHandler {
    public static final ClothScreenManager INSTANCE = new ClothScreenManager();
    private ClothScreenManager() {}

    static {
        CustomGun.getEventRegister().register(INSTANCE, EventType.CLIENT_TICK_EVENT, EventPriority.NORMAL, false);
    }

    private final ClothConfigType[] CLOTH_CONFIG_TYPES = ClothConfigType.values();
    private int lastConfigIndex = 0;
    private @Nullable Screen lastScreen = null; // 当前打开的cloth screen

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

    public void onSetScreen(Minecraft mc) {
        @Nullable Screen currentScreen = ClientGuiUtils.getCurrentScreen(mc);
        if (currentScreen instanceof ConfigScreen configScreen) {
            // 当前是cloth的screen，需要先保存
            boolean openOtherScreens = false;
            configScreen.saveAll(openOtherScreens);

            if (this.lastScreen != null) {
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
        Screen newScreen = CLOTH_CONFIG_TYPES[lastConfigIndex].create(currentScreen);
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
