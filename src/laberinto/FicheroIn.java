package laberinto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Claudio
 */
//clase para la lectura del fichero seleccionado
public class FicheroIn {

    public BufferedReader br;
    private final FileReader fr;

    //constructor, gestión de posible error al no encontrar el fichero
    public FicheroIn(String lab) throws FileNotFoundException {
        this.fr = new FileReader(lab);
        this.br = new BufferedReader(fr);
    }

    //mediante la funcion readLine leemos las 2 primeras lineas del fichero y 
    //las guardamos en un array de 2 enteros, uno para fila y otro para columna
    public int[] getFilasColumnas() throws IOException {
        int[] filCol = new int[2];
        filCol[0] = Integer.parseInt(br.readLine());
        filCol[1] = Integer.parseInt(br.readLine());

        return filCol;
    }
    
    //método para la lectura de cada uno de los bits que definen cada Casilla
    public int getBit() throws IOException {
        int bit = br.read() - 48; //convertimos a entero
        return bit;

    }

}
