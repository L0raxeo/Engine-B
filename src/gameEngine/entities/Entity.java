package gameEngine.entities;

import java.awt.*;

public abstract class Entity
{

    protected String name;
    protected String unlocalizedName;
    protected float x, y;
    protected int width, height;
    protected float xMove, yMove;
    protected Rectangle bounds;
    protected boolean isSolid;

    protected boolean active = true;

    public Entity(String unlocalizedName, String name, float x, float y, int width, int height, boolean isSolid)
    {
        this.unlocalizedName = unlocalizedName;
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isSolid = isSolid;

        this.xMove = 0;
        this.yMove = 0;

        this.bounds = new Rectangle(0, 0, width, height);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    /**
     * Moves object according to speed (xMove = x-speed, yMove = y-speed)
     */
    public void move()
    {
        if (checkEntityCollisions(xMove, 0f)) moveX();
        if (checkEntityCollisions(0f, yMove)) moveY();
    }

    public void destroy()
    {
        active = false;
        onDestroy();
    }

    public void onDestroy()
    {

    }

    /**
     * Entity Collision checks entity collision
     * if the entity is solid as stated through
     * the parameters and initialized in the
     * constructor
     *
     * @param xOffset idk
     * @param yOffset idk
     * @return statement returns whether the
     *         entity has collided with another
     *         entity
     */
    public boolean checkEntityCollisions(float xOffset, float yOffset)
    {
        for (Entity e : EntityManager.entities)
        {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
                return false;
        }

        return true;
    }

    /**
     * @param xOffset idk
     * @param yOffset idk
     * @return the collision bounds considering
     *         coordinates and dimensions
     */
    public Rectangle getCollisionBounds(float xOffset, float yOffset)
    {
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    public void moveX()
    {
        if (xMove > 0)
        {
            int tx = (int) (x + xMove + bounds.x + bounds.width) / 32;

            if (collisionWithTile(tx, (int) (y + bounds.y) / 32) &&
                    collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / 32))
            {
                x += xMove;
            }
            else
            {
                x = tx * 32 - bounds.x - bounds.width - 1;
            }
        }
        else if (xMove < 0)
        {
            int tx = (int) (x + xMove + bounds.x) / 32;

            if (collisionWithTile(tx, (int) (y + bounds.y) / 32) &&
                    collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / 32))
            {
                x += xMove;
            }
            else
            {
                x = tx * 32 + 32 - bounds.x;
            }
        }
    }

    public void moveY()
    {
        if (yMove < 0)
        {
            int ty = (int) (y + yMove + bounds.y) / 32;

            if (collisionWithTile((int) (x + bounds.x) / 32, ty) &&
                    collisionWithTile((int) (x + bounds.x + bounds.width) / 32, ty))
            {
                y += yMove;
            }
            else
            {
                y = ty * 32 + 32 - bounds.y;
            }
        }
        else if (yMove > 0)
        {
            int ty = (int) (y + yMove + bounds.y + bounds.height) / 32;

            if (collisionWithTile((int) (x + bounds.x) / 32, ty) &&
                    collisionWithTile((int) (x + bounds.x + bounds.width) / 32, ty))
            {
                y += yMove;
            }
            else
            {
                y = ty * 32 - bounds.y - bounds.height - 1;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y)
    {
        return true;
    }

    /**
     * Getters
     */

    public int getX()
    {
        return (int) x;
    }

    public int getY()
    {
        return (int) y;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public boolean isSolid()
    {
        return isSolid;
    }

    public float getxMove()
    {
        return xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public boolean isActive()
    {
        return active;
    }

    /**
     * Setters
     */
    public void setSolid(boolean isSolid)
    {
        this.isSolid = isSolid;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

}
