
package laberinto;

import java.io.FileNotFoundException;
import java.io.IOException;
import laberinto.gui.*;

/**
 *
 * @author Claudio
 */
public class Laberinto {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        FicheroIn fileLab = new FicheroIn("maze1.txt");
        PantallaMain inicio = new PantallaMain(fileLab);
    }
    
}
