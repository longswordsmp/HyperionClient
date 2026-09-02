package com.hyperion.client;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private static final List<Module> modules = new ArrayList<>();

    public static void registerAll() {
        // Add your modules here later – for now, empty stubs
        // Example: modules.add(new SomeModule());
    }

    public static void onTick() {
        for (Module module : modules) {
            if (module.isEnabled()) {
                module.onTick();
            }
        }
    }

    // Optional: add getters, toggles, etc. as needed
}
