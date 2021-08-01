package com.sampleGame.init;

import gameEngine.utils.FontLoader;

import java.awt.*;

public class Fonts
{

    /*
     * DO NOT DELETE FILE
     */

    public static Font sample_font;

    /**
     * Load/initialize font with correct path (example below - sample_font)
     */
    public static void init()
    {
        sample_font = FontLoader.loadFont("assets/samples/fonts/sample_font.ttf", 32);

        System.out.println("[System]: initialization/INFO - Successfully initialized fonts (Fonts)");
    }

}
