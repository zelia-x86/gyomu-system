package com.gyomu.system;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

public class Database {

  public String[] columns = {"製品コード", "商品コード", "品番", "品名", "数量"};

  private String databaseUrl = "jdbc:sqlite:data/database.db";
  private Connection con = null;
  private PreparedStatement query = null;
  private PreparedStatement insert = null;
  private String query_sql = "SELECT * FROM db WHERE " +
    "seihin LIKE ? AND " +
    "shouhin LIKE ? AND " +
    "shinaban LIKE ? AND " +
    "hinamei LIKE ? AND " +
    "amount <= ? " +
    "LIMIT 1000;";
  private String insert_sql = "INSERT INTO db VALUES (?, ?, ?, ?, ?, ?);";
  private String[] create_sql = {
    "DROP TABLE IF EXISTS db;",
    "CREATE TABLE db ( " +
      "uuid TEXT NOT NULL UNIQUE," +
      "seihin TEXT NOT NULL," +
      "shouhin TEXT NOT NULL," +
      "shinaban TEXT NOT NULL," +
      "hinamei TEXT NOT NULL," +
      "amount INTEGER NOT NULL" +
      ");",

      "INSERT INTO db VALUES ('A100','A100','A100','A100','高品質USB-Cケーブル 1m',30);",
      "INSERT INTO db VALUES ('B120','B120','B120','B120','ワイヤレスマウス 静音タイプ',20);",
      "INSERT INTO db VALUES ('C200','C200','C200','C200','Bluetoothスピーカー 防水仕様',25);",
      "INSERT INTO db VALUES ('D300','D300','D300','D300','27インチ4Kモニター',35);",
      "INSERT INTO db VALUES ('E400','E400','E400','E400','ノートパソコンスタンド アルミ製',40);",
      "INSERT INTO db VALUES ('F500','F500','F500','F500','ゲーミングキーボード RGBライト',45);",
      "INSERT INTO db VALUES ('G600','G600','G600','G600','500GB ポータブルSSD',50);",
      "INSERT INTO db VALUES ('H700','H700','H700','H700','スマートウォッチ 心拍数計測',28);",
      "INSERT INTO db VALUES ('I800','I800','I800','I800','ノイズキャンセリングヘッドホン',32);",
      "INSERT INTO db VALUES ('J900','J900','J900','J900','モバイルバッテリー 20000mAh',60);",
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
    if (this.insert == null) {
      try {
        this.insert = con.prepareStatement(insert_sql);
        this.insert.setQueryTimeout(30);
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
    create_cursor(this.con);
    ArrayList<String[]> ret = new ArrayList<String[]>();
    try {
      this.query.clearParameters();
      this.query.setString(1, "%" + seihin + "%");
      this.query.setString(2, "%" + shouhin + "%");
      this.query.setString(3, "%" + shinaban + "%");
      this.query.setString(4, "%" + shinamei + "%");
      this.query.setInt(5, suuryo);
      ResultSet rs = this.query.executeQuery();
      do {
        String[] p = new String[columns.length + 1];
        for (int i = 0; i < p.length; i++)
          p[i] = rs.getString(i+1);
        ret.add(p);
      } while (rs.next());
    } catch (SQLException e) {};
    return ret;
  }

  public boolean entry(String seihin, String shouhin,
    String shinaban, String shinamei, int suuryo)
  {
    if (
      suuryo < 1
      || seihin.isBlank()
      || shouhin.isBlank()
      || shinaban.isBlank()
      || shinamei.isBlank()
    )
      return false;
    this.create_cursor(this.con);
    String uuid = UUID.randomUUID().toString()
      .replace("-", "").substring(0, 8).toUpperCase();
    try {
      this.insert.clearParameters();
      this.insert.setString(1, uuid);
      this.insert.setString(2, seihin);
      this.insert.setString(3, shouhin);
      this.insert.setString(4, shinaban);
      this.insert.setString(5, shinamei);
      this.insert.setInt(6, suuryo);
      this.insert.executeUpdate();
    } catch (SQLException e) {
      return false;
    }
    return true;
  }

  public boolean edit (
    String uuid,
    String seihin, String shouhin,
    String shinaban, String hinamei,
    int amount
  ) {
    String sql = "UPDATE db SET ;" +
      "seihin = ?,"
    boolean ret = false;
    try {
      PreparedStatement cursor = this.con.prepareStatement(sql);
    } catch (SQLException e) {e.printStackTrace();}
    return ret;
  }

  public boolean delete (String uuid) {
    String sql = "DELETE FROM db WHERE uuid = ?;";

    boolean ret = false;
    try {
      PreparedStatement cursor = con.prepareStatement(sql, new String[] {uuid});
      if (cursor.executeUpdate() == 1)
        ret = true;
    } catch (SQLException e) {e.printStackTrace();}
    return ret;
  }
  
  public void close () {
    try {
      this.con.close();
    } catch (SQLException e) {}
  }
}
