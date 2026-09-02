package com.hyperion.modules.visual;
import com.hyperion.client.Module;
import com.hyperion.client.ModuleCategory;
import com.hyperion.client.RainbowManager;
import net.minecraft.util.math.ChunkPos;
public class ESP extends Module {
    public static ESP INSTANCE = new ESP();
    public ESP() { super("ESP", ModuleCategory.VISUAL); }
    public void highlightChunk(ChunkPos pos, int color) {}
    @Override public void onRender() {}
}
