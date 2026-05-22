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

  public String[] columns = {"No", "製品コード", "商品コード", "品番", "品名", "数量"};

  private String databaseUrl = "jdbc:sqlite:data/database.db";
  private Connection con = null;
  private PreparedStatement query = null;
  private String query_sql = "SELECT * FROM \"商品\" WHERE " +
    "\"製品コード\" LIKE ? AND " +
    "\"商品コード\" LIKE ? AND " +
    "\"品番\" LIKE ? AND " +
    "\"品名\" LIKE ? AND " +
    "\"数量\" <= ? " +
    "LIMIT 1000;";
  private String[] create_sql = {
    "DROP TABLE IF EXISTS \"商品\";",
    "CREATE TABLE \"商品\" (" +
      "\"No\" INTEGER NOT NULL UNIQUE," +
      "\"製品コード\" TEXT NOT NULL," +
      "\"商品コード\" TEXT NOT NULL," +
      "\"品番\" TEXT NOT NULL," +
      "\"品名\" TEXT NOT NULL," +
      "\"数量\" INTEGER NOT NULL" +
      ");",

      "INSERT INTO \"商品\" VALUES (1,'A100','A100','A100','高品質USB-Cケーブル 1m',30);",
      "INSERT INTO \"商品\" VALUES (2,'B120','B120','B120','ワイヤレスマウス 静音タイプ',20);",
      "INSERT INTO \"商品\" VALUES (3,'C200','C200','C200','Bluetoothスピーカー 防水仕様',25);",
      "INSERT INTO \"商品\" VALUES (4,'D300','D300','D300','27インチ4Kモニター',35);",
      "INSERT INTO \"商品\" VALUES (5,'E400','E400','E400','ノートパソコンスタンド アルミ製',40);",
      "INSERT INTO \"商品\" VALUES (6,'F500','F500','F500','ゲーミングキーボード RGBライト',45);",
      "INSERT INTO \"商品\" VALUES (7,'G600','G600','G600','500GB ポータブルSSD',50);",
      "INSERT INTO \"商品\" VALUES (8,'H700','H700','H700','スマートウォッチ 心拍数計測',28);",
      "INSERT INTO \"商品\" VALUES (9,'I800','I800','I800','ノイズキャンセリングヘッドホン',32);",
      "INSERT INTO \"商品\" VALUES (10,'J900','J900','J900','モバイルバッテリー 20000mAh',60);",
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

  public ArrayList<String[]> searchName (String seihin, String shouhin,
    String shinaban, String shinamei, int suuryo)
  {
    ArrayList<String[]> ret = new ArrayList<String[]>();
    try {
    this.query.setString(1, "%" + seihin + "%");
    this.query.setString(2, "%" + shouhin + "%");
    this.query.setString(3, "%" + shinaban + "%");
    this.query.setString(4, "%" + shinamei + "%");
    this.query.setInt(5, suuryo);
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
