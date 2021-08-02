package com.sampleGame.scenes;

import com.sampleGame.init.Textures;
import gameEngine.entities.EntityManager;
import gameEngine.input.KeyManager;
import gameEngine.input.Keys;
import gameEngine.scenes.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SampleScene extends Scene
{

    /**
     * Constructor is invoked (called) when the scene is first created
     * and therefore invokes (calls) the Awake() method (if there is one)
     *
     * @param entityManager used to manage all entities
     */
    public SampleScene(EntityManager entityManager)
    {
        super(entityManager);
    }

    // Called when scene is activated (set to the current scene)
    @Override
    public void init()
    {
        if (entityManager != null)
            entityManager.tick();
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
