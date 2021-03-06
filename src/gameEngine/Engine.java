package gameEngine;

import com.sampleGame.Reference;
import com.sampleGame.init.Fonts;
import com.sampleGame.init.Scenes;
import com.sampleGame.init.Sounds;
import com.sampleGame.init.Textures;
import gameEngine.display.Display;
import gameEngine.entities.EntityManager;
import gameEngine.input.KeyManager;
import gameEngine.input.MouseManager;
import gameEngine.scenes.SceneManager;
import gameEngine.ui.UIManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * imagine not being able to setup github correctly
 */

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

    public static KeyManager keyManager;
    public static MouseManager mouseManager;

    public static EntityManager entityManager;
    public static UIManager uiManager;

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
     * Pre-Initialization
     *
     * Usually used to initialize assets and input managers
     */
    private void preInit()
    {
        Textures.init();
        Fonts.init();
        Sounds.init();

        keyManager = new KeyManager();
        mouseManager = new MouseManager();

        System.out.println("[System]: initialization/INFO - Successfully pre-initialized game (Game)");
    }

    /**
     * Initialization
     *
     * Used to initialize the Display (Application Window)
     * and also add listeners (KeyListener, MouseListener... etc)
     */
    private void init()
    {
        display = new Display(title, width, height);

        display.getFrame().addKeyListener(keyManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        System.out.println("[System]: initialization/INFO - Successfully initialize game (Game)");
    }

    /**
     * Post-Initialization
     *
     * Used to initialize managers (EntityManager, UIManager... etc)
     * Also used to initialize states
     */
    private void postInit()
    {
        entityManager = new EntityManager();
        uiManager = new UIManager();

        Scenes.init();

        System.out.println("[System]: initialization/INFO - Successfully post-initialized game (Game)");
        System.out.println("[System]: initialization/INFO - Fully initialized system. Any output from now on will not be part of the system, unless it's an error");
        System.out.println("  _____             _              ____  ");
        System.out.println(" | ____|_ __   __ _(_)_ __   ___  | __ ) ");
        System.out.println(" |  _| | '_ \\ / _` | | '_ \\ / _ \\ |  _ \\ ");
        System.out.println(" | |___| | | | (_| | | | | |  __/ | |_) |");
        System.out.println(" |_____|_| |_|\\__, |_|_| |_|\\___| |____/ ");
        System.out.println("              |___/                      ");
    }

    /**
     * Ticks key manager and mouse manager
     *
     * If there is a current scene loaded,
     * it will tick it
     */
    private void tick()
    {
        keyManager.tick();
        mouseManager.tick();

        if (SceneManager.getCurrentScene() != null)
            SceneManager.getCurrentScene().tick();
    }

    /**
     * render() renders the current scene to the Canvas
     *
     * - Uses buffer strategy (3 buffers)
     *
     * Process:
     * 1. sets buffer strategy to canvas' buffer strategy
     * 2. checks if the buffer strategy is null after attempting to get the canvas buffer strategy
     * 3. if the buffer strategy is null, it creates one with 3 buffers
     * 4. sets the Graphics (g) to the drawn graphics on buffer strategy
     * 5. clears screen for next frame
     * 6. draws scene if there is an active scene
     * 7. Ends the drawing: shows buffers, and disposes graphics
     */
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

        if (SceneManager.getCurrentScene() != null)
            SceneManager.getCurrentScene().render(g);

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

    /**
     * Because the engine is running on a thread, the
     * start and stop method have to be synchronized
     */
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
