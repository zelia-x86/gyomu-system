package com.gyomu.system;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Window extends JFrame {
    public Window(Database db) {
        setTitle("Main Window");
        setSize(800, 600);
        // setResizable(false);
        setLayout(new GridLayout(2, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        Table table = new Table(db);
        Fields fields = new Fields();

        // buttons
        Terminal terminal = new Terminal(fields, table, db);
        View view = new View(db, table);


        add(terminal);
        add(view);
    }
}
