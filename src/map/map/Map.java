package map.map;

import Events.MyEvents;
import building_resource_panels.WorkerPanel;
import core.Core;
import interFaces.Mobile;
import interFaces.Observable;
import map.building.Building;
import map.building.BuildingType;
import map.resource.Resource;
import map.resource.ResourceType;
import map.terrain.TerrainType;
import map.terrain.Tile;

import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.io.Serializable;
import java.util.Vector;

/**
 * Created by sarb on 5/29/17.
 */

public class Map extends JLabel implements Serializable
{
    private Core core;

    private int widthTiles;
    private int heightTiles;

    private Tile tiles[][];
    private Vector<Mobile> mobiles;
    private Vector<Observable> observables;

    public Map(Core core, int widthTiles, int heightTiles)
    {
        this.core = core;

        this.widthTiles = widthTiles;
        this.heightTiles = heightTiles;

        mobiles = new Vector<>();
        observables = new Vector<>();

        tiles = new Tile[widthTiles][heightTiles];
        for (int i = 0; i < widthTiles; i++)
            for (int j = 0; j < heightTiles; j++)
                tiles[i][j] = new Tile(core,TerrainType.GRASS,i,j);

        updateAll();
    }

    public void updateAll()
    {
        for (int i = 0; i < widthTiles; i++)
            for (int j = 0; j < heightTiles; j++)
                tiles[i][j].update();
    }

    public void replace(Map newMap)
    {
        this.tiles = newMap.getTiles();
        this.widthTiles = newMap.getWidthTiles();
        this.heightTiles = newMap.getHeightTiles();
    }

    public void addMobile(Mobile mobile)
    {
        mobiles.add(mobile);
    }

    @Override
    protected synchronized void processComponentEvent(ComponentEvent e)
    {
        super.processComponentEvent(e);

        switch (e.getID())
        {
            case MyEvents.LOAD:
                for (int i = 0 ; i < widthTiles ; i ++) {
                    for (int j = 0; j < heightTiles; j++) {
                        tiles[i][j] = new Tile(core, (TerrainType.getTerrain(core.getSaveAndLoad().getMapEditorSave().terrainTypes[i][j])), i, j);
                        if(core.getSaveAndLoad().getMapEditorSave().buildingTypes[i][j] != 0)
                            tiles[i][j].setFiller(new Building(core,BuildingType.getType(core.getSaveAndLoad().getMapEditorSave().buildingTypes[i][j]),i,j));
                        if(core.getSaveAndLoad().getMapEditorSave().resourceTypes[i][j] != 0)
                            tiles[i][j].setFiller(new Resource(core,ResourceType.getType(core.getSaveAndLoad().getMapEditorSave().resourceTypes[i][j]),i,j));
                    }
                }
                    break;
            case MyEvents.BUILDING1_SELECT:
                WorkerPanel workerPanel = new WorkerPanel(350,100,core.getGameFrame().getGamePanel().getxRoot(),core.getGameFrame().getGamePanel().getyRoot(),1000,3000,"WarHouse",core);
                core.getGameFrame().add(workerPanel);
                break;
                case MyEvents.UPDATE:
                    updateAll();
                    break;
            default:
                System.out.println( "Map get wrong id" );
        }
    }

    public Vector<Mobile> getMobiles()
    {
        return mobiles;
    }

    public int getWidthTiles()
    {
        return widthTiles;
    }

    public int getHeightTiles()
    {
        return heightTiles;
    }

    public Tile getTile(int x, int y)
    {
        return tiles[x][y];
    }

    public Tile[][] getTiles()
    {
        return tiles;
    }
}
