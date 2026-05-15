package com.gyomu.system;

// import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Table extends AbstractTableModel {

  private Database db;

  public Table (Database db) {
    this.db = db;
  }

  @Override
  public int getColumnCount() {
    return this.db.columns.length;
  }

  @Override
  public int getRowCount() {
      return 0;
  }

  @Override
  public String getColumnName(int column) {
    return this.db.columns[column];
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return new Object[][] {};
  }
}
