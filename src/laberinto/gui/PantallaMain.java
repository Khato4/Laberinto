
package laberinto.gui;

import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
    
    //el constructor recibe el fichero por parametro para definir el tamaño de la ventana
    public PantallaMain(File fileLab) throws IOException{
        
        FicheroIn fichero = new FicheroIn(fileLab.getAbsolutePath());
        //leemos del fichero el numero de filas y columnas para especificar el tamaño
        int[] filCol = fichero.getFilasColumnas();
        PantallaMain.height = filCol[0] * 30 + 60;
        PantallaMain.width = filCol[1] * 30 + 7;
        
        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        
        //creamos la estructura de datos de tablero y llenamos
        Tablero tab = new Tablero(fileLab);
        
        
        //barra del menu
        JMenuBar barraMenu = new JMenuBar();
        barraMenu.setBounds(0,0,width,30);
        barraMenu.setBackground(DARK_GRAY);
        barraMenu.setVisible(true);
        this.setVisible(true);
        this.add(barraMenu);
        
        //panel donde se dibujara el laberinto
        PanelLaberinto panLab = new PanelLaberinto(fileLab);
        panLab.setBounds(0, 30, width, height-30);
        panLab.setVisible(true);
        this.add(panLab);
        panLab.requestFocus();
        
        //menu
        JMenu menu = new JMenu("Fichero");
        menu.setForeground(WHITE);
        menu.setVisible(true);
        barraMenu.add(menu);
        
        //botones
        //1er boton, seleccionar fichero laberinto
        JMenuItem abrir = new JMenuItem("Abrir Laberinto");
        JFileChooser select = new JFileChooser();
        abrir.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int returnVal = select.showOpenDialog(select);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    //guardamos el fichero laberinto seleccionado en labFile
                    File labFile = (select.getSelectedFile());
                    
                    //cerramos el actual laberinto y creamos el nuevo
                    cerrarVentana();
                    try {
                        PantallaMain nueva = new PantallaMain(labFile);
                    } catch (IOException ex) {
                        Logger.getLogger(PantallaMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }));
        
        
        menu.add(abrir);
        JMenuItem reinit = new JMenuItem("Reiniciar Posición");
        reinit.addActionListener(((ActionEvent ae)->{
            panLab.ficha.resetPosicion();
            panLab.repaint();
        }));
        menu.add(reinit);
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener((ActionEvent ae)->{
           System.exit(0); 
        });
        menu.add(salir);
        
        this.setVisible(true);
    }
    
    public void cerrarVentana(){
        this.dispose();
    }
    
}
