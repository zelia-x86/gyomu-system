package com.gyomu.system;

import javax.swing.JScrollPane;
import javax.swing.JTable;


public class View extends JScrollPane {
  public View (Database db, Table table) {
    super(new JTable(table));
  }
}
