package kodo2C;

import javafx.beans.property.*;

public class RowDataTsunami {
	private SimpleStringProperty prefecture;
	private SimpleStringProperty area;
	private SimpleStringProperty time;
	private SimpleStringProperty maxheight;
	private SimpleStringProperty maxtime;
	
	public RowDataTsunami(String prefecture, String area, String time, String maxheight,String  maxtime) {
		this.prefecture = new SimpleStringProperty(prefecture);
		this.area = new SimpleStringProperty(area);
		this.time = new SimpleStringProperty(time);
		this.maxtime = new SimpleStringProperty(maxtime);
		this.maxheight = new SimpleStringProperty(maxheight);
	}
	
	public StringProperty prefectureProperty() {
		return prefecture;
	}
	public StringProperty areaProperty() {
		return area;
	}
	public StringProperty timeProperty() {
		return time;
	}
	public StringProperty maxheightProperty() {
		return maxheight;
	}
	public StringProperty maxtimeProperty() {
		return maxtime;
	}
}
