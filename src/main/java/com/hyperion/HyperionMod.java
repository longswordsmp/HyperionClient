package com.hyperion;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import com.hyperion.client.ModuleManager;
import com.hyperion.client.HyperionClient;
import com.hyperion.client.RainbowManager;

public class HyperionMod implements ModInitializer {
    public static final String MOD_ID = "hyperion";
    public static KeyBinding openGuiKey;

    @Override
    public void onInitialize() {
        ObfuscationEngine.init();

        // Correct KeyBinding constructor for 1.21.11 (only 3 arguments)
        openGuiKey = new KeyBinding(
            "key.hyperion.gui",                     // translation key
            InputUtil.Type.KEYSYM,                  // type
            GLFW.GLFW_KEY_RIGHT_SHIFT               // default key
        );

        // Register the key binding – this also registers its category implicitly
        KeyBindingHelper.registerKeyBinding(openGuiKey);

        // Register the category (if needed for the options screen, but it's optional)
        // KeyBindingHelper.registerKeyBindingCategory(new KeyBindingCategory(MOD_ID));

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
