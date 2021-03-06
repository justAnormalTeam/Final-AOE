package core;

import gameFrame.GameFrame;
import map.map.Map;
import saving.SaveAndLoad;

import javax.swing.*;

/**
 * Created by sarb on 7/13/17.
 */
public class Core extends JLabel
{
    private Map map;
    private GameFrame gameFrame;
    private SaveAndLoad saveAndLoad;
    private boolean coordinated = true;


    public Core()
    {
        map = new Map(this,50,100);
        gameFrame = new GameFrame(this,"AOE",1000,600);
        saveAndLoad = new SaveAndLoad(this);
    }

    public boolean isCoordinated()
    {
        return coordinated;
    }

    public static void main(String[] args)
    {
        new Core();
    }

    public GameFrame getGameFrame()
    {
        return gameFrame;
    }

    public Map getMap()
    {
        return map;
    }

    public SaveAndLoad getSaveAndLoad() {
        return saveAndLoad;
    }
}
