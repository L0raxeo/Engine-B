package gameEngine.scenes;

import java.awt.*;

public abstract class Scene
{

    public abstract void init();

    public abstract void tick();

    public abstract void render(Graphics g);

    public void addUIObjects()
    {

    }

}
