package kodo2C;
import javafx.beans.property.*;
import javafx.beans.*;
public class RowDataSub {
	private SimpleStringProperty level;
	private SimpleStringProperty prefecture;
	private SimpleStringProperty area;
	public RowDataSub(String level, String prefecture, String area) {
		this.level = new SimpleStringProperty(lvToString(level));
		this.prefecture = new SimpleStringProperty(prefecture);
		this.area = new SimpleStringProperty(area);
	}
	private String lvToString(String lv) {
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
	public StringProperty levelProperty() {
		return level;
	}
	public StringProperty prefectureProperty() {
		return prefecture;
	}
	public StringProperty areaProperty() {
		return area;
	}
}
