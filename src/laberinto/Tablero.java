
package laberinto;

import java.io.IOException;

/**
 *
 * @author Claudio
 */
public class Tablero {
    
    public static int fil;
    public static int col;
    public static Casilla[][] tab;
    public static int posFich[] = new int[2];
    public static int posFin[] = new int[2];
    
    public Tablero(FicheroIn fileLab, int filas, int columnas) throws IOException{
        //introducimos las dimensiones del tablero
        Tablero.fil = filas;
        Tablero.col = columnas;
        Tablero.tab = new Casilla[fil][col];
        
        //pasamos a rellenar el Tablero de objetos Casilla
        for(int i = 0; i < fil; i++){
            for(int j = 0; j < col; j++){
                Tablero.tab[i][j] = new Casilla(fileLab.getBit(), fileLab.getBit(), 
                        fileLab.getBit(), fileLab.getBit());
                //comprobacion por consola del tablero
//                System.out.println("i: "+i+"  j: "+j);
//                System.out.println(tab[i][j].north);
//                System.out.println(tab[i][j].east);
//                System.out.println(tab[i][j].south);
//                System.out.println(tab[i][j].west);
            }
            fileLab.getBit(); //leemos un bit extra para el salto de linea
        }
        
        //legados a este punto solo queda la posicion de la salida
        this.posFin[0] = Integer.parseInt(fileLab.br.readLine());
        this.posFin[1] = Integer.parseInt(fileLab.br.readLine())-1;
    }
}
