package kodo2C;
import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

public class ConnectDB {
	private static final String url = "jdbc:postgresql://tokushima.data.ise.shibaura-it.ac.jp/al19113db";
	private Connection conn;
	ResultSet rs;
	private Statement stmt = null;//データ取得用
	private PreparedStatement prestmt = null;//条件付きのデータ取得用
	private String sql;

	public ConnectDB() throws Exception {
		// TODO 自動生成されたコンストラクター・スタブ
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection(url, "al19113", "bond");
		stmt = conn.createStatement();
	}

	void test() throws Exception {
		sql = "select * from t_quake";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
	}
	void testTsunami() throws Exception{
		sql = "select * from t_tsunami;";
		rs= stmt.executeQuery(sql);
	}
	public void closeDB() throws Exception {
		stmt.close();
		//prestmt.close();
		conn.close();
	}

	public void getMainTable(UserInputs input, TableView<RowDataMain> table, ObservableList<RowDataMain> records) throws SQLException {
		compositeSQL(input);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		records.clear();
		while(rs.next()) {
			records.add(new RowDataMain(rs.getInt(1), rs.getTimestamp(2), rs.getString(3), rs.getString(4),
					rs.getString(9), rs.getDouble(7), rs.getString(8), rs.getDouble(5), rs.getDouble(6)));
		}
		table.setItems(records);
	}
	public void getSubTable(int quakeCode, TableView<RowDataSub> table, ObservableList<RowDataSub> records) throws Exception {
		//stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from t_eacharealv where quake_code = '" + Integer.toString(quakeCode)+"';");
		records.clear();
		while(rs.next()) {
			records.add(new RowDataSub(rs.getString(4), rs.getString(2), rs.getString(3)));
		}
		table.setItems(records);
	}
	public void getTsunamiTable(int quakeCode, TableView<RowDataTsunami> table, ObservableList<RowDataTsunami> records) throws SQLException {
		//stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from t_tsunami where quake_code = '" + Integer.toString(quakeCode) +"';");
		records.clear();
		while(rs.next()) {
			String firstwave;
			if(rs.getTimestamp(4)== null) {
				firstwave = "なし";
			}else {
				firstwave = rs.getTimestamp(4).toString();
			}
			records.add(new RowDataTsunami(rs.getString(2), rs.getString(3), firstwave, rs.getString(6), rs.getTimestamp(5).toString()));
		}
		table.setItems(records);
	}
	void printSQL() {
		System.out.println(sql);
	}
	private void compositeSQL(UserInputs input) {
		sql = "select * from t_quake\n";
		sql += "where maxlv between " + input.getLowerLevel() +" and " + input.getUpperLevel() +"\n";
		sql += "and quake_time between '" + input.getLowerDate().toString() + "' and '" + input.getUpperDate().toString()+"'\n";
		if(input.getUpperMagniSelected() && input.getLowerMagniSelected()) {
			sql += "and magnitude between " + input.getLowerMagni() + " and " + input.getUpperMagni()+"\n";
		}else if(input.getUpperMagniSelected()) {
			sql += "and magnitude < " + input.getUpperMagni() + "\n";
		}else if(input.getLowerMagniSelected()) {
			sql += "and magnitude > " + input.getLowerMagni() + "\n";
		}
		if(input.getPrefectureSelected()) {
			sql += "and quake_center_prefecture='" + input.getPrefecture() +"'\n";
		}
		sql += ";";
	}

}
