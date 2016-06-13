
package laberinto.gui;

import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import laberinto.*;

/**
 *
 * @author Claudio Sugar
 */

//clase que crea la ventana inicial y nos permite seleccionar fichero
public class PantallaMain extends JFrame {
    
    public static int height;
    public static int width;
    
    public PantallaMain(FicheroIn fileLab) throws IOException{
        
        //leemos del fichero el numero de filas y columnas para especificar el tamaño
        int[] filCol = fileLab.getFilasColumnas();
        PantallaMain.height = filCol[0] * 30 + 60;
        PantallaMain.width = filCol[1] * 30 + 7;
        
        System.out.println(PantallaMain.height);
        System.out.println(PantallaMain.width);
        
        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        
        //creamos la estructura de datos de tablero y llenamos
        Tablero tab = new Tablero(fileLab, filCol[0], filCol[1]);
        
        
        //barra del menu
        JMenuBar barraMenu = new JMenuBar();
        barraMenu.setBounds(0,0,width,30);
        barraMenu.setBackground(DARK_GRAY);
        barraMenu.setVisible(true);
        this.setVisible(true);
        this.add(barraMenu);
        
        //menu
        JMenu menu = new JMenu("Fichero");
        menu.setForeground(WHITE);
        menu.setVisible(true);
        barraMenu.add(menu);
       
        //panel donde se dibujara el laberinto
        PanelLaberinto panLab = new PanelLaberinto(fileLab, filCol[0], filCol[1]);
        panLab.setBounds(0, 30, width, height-30);
        panLab.setVisible(true);
        this.add(panLab);
        
        //botones
        //1er boton, seleccionar fichero laberinto
        JMenuItem abrir = new JMenuItem("Abrir Laberinto");
        JFileChooser select = new JFileChooser();
        abrir.addActionListener(((ActionEvent ae)->{
            int returnVal = select.showOpenDialog(select);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                //guardamos el fichero laberinto seleccionado en labFile
                String labSelect = select.getSelectedFile().toString();
                try {
                    FicheroIn labFile = new FicheroIn(labSelect);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PantallaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.setVisible(false); //you can't see me!
                this.dispose(); //Destroy the JFrame object
                try {
                    PantallaMain inicio = new PantallaMain(fileLab);
                } catch (IOException ex) {
                    Logger.getLogger(PantallaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(labSelect);
                
            }
            }));
        
        
        
        menu.add(abrir);
        JMenuItem reinit = new JMenuItem("Reiniciar Posición");
        menu.add(reinit);
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener((ActionEvent ae)->{
           System.exit(0); 
        });
        menu.add(salir);
        
        this.setVisible(true);
    }
    
}
