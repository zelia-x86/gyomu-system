package com.gyomu.system;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Terminal extends JPanel {
    private GridBagLayout layout;
    private GridBagConstraints gbc;

    public JLabel UUID;

    public Terminal(Fields fields, Table table, Database db, Listener listener, JLabel uuid) {
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(layout);

        // buttons
        this.UUID = uuid;
        JButton search = new JButton("検索");
        JButton send = new JButton("送信");
        JButton edit = new JButton("編集");
        JButton delete = new JButton("削除");

        JPanel bPanel = new JPanel(new GridBagLayout());
        // bPanel.setBackground(Color.BLUE);

        // constraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 5;
        gbc.fill = GridBagConstraints.BOTH;
        add(new fPanel(fields), gbc);

        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(bPanel, gbc);

        gbc = new GridBagConstraints();
        gbc.weightx = 1;



        bPanel.add(UUID, gbc);
        bPanel.add(send, gbc);
        bPanel.add(search, gbc);
        // bPanel.add(edit, gbc);
        bPanel.add(delete, gbc);


        // actions
        search.setActionCommand("search")   ;
        send.setActionCommand("send");
        edit.setActionCommand("edit");
        delete.setActionCommand("delete");
        search.addActionListener(listener);
        send.addActionListener(listener);
        edit.addActionListener(listener);
        delete.addActionListener(listener);
            

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

