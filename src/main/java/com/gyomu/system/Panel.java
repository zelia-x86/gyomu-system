package com.gyomu.system;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private Database db;
    private Fields fields;
    private Terminal terminal;
    private Table table;

    public Panel() {

        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        db = new Database();
        fields = new Fields();             
        table = new Table(db);
        terminal = new Terminal(fields, table, db); 

        add(fields.getPanel(), BorderLayout.NORTH);

       
        add(terminal, BorderLayout.SOUTH);
    }
}
