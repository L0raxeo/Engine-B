package gameEngine.display;

import com.sampleGame.Reference;

import javax.swing.*;
import java.awt.*;

public class Display
{

    private JFrame frame;
    private Canvas canvas;

    private final String title;

    /**
     * Holds the width and the height
     * of Display
     */
    private final Dimension size;

    public Display(String title, int width, int height)
    {
        this.title = title;
        size = new Dimension(width, height);

        createDisplay();
    }

    /**
     * Creates the Display:
     * - Creates JFrame and sets attributes according to Reference file
     * - Creates Canvas (where the game draws' graphics)
     * - Adds/attaches the canvas to the JFrame
     */
    private void createDisplay()
    {
        frame = new JFrame(title);
        frame.setSize(size);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(Reference.RESIZABLE);
        frame.setLocationRelativeTo(Reference.LOCATION);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(size);
        canvas.setMaximumSize(size);
        canvas.setMinimumSize(size);
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();

        System.out.println("[System]: initialization/INFO - Successfully created display (Display)");
    }

    public Canvas getCanvas()
    {
        return canvas;
    }

    public JFrame getFrame()
    {
        return frame;
    }

}
