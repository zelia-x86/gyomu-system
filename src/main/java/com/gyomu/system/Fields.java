package com.gyomu.system;

import javax.swing.*;

public class Fields {

    // LEFT
    public JTextField seihin = new JTextField();
    public JTextField shouhin = new JTextField();
    public JTextField shinaban = new JTextField();
    public JTextField shinamei = new JTextField();
    public JTextField suuryo = new JTextField();


    // NEW UI COMPONENTS
    public JCheckBox chk1 = new JCheckBox("チェック1");
    public JCheckBox chk2 = new JCheckBox("チェック2");
    public JRadioButton radio = new JRadioButton("ラジオ");
    public JComboBox<String> select = new JComboBox<>(new String[]{
            "Option 1", "Option 2", "Option 3"
    });

    public Fields() {
        // optional: set sizes
        seihin.setColumns(12);
        shouhin.setColumns(12);
        shinaban.setColumns(12);
        shinamei.setColumns(12);
        suuryo.setColumns(12);
    }
}
