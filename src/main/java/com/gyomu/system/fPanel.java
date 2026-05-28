package com.gyomu.system;

import java.awt.*;
import javax.swing.*;

public class fPanel extends JPanel {

    private final Color border = new Color(74, 181, 223);

    public fPanel(Fields fields) {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel leftPanel = new JPanel(new GridBagLayout());
        JPanel rightPanel = new JPanel(new GridBagLayout());

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        add(leftPanel, gbc);

        gbc.gridx = 1;
        add(rightPanel, gbc);

        // LEFT PANEL
        GridBagConstraints l = new GridBagConstraints();
        l.fill = GridBagConstraints.HORIZONTAL;
        l.insets = new Insets(5, 5, 5, 5);
        l.weightx = 1;

        l.gridx = 0; l.gridy = 0;
        leftPanel.add(inputPanel("製品コード", fields.seihin), l);

        l.gridy++;
        leftPanel.add(inputPanel("商品コード", fields.shouhin), l);

        l.gridy++;
        leftPanel.add(inputPanel("品番", fields.shinaban), l);

        l.gridy++;
        leftPanel.add(inputPanel("品名", fields.shinamei), l);

        l.gridy++;
        leftPanel.add(inputPanel("数量（以下）", fields.suuryo), l);

        // RIGHT PANEL
        GridBagConstraints r = new GridBagConstraints();
        // NEW UI
        r.gridy++;
        rightPanel.add(checkPanel(fields.chk1), r);

        r.gridy++;
        rightPanel.add(checkPanel(fields.chk2), r);

        r.gridy++;
        rightPanel.add(checkPanel(fields.radio), r);

        r.gridy++;
        rightPanel.add(selectPanel("セレクト", fields.select), r);

        setBorder(BorderFactory.createLineBorder(border));
    }

    private JPanel inputPanel(String label, JTextField field) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(230, 243, 247));
        panel.setBorder(BorderFactory.createLineBorder(border));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        gbc.gridx = 0;
        panel.add(new JLabel(label + ":"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(field, gbc);

        return panel;
    }

    private JPanel checkPanel(JComponent comp) {
        JPanel p = new JPanel();
        p.add(comp);
        return p;
    }

    private JPanel selectPanel(String label, JComboBox<String> box) {
        JPanel p = new JPanel();
        p.add(new JLabel(label + ": "));
        p.add(box);
        return p;
    }
}
