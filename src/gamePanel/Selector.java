package gamePanel;

import Events.MyEvents;
import core.Core;
import map.building.Building;
import map.building.BuildingSelectEvent;
import map.building.BuildingType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by sarb on 7/14/17.
 */
public class Selector extends JLabel implements MouseListener, MouseMotionListener
{
    private Core core;

    private Point startPoint;
    private Rectangle rectangle;

    public Selector(Core core)
    {
        this.core = core;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        startPoint = e.getPoint();
        int x = e.getX() / core.getGameFrame().getGamePanel().getTileSize();
        int y = (e.getY() * 2 * core.getGameFrame().getGamePanel().getCotang()) / core.getGameFrame().getGamePanel().getTileSize();

        int xtile = core.getGameFrame().getGamePanel().getxRoot() + x;
        int ytile = core.getGameFrame().getGamePanel().getyRoot() + y;
        if (SwingUtilities.isLeftMouseButton(e) &&core.getMap().getTile(xtile,ytile).getFiller() instanceof Building && ((Building) core.getMap().getTile(xtile,ytile).getFiller()).getBuildingType() == BuildingType.BUILDING1 ){
            core.getMap().dispatchEvent(new BuildingSelectEvent(this, MyEvents.BUILDING1_SELECT,xtile,ytile));
    }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        rectangle = null;
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        rectangle = new Rectangle((int)Math.min(startPoint.getX(),e.getPoint().getX()), (int)Math.min(startPoint.getY(),e.getPoint().getY()),(int)Math.abs(startPoint.getX() - e.getPoint().getX()) , (int)Math.abs(startPoint.getY()- e.getPoint().getY()));
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }

    public Rectangle getRectangle()
    {
        return rectangle;
    }
}
