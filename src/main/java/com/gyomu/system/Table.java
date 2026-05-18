package com.gyomu.system;

import java.util.ArrayList;
import java.util.List;

// import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Table extends AbstractTableModel {

  private List<String[]> rows;

  private Database db;

  public Table (Database db) {
    this.rows = new ArrayList<String[]>();
    this.db = db;
  }

  @Override
  public int getColumnCount() {
    return this.db.columns.length;
  }

  @Override
  public int getRowCount() {
      return this.rows.size();
  }

  @Override
  public String getColumnName(int column) {
    return this.db.columns[column];
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return this.rows.get(rowIndex)[columnIndex];
  }

  public void  updateCell (String value, int rowIndex, int columnIndex) {
    this.rows.get(rowIndex)[columnIndex] = value;
    this.fireTableCellUpdated(rowIndex, columnIndex);
  }

  public void insertRows (String[] row) {
    this.rows.add(row);
    this.fireTableDataChanged();
  }

  public void clearRows() {
    // no update
    this.rows.clear();
  }
}
