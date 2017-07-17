package core;

import gameFrame.GameFrame;
import gamePanel.GamePanel;
import gamePanel.GamePanelMover;
import map.map.Map;
import menuScreen.WellcomeFrame;

import javax.swing.*;

/**
 * Created by sarb on 7/13/17.
 */
public class Core extends JLabel
{
    private Map map;
    private GameFrame gameFrame;
    private boolean coordinated = true;
    private WellcomeFrame wellcomeFrame;

    public Core()
    {
        map = new Map(this,50,100);
        this.wellcomeFrame = new WellcomeFrame(this);
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
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
}
