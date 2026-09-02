package com.hyperion.client;
import net.minecraft.client.MinecraftClient;
public abstract class Module {
    protected MinecraftClient mc = MinecraftClient.getInstance();
    private boolean enabled = false;
    private String name;
    private ModuleCategory category;
    public Module(String name, ModuleCategory category) { this.name = name; this.category = category; }
    public void toggle() { enabled = !enabled; if (enabled) onEnable(); else onDisable(); }
    public boolean isEnabled() { return enabled; }
    public void onEnable() {}
    public void onDisable() {}
    public void onTick() {}
    public void onRender() {}
    public String getName() { return name; }
    public ModuleCategory getCategory() { return category; }
}
