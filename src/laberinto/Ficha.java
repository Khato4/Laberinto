
package laberinto;

import java.util.Random;

/**
 *
 * @author Claudio
 */
public class Ficha {
    
    public int posicion[] = new int [2]; //contiene la fila y la columna
        
        private int fila;
        private int columna;
        
    public Ficha(){
        
        Random rnd = new Random();
        this.fila = rnd.nextInt(Tablero.getFil());
        this.columna = rnd.nextInt(Tablero.getCol());
    }
    
    public int getFila(){
        return this.fila;
    }
    
    public int getColumna(){
        return this.columna;
    }
    
}
