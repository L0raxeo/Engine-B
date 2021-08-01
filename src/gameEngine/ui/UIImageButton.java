package gameEngine.ui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject
{

    /**
     * The BufferedImage[] (array) stores two frames:
     * images[0] = idle texture
     * images[1] = hovering texture
     *
     * in other words:
     *
     * Index 1: idle texture
     * Index 2: hovering texture
     *
     * However, hovering in this case means selected
     */
    private final BufferedImage[] images;
    private final ClickListener clicker;

    private final Font font;
    private final String text;

    private final boolean clickable;

    public UIImageButton(float x, float y, int width, int height, String text, Font font,
                         BufferedImage[] images, boolean clickable, ClickListener clicker)
    {
        super (x, y, width, height);

        this.images = images;
        this.clicker = clicker;

        this.font = font;
        this.text = text;

        this.clickable = clickable;
    }

    @Override
    public void tick() {}

    /**
     * the rendering method doubles as a method that renders
     * to the screen while also handling the button's current
     * state (hovering or not-hovering). If the cursor is
     * hovering over the button, then it draws the second frame
     * in the images array.
     *
     * @param g allows to draw the graphics of the components
     */
    public void render(Graphics g)
    {
        if (hovering)
        {
            g.drawImage(images[1], (int) x, (int) y, width, height, null);
            UIText.drawString(g, text, (int) x + (width / 2), (int) y + (height / 2), true, Color.black, font);
        }
        else
        {
            g.drawImage(images[0], (int) x, (int) y, width, height, null);
            UIText.drawString(g, text, (int) x + (width / 2), (int) y + (height / 2) - 9, true, Color.black, font);
        }
    }

    /**
     * if you don't know what "super" does in this context, it is basically
     * saying that the function of this method has the same function as the
     * super class' onMouseMove() method. To see it, just go to UIObject, &
     * look for the onMouseMove() method.
     *
     * @param e represents mouse event
     *          used to pass along the
     */
    @Override
    public void onMouseMove(MouseEvent e)
    {
        super.onMouseMove(e);
    }

    /**
     * When the UIImageButton is pressed,
     * the button checks whether it is clickable
     * or not (which is determined when the button
     * is first created). If it is, then it clicks
     * the button. The "clickable" boolean is
     * useful when you are in a menu and there is
     * a button that has a function that has not
     * been unlocked, or one that is not accessible
     */
    @Override
    public void onPress()
    {
        if (clickable)
            clicker.onClick();
    }

    @Override
    public void onRelease()
    {

    }

}
