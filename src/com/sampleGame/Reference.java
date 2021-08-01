package com.sampleGame;

import java.awt.*;

public class Reference
{

    /*
     * ----- DO NOT DELETE FILE -----
     * ----- DO NOT DELETE FILE -----
     */

    /*
     * ----- Game Information -----
     */

    /**
     * Sample Game ID for "Test Game" - GAMEID = "testgame"
     */
    public static final String GAMEID = "sampleid";
    public static final String NAME = "Sample Name";
    public static final String VERSION = "1.0";

    /*
     * ----- Display Information -----
     */

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 700;

    /**
     * Determines whether the user has the
     * ability to resize the application window (display)
     */
    public static final boolean RESIZABLE = false;

    /**
     * Determines the location of the
     * application window (display)
     * when the game is first launched
     *
     * NULL: by setting the location to
     * null, you are centering the
     * application window (display)
     */
    public static final Component LOCATION = null;

    /**
     * FPS cap- maximum FPS that the game will run
     *
     * Can be referenced and changed statically:
     * - Get: Reference.fps (returns maximum FPS as int)
     * - Set: Reference.fps = var (substitute var for an int)
     */
    public static int fps = 60;

}
