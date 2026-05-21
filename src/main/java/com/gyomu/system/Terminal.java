package com.gyomu.system;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Terminal extends JPanel {
    private GridBagLayout layout;
    private GridBagConstraints constraints;

    public Terminal(Fields fields, Table table, Database db) {
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();


        setLayout(layout);
        JButton search = new JButton("検索");
        search.setActionCommand("search");
        search.addActionListener(new Listener(db, table, fields));

        
        JButton send = new JButton("送信");
        send.setActionCommand("send");
        send.addActionListener(new Listener(db, table, fields));


        constraints.gridheight = 3;
        constraints.gridwidth  = 3;
        constraints.weightx = 1;
        layout.setConstraints(fields.input, constraints);
        add(fields.input);


        constraints.gridheight = 3;
        constraints.gridwidth  = 1;
        constraints.weightx = 1;
        layout.setConstraints(send, constraints);
        add(send);





        // add(fields.search);
        // add(search);

        // add(fields.input);
        // add(send);
    }

    @Override
    public int getHeight() {
        return 200;
    }

    public void add(Component comp, int width, int height) {
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        add(comp);
    }
}

