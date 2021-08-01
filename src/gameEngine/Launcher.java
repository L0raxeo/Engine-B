package gameEngine;

import com.sampleGame.Reference;

/*
 * test note
 */

/**
 * launches game
 */
public class Launcher
{

    /**
     * This is of course the main method, however it only has one purpose: launching the game
     *
     * The launcher creates a new instance of the game engine, passing in the attributes
     * that are defined in the Reference file. The game engine is then started thus the:
     * gameEngine.start();
     *
     * @param args is always the parameter inside the main method
     */
    public static void main(String[] args)
    {
        Engine gameEngine = new Engine(Reference.NAME, Reference.WIDTH, Reference.HEIGHT);
        gameEngine.start();
    }

}
