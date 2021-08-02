package gameEngine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{

    private final boolean[] keys;

    /**
     * if you don't know what this is...
     *
     * I'm writing some of the more humorous
     * documentation at 12:31 AM gimme a break;
     *
     * The constructor. If you don't know what a
     * constructor is, then google it lazybones.
     *
     * if you are really still reading this comment:
     * fine. here is what the constructor does.
     * It just initializes the keys boolean array.
     */
    public KeyManager()
    {
        keys = new boolean[1080];
    }

    /**
     * seriously don't worry about this.
     * The KeyManager is the one part of
     * the game engine that I didn't want
     * to spend all my time on, and therefore
     * didn't try very hard to make it look nice.
     */
    public void tick()
    {
        Keys.a = keys[KeyEvent.VK_A];
        Keys.b = keys[KeyEvent.VK_B];
        Keys.c = keys[KeyEvent.VK_C];
        Keys.d = keys[KeyEvent.VK_D];
        Keys.e = keys[KeyEvent.VK_E];
        Keys.f = keys[KeyEvent.VK_F];
        Keys.g = keys[KeyEvent.VK_G];
        Keys.h = keys[KeyEvent.VK_H];
        Keys.i = keys[KeyEvent.VK_I];
        Keys.j = keys[KeyEvent.VK_J];
        Keys.k = keys[KeyEvent.VK_K];
        Keys.l = keys[KeyEvent.VK_L];
        Keys.m = keys[KeyEvent.VK_M];
        Keys.n = keys[KeyEvent.VK_N];
        Keys.o = keys[KeyEvent.VK_O];
        Keys.p = keys[KeyEvent.VK_P];
        Keys.q = keys[KeyEvent.VK_Q];
        Keys.r = keys[KeyEvent.VK_R];
        Keys.s = keys[KeyEvent.VK_S];
        Keys.t = keys[KeyEvent.VK_T];
        Keys.u = keys[KeyEvent.VK_U];
        Keys.v = keys[KeyEvent.VK_V];
        Keys.w = keys[KeyEvent.VK_W];
        Keys.x = keys[KeyEvent.VK_X];
        Keys.y = keys[KeyEvent.VK_Y];
        Keys.z = keys[KeyEvent.VK_Z];

        Keys.f1 = keys[KeyEvent.VK_F1];
        Keys.f2 = keys[KeyEvent.VK_F2];
        Keys.f3 = keys[KeyEvent.VK_F3];
        Keys.f4 = keys[KeyEvent.VK_F4];
        Keys.f5 = keys[KeyEvent.VK_F5];
        Keys.f6 = keys[KeyEvent.VK_F6];
        Keys.f7 = keys[KeyEvent.VK_F7];
        Keys.f8 = keys[KeyEvent.VK_F8];
        Keys.f9 = keys[KeyEvent.VK_F9];
        Keys.f10 = keys[KeyEvent.VK_F10];
        Keys.f11 = keys[KeyEvent.VK_F11];
        Keys.f12 = keys[KeyEvent.VK_F12];

        Keys.escape = keys[KeyEvent.VK_ESCAPE];
        Keys.backspace = keys[KeyEvent.VK_DELETE];
        Keys.tab = keys[KeyEvent.VK_TAB];
        Keys.capslock = keys[KeyEvent.VK_CAPS_LOCK];
        Keys.left_shift = keys[KeyEvent.VK_SHIFT];
        Keys.left_ctrl = keys[KeyEvent.VK_CONTROL];
        Keys.win = keys[KeyEvent.VK_WINDOWS];
        Keys.left_alt = keys[KeyEvent.VK_ALT];
        Keys.right_alt = keys[KeyEvent.VK_ALT];
        Keys.enter = keys[KeyEvent.VK_ENTER];
        Keys.right_shift = keys[KeyEvent.VK_SHIFT];
        Keys.right_ctrl = keys[KeyEvent.VK_CONTROL];

        Keys.backtick = keys[KeyEvent.VK_BACK_QUOTE];
        Keys.minus_sign = keys[KeyEvent.VK_MINUS];
        Keys.equals_sign = keys[KeyEvent.VK_EQUALS];
        Keys.slash = keys[KeyEvent.VK_SLASH];
        Keys.period = keys[KeyEvent.VK_PERIOD];
        Keys.comma = keys[KeyEvent.VK_COMMA];
        Keys.semi_colon = keys[KeyEvent.VK_SEMICOLON];
        Keys.left_square_bracket = keys[KeyEvent.VK_OPEN_BRACKET];
        Keys.right_square_bracket = keys[KeyEvent.VK_CLOSE_BRACKET];
        Keys.backslash = keys[KeyEvent.VK_BACK_SLASH];

        Keys.m_0 = keys[KeyEvent.VK_0];
        Keys.m_1 = keys[KeyEvent.VK_1];
        Keys.m_2 = keys[KeyEvent.VK_2];
        Keys.m_3 = keys[KeyEvent.VK_3];
        Keys.m_4 = keys[KeyEvent.VK_4];
        Keys.m_5 = keys[KeyEvent.VK_5];
        Keys.m_6 = keys[KeyEvent.VK_6];
        Keys.m_7 = keys[KeyEvent.VK_7];
        Keys.m_8 = keys[KeyEvent.VK_8];
        Keys.m_9 = keys[KeyEvent.VK_9];

        Keys.up = keys[KeyEvent.VK_UP];
        Keys.down = keys[KeyEvent.VK_DOWN];
        Keys.left = keys[KeyEvent.VK_LEFT];
        Keys.right = keys[KeyEvent.VK_RIGHT];
    }

    private static boolean hasPressed = false;
    private static boolean hasReleased = false;

    public static boolean onKeyDown(boolean key)
    {
        if (key && !hasPressed)
        {
            hasPressed = true;
            return true;
        }
        else if (!key)
        {
            hasPressed = false;
            return false;
        }
        else
            return false;
    }

    public static boolean onKeyReleased(boolean key)
    {
        if (!key && !hasReleased)
        {
            hasReleased = true;
            return true;
        }
        else if (key)
        {
            hasReleased = false;
            return false;
        }
        else
            return false;
    }

    public static boolean onKeyHeld(boolean key)
    {
        return key;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        keys[e.getKeyCode()] = false;
    }

}
