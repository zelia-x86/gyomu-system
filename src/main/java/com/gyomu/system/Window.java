package com.gyomu.system;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Window extends JFrame {
    public Window(Database db) {
        setTitle("Main Window");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        Search Search = new Search();
        Table table = new Table(db);
        add(Search, BorderLayout.NORTH);
        add(new JScrollPane(new JTable(table)));
    }
}
