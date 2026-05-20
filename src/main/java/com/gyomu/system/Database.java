package com.gyomu.system;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

  public String[] columns = {"No", "商品コード", "品名", "数量"};

  private String databaseUrl = "jdbc:sqlite:data/database.db";
  private Connection con = null;
  // private Statement cursor = null;
  private PreparedStatement query = null;
  // private String query_sql = "SELECT * FROM \"商品\"";
  private String query_sql = "SELECT * FROM \"商品\" WHERE \"品名\" LIKE ? LIMIT ?;";
  private String[] create_sql = {
    "DROP TABLE IF EXISTS \"商品\";",
    "CREATE TABLE \"商品\" (" + //
      "\"No\"\tINTEGER NOT NULL UNIQUE," + //
      "\"商品コード\"\tTEXT NOT NULL UNIQUE," + //
      "\"品名\"\tTEXT NOT NULL," + //
      "\"数量\"\tINTEGER NOT NULL" + //
      ");",
      "INSERT INTO \"商品\" VALUES (1,'A100','テスト商品',30);",
      "INSERT INTO \"商品\" VALUES (2,'B12','テスト',20);",
  };

  public Database () {
    File data = new File("data");
    if (!data.exists())
      data.mkdirs();
    try {
      con = DriverManager.getConnection(this.databaseUrl);
      if (con != null)
        this.create_table(con);
        this.create_cursor(con);
    } catch (SQLException e) { e.printStackTrace(); }
  }

  private void create_cursor (Connection con) {
    if (this.query == null) {
      try {
        this.query = con.prepareStatement(query_sql);
        this.query.setQueryTimeout(30);
      } catch (SQLException e) { e.printStackTrace(); }
    }
  }

  private void create_table (Connection con) {
    try {
      Statement stmt = con.createStatement();
      for (String sql : create_sql)
        stmt.execute(sql);
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public ArrayList<String[]> searchName (String name, int limit) {
    ArrayList<String[]> ret = new ArrayList<String[]>();
    try {
    this.query.setString(1, "%" + name + "%");
    this.query.setInt(2, limit);
    ResultSet rs = this.query.executeQuery();
      do {
        String[] p = new String[columns.length];
        for (int i = 0; i < p.length; i++)
          p[i] = rs.getString(i+1);
        ret.add(p);
      } while (rs.next());
    } catch (SQLException e) {};
    return ret;
  }
  
  public void close () {
    try {
      this.con.close();
    } catch (SQLException e) {}
  }
}
