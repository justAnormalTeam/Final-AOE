package gameFrame;

import com.apple.eawt.Application;
import com.apple.eawt.FullScreenUtilities;
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
        setFullScreen(this);

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

    private void setFullScreen(JFrame myFrame)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        this.setSize(new Dimension(width,height));
        FullScreenUtilities.setWindowCanFullScreen(myFrame,true);
        Application.getApplication().requestToggleFullScreen(myFrame);
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
