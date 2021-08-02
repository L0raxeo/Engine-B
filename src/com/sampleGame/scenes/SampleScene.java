package com.sampleGame.scenes;

import com.sampleGame.init.Textures;
import gameEngine.input.KeyManager;
import gameEngine.input.Keys;
import gameEngine.scenes.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SampleScene extends Scene
{

    // Called when scene is activated (set to the current scene)
    @Override
    public void init()
    {

    }

    // Update scene here
    @Override
    public void tick()
    {
        if (KeyManager.onKeyDown(Keys.backtick))
            System.out.println("kys");
    }

    // Render scene here
    @Override
    public void render(Graphics g)
    {
        g.drawImage(Textures.sample_texture, 0, 0, 292, 88, null);
    }

}
