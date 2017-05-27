package graficas;

import java.awt.Graphics;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Ahorcado extends JFrame {

    public Ahorcado() {
        add(new NewPanel());
    }
    
        public static void pause() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ahorcado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args) {
        NewPanel p=new NewPanel();
        Ahorcado frame = new Ahorcado();
        frame.setTitle("Ahorcado");
        frame.setSize(750, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        frame.setVisible(true);
        
        
        String palabras[]={"CAT","DOG","MOUSE","ELEPHANT","COW","HORSE","RABIT","SPIDER","GIRAFFE","CROCODILE","SNAKE","BUTTERFLY","FLY","BIRD","DOVE","RAT0,TIGER","LION","MONKEY","BEAR"};
        Random randomGenerator = new Random();
        int posicionRandom = randomGenerator.nextInt(20);
        String palabraClave = palabras[posicionRandom];
        p.Ahorcado(palabraClave);
      
        
    }
}
    

