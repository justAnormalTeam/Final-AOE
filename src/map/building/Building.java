package map.building;

import Utils.ImageReader;
import core.Core;
import interFaces.Observable;
import map.terrain.TerrainType;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

/**
 * Created by bobvv on 7/9/17.
 */
public class Building extends JLabel implements Serializable, Observable
{
    Core core;

    private BuildingType buildingType;
    private ImageIcon imageIcon;
    private int x,y;

    public Building(Core core,BuildingType buildingType,int x,int y)
    {
        this.core = core;
        this.buildingType = buildingType;
        this.x = x;
        this.y = y;
        this.imageIcon = ImageReader.createImage("/Assets/buildings/" + buildingType.toString().toLowerCase() + ".png");
    }

    public Shape getOval(int xRoot, int yRoot, int tileSize, int cotang)
    {
        int relX = ( (x - xRoot) * tileSize ) + tileSize/2  + (y%2)*tileSize/2 ;
        int relY = (y - yRoot) * tileSize / (2* cotang);
        return new Ellipse2D.Double(relX - tileSize/7, relY + tileSize/(4*cotang), tileSize/4,tileSize/4);
    }

    public BuildingType getBuildingType()
    {
        return buildingType;
    }

    public boolean isAvailableTerrain(TerrainType terrain)
    {
        return terrain == buildingType.getAvailableTerrain();
    }

    @Override
    public ImageIcon getImageIcon() {
        return imageIcon;
    }
}
