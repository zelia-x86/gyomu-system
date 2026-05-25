package com.gyomu.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Listener implements ActionListener {

  private Database db;
  private Table table;
  private Fields fields;
  private JFrame parent;

  public Listener (Database db, Table table, Fields fields, JFrame parent) {
    this.fields = fields;
    this.db = db;
    this.table = table;
    this.parent = parent;
  }
 
  @Override
  public void actionPerformed(ActionEvent e) {
    int suuryo =  0;
    try {
      suuryo = Integer.parseInt(fields.suuryo.getText());
    } catch (NumberFormatException ef) {}

    // button router
    switch (e.getActionCommand()) {
      case "search":
        if (suuryo == 0) {
          suuryo = 100;
          fields.suuryo.setText("" + suuryo);
        }
        this.table.clearRows();
        for (String[] et : db.searchName(
          fields.seihin.getText(),
          fields.shouhin.getText(),
          fields.shinamei.getText(),
          fields.shinaban.getText(),
          suuryo
        ))
          this.table.insertRows(et);        
        break;
      case "send":
        boolean ret = this.db.entry(
          fields.seihin.getText(),
          fields.shouhin.getText(),
          fields.shinamei.getText(),
          fields.shinaban.getText(),
          suuryo
        );
        if (!ret) {
          // todo
          JOptionPane.showMessageDialog(parent, "正しく入力してください");
        }
        break;    
      default:
        break;
    }    
  }
  
}
