package com.gyomu.system;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Window extends JFrame {
    public Window() {
        setTitle("Main Window");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        Search Search = new Search();
        add(Search, BorderLayout.NORTH);
    }
    
    public static void main(String[] args) {
        Window window = new Window();
        window.setVisible(true);
    }
}
