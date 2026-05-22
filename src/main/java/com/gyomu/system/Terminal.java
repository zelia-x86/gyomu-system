package com.gyomu.system;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Terminal extends JPanel {
    private JButton searchButton;

    public Terminal(Fields fields, Table table, Database db) {
        searchButton = new JButton("検索");
        searchButton.setActionCommand("search");
        searchButton.addActionListener(new Listener(db, table, fields));

        JButton goodsgGroupButton = new JButton("製品グループ");
        goodsgGroupButton.setActionCommand("goodsGroupSearch");
        goodsgGroupButton.addActionListener(new Listener(db, table, fields));

        JButton saveLocationButton = new JButton("保管場所");
        saveLocationButton.setActionCommand("saveLocationSearch");
        saveLocationButton.addActionListener(new Listener(db, table, fields));

        JButton customerButton = new JButton("得意先");
        customerButton.setActionCommand("customerSearch");
        customerButton.addActionListener(new Listener(db, table, fields));

        JButton purchaseButton = new JButton("仕入");
        purchaseButton.setActionCommand("purchaseSearch");
        purchaseButton.addActionListener(new Listener(db, table, fields));

        JButton send = new JButton("送信");
        send.setActionCommand("send");
        send.addActionListener(new Listener(db, table, fields));

        add(fields.search);
        add(searchButton);

        add(fields.goodsgGroupButton);
        add(goodsgGroupButton);

        add(fields.saveLocationButton);
        add(saveLocationButton);

        add(fields.customerButton);
        add(customerButton);

        add(fields.purchaseButton);
        add(purchaseButton);

        add(fields.input);
        add(send);
    }

    @Override
    public int getHeight() { 
        return 200;
    }
}

