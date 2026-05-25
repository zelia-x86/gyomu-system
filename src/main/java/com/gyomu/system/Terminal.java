package com.gyomu.system;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Terminal extends JPanel {
    private GridBagLayout layout;
    private GridBagConstraints gbc;

    public Terminal(Fields fields, Table table, Database db, Listener listener) {
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(layout);

        // buttons
        JButton search = new JButton("検索");
        JButton send = new JButton("送信");

        JPanel bPanel = new JPanel();
        bPanel.setBackground(Color.BLUE);

        // constraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 5;
        gbc.fill = GridBagConstraints.BOTH;
        add(new fPanel(fields), gbc);

        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(bPanel, gbc);
        bPanel.add(send);
        bPanel.add(search);


        // actions
        search.setActionCommand("search")   ;
        search.addActionListener(listener);
        send.setActionCommand("send");
        send.addActionListener(listener);
            

        // constraints.gridheight = 3;
        // constraints.gridwidth  = 3;
        // constraints.weightx = 1;
        // layout.setConstraints(fields.name, constraints);
        // // add(fields.name);


        // constraints.gridheight = 3;
        // constraints.gridwidth  = 1;
        // constraints.weightx = 1;
        // layout.setConstraints(send, constraints);
        // add(send);





        // add(fields.name);
        // add(search);

        // add(fields.input);
        // add(send);
    }

    // @Override
    // public int getHeight() {
    //     return 200;
    // }

    public void add(Component comp, int width, int height) {
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        add(comp);
    }
}

