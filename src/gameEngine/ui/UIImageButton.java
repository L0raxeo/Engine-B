package gameEngine.ui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject
{

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

    @Override
    public void onMouseMove(MouseEvent e)
    {
        super.onMouseMove(e);
    }

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
