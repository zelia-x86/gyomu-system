package com.gyomu.system;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Search extends JPanel {
    private JTextField searchField;
    private JButton searchButton;

    public Search() {
        searchField = new JTextField(20);
        searchButton = new JButton("検索");

        add(searchField);
        add(searchButton);
    }
    public String getSearchText() {
        return searchField.getText();
    }
}
