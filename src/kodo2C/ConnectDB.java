package kodo2C;
import java.sql.*;

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
		sql = "select * from t_eacharealv";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
	}

	public void closeDB() throws Exception {
		stmt.close();
		prestmt.close();
		conn.close();
	}

	public static void main(String[] args) throws Exception {
		//テストスタブ
		ConnectDB test = new ConnectDB();
		test.test();
		while (test.rs.next()) {
			System.out.println(test.rs.getString("quake_area") + "\t" + test.rs.getString("quake_prefecture") + "\t"
					+ test.rs.getInt("lv"));
		}
	}

}
