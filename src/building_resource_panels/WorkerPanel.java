package building_resource_panels;

import Utils.ImageReader;
import core.Core;

import javax.swing.*;
import java.awt.*;

public class WorkerPanel extends BasicPanel
{

    private int numberOfButtons = 2;
    private static String[] buttonFunctions = {"Builder","Soldier"};
    private JButton[] buttons;

    private int x;
    private int y;

    private Core core;


    public WorkerPanel(int width, int heigth, int xRoot, int yRoot, int hitpoints, int maxHP, String name, Core core)
    {
        super(width, heigth, xRoot, yRoot, hitpoints, maxHP, name);
        this.core = core;

        buttons = new JButton[2];
        makeButtons();

        this.x = x;
        this.y = y;
    }


    private int root =0;
    private void makeButtons()
    {
        int buttonWidth = getWidth()/6;
        int buttonHeight = getHeight()/6;
        int begin = 70;

        for(int i=0;i<numberOfButtons;i++)
        {
            buttons[i] = new JButton(buttonFunctions[i]);
            buttons[i].setSize(buttonWidth, buttonHeight);
            buttons[i].setLocation(begin + i*getWidth()/6,getHeigth()/2);
            this.add(buttons[i]);
        }
        buttons[0].addActionListener(e->
        {
            System.out.println("salam1");
        });
        buttons[1].addActionListener(e->
        {
            System.out.println("salam2");
        });
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(ImageReader.createImage("/Assets/panel.png").getImage(),getX(),getY(),getWidth(),getHeight(),null);
    }
}
