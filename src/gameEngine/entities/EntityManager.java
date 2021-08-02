package gameEngine.entities;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

public class EntityManager
{

    public static ArrayList<Entity> entities = new ArrayList<>();
    private final Comparator<Entity> renderSorter = Comparator.comparingInt(a -> (int) a.getY() + a.getHeight());

    public void tick()
    {
        ListIterator<Entity> it = entities.listIterator();

        while (it.hasNext())
        {
            try
            {
                Entity e = it.next();
                e.tick();

                if (!e.isActive())
                    it.remove();
            }
            catch (Exception e)
            {
                return;
            }
        }

        entities.sort(renderSorter);
    }

    public void render(Graphics g)
    {
        for (Entity e : entities)
            e.render(g);
    }

}
