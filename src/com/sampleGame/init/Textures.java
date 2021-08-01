package com.sampleGame.init;

import gameEngine.utils.ImageLoader;

import java.awt.image.BufferedImage;

public class Textures
{

    /*
     * DO NOT DELETE FILE
     */

    public static BufferedImage sample_texture;

    public static void init()
    {
        sample_texture = ImageLoader.loadImage("/assets/samples/textures/sample_texture.png");

        System.out.println("[System]: initialization/INFO - Successfully loaded textures (Textures)");
    }

}
