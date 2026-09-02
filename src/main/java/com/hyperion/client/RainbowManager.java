package com.hyperion.client;
import java.awt.Color;
public class RainbowManager {
    private static long startTime = System.currentTimeMillis();
    public static void start() {}
    public static int getRainbowColor(long offset, float speed, float saturation, float brightness) {
        float hue = ((System.currentTimeMillis() - startTime) * 0.005f + offset) % 360 / 360.0f;
        return Color.HSBtoRGB(hue, saturation, brightness);
    }
    public static int getRainbowColor(long offset) { return getRainbowColor(offset, 0.5f, 1f, 1f); }
}
