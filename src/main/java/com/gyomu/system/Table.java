package com.gyomu.system;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
// import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Table extends AbstractTableModel {

  private List<String[]> rows;
  private Database db;
  private JLabel uuid;
  private Fields fields;
  private boolean rowSelected;

  public JScrollPane panel;
  public JTable table;


  public Table (Database db, JLabel uuid, Fields fields) {
    this.rows = new ArrayList<String[]>();
    this.db = db;
    this.uuid = uuid;
    this.fields = fields;
    this.rowSelected = false;
    table = new JTable(this);
    panel = new JScrollPane(this.table);

    // selection
    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    ListSelectionModel selection = table.getSelectionModel();
    selection.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) return;
        int row = table.getSelectedRow();
        if (row < 0) {
          rowSelected = false;
          // fields.seihin.setText(fields.seihin.defaultText);
          table.clearSelection();
        } else {
          rowSelected = true;
          uuid.setText(getUUID());
          // fields.seihin.setText(rows.get(row)[1]);
        }
      }
    });
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
    return this.rows.get(rowIndex)[columnIndex + 1];
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

  public String getUUID () {
    int row = table.getSelectedRow();
    if (row < 0) return null;
    return this.rows.get(row)[0];
  }

  // public boolean updateUUID () {
  //   boolean ret = false;
  //   int row = table.getSelectedRow();
  //   if (row >= 0) {
  //     uuid.setText(getUUID());
  //     ret = true;
  //   return false;
  // }
}
