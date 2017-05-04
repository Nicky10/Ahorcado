package graficas;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.*;

public class NewPanel extends JPanel implements ActionListener, MouseListener {

    private Timer timer;
    private int x, y, count, secuencia;
    private boolean choco;

    public NewPanel() {
        this.x = 0;
        this.y = 70;
        this.count = 0;
        this.addMouseListener(this);
        this.timer = new Timer(50, this);
        timer.start();
        this.choco = false;
        this.secuencia = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(loadImage("fondo.png"), 0, 0, 1500, 800, this);
        g.drawImage(loadImage("cats.gif"), x, 600, x + 132, 680, 132*secuencia, 0, 132*secuencia + 132, 80, this);
//        g.fillRect(60, y + 70, 70, 110);
//        g.fillRect(230, y, 70, 110);
//        g.setColor(Color.RED);
//        g.fillRect(280, y + 20, 70, 110);
//        g.fillRect(450, y + 70, 70, 110);
//
//        g.setColor(Color.YELLOW);
//        g.fillOval(1025, 450, 50, 50);
//        g.setColor(Color.WHITE);
//        g.fillRect(1000, 500, 100, 100);
//        g.setColor(Color.BLUE);
//        g.fillRect(1020, 600, 20, 60);
//        g.fillRect(1060, 600, 20, 60);
//        if (choco) {
//            g.setColor(Color.red);
//            g.fillRect(1025, 525, 50, 50);
//        }
//
//        int[] xs = {x + 50, x + 100, x + 150, x + 200};
//        int[] ys = {560, 510, 510, 560};
//
//        g.setColor(Color.BLUE);
//        g.fillPolygon(xs, ys, 4);
//        g.setColor(Color.CYAN);
//        g.fillRect(x, 560, 250, 50);
//        g.setColor(Color.BLACK);
//        g.fillOval(x + 50, 610, 50, 50);
//        g.fillOval(x + 150, 610, 50, 50);
//        g.drawRect(x, 510, 250, 150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (choco) {
            timer.stop();
        }
//        checkCollisions();
        repaint();
        count++;
        x += 10;
        if (x == 1500) {
            x = -132;
        }
        y += 0.98*count;
        secuencia++;
        if (secuencia == 6) {
            secuencia = 0;
        }
    }

    public void mouseClicked(MouseEvent e) {
        
    }

    public void mousePressed(MouseEvent e) {
       
    }

    public void mouseReleased(MouseEvent e) {
        
    }

    public void mouseEntered(MouseEvent e) {
       
    }

    public void mouseExited(MouseEvent e) {

    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, 360, 250, 150);
    }

    public void checkCollisions() {
        Rectangle carro = getBounds();
        Rectangle obstaculo = new Rectangle(1000, 450, 100, 210);
        if (carro.intersects(obstaculo)) {
            choco = true;
        }
    }
    
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
}
