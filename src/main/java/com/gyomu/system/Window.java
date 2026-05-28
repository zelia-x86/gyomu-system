package com.gyomu.system;
import java.awt.Color;
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
        setBackground(Color.PINK);

        Table table = new Table(db);
        Fields fields = new Fields();
        Listener listener = new Listener(db, table, fields, this);

        // buttons
        Terminal terminal = new Terminal(fields, table, db, listener);


        add(terminal);
        add(table.panel);
    }
}
