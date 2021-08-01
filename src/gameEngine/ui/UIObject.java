package gameEngine.ui;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UIObject
{

    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;
    protected  boolean hovering;

    /**
     *
     * @param x of UIObject starting in the top left corner
     * @param y of UIObject starting in the top left corner
     * @param width of UIObject in pixels (west to east)
     * @param height of UIObject in pixels (north to south)
     */
    public UIObject(float x, float y, int width, int height)
    {
        this.x = x;
        this.width = width;
        this.height = height;

        this.bounds = new Rectangle((int) x, (int) y, width, height);
    }

    /**
     * Used to update object's variables
     * and attributes
     */
    public abstract void tick();

    /**
     *
     * @param g allows to draw the graphics of the components
     *          after it has been updated via the tick() method
     */
    public abstract void render(Graphics g);

    public abstract void onPress();

    public abstract void onRelease();

    /**
     * @param e represents mouse event
     *          used to pass along the
     *          coordinates of cursor
     */
    public void onMouseMove(MouseEvent e)
    {
        hovering = bounds.contains(e.getX(), e.getY());
    }

    public void onMouseEnter(MouseEvent e)
    {
        if (hovering)
            onPress();
    }

    public void onMousePress(MouseEvent e)
    {
        if (hovering)
            onPress();
    }

    public void onMouseRelease(MouseEvent e)
    {
        if (hovering)
            onRelease();
    }

    /*
     * Getters for global UIObject attributes
     */

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public boolean isHovering()
    {
        return hovering;
    }

    /*
     * Setters for global UIObject attributes
     */

    public void setX(float x)
    {
        this.x = x;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setHovering(boolean hovering)
    {
        this.hovering = hovering;
    }

}
