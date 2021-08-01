package gameEngine.ui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class UIManager
{

    /**
     * Stores all active UIObjects
     */
    private static final ArrayList<UIObject> uiObjects = new ArrayList<>();

    /**
     * Updates all active UIObjects
     */
    public void tick()
    {
        for (UIObject o : uiObjects)
        {
            o.tick();
        }
    }

    /**
     * @param g renders all UIObjects
     */
    public void render(Graphics g)
    {
        try
        {
            for (UIObject o : uiObjects)
            {
                o.render(g);
            }
        }
        catch (ConcurrentModificationException evt)
        {
            System.out.println("[System]: thread/WARN - Could not iterate through UI Components to render - this may " +
                    "result in a crash" +
                    " - " +
                    "ConcurrentModificationException (UIManager)");
        }
    }

    public void onMouseMove(MouseEvent e)
    {
        try
        {
            for (UIObject o : uiObjects)
            {
                o.onMouseMove(e);
            }
        }
        catch (ConcurrentModificationException evt)
        {
            System.out.println("[System]: thread/WARN - Could not iterator UI Components - " +
                    "ConcurrentModificationException (UIManager)");
        }
    }

    public void onMousePress(MouseEvent e)
    {
        try
        {
            for (UIObject o : uiObjects)
            {
                o.onMousePress(e);
            }
        }
        catch (ConcurrentModificationException evt)
        {
            System.out.println("[System]: thread/WARN - Could not press mouse: UIManager could be null- this could be" +
                    " " +
                    "a problem (UIManager)");
        }
    }

    public void onMouseRelease(MouseEvent e)
    {
        try
        {
            for (UIObject o : uiObjects)
            {
                o.onMouseRelease(e);
            }
        }
        catch (ConcurrentModificationException evt)
        {
            System.out.println("[System]: thread/WARN - Could not release mouse: UIManager could be null- this could " +
                    "be " +
                    "a problem (UIManager)");
        }
    }

    public static void addObject(UIObject o)
    {
        uiObjects.add(o);
    }

    public static ArrayList<UIObject> getUIObjects()
    {
        return uiObjects;
    }

}
