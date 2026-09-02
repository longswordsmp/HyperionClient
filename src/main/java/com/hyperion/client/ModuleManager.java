package com.hyperion.client;
import java.util.ArrayList;
import java.util.List;
public class ModuleManager {
    private static List<Module> modules = new ArrayList<>();
    public static void registerAll() {
        modules.add(new com.hyperion.modules.basefinding.BaseFinder());
        modules.add(new com.hyperion.modules.basefinding.SusChunkFinder());
        modules.add(new com.hyperion.modules.visual.ESP());
        // add other modules here
    }
    public static void onTick() { for (Module m : modules) if (m.isEnabled()) m.onTick(); }
}
