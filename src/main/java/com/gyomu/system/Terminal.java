package com.gyomu.system;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Terminal extends JPanel {
    private JButton searchButton;

    public Terminal(Fields fields, Table table, Database db) {
        searchButton = new JButton("検索");
        searchButton.setActionCommand("search");
        searchButton.addActionListener(new Listener(db, table, fields));

        
        JButton send = new JButton("送信");
        send.setActionCommand("send");
        send.addActionListener(new Listener(db, table, fields));

        add(fields.search);
        add(searchButton);

        add(fields.input);
        add(send);
    }

    @Override
    public int getHeight() {
        return 200;
    }
}

