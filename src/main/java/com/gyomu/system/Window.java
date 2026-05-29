package com.gyomu.system;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame {
    public Window(Database db) {
        setTitle("Main Window");
        setSize(800, 600);
        // setResizable(false);
        setLayout(new GridLayout(2, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Color.PINK);

        JLabel uuid = new JLabel("(UUID)");
        Fields fields = new Fields();
        Table table = new Table(db, uuid, fields);
        Listener listener = new Listener(db, table, fields, this, uuid);

        // buttons
        Terminal terminal = new Terminal(fields, table, db, listener, uuid);


        add(terminal);
        add(table.panel);
    }
}
