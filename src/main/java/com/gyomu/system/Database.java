package com.gyomu.system;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

  private String databaseUrl = "jdbc:sqlite:data/database.db";
  private Connection con = null;
  private Statement cursor = null;
  private String create_sql = "DROP TABLE \"商品\";\r\n" + //
        "CREATE TABLE \"商品\" (\r\n" + //
        "\t\"No\"\tINTEGER NOT NULL UNIQUE,\r\n" + //
        "\t\"商品コード\"\tTEXT NOT NULL UNIQUE,\r\n" + //
        "\t\"品名\"\tTEXT NOT NULL,\r\n" + //
        "\t\"数量\"\tINTEGER NOT NULL\r\n" + //
        ");";

  public Database () {
    File data = new File("data");
    if (!data.exists())
      data.mkdirs();
    try {
      this.con = DriverManager.getConnection(this.databaseUrl);
      this.con.close();
    } catch (SQLException e) { e.printStackTrace(); }
  }

  void create_cursor () {
    if (this.cursor == null) {
      try {
        this.cursor = this.con.createStatement();
        this.cursor.setQueryTimeout(30);
      } catch (SQLException e) { e.printStackTrace(); }
    }
  }

  void create_table (Statement cursor) {
    try {
      cursor.executeUpdate(create_sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  ResultSet query (String sql) {
    try {
      return this.cursor.executeQuery(sql);
    } catch (SQLException e) { e.printStackTrace(); }
    return null;
  }

  
  void update (String sql) {
    try {
      this.cursor.executeUpdate(sql);
    } catch (SQLException e) { e.printStackTrace(); }
  }
  
  void exec (String sql) {
    try {
      this.cursor.execute(sql);
    } catch (SQLException e) { e.printStackTrace(); }
  }
  
}
