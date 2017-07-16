package saving;

import java.io.Serializable;

/**
 * Created by bobvv on 7/13/17.
 */
public class MapEditorSave implements Serializable {
    public int [][] terrainTypes ;

    public int [][] resourceTypes ;

    public int [][] buildingTypes ;
    public MapEditorSave(int width , int height) {
        terrainTypes = new int[width][height];
        resourceTypes = new int[width][height];
        buildingTypes = new int[width][height];
    }



    public void setTerrainTypes(int x,int y,int i) {
        this.terrainTypes[x][y] = i;
    }
    public void setResourceTypes(int x,int y,int i) {
        this.resourceTypes[x][y] = i;
    }
    public void setBuildingTypes(int x,int y,int i) {
        this.buildingTypes[x][y] = i;
    }
}
