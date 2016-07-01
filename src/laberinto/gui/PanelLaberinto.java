
package laberinto.gui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import laberinto.*;

/**
 *
 * @author Claudio Sugar
 */
public class PanelLaberinto extends JPanel implements KeyListener {
    
        public Tablero tablero;
        public Ficha ficha;
    
    
    //constructor despues de haber elegido un fichero
    public PanelLaberinto(File fileLab) throws IOException{
        this.setLayout(null);
        this.tablero = new Tablero(fileLab);
        this.ficha = new Ficha();
        addKeyListener(this);
        this.setFocusable(true);
        
    }
    

    @Override
    public void keyTyped(KeyEvent ke) {
        System.out.println(ke.getKeyText(ke.getKeyCode()));
    }
    @Override
    public void keyReleased(KeyEvent ke) {
        System.out.println(ke.getKeyText(ke.getKeyCode()));
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        System.out.println(ke.getKeyText(ke.getKeyCode()));
        File bump = new File("smb_bump.wav");
        File win = new File("win.wav");
        switch(KeyEvent.getKeyText(ke.getKeyCode())){
                case "W":
                    if(tablero.tab[ficha.getFila()][ficha.getColumna()].getNorth()){
                        sonido(bump);
                        break;
                     }
                     ficha.setFila(ficha.getFila()-1);
                     System.out.println(ficha.getFila());
                     System.out.println("AAA");
                     repaint();
                     break;
                     
                case "D":
                    if(tablero.tab[ficha.getFila()][ficha.getColumna()].getEast()){
                        sonido(bump);
                        break;
                     }
                     ficha.setColumna(ficha.getColumna()+1);
                     System.out.println(ficha.getFila());
                     System.out.println("AAA");
                     repaint();
                     break;
                     
                 case "S":
                     if(tablero.tab[ficha.getFila()][ficha.getColumna()].getSouth()){
                         sonido(bump);
                         break;
                     }
                     ficha.setFila(ficha.getFila()+1);
                     System.out.println(ficha.getFila());
                     System.out.println("AAA");
                     repaint();
                     break;
                     
                 case "A":
                     if(tablero.tab[ficha.getFila()][ficha.getColumna()].getWest()){
                         sonido(bump);
                         break;
                     }
                     ficha.setColumna(ficha.getColumna()-1);
                     System.out.println(ficha.getFila());
                     System.out.println("AAA");
                     repaint();
                     break;
                     
        }
        System.out.println("pos: ["+ficha.getFila()+","+ficha.getColumna()+"]");
        System.out.println("exit: ["+Arrays.toString(tablero.posFin));
        
        if(ficha.getFila() == tablero.posFin[0] && ficha.getColumna() == tablero.posFin[1]){
            sonido(win);
            JOptionPane optionPane = new JOptionPane(new JLabel("¡Has ganado!",JLabel.CENTER));
            JDialog dialog = optionPane.createDialog("");
            dialog.setModal(true);
            dialog.setVisible(true);
            
            ficha.resetPosicion();
            
            repaint();
        }
    }
    
    @Override
         protected void paintComponent(Graphics g){
            super.paintComponent(g);
            tablero.paintComponent(g);
            ficha.paintComponent(g);
            
         }
         
    private void sonido(File audio){
                AudioInputStream audioInputStream = null;
                    try {
                audioInputStream = AudioSystem.getAudioInputStream(audio);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(PanelLaberinto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PanelLaberinto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(PanelLaberinto.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    audioInputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(PanelLaberinto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }

}

