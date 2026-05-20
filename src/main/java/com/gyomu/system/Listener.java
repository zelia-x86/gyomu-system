package com.gyomu.system;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Listener implements ActionListener {

  private Database db;
  private Table table;
  private Component caller;
  private JTextField field;

  public Listener (Component caller, JTextField field, Database db, Table table) {
    this.caller = caller;
    this.field = field;
    this.db = db;
    this.table = table;
  }
 
  @Override
  public void actionPerformed(ActionEvent e) {
    if ( e.getSource() == this.caller ) {
      System.err.println(this.field.getText());
      for (String[] et : db.searchName("null", 10))
        this.table.insertRows(et);
    }
    
  }
  
}
