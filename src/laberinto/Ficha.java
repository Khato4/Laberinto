
package laberinto;

/**
 *
 * @author Claudio
 */
public class Ficha {
    
    public int posicion[] = new int [2]; //contiene la fila y la columna
                                         //en la que se encuentra la ficha
    
    public Ficha(int fila, int columna){
        this.posicion[0] = fila;
        this.posicion[1] = columna;
    }
    
    
    
}
