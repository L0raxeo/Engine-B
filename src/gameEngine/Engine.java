package gameEngine;

import com.sampleGame.Reference;
import com.sampleGame.init.Fonts;
import com.sampleGame.init.Scenes;
import com.sampleGame.init.Sounds;
import com.sampleGame.init.Textures;
import gameEngine.display.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Engine implements Runnable
{

    /**
     * The Display is the application window or the GUI that the
     * user will be seeing while the game is running
     */
    public Display display;

    public final String title;
    public final int width;
    public final int height;

    private Thread thread;
    private boolean running = false;

    /**
     * @param title of Display
     * @param width of Display
     * @param height of Display
     */
    public Engine(String title, int width, int height)
    {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    /*
     * The initialization sequence is split into three parts:
     * 1. preInit()
     * 2. init()
     * 3. postInit()
     *
     * this is used to maximize efficiency when initializing
     * assets and other core components
     */

    /**
     * Pre-initialization
     *
     * usually used to initialize textures
     */
    private void preInit()
    {
        Textures.init();
        Fonts.init();
        Sounds.init();

        System.out.println("[System]: initialization/INFO - Successfully pre-initialized game (Game)");
    }

    /**
     *
     */
    private void init()
    {
        display = new Display(title, width, height);

        System.out.println("[System]: initialization/INFO - Successfully initialize game (Game)");
    }

    private void postInit()
    {
        Scenes.init();

        System.out.println("[System]: initialization/INFO - Successfully post-initialized game (Game)");
    }

    private void tick()
    {

    }

    private void render()
    {
        BufferStrategy bs = display.getCanvas().getBufferStrategy();

        if (bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        // Clear Screen
        g.clearRect(0, 0, width, height);
        // Draw Here



        // End Drawing
        bs.show();
        g.dispose();
    }

    /**
     * Handles the thread, ticking, and rendering of the game, as well as invoking the initialization sequences.
     *
     * manages the maximum FPS which is determined in Reference file
     */
    @Override
    public void run()
    {
        preInit();
        init();
        postInit();

        int fps = Reference.fps;
        double timePerTick = 1000000000f / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running)
        {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1)
            {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000)
            {
                display.getFrame().setTitle(title + " " + Reference.VERSION + " | FPS: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public synchronized void start()
    {
        if (running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop()
    {
        if (!running) return;
        running = false;

        try
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
