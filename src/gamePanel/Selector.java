package gamePanel;

import core.Core;

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
