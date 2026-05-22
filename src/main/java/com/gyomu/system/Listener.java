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
        for (String[] et : db.searchName(this.fields.search.getText(), 10))
          this.table.insertRows(et);        
        break;
      case "goodsCodeSearch":
        this.table.clearRows();
        for (String[] et : db.searchGoodsCode(this.fields.goodsCodeField.getText(), 10))
          this.table.insertRows(et);
        break;
      case "goodsNumberSearch":
        this.table.clearRows();
        for (String[] et : db.searchGoodsNumber(this.fields.goodsNumberField.getText(), 10))
          this.table.insertRows(et);
        break;
      case "goodsNameSearch":
        this.table.clearRows();
        for (String[] et : db.searchGoodsName(this.fields.goodsNameField.getText(), 10))
          this.table.insertRows(et);
        break;
      case "goodsQuantitySearch":
        this.table.clearRows();
        for (String[] et : db.searchGoodsQuantity(this.fields.goodsQuantityField.getText(), 10))
          this.table.insertRows(et);
        break;
      default:
        break;
    }    
  }
  
}
