
package laberinto;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Claudio
 */

//Esta clase corresponde a la clase "Laberinto" de la especificación de la
//práctica
public class Tablero {
    
    private static int fil;
    private static int col;
    public Casilla[][] tab;
    public int posFin[] = new int[2];

    public Tablero(File fileLab) throws IOException{
        FicheroIn fichero = new FicheroIn(fileLab.getAbsolutePath());
        int[] filCol = fichero.getFilasColumnas();
        //introducimos las dimensiones del tablero
        this.fil = filCol[0];
        this.col = filCol[1];
        this.tab = new Casilla[fil][col];
        
        //pasamos a rellenar el Tablero de objetos Casilla
        for(int i = 0; i < fil; i++){
            for(int j = 0; j < col; j++){
                this.tab[i][j] = new Casilla(fichero.getBit(), fichero.getBit(), 
                        fichero.getBit(), fichero.getBit());
            }
            fichero.getBit(); //leemos un bit extra para el salto de linea
        }
        
        //llegados a este punto solo queda guardar la posicion de la salida
        this.posFin[0] = Integer.parseInt(fichero.br.readLine());
        this.posFin[1] = Integer.parseInt(fichero.br.readLine())-1;
    }
    
        /**
     * @return the fil
     */
    public static int getFil() {
        return Tablero.fil;
    }

    /**
     * @return the col
     */
    public static int getCol() {
        return Tablero.col;
    }

    
    
    public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(5));
            
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File("exit.png"));
            } catch (IOException e) {
            }
            g2.drawImage(img, (this.posFin[1]) * Casilla.dimension, 
                    (this.posFin[0])* Casilla.dimension, 30, 30, null);
            System.out.println("exit" );
            

            
            for(int i = 0; i < this.fil; i++){
                for(int j =0; j < this.col; j++){
                    if(this.tab[i][j].getNorth()){
                        g2.setColor (Color.black);
                        g2.drawLine(Casilla.dimension * j, 
                                Casilla.dimension * i,
                                Casilla.dimension * j + Casilla.dimension,
                                Casilla.dimension * i);
                    }
                    if(this.tab[i][j].getEast()){
                        g2.drawLine(Casilla.dimension * j + Casilla.dimension, 
                                Casilla.dimension * i,
                                Casilla.dimension * j + Casilla.dimension,
                                Casilla.dimension * i + Casilla.dimension);
                    }
                    if(this.tab[i][j].getSouth()){
                        g2.drawLine(Casilla.dimension * j, 
                                Casilla.dimension * i + Casilla.dimension,
                                Casilla.dimension * j + Casilla.dimension,
                                Casilla.dimension * i + Casilla.dimension);
                    }
                    if(this.tab[i][j].getWest()){
                        g2.drawLine(Casilla.dimension * j, 
                                Casilla.dimension * i,
                                Casilla.dimension * j,
                                Casilla.dimension * i + Casilla.dimension);
                    }
                }
            }
            
        }
    
}
