import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.cell.*;
import javafx.collections.*;
import javafx.beans.*;
import javafx.beans.property.*;
import javafx.beans.value.*;

public class GUITest extends Application {

	private TextField searchText;
	private Button searchBt;
	private ComboBox<String> locales;
	private TableView<RowData> table;
	private VBox menus;
	private HBox windowTop;
	private BorderPane bp;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		searchBt = new Button("検索");
		searchText = new TextField();
		menus = new VBox();
		windowTop = new HBox();
		bp = new BorderPane();
		table = new TableView<GUITest.RowData>();
		locales = new ComboBox<String>();

		// 絞り込みコンボボックス用のメニュー
		ObservableList<String> ol2 = FXCollections.observableArrayList("Lasvegas", "Tokyo", "NewYork", "Sydney");
		locales.setItems(ol2);
		// ここから属性名の定義
		// とりあえず日付，地域，震度，マグニチュード

		TableColumn<RowData, String> tc1 = new TableColumn<RowData, String>("日時");
		TableColumn<RowData, String> tc2 = new TableColumn<RowData, String>("地域");
		TableColumn<RowData, String> tc3 = new TableColumn<RowData, String>("震度");
		TableColumn<RowData, String> tc4 = new TableColumn<RowData, String>("マグニチュード");
		// プロパティの対応付け
		tc1.setCellValueFactory(new PropertyValueFactory<RowData, String>("date"));
		tc2.setCellValueFactory(new PropertyValueFactory<RowData, String>("locale"));
		tc3.setCellValueFactory(new PropertyValueFactory<RowData, String>("level"));
		tc4.setCellValueFactory(new PropertyValueFactory<RowData, String>("magnitude"));

		// テーブルの中身の定義．これはあくまでプロトタイプなのでベタ打ちだけど，実際にはPostgreから持ってくる．
		ObservableList<RowData> ol = FXCollections.observableArrayList();
		ol.add(new RowData("2049-10-02", "Lasvegas", 2, 10));
		ol.add(new RowData("2051-10-02", "Tokyo", 5, 10));
		ol.add(new RowData("2077-10-02", "NewYork", 1, 1));
		ol.add(new RowData("2088-10-02", "Sydney", 2, 10));
		// テーブルに列を設定
		table.getColumns().add(tc1);
		table.getColumns().add(tc2);
		table.getColumns().add(tc3);
		table.getColumns().add(tc4);
		// テーブルにデータを設定
		table.setItems(ol);

		menus.getChildren().add(searchText);
		menus.getChildren().add(locales);
		windowTop.getChildren().add(menus);
		windowTop.getChildren().add(searchBt);

		bp.setTop(windowTop);
		bp.setBottom(table);

		Scene sc = new Scene(bp, 640, 480);
		stage.setScene(sc);
		stage.setTitle("プロトタイプ");
		stage.show();
	}

	public class RowData {
		private final SimpleStringProperty date;
		private final SimpleStringProperty locale;
		private final IntegerProperty level;
		private final SimpleIntegerProperty magnitude;

		public RowData(String date, String locale, Integer level, Integer Magnitude) {
			this.date = new SimpleStringProperty(date);
			this.locale = new SimpleStringProperty(locale);
			this.level = new SimpleIntegerProperty(level);
			this.magnitude = new SimpleIntegerProperty(Magnitude);
		}

		public StringProperty dateProperty() {
			return date;
		}

		public StringProperty localeProperty() {
			return locale;
		}

		public IntegerProperty levelProperty() {
			return level;
		}

		public IntegerProperty magnitudeProperty() {
			return magnitude;
		}
	}

}
