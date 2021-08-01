package gameEngine.scenes;

import java.awt.*;

public abstract class Scene
{

    /**
     * Constructor is invoked (called) when the scene is first created
     * and therefore invokes (calls) the Awake() method (if there is one)
     */
    public Scene()
    {
        Awake();
    }

    /**
     * Is invoked (called) when the scene is first created
     */
    public void Awake()
    {

    }

    /**
     * Each scene has an initialization which is invoked (called)
     * when it is first activated (set as the current scene)
     */
    public abstract void init();

    /**
     * Ticks the scene (this is where all the changes in the scene are updated/synced)
     *
     * tick() is the equivalent to Update() in Unity (C#)
     */
    public abstract void tick();

    /**
     * @param g renders (draws using Graphics g) all changes made
     *          in tick() to the screen using a BufferStrategy
     */
    public abstract void render(Graphics g);

    public void addUIObjects()
    {

    }

}
