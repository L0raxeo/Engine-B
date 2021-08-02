package gameEngine.input;

import gameEngine.Engine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener
{

    private final boolean[] buttons;

    public static boolean right_click, left_click; // right:mb_3, left:mb_1

    public static int xMouse, yMouse;

    public MouseManager()
    {
        buttons = new boolean[256];
    }

    public void tick()
    {
        right_click = buttons[MouseEvent.BUTTON3];
        left_click = buttons[MouseEvent.BUTTON1];
    }

    private static boolean hasPressed = false;
    private static boolean hasReleased = false;

    public static boolean onKeyDown(boolean btn)
    {
        if (btn && !hasPressed)
        {
            hasPressed = true;
            return true;
        }
        else if (!btn)
        {
            hasPressed = false;
            return false;
        }
        else
            return false;
    }

    public static boolean onKeyReleased(boolean btn)
    {
        if (!btn && !hasReleased)
        {
            hasReleased = true;
            return true;
        }
        else if (btn)
        {
            hasReleased = false;
            return false;
        }
        else
            return false;
    }

    public static boolean onKeyHeld(boolean btn)
    {
        return btn;
    }

    public static int getMouseX()
    {
        return xMouse;
    }

    public static int getMouseY()
    {
        return yMouse;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        buttons[e.getButton()] = true;

        if (Engine.uiManager != null)
            Engine.uiManager.onMousePress(e);
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        buttons[e.getButton()] = false;

        if (Engine.uiManager != null)
            Engine.uiManager.onMouseRelease(e);
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {

    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        xMouse = e.getX();
        yMouse = e.getY();

        try
        {
            Engine.uiManager.onMouseMove(e);
        }
        catch (NullPointerException evt)
        {
            System.out.println("[System]: thread/WARN-could not move mouse: UIManager could be null- this could be" +
                    " a " +
                    "problem (MouseManager)");
        }
    }

}
