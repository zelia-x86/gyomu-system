package com.gyomu.system;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Search extends JPanel {
    private JButton searchButton;

    public Search(Fields fields, Table table, Database db) {
        searchButton = new JButton("検索");
        searchButton.setActionCommand("search");
        searchButton.addActionListener(new Listener(db, table, fields));

        add(fields.search);
        add(searchButton);
    }
}

