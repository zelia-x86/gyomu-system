package com.gyomu.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Listener implements ActionListener {

  private Database db;
  private Table table;
  private Fields fields;
  private JFrame parent;
  private JLabel uuid;
  private boolean editState;

  public Listener (Database db, Table table, Fields fields, JFrame parent, JLabel uuid) {
    this.fields = fields;
    this.db = db;
    this.table = table;
    this.parent = parent;
    this.uuid = uuid;
    this.editState = false;
    
  }
 
  @Override
  public void actionPerformed(ActionEvent e) {
    // button router
    switch (e.getActionCommand()) {
      case "search":
        search();
        break;
      case "send":
        entry();
        break;
      case "edit":
        edit();
        break;
      case "delete":
        delete();
        break;
      default:
        break;
    }
  }

  private void search () {
    if (fields.suuryo.getInt() < 1)
      fields.suuryo.setText("100");

    this.table.clearRows();
    for (String[] et : db.searchName (
      fields.seihin.getText(),
      fields.shouhin.getText(),
      fields.shinamei.getText(),
      fields.shinaban.getText(),
      fields.suuryo.getInt()
    ))
      this.table.insertRows(et);        
  }

  private void entry () {
    if (!this.db.entry(
      fields.seihin.getText(),
      fields.shouhin.getText(),
      fields.shinamei.getText(),
      fields.shinaban.getText(),
      fields.suuryo.getInt()
    ))
      JOptionPane.showMessageDialog(parent, "正しく入力してください");
  }
  
  private void edit () {

    int row = table.table.getSelectedRow();

    if (row < 0) {
      error("エントリーを選択してください。");
      return;
    }

    


    if (!this.db.edit (
      this.uuid.getText(),
      fields.seihin.getText(),
      fields.shouhin.getText(),
      fields.shinamei.getText(),
      fields.shinaban.getText(),
      fields.suuryo.getInt()
    ))
      JOptionPane.showMessageDialog(parent, "正しく入力してください");
  }

  private void delete () {
    String uuid = table.getUUID();
    if (db.delete (uuid))
      search();
    else
      error("アイテムを選択してください");
  }

  private void error(String message) {
    JOptionPane.showMessageDialog(parent, message);
  }
}
