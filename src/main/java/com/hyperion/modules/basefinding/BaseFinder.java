package com.hyperion.modules.basefinding;
import com.hyperion.client.Module;
import com.hyperion.client.ModuleCategory;
public class BaseFinder extends Module {
    public BaseFinder() { super("BaseFinder", ModuleCategory.BASEFINDING); }
    @Override public void onEnable() { System.out.println("BaseFinder enabled"); }
    @Override public void onTick() { /* scanning logic here */ }
}
