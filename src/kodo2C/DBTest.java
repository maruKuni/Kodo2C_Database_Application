package kodo2C;

public class DBTest {

	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		ConnectDB db = new ConnectDB();
		db.testTsunami();
		while(db.rs.next()) {
			System.out.println("code:\t" + db.rs.getString(1));
		}
		db.closeDB();
	}

}
