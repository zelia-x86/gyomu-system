package com.gyomu.system;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public String getSearchText() {
        
        String targetText = "AA";
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == searchButton) {
                    System.out.println("検索ボタンがクリックされました。");
                }
            }
        });
        String searchText = searchField.getText();
        if (searchText != null && !searchText.isEmpty()) {
            if (targetText.contains(searchText)) {
                System.out.println(searchText);
                return searchText;
            }
        }
        return null;
    }
    }

