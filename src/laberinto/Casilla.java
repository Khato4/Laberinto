
package laberinto;

import laberinto.gui.*;


/**
 *
 * @author Claudio
 */
public class Casilla {
    
    public int north; //las casillas son definidas por un codigo de 4 enteros
    public int east;
    public int south;
    public int west;
    public static int dimension = 30;
    
    public Casilla(int north, int east, int south, int west){
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
        
    }
    
    public boolean getNorth(){
        return north == 1;
    }
    
    public boolean getEast(){
        return east == 1;
    }
    
    public boolean getSouth(){
        return south == 1;
    }
    
    public boolean getWest(){
        return west == 1;
    }
}


