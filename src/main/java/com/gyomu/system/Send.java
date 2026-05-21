package com.gyomu.system;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Send extends JPanel {
    private JButton sendButton;

    public Send(Fields Fields, Table table, Database db) {
        sendButton = new JButton("送信");

        add(Fields.send);
        add(sendButton);
    }
}
