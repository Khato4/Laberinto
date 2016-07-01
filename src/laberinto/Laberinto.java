package laberinto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import laberinto.gui.*;

/**
 *
 * @author Claudio
 */
//inicio de la aplicación, seleccionamos un fichero inicial y lo pasamos por
//parámetro
public class Laberinto {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File laberinto = new File("maze1.txt");
        PantallaMain inicio = new PantallaMain(laberinto);
        
    }

}
