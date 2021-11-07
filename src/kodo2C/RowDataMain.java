package kodo2C;
import java.sql.Timestamp;
import javafx.beans.property.*;
import javafx.beans.*;
public class RowDataMain {
	//主テーブル用のデータ
	private final SimpleStringProperty date;
	private final SimpleStringProperty prefecture;
	private final SimpleStringProperty centre;
	private final SimpleStringProperty maxlv;
	private final SimpleDoubleProperty magnitude;
	private final SimpleStringProperty depth;
	private final SimpleDoubleProperty latitude;
	private final SimpleDoubleProperty longitude;
	private final SimpleIntegerProperty code;
	public RowDataMain(int code,Timestamp date, String prefecture,String centre, 
			String maxlv,double magnitude, String depth,
			double latitude, double longitude) {
		this.code = new SimpleIntegerProperty(code);
		this.date = new SimpleStringProperty(date.toString());
		this.prefecture = new SimpleStringProperty(prefecture);
		this.maxlv = new SimpleStringProperty(lvToString(maxlv));
		this.centre = new SimpleStringProperty(centre);
		this.magnitude = new SimpleDoubleProperty(magnitude);
		this.depth = new SimpleStringProperty(depth);
		this.longitude = new SimpleDoubleProperty(longitude);
		this.latitude = new SimpleDoubleProperty(latitude);
	}
	public static String lvToString(String lv) {
		if(lv.equals("5")) {
			return "5弱";
		}else if(lv.equals("6")) {
			return "5強";
		}else if(lv.equals("7")) {
			return "6弱";
		}else if(lv.equals("8")) {
			return "6強";
		}else if(lv.equals("9")) {
			return "7";
		}
		return lv;
	}
	public StringProperty dateProperty(){
		return date;
	}
	public StringProperty prefectureProperty() {
		return prefecture;
	}
	public StringProperty centreProperty() {
		return centre;
	}
	public StringProperty maxlvProperty() {
		return maxlv;
	}
	public DoubleProperty magnitudeProperty() {
		return magnitude;
	}
	public StringProperty depthProperty() {
		return depth;
	}
	public DoubleProperty longitudeProperty() {
		return longitude;
	}
	public DoubleProperty latitudeProperty() {
		return latitude;
	}
	public IntegerProperty codeProperty() {
		return code;
	}
}
