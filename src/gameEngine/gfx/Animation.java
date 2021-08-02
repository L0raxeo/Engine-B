package gameEngine.gfx;

import java.awt.image.BufferedImage;

public class Animation
{

    /**
     * Speed of the animation:
     *
     * the speed integer is the amount of time
     * in between each frame.
     *
     * Higher value speed = slower animation
     * Lower value speed = faster animation
     *
     * (I know that doesn't make much sense but what are you going to do buddy. who cares. war crime.)
     */
    private final int speed;
    private int index;
    private long lastTime, timer;

    /**
     * All frames in animation
     */
    private final BufferedImage[] frames;

    /**
     * An animation is treated as an object that is part of a class:
     * ---------------------------------------------------------------
     * Ex.
     * private Animation sample_anim = new Animation(50, frames);
     * ---------------------------------------------------------------
     *
     * @param speed specifies speed (view variable above for more information)
     * @param frames each individual frame as a BufferedImage stored in an array
     */
    public Animation(int speed, BufferedImage[] frames)
    {
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    /**
     * When an animation is going to be rendered,
     * the tick method of that object (which could be an
     * entity or a scene etc...)
     * must invoke the animation's tick method
     *
     * This method must be ticked as such:
     * ---------------------------------------
     * Ex.
     * sample_anim.tick();
     * ---------------------------------------
     */
    public void tick()
    {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (timer > speed)
        {
            index++;
            timer = 0;
            if (index >= frames.length)
                index = 0;
        }
    }

    /**
     * The current frame (getCurrentFrame) is the BufferedImage
     * that the renderer should be rendering for an animation.
     * -----------------------------------------------------------------------
     * Ex.
     * g.drawImage(Animation.getCurrentFrame(), x, y, width, height, null);
     * -----------------------------------------------------------------------
     * @return the current frame that the renderer should be drawing
     */
    public BufferedImage getCurrentFrame()
    {
        return frames[index];
    }

}
