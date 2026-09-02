package com.hyperion.client;

import java.awt.Color;

public class RainbowManager {
    private static long startTime = System.currentTimeMillis();

    public static void start() {
        // Initialise any rainbow-related state if needed
    }

    public static int getRainbowColor(long offset, float speed, float saturation, float brightness) {
        long elapsed = System.currentTimeMillis() - startTime;
        float hue = ((elapsed * speed + offset) % 360) / 360.0f;
        return Color.HSBtoRGB(hue, saturation, brightness);
    }

    public static int getRainbowColor(long offset) {
        return getRainbowColor(offset, 0.005f, 1.0f, 1.0f);
    }
}
