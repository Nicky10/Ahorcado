package graficas;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPanel extends JPanel implements ActionListener, Mouse {

    private Timer timer;
    private int x;

    public NewPanel() {
        this.x = 300;
        this.timer = new Timer(5, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(60, 140, 70, 110);
        g.fillRect(230, 70, 70, 110);
        g.setColor(Color.RED);
        g.fillRect(280, 90, 70, 110);
        g.fillRect(450, 140, 70, 110);

        g.setColor(Color.YELLOW);
        g.fillOval(125, 300, 50, 50);
        g.setColor(Color.WHITE);
        g.fillRect(100, 350, 100, 100);
        g.setColor(Color.BLUE);
        g.fillRect(120, 450, 20, 60);
        g.fillRect(160, 450, 20, 60);

        int[] xs = {x + 50, x + 100, x + 150, x + 200};
        int[] ys = {410, 360, 360, 410};

        g.setColor(Color.BLUE);
        g.fillPolygon(xs, ys, 4);
        g.setColor(Color.CYAN);
        g.fillRect(x, 410, 250, 50);
        g.setColor(Color.BLACK);
        g.fillOval(x + 50, 460, 50, 50);
        g.fillOval(x + 150, 460, 50, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        x += 1;
    }

}
