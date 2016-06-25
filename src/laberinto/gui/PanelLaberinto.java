
package laberinto.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import laberinto.*;

/**
 *
 * @author Claudio Sugar
 */
public class PanelLaberinto extends JPanel{
    
    //constructor despuess de haber elegido un fichero
    public PanelLaberinto(FicheroIn fileLab, int filas, int columnas) throws IOException{
        this.setLayout(null);
        
        Tablero tablero = new Tablero();
        Ficha ficha = new Ficha();
        
        repaint();
        
    }

    
        @Override
        public void paint(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            
            tablero.draw(g);
            ficha.draw(g);
            
            
            g2.setStroke(new BasicStroke(5));
            
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File("exit.png"));
            } catch (IOException e) {
            }
            g2.drawImage(img, (Tablero.posFin[1]) * Casilla.dimension, 
                    (Tablero.posFin[0])* Casilla.dimension, 30, 30, null);
            
            g2.drawImage(img, (ficha.getFila())) * Casilla.dimension, 
                    (Tablero.posFin[0])* Casilla.dimension, 30, 30, null);
            
            for(int i = 0; i < Tablero.fil; i++){
                for(int j =0; j < Tablero.col; j++){
                    if(Tablero.tab[i][j].getNorth()){
                        g2.setColor (Color.black);
                        g2.drawLine(Casilla.dimension * j, 
                                Casilla.dimension * i,
                                Casilla.dimension * j + Casilla.dimension,
                                Casilla.dimension * i);
                    }
                    if(Tablero.tab[i][j].getEast()){
                        g2.drawLine(Casilla.dimension * j + Casilla.dimension, 
                                Casilla.dimension * i,
                                Casilla.dimension * j + Casilla.dimension,
                                Casilla.dimension * i + Casilla.dimension);
                    }
                    if(Tablero.tab[i][j].getSouth()){
                        g2.drawLine(Casilla.dimension * j, 
                                Casilla.dimension * i + Casilla.dimension,
                                Casilla.dimension * j + Casilla.dimension,
                                Casilla.dimension * i + Casilla.dimension);
                    }
                    if(Tablero.tab[i][j].getWest()){
                        g2.drawLine(Casilla.dimension * j, 
                                Casilla.dimension * i,
                                Casilla.dimension * j,
                                Casilla.dimension * i + Casilla.dimension);
                    }
                }
            }
            
        }
    }

