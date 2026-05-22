package com.gyomu.system;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Terminal extends JPanel {
    private JButton searchButton;

    public Terminal(Fields fields, Table table, Database db) {
        searchButton = new JButton("検索");
        searchButton.setActionCommand("search");
        searchButton.addActionListener(new Listener(db, table, fields));

        JButton goodsCodeButton = new JButton("商品コード");
        goodsCodeButton.setActionCommand("goodsCodeSearch");
        goodsCodeButton.addActionListener(new Listener(db, table, fields));

        JButton goodsNumberButton = new JButton("品番");
        goodsNumberButton.setActionCommand("goodsNumberSearch");
        goodsNumberButton.addActionListener(new Listener(db, table, fields));

        JButton goodsNameButton = new JButton("品名");
        goodsNameButton.setActionCommand("goodsNameSearch");

        JButton goodsQuantityButton = new JButton("数量");
        goodsQuantityButton.setActionCommand("goodsQuantitySearch");
        goodsQuantityButton.addActionListener(new Listener(db, table, fields));

        JButton send = new JButton("送信");
        send.setActionCommand("send");
        send.addActionListener(new Listener(db, table, fields));

        add(fields.search);
        add(searchButton);

        add(fields.goodsCodeField);
        add(goodsCodeButton);

        add(fields.goodsNumberField);
        add(goodsNumberButton);

        add(fields.goodsNameField);
        add(goodsNameButton);

        add(fields.goodsQuantityField);
        add(goodsQuantityButton);

        add(fields.input);
        add(send);
    }

    @Override
    public int getHeight() { 
        return 200;
    }
}

