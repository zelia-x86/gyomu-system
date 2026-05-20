package com.gyomu.system;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Send extends JPanel {
    private JTextField sendField;
    private JButton sendButton;

    public Send() {
        sendField = new JTextField(20);
        sendButton = new JButton("送信");

        add(sendField);
        add(sendButton);
    }
}
