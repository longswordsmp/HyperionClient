package com.hyperion;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class HyperionMod implements ModInitializer {
    public static final String MOD_ID = "hyperion";
    public static KeyBinding openGuiKey;

    @Override
    public void onInitialize() {
        ObfuscationEngine.init();
        openGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.hyperion.gui",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,   // FIXED: correct constant name
            "category.hyperion"
        ));
        ConfigManager.load();
        ModuleManager.registerAll();
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null && client.world != null) {
                ModuleManager.onTick();
            }
        });
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (openGuiKey.wasPressed()) {
                HyperionClient.openGui();
            }
        });
        DetectionWatchdog.start();
        RainbowManager.start();
    }
}
