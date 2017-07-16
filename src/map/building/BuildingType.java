package map.building;

import map.terrain.TerrainType;

import java.awt.*;

/**
 * Created by bobvv on 7/9/17.
 */
public enum BuildingType
{
    BUILDING1(new Color(0,139, 120), TerrainType.GRASS, 1),
    BUILDING2(new Color(51, 50, 41), TerrainType.SAND, 2),
    BUILDING3(new Color(31, 50, 41), TerrainType.MOUNTAIN, 3),
    BUILDING4(new Color(21, 50, 41), TerrainType.GRASS, 4),
    BUILDING5(new Color(11, 50, 41), TerrainType.GRASS, 5),
    BUILDING6(new Color(85, 50, 41), TerrainType.GRASS, 6);

    private Color color;
    private TerrainType availableTerrain;


    private int index;


    BuildingType(Color color, TerrainType terrainType, int index)
    {
        this.color = color;
        this.availableTerrain = terrainType;
        this.index = index;
    }

    public static BuildingType getType(int number)
    {
        switch (number){
            case 1:
                return BUILDING1;
            case 2:
                return BUILDING2;
            case 3:
                return BUILDING3;
            case 4:
                return BUILDING4;
            case 5:
                return BUILDING5;
            case 6:
                return BUILDING6;
                default:
                    return BUILDING1;
        }
    }

    public int getIndex() {
        return index;
    }

    public TerrainType getAvailableTerrain() {
        return availableTerrain;
    }

    public Color getColor() {
        return color;
    }
}
