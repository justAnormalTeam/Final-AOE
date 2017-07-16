package gamePanel;

import Events.MyEvents;
import core.Core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;

/**
 * Created by sarb on 7/13/17.
 */
public class GamePanel extends JPanel
{
    private Core core;

    private GamePanelMover gamePanelMover;
    private Selector selector;

    private int width;
    private int height;

    private int xRoot;
    private int yRoot;
    private int tileSize;
    private int TILE_MIN_SIZE;
    private int TILE_MAX_SIZE;

    private int cotang;

    {
        xRoot = 1;
        yRoot = 1;
        tileSize = 200;
        cotang = 2;
        TILE_MAX_SIZE = 200;
        TILE_MIN_SIZE = 50;
    }
    private Timer timer;

    {
        timer = new Timer(30, e-> repaint());
        timer.start();
    }
    public GamePanel(Core core, int width, int height)
    {
        this.core = core;

        this.width = width;
        this.height = height;
        setSize(width,height);

        gamePanelMover = new GamePanelMover(core);
        addMouseWheelListener(gamePanelMover);
    }

    @Override
    protected synchronized void processComponentEvent(ComponentEvent e)
    {
        super.processComponentEvent(e);

        switch (e.getID())
        {
            case MyEvents.CAMERA_DOWN:
                yRoot++;
                break;

            case MyEvents.CAMERA_LEFT:
                xRoot--;
                break;

            case MyEvents.CAMERA_RIGHT:
                xRoot++;
                break;

            case MyEvents.CAMERA_UP:
                yRoot--;
                break;

            case MyEvents.CHANGE_TILE_SIZE:
                int newSize = tileSize - ((ChangeTileSizeEvent)e).getChangeAmount();
                if( newSize <= TILE_MIN_SIZE )
                    tileSize = TILE_MIN_SIZE;
                else if( newSize >= TILE_MAX_SIZE)
                    tileSize = TILE_MAX_SIZE;
                else
                    tileSize = newSize;
                repaint();
                break;

            default:
                System.out.println( "GamePanel get wrong id" );
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        for (int j = 0; j < core.getMap().getHeightTiles(); j++)
            for (int i = 0; i < core.getMap().getWidthTiles(); i++)
                if (i > xRoot - 2 && j > yRoot - 2 && i < xRoot + getHorizontalTiles()
                        && j < yRoot + getVerticalTiles()) {
                    core.getMap().getTile(i, j).draw(g2, xRoot, yRoot, tileSize, cotang);
                    if( core.getMap().getTile(i,j).getFiller()!= null) {
                        int relX = ( (i - xRoot) * tileSize ) + tileSize/2  + (j%2)*tileSize/2 ;
                        int relY = ((j - yRoot) * tileSize) / (2* cotang) - (int)((tileSize/2)*core.getMap().getTile(i,j).getTerrainType().getHeight());
                        g2.drawImage(core.getMap().getTile(i, j).getFiller().getImageIcon().getImage(), relX - tileSize / 2, relY - tileSize / 2, tileSize, tileSize, null);
                    }
                }

        if(core.getGameFrame().getSelector().getRectangle() != null)
        {
            g2.setColor(Color.red);
            g2.draw(core.getGameFrame().getSelector().getRectangle());
        }
    }


    public int getVSize()
    {
        return tileSize/(2*cotang);
    }

    public int getHSize()
    {
        return tileSize;
    }

    public int getVerticalTiles()
    {
        return getHeight()/ getVSize() +1;
    }

    public int getHorizontalTiles()
    {
        return getWidth()/ getHSize() +1;
    }

    public GamePanelMover getGamePanelMover()
    {
        return gamePanelMover;
    }

    public int getxRoot()
    {
        return xRoot;
    }

    public int getyRoot()
    {
        return yRoot;
    }

    public void setxRoot(int xRoot)
    {
        this.xRoot = xRoot;
    }

    public void setyRoot(int yRoot)
    {
        this.yRoot = yRoot;
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getCotang() {
        return cotang;
    }
}
