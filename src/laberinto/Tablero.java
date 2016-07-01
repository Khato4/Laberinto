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
/*Esta clase corresponde a la clase "Laberinto" de la especificación de la
  práctica, es la estructura de datos del Laberinto comprendido como una matriz
  de objetos Casilla
*/
public class Tablero {
    
    private static int fil;             //número de filas
    private static int col;             //número de columnas
    public Casilla[][] tab;             //matriz 2 dimensiones de Casillas
    public int posFin[] = new int[2];   //posición de la salida

    public Tablero(File fileLab) throws IOException {
        FicheroIn fichero = new FicheroIn(fileLab.getAbsolutePath());
        int[] filCol = fichero.getFilasColumnas();
        //introducimos las dimensiones del tablero
        Tablero.fil = filCol[0];
        Tablero.col = filCol[1];
        this.tab = new Casilla[fil][col];

        //pasamos a rellenar el Tablero de objetos Casilla mediante un bucle
        //que lee bits de 4 en 4 y los pasa por parámetro al constructor de
        //Casilla
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                this.tab[i][j] = new Casilla(fichero.getBit(), fichero.getBit(),
                        fichero.getBit(), fichero.getBit());
            }
            fichero.getBit(); //leemos un bit extra para el salto de linea
        }

        //llegados a este punto solo queda guardar la posicion de la salida
        this.posFin[0] = Integer.parseInt(fichero.br.readLine());
        this.posFin[1] = Integer.parseInt(fichero.br.readLine()) - 1;

    }

    //getters del numero de filas y columnas
    public static int getFil() {
        return Tablero.fil;
    }

    
    public static int getCol() {
        return Tablero.col;
    }
    
    //función de dibujo del tablero
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        
        //obtenemos la imagen que colocaremos en la posición de salida
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("exit.png"));
        } catch (IOException e) {
        }
        //y la dibujamos
        g2.drawImage(img, (this.posFin[1]) * Casilla.dimension,
                (this.posFin[0]) * Casilla.dimension, 30, 30, null);
        
        //bucle de dibujo, recorremos la matriz de Casillas de derecha a izquierda
        //y de arriba a abajo. Para cada Casilla realizamos un get de cada una 
        //de sus 4 posibles paredes, y si retornan true, las dibujamos en su 
        //posición correspondiente
        for (int i = 0; i < Tablero.fil; i++) {
            for (int j = 0; j < Tablero.col; j++) {
                if (this.tab[i][j].getNorth()) {
                    g2.setColor(Color.black);
                    g2.drawLine(Casilla.dimension * j,
                            Casilla.dimension * i,
                            Casilla.dimension * j + Casilla.dimension,
                            Casilla.dimension * i);
                }
                if (this.tab[i][j].getEast()) {
                    g2.drawLine(Casilla.dimension * j + Casilla.dimension,
                            Casilla.dimension * i,
                            Casilla.dimension * j + Casilla.dimension,
                            Casilla.dimension * i + Casilla.dimension);
                }
                if (this.tab[i][j].getSouth()) {
                    g2.drawLine(Casilla.dimension * j,
                            Casilla.dimension * i + Casilla.dimension,
                            Casilla.dimension * j + Casilla.dimension,
                            Casilla.dimension * i + Casilla.dimension);
                }
                if (this.tab[i][j].getWest()) {
                    g2.drawLine(Casilla.dimension * j,
                            Casilla.dimension * i,
                            Casilla.dimension * j,
                            Casilla.dimension * i + Casilla.dimension);
                }
            }
        }

    }

}
