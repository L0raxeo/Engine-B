package com.sampleGame.scenes;

import com.sampleGame.init.Textures;
import gameEngine.scenes.Scene;

import java.awt.*;

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

    }

    // Render scene here
    @Override
    public void render(Graphics g)
    {
        g.drawImage(Textures.sample_texture, 0, 0, 292, 88, null);
    }

}
