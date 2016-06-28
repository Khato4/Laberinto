
package laberinto;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

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
    
    
    public void draw(Graphics g){
        BufferedImage img = null;
        try {
                img = ImageIO.read(new File("ficha.png"));
            } catch (IOException e) {
            }
            g.drawImage(img, (this.getColumna()) * Casilla.dimension, 
                    (this.getFila())* Casilla.dimension, 30, 30, null);
            
            System.out.println("ficha: "+this.getFila()+"    "+this.getColumna());
        
    }
    
}
