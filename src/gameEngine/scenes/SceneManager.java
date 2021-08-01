package gameEngine.scenes;

import gameEngine.ui.UIManager;

public class SceneManager
{

    /*
     * Active scene
     */
    private static Scene currentScene = null;

    /**
     * @return current scene since the static object is private
     */
    public static Scene getCurrentScene()
    {
        return currentScene;
    }

    /**
     * Sets the scene by setting the current scene
     * initializes that scene
     * clears previous UI Objects
     *
     * @param scene will have the currentScene be set to it
     */
    public static void setScene(Scene scene)
    {
        UIManager.getUIObjects().clear();
        currentScene = scene;
        currentScene.init();
        currentScene.addUIObjects();
    }

}
