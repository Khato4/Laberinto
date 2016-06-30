
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
    
    private int fila;
    private int columna;
    private static int filaInicial;
    private static int columnaInicial;
        
    public Ficha(){
        
        Random rnd = new Random();
        this.fila = rnd.nextInt(Tablero.getFil());
        this.columna = rnd.nextInt(Tablero.getCol());
        Ficha.filaInicial = this.fila;
        Ficha.columnaInicial = this.columna;
    }
    
    public int getFila(){
        return this.fila;
    }
    
    public int getColumna(){
        return this.columna;
    }
    
    public void setFila(int x){
        this.fila = x;
    }
    
    public void setColumna(int y){
        this.columna = y;
    }
    
    public int getFilaInicial(){
        return Ficha.filaInicial;
    }
    
    public int getColumnaInicial(){
        return Ficha.columnaInicial;
    }
    
    public void paintComponent(Graphics g){
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
