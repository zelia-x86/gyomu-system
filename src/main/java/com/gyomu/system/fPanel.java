package com.gyomu.system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class fPanel extends JPanel {

  private Color border = new Color(74, 181, 223);

  public fPanel (Fields fields) {
    setLayout(new GridBagLayout());
    final GridBagConstraints gbc = new GridBagConstraints();

    final JPanel leftPanel = new JPanel(new GridBagLayout());
    final JPanel rightPanel = new JPanel(new GridBagLayout());

    // leftPanel.setBackground(Color.PINK);
    rightPanel.setBackground(Color.GRAY);

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(5,5,5,5);

    add(leftPanel, gbc);

    gbc.gridx = 1;
    add (rightPanel, gbc);


    // left panel
    gbc.weighty = 0;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.ipady = 3;
    // gbc.fill = GridBagConstraints.HORIZONTAL;
    leftPanel.add(inputPanel("製品コード", fields.seihin), gbc);
    gbc.gridy = 1;
    leftPanel.add(inputPanel("商品コード", fields.shouhin), gbc);
    gbc.gridy = 2;
    leftPanel.add(inputPanel("品番", fields.shinaban), gbc);
    gbc.gridy = 3;
    leftPanel.add(inputPanel("品名", fields.shinamei), gbc);
    gbc.gridy = 4;
    leftPanel.add(inputPanel("数量（以下）", fields.suuryo), gbc);




    // setBackground(Color.RED);
    // setBorder(BorderFactory.createTitledBorder("ターミナル"));
    setBorder(BorderFactory.createLineBorder(this.border));
  }

  private JPanel inputPanel (String label, JTextField field) {
    final JPanel panel = new JPanel(new GridBagLayout());
    final GridBagConstraints gbc = new GridBagConstraints();
    panel.setBackground(new Color(230, 243, 247));
    panel.setBorder(BorderFactory.createLineBorder(this.border));
    // panel.
    // field.setMaximumSize(new Dimension(Integer.MAX_VALUE, field.getPreferredSize().height));
    // field.setSize(20, 20);

    gbc.fill = GridBagConstraints.HORIZONTAL;
    // gbc.ipadx = 6;
    gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST; gbc.weightx = 1;
    gbc.insets = new Insets(4,4,4,4);

    JLabel l = new JLabel();
    l.setSize(10, 10);

    panel.add(new JLabel(label + ":"), gbc);
    // panel.add(javax.swing.Box.createRigidArea(new Dimension(6,0)), gbc);
    gbc.gridx = 1; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
    gbc.weightx = 10;
    panel.add(field, gbc);

    return panel;
  }
}
