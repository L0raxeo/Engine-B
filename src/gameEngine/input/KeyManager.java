package gameEngine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{

    private final boolean[] keys;

    public KeyManager()
    {
        keys = new boolean[256];
    }

    public void tick()
    {

    }

    public static boolean onKeyPress(KeyEvent e)
    {
        return false;
    }

    public static boolean onKeyRelease(KeyEvent e)
    {
        return false;
    }

    public static boolean onKeyHeld(KeyEvent e)
    {
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

}
