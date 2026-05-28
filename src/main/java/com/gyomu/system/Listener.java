package com.gyomu.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {

    private final Database db;
    private final Table table;
    private final Fields fields;

    public Listener(Database db, Table table, Fields fields) {
        this.db = db;
        this.table = table;
        this.fields = fields;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // ==========================
        // LEFT SIDE INPUTS
        // ==========================
        String seihin   = fields.seihin.getText();
        String shouhin  = fields.shouhin.getText();
        String shinaban = fields.shinaban.getText();
        String shinamei = fields.shinamei.getText();

        int suuryo = Integer.MAX_VALUE;
        try {
            if (!fields.suuryo.getText().isBlank()) {
                suuryo = Integer.parseInt(fields.suuryo.getText());
            }
        } catch (NumberFormatException ex) {
            suuryo = Integer.MAX_VALUE;
        }

        // ==========================
        // RIGHT SIDE INPUTS
        // ==========================
        int check1 = fields.chk1.isSelected() ? 1 : 0;
        int check2 = fields.chk2.isSelected() ? 1 : 0;
        String radio = fields.radio.isSelected() ? "ON" : "";
        String select = fields.select.getSelectedItem().toString();

        // ==========================
        // DATABASE SEARCH
        // ==========================
        var results = db.searchName(
                seihin,
                shouhin,
                shinaban,
                shinamei,
                suuryo,
                check1,
                check2,
                radio,
                select
        );

        // ==========================
        // UPDATE TABLE
        // ==========================
        table.update(results);
    }
}
