package graficas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

 

public class NewPanel extends JPanel implements ActionListener  {
        

        private static int vidas = 0;
        private static char letraIngresada = ' ';
        private static char guion = '_';
        private static String parada = "EXIT";
        private static String info = "INFO";
        private static String stringIngresado = new String();
        private static int puntJugador = 0;
        private static int puntComp = 0;
        private static int ronda = 1;
        private static int posicionLetra = -1;
        private int temp = 0;
        private static boolean pausa = false;
        private static JButton boton = new JButton();
        private static JTextField text = new JTextField();
        private static JLabel label = new JLabel();
        private static JLabel label2 = new JLabel();
        
        public NewPanel(){
        
        setFocusable(true);
        this.vidas = 0;
        this.letraIngresada = letraIngresada;
        this.guion = guion;
        this.parada = parada;
        this.info = info;
        this.stringIngresado = stringIngresado;
        this.puntJugador = puntJugador;
        this.puntComp = puntComp;
        this.ronda = ronda;
        this.posicionLetra = posicionLetra;
        this.temp = vidas;
   
        
        boton.setText("Enviar Letra");
        boton.setVisible(true);
        boton.addActionListener(NewPanel.listener);
        text.setSize(new Dimension(300,100));
        
        text.setText("Ingrese una letra");
        
        
        label2.setText("Ingrese una letra");
        
        
        text.setVisible(true);
       
        label.setVisible(true);
        
        add(label);
        add(label2);
        add(text);
        add(boton);
        
        
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        vidas=temp;  
    }
    
    private static ActionListener listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               stringIngresado = text.getText();
               pausa = true;
            }
    };
    
        
        
    
    
   
    
    public void Ahorcado(String palabraClave){
        
            while(true){
            
            int tamanoPalabra=0;
            String letrasIngresadas="";
            char[] arregloGuiones = new char [palabraClave.length()];
            char[] arregloPalabra = palabraClave.toCharArray();
            
            
            
            if (stringIngresado.equals(parada)){
                    //System.out.print("Ha finalizado su partida!! Gracias por jugar.\n");
                    System.exit(0);
                    break;
            }

//            System.out.printf("Ronda:%d\nEscriba <exit> para finalizar el juego.\nEscriba <info> para saber acerca de este proyecto.\nPuntaje total: Jugador:%d - Computador:%d\n\n\n",ronda,puntJugador,puntComp);
//            System.out.print("Palabra secreta\nAnimales en ingles:\n");

            for (int i=0; i<palabraClave.length(); i++){
                arregloGuiones[i]= '_';
                label.setText(label.getText()+arregloGuiones[i]+" ");
            }

            //System.out.println("\n");

            while(tamanoPalabra<arregloPalabra.length||temp>7){

                
                
                while (pausa==false){
                    Ahorcado.pause();
                }
                pausa = false;
                stringIngresado = stringIngresado.toUpperCase();
                letraIngresada = stringIngresado.charAt(0); 
                //letrasIngresadas += letraIngresada;
                posicionLetra = palabraClave.indexOf(letraIngresada);

                if ((stringIngresado.charAt(0)>64&&stringIngresado.charAt(0)<91)||stringIngresado.charAt(0)>96&&stringIngresado.charAt(0)<123){
                    letraIngresada = stringIngresado.charAt(0);
                } else {
                    JOptionPane.showMessageDialog(null,"Solo Letras LOK");
                }

                if (stringIngresado.equals(parada)){
                    break;
                } else if (stringIngresado.equals(info)){
                    JOptionPane.showMessageDialog(null,"Este programa fue creado por Nicolas Delgado, Nicolas Molano y Santiago Mahecha, estudiantes de Ing Sistemas de la Universidad Nacional de Colombia.\n\n");
                    continue;
                }
                
                String guiones = "";
                for (int i=0; i<arregloPalabra.length; i++){
                    if (letraIngresada==arregloPalabra[i]){

                        tamanoPalabra++;
                        arregloGuiones[i] = letraIngresada;
                    } else {  
                        arregloGuiones[i] = arregloGuiones[i];
                    }
                    
                }
                
                
                for (int i=0; i<arregloPalabra.length; i++){
                    guiones = guiones + arregloGuiones[i];
                }
                
                label.setText(guiones);
                
                if(posicionLetra==-1){
                    this.vidas++;
                    this.temp=vidas;
                }
                        
                if (tamanoPalabra==arregloPalabra.length){
                    puntJugador++;
                    JOptionPane.showMessageDialog(null,"Has ganado ");
                    System.exit(0);
                } else if (temp>=8){
                    puntComp++;
                    JOptionPane.showMessageDialog(null,"Has perdido ");
                    System.exit(0);
                    break;
                }
                
            }
            
            
        }
            JOptionPane.showMessageDialog(null,"Palabra correcta");
            label.setText("");      
    }
    @Override
    protected void paintComponent(Graphics e) {
        super.paintComponent(e);
        switch(vidas){
        
            case 1:
               
        //cabeza
        e.fillOval(400, 150, 100, 100);
        repaint();
        break;
        
        
            case 2:
        //cabeza
        e.fillOval(400, 150, 100, 100);
        //tronco
        e.fillRect(442, 240, 20,200);
        repaint();
        break;
            case 3:
        //cabeza
        e.fillOval(400, 150, 100, 100);
        //tronco
        e.fillRect(442, 240, 20,200);
        //brazos
         int[] xs = {442, 442,420,400};
         int[] ys = {265,285,370,370};
        e.fillPolygon(xs, ys,4);
        repaint();
        break;
            case 4:
         //cabeza
        e.fillOval(400, 150, 100, 100);
        //tronco
        e.fillRect(442, 240, 20,200);
        //brazos
         int[] xs4 = {442, 442,420,400};
         int[] ys4 = {265,285,370,370};
        e.fillPolygon(xs4, ys4,4);
         int[] xs1 = {462, 462,485,505};
         int[] ys1 = {265,285,370,370};
         e.fillPolygon(xs1, ys1,4);
        repaint();
         break;
            case 5:
         //cabeza
        e.fillOval(400, 150, 100, 100);
        //tronco
        e.fillRect(442, 240, 20,200);
        //brazos
         int[] xs5 = {442, 442,420,400};
         int[] ys5 = {265,285,370,370};
        e.fillPolygon(xs5, ys5,4);
         int[] xs6 = {462, 462,485,505};
         int[] ys6 = {265,285,370,370};
         e.fillPolygon(xs6, ys6,4);       
         //piernas IZQ,DER
         int[] xs2 = {442, 452,410,390};
         int[] ys2 = {440,440,600,600};
         e.fillPolygon(xs2, ys2,4);
         repaint();
         break;
            case 6:
                //cabeza
        e.fillOval(400, 150, 100, 100);
        //tronco
        e.fillRect(442, 240, 20,200);
        //brazos
         int[] xs7 = {442, 442,420,400};
         int[] ys7 = {265,285,370,370};
        e.fillPolygon(xs7, ys7,4);
         int[] xs8 = {462, 462,485,505};
         int[] ys8 = {265,285,370,370};
         e.fillPolygon(xs8, ys8,4);       
         //piernas IZQ,DER
         int[] xs9 = {442, 452,410,390};
         int[] ys9 = {440,440,600,600};
         e.fillPolygon(xs9, ys9,4);
         int[] xs3 = {452, 462,509,489};
         int[] ys3 = {440,440,600,600};
         e.fillPolygon(xs3, ys3,4);
        repaint();
         break;
            case 7:
                 //cabeza
        e.fillOval(400, 150, 100, 100);
        //tronco
        e.fillRect(442, 240, 20,200);
        //brazos
         int[] xs10 = {442, 442,420,400};
         int[] ys10 = {265,285,370,370};
        e.fillPolygon(xs10, ys10,4);
         int[] xs11 = {462, 462,485,505};
         int[] ys11 = {265,285,370,370};
         e.fillPolygon(xs11, ys11,4);       
         //piernas IZQ,DER
         int[] xs12 = {442, 452,410,390};
         int[] ys12 = {440,440,600,600};
         e.fillPolygon(xs12, ys12,4);
         int[] xs13 = {452, 462,509,489};
         int[] ys13 = {440,440,600,600};
         e.fillPolygon(xs13, ys13,4);
         //cuerda y ojos
         e.setColor(Color.white);
         e.fillRect(442, 0, 20, 150);
         e.fillRect(442, 250, 20, 20);
         e.fillRect(425, 190, 20, 5);
         e.fillRect(460, 190, 20, 5);
         
         Font font=new Font("Arial",1,50);
         e.setFont(font);
         e.drawString("AHORCADO", 10, 40);
         
         repaint();
         
                 
         break;
         
              
        }
        
        }
}