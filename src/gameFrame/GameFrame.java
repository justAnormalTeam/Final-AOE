package gameFrame;

import core.Core;
import gamePanel.GamePanel;
import gamePanel.Selector;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sarb on 7/13/17.
 */
public class GameFrame extends JFrame
{
    private Core core;

    private GamePanel gamePanel;
    private Selector selector;

    public GameFrame(Core core, String title, int width, int height) throws HeadlessException
    {
        super(title);

        this.core = core;

        this.gamePanel = new GamePanel(core, getWidth(), getHeight());
        addKeyListener(gamePanel.getGamePanelMover());
        add(gamePanel);

        selector = new Selector(core);
        gamePanel.addMouseListener(selector);
        gamePanel.addMouseMotionListener(selector);

        setSize(width,height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public Selector getSelector()
    {
        return selector;
    }

    public GamePanel getGamePanel()
    {
        return gamePanel;
    }
}
