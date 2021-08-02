package com.sampleGame.init;

import com.sampleGame.scenes.SampleScene;
import gameEngine.Engine;
import gameEngine.scenes.Scene;
import gameEngine.scenes.SceneManager;

public class Scenes
{

    /*
     * DO NOT DELETE FILE
     */

    public static Scene sampleScene;

    /**
     * Load/initialize scene with correct path (example below - sampleScene)
     *
     * Sets current scene specified in the Reference class
     */
    public static void init()
    {
        sampleScene = new SampleScene(Engine.entityManager);

        SceneManager.setScene(sampleScene);

        System.out.println("[System]: initialization/INFO - Successfully initialized scenes (Scenes)");
    }

}
