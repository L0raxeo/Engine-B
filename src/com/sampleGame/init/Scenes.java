package com.sampleGame.init;

import com.sampleGame.scenes.SampleScene;
import gameEngine.scenes.Scene;

public class Scenes
{

    /*
     * DO NOT DELETE FILE
     */

    public static Scene sampleScene;

    public static void init()
    {
        sampleScene = new SampleScene();

        System.out.println("[System]: initialization/INFO - Successfully initialized scenes (Scenes)");
    }

}
