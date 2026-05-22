package com.gyomu.system;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class Fields {
   private JPanel mainPanel;
  // fields
  public JTextField search = new JTextField(20);
  public JTextField goodsCodeField = new JTextField(20);
  public JTextField goodsNumberField = new JTextField(20);
  public JTextField goodsNameField = new JTextField(20);
  public JTextField goodsQuantityField = new JTextField(20);
  public JTextField input = new JTextField(20);

  public Fields() {

        mainPanel = new JPanel(new GridLayout(1, 3, 10, 0));

        JPanel part1 = new JPanel(new GridLayout(2, 2, 5, 5));
        part1.add(new JLabel("検索"));
        part1.add(search);

        part1.add(new JLabel("商品コード"));
        part1.add(goodsCodeField);

        JPanel part2 = new JPanel(new GridLayout(2, 2, 5, 5));
        part2.add(new JLabel("品番"));
        part2.add(goodsNumberField);

        part2.add(new JLabel("品名"));
        part2.add(goodsNameField);

        JPanel part3 = new JPanel(new GridLayout(2, 2, 5, 5));
        part3.add(new JLabel("数量"));
        part3.add(goodsQuantityField);

        part3.add(new JLabel("入力"));
        part3.add(input);

        // Add  main panel
        mainPanel.add(part1);
        mainPanel.add(part2);
        mainPanel.add(part3);
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}