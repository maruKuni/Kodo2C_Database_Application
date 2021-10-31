import java.sql.*;
public class ConnectDB {
	private static final String url = "jdbc:postgresql://tokushima.data.ise.shibaura-it.ac.jp/al19113db";
	Connection conn;
	ResultSet rs;
	Statement stmt;//データ取得用
	PreparedStatement prestmt;//条件付きのデータ取得用
	String sql;
	public ConnectDB() throws Exception {
		// TODO 自動生成されたコンストラクター・スタブ
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection(url, "al19113", "bond");
		stmt = conn.createStatement();
	}
	void 
	public void closeDB(){
		
	}
}
