package gameEngine;

import com.sampleGame.Reference;

public class Launcher
{

    public static void main(String[] args)
    {
        Engine gameEngine = new Engine(Reference.NAME, Reference.WIDTH, Reference.HEIGHT);
        gameEngine.start();
    }

}
