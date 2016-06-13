
package laberinto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Claudio
 */
public class FicheroIn {
    
    public BufferedReader br;
    private FileReader fr;
    
    public FicheroIn(String lab) throws FileNotFoundException{
        this.fr = new FileReader(lab);
        this.br = new BufferedReader(fr);
    }
    
    public int[] getFilasColumnas() throws IOException{
        
        int[] filCol = new int[2];
        filCol[0] = Integer.parseInt(br.readLine());
        filCol[1] = Integer.parseInt(br.readLine());
        
        return filCol;
    }
    
    public int getBit() throws IOException {
        int bit = br.read() - 48; //convertimos a entero
        return bit;
        
    }
    
    public int[] getStart() throws IOException{
        int start[] = new int[2];
        start[0] = br.read();
        start[1] = br.read();
        return start;
    }
    
}
