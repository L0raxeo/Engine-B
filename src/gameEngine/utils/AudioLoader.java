package gameEngine.utils;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Objects;

public class AudioLoader
{

    /**
     * plays sound
     * @param path of .wav file (WAVE file)
     */
    public static void playSound(String path)
    {
        try
        {
            AudioInputStream audioInputStream =
                    AudioSystem.getAudioInputStream(new BufferedInputStream(Objects.requireNonNull(AudioLoader.class.getClassLoader().getResourceAsStream(path))));

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch (LineUnavailableException | IOException | UnsupportedAudioFileException evt)
        {
            evt.printStackTrace();
        }
    }

}
