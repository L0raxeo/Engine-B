package gameEngine.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ImageLoader
{

    /**
     *
     * @param path is the specific path to the .png file
     * @return
     * Returns loaded image with attribute {path}
     */
    public static BufferedImage loadImage(String path)
    {
        try
        {
            return ImageIO.read(Objects.requireNonNull(ImageLoader.class.getResource(path)));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

}
