package gameEngine.utils;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class FontLoader
{

    /**
     *
     * @param path is the specific path to the file
     * @param size specifies the size of the font
     *             since the font system is unable
     *             to change the font size after it
     *             has been loaded
     * @return
     * Returns font with attributes specified {path, size}
     */
    public static Font loadFont(String path, float size)
    {
        try
        {
            return Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream(path))).deriveFont(Font.PLAIN, size);
        }
        catch (FontFormatException | IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

}
