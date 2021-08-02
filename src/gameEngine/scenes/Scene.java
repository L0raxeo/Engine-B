package gameEngine.scenes;

import gameEngine.entities.EntityManager;

import java.awt.*;

public abstract class Scene
{

    protected EntityManager entityManager;

    protected boolean active = false;

    /**
     * Constructor is invoked (called) when the scene is first created
     * and therefore invokes (calls) the Awake() method (if there is one)
     */
    public Scene(EntityManager entityManager)
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
    public void init()
    {

    }

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

    /**
     * Optional @Override method for adding UIObjects
     *
     * If this method is added to the scene, then it will be invoked (called) automatically
     *
     * When you implement this method into your scene,
     * it will automatically add the argument:
     * super.addUIObjects();
     * which just calls the print method written below.
     * However, the creators can always remove that super
     * argument if s/he does not want it there.
     */
    public void addUIObjects()
    {
        System.out.println("[System]: thread/INFO - Added UI Objects to UIObject Manager");
    }

}
