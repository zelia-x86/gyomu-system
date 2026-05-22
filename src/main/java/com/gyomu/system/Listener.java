package com.gyomu.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {

  private Database db;
  private Table table;
  private Fields fields;

  public Listener (Database db, Table table, Fields fields) {
    this.fields = fields;
    this.db = db;
    this.table = table;
  }
 
  @Override
  public void actionPerformed(ActionEvent e) {
    // button router
    switch (e.getActionCommand()) {
      case "search":
        this.table.clearRows();
        for (String[] et : db.searchName(
          fields.seihin.getText(),
          fields.shouhin.getText(),
          fields.shinamei.getText(),
          fields.shinaban.getText(),
          Integer.parseInt(fields.suuryo.getText())
        ))
          this.table.insertRows(et);        
        break;
    
      default:
        break;
    }    
  }
  
}
