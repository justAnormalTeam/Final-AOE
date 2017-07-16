package map.resource;

import map.terrain.TerrainType;

import java.awt.*;
import java.util.Random;

/**
 * Created by sarb on 6/6/17.
 */
public enum ResourceType
{
    TREE(new Color(34,139,34), TerrainType.GRASS, 2, ".png", 10000, ResourceMode.lumber),
    PALM(new Color(51,25,0), TerrainType.SAND, 1, ".png", 3000, ResourceMode.lumber),
    DEEP_FISH(new Color(255,0,255), TerrainType.DEEP_WATER, 1, ".gif", 10000, ResourceMode.meat),
    SHALLOW_FISH(new Color(255,102,102), TerrainType.SHALLOW_WATER, 1, ".gif", 20000, ResourceMode.meat),
    GOLD(new Color(255,255,0), TerrainType.PEAK, 1, ".png", 100000, ResourceMode.gold),
    SILVER(new Color(160,160,160), TerrainType.MOUNTAIN, 1, ".png", 100000, ResourceMode.silver);

    private Color color;
    private TerrainType availableTerrain;
    private int differentType;
    private String extension;
    private int amount;
    private ResourceMode mode;

    ResourceType(Color color, TerrainType terrainType, int differentType, String extension, int amount, ResourceMode mode)
    {
        this.color = color;
        this.availableTerrain = terrainType;
        this.differentType = differentType;
        this.extension = extension;
        Random random = new Random(System.currentTimeMillis());
        amount= (int)( (random.nextDouble()+1) * amount );
        this.amount = amount;
        this.mode = mode;
    }

    public void gatherResource(int decreaseAmount){
        // we should pass something to this method and add the gathered resource to that player.
        amount -= decreaseAmount;
    }

    // getters and setters:
    public int getDifferentType()
    {
        return differentType;
    }

    public TerrainType getAvailableTerrain()
    {
        return availableTerrain;
    }

    public Color getColor()
    {
        return color;
    }

    public String getExtension()
    {
        return extension;
    }
}
