package graficas;

import javax.swing.*;

public class TestPaintComponent extends JFrame {

    public TestPaintComponent() {
        add(new NewPanel());
    }
    
    public static void main(String[] args) {
        TestPaintComponent frame = new TestPaintComponent();
        frame.setTitle("TestPaintComponent");
        frame.setSize(1500, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
