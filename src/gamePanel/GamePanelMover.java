package gamePanel;

import Events.MyEvents;
import core.Core;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by sarb on 7/13/17.
 */
public class GamePanelMover extends JLabel implements KeyListener,MouseMotionListener,MouseWheelListener
{
    private Core core;

    public GamePanelMover(Core core)
    {
        this.core = core;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if ( core.getGameFrame().getGamePanel().getyRoot() > 1 )
                    core.getGameFrame().getGamePanel().dispatchEvent(new ComponentEvent(this, MyEvents.CAMERA_UP));
                break;
            case KeyEvent.VK_DOWN:
                if ( core.getGameFrame().getGamePanel().getyRoot() < core.getMap().getHeightTiles() - core.getGameFrame().getGamePanel().getVerticalTiles())
                    core.getGameFrame().getGamePanel().dispatchEvent(new ComponentEvent(this, MyEvents.CAMERA_DOWN));
                break;
            case KeyEvent.VK_RIGHT:
                if( core.getGameFrame().getGamePanel().getxRoot() < core.getMap().getWidthTiles() - core.getGameFrame().getGamePanel().getHorizontalTiles())
                    core.getGameFrame().getGamePanel().dispatchEvent(new ComponentEvent(this, MyEvents.CAMERA_RIGHT));
                break;
            case KeyEvent.VK_LEFT:
                if ( core.getGameFrame().getGamePanel().getxRoot() > 1 )
                    core.getGameFrame().getGamePanel().dispatchEvent(new ComponentEvent(this, MyEvents.CAMERA_LEFT));
                break;
        }

        core.getGameFrame().getGamePanel().repaint();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {

    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        if (e.getModifiers() == 1)
            return;

        core.getGameFrame().getGamePanel().dispatchEvent(new ChangeTileSizeEvent(this,MyEvents.CHANGE_TILE_SIZE,(int) e.getPreciseWheelRotation()*4));
    }
}
