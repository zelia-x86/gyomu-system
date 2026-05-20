package com.gyomu.system;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Search extends JPanel {
    private JTextField searchField;
    private JButton searchButton;

    public Search(Table table, Database db) {
        searchField = new JTextField(20);
        searchButton = new JButton("検索");
        searchButton.addActionListener(new Listener(searchButton, searchField, db, table));

        add(searchField);
        add(searchButton);
    }
}

