package com.gyomu.system;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class Database {

    public String[] columns = {
            "uuid", "製品コード", "商品コード", "品番", "品名", "数量",
            "チェック1", "チェック2", "ラジオ", "セレクト"
    };

    private String databaseUrl = "jdbc:sqlite:data/database.db";
    private Connection con = null;
    private PreparedStatement query = null;
    private PreparedStatement insert = null;

    private String query_sql =
            "SELECT * FROM 商品 WHERE " +
                    "製品コード LIKE ? AND " +
                    "商品コード LIKE ? AND " +
                    "品番 LIKE ? AND " +
                    "品名 LIKE ? AND " +
                    "数量 <= ? AND " +
                    "チェック1 LIKE ? AND " +
                    "チェック2 LIKE ? AND " +
                    "ラジオ LIKE ? AND " +
                    "セレクト LIKE ? " +
                    "LIMIT 1000;";

    private String insert_sql =
            "INSERT INTO 商品 VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private String[] create_sql = {
            "DROP TABLE IF EXISTS 商品;",
            "CREATE TABLE 商品 (" +
                    "uuid TEXT NOT NULL UNIQUE," +
                    "製品コード TEXT NOT NULL," +
                    "商品コード TEXT NOT NULL," +
                    "品番 TEXT NOT NULL," +
                    "品名 TEXT NOT NULL," +
                    "数量 INTEGER NOT NULL," +
                    "チェック1 INTEGER NOT NULL," +
                    "チェック2 INTEGER NOT NULL," +
                    "ラジオ TEXT NOT NULL," +
                    "セレクト TEXT NOT NULL" +
                    ");",

            // sample data
            "INSERT INTO 商品 VALUES ('A100','A100','A100','A100','高品質USB-Cケーブル 1m',30,0,0,'','');",
            "INSERT INTO 商品 VALUES ('B120','B120','B120','B120','ワイヤレスマウス 静音タイプ',20,0,0,'','');",
            "INSERT INTO 商品 VALUES ('C200','C200','C200','C200','Bluetoothスピーカー 防水仕様',25,0,0,'','');"
    };

    public Database() {
        File data = new File("data");
        if (!data.exists()) data.mkdirs();

        try {
            con = DriverManager.getConnection(this.databaseUrl);
            if (con != null) create_table(con);
            create_cursor(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void create_cursor(Connection con) {
        try {
            if (this.query == null) {
                this.query = con.prepareStatement(query_sql);
                this.query.setQueryTimeout(30);
            }
            if (this.insert == null) {
                this.insert = con.prepareStatement(insert_sql);
                this.insert.setQueryTimeout(30);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void create_table(Connection con) {
        try {
            Statement stmt = con.createStatement();
            for (String sql : create_sql) stmt.execute(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String[]> searchName(
            String seihin, String shouhin,
            String shinaban, String shinamei,
            int suuryo, int check1, int check2,
            String radio, String select) {

        create_cursor(this.con);
        ArrayList<String[]> ret = new ArrayList<>();

        try {
            this.query.clearParameters();
            this.query.setString(1, "%" + seihin + "%");
            this.query.setString(2, "%" + shouhin + "%");
            this.query.setString(3, "%" + shinaban + "%");
            this.query.setString(4, "%" + shinamei + "%");
            this.query.setInt(5, suuryo);
            this.query.setString(6, "%" + check1 + "%");
            this.query.setString(7, "%" + check2 + "%");
            this.query.setString(8, "%" + radio + "%");
            this.query.setString(9, "%" + select + "%");

            ResultSet rs = this.query.executeQuery();
            while (rs.next()) {
                String[] p = new String[columns.length];
                for (int i = 0; i < p.length; i++)
                    p[i] = rs.getString(i + 1);
                ret.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public boolean entry(
            String seihin, String shouhin,
            String shinaban, String shinamei,
            int suuryo, int check1, int check2,
            String radio, String select) {

        if (suuryo < 1 ||
                seihin.isBlank() ||
                shouhin.isBlank() ||
                shinaban.isBlank() ||
                shinamei.isBlank())
            return false;

        create_cursor(this.con);

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
            this.insert.setInt(7, check1);
            this.insert.setInt(8, check2);
            this.insert.setString(9, radio);
            this.insert.setString(10, select);

            this.insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // ==========================
    // UI FIELD CLASSES
    // ==========================

    public abstract class InnerField {
    }

    public class CheckBoxField extends InnerField {
        public JCheckBox checkBox = new JCheckBox();
    }

    public class RadioButtonField extends InnerField {
        public JRadioButton radioButton = new JRadioButton();
    }

    public class SelectField extends InnerField {
        public JComboBox<String> comboBox;

        public SelectField(String[] items) {
            comboBox = new JComboBox<>(items);
        }
    }

    public void close() {
        try {
            this.con.close();
        } catch (SQLException e) {
        }
    }
}
