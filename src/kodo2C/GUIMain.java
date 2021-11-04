package kodo2C;

import java.time.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.cell.*;
import javafx.collections.*;
public class GUIMain extends Application{
	private ComboBox<String> prefecture;
	private ComboBox<String> upperLevels;
	private ComboBox<String> lowerLevels;
	private DatePicker upperDate;
	private DatePicker lowerDate;
	private TextField upperMagnitude;
	private TextField lowerMagnitude;
	private Button search;
	private TableView<RowDataMain> mainTable;
	private TableView<RowDataSub> subTable;
	private TableView<RowDataTsunami> tsunamiTable;
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage arg0) throws Exception {
		initComponents();
		layoutComponents(arg0);
		layoutComponents(arg0);
		arg0.setTitle("地震災害データベース");
		arg0.show();
	}
	private void initComponents() {
		setLevelsList();
		setPrefectureList();
		upperMagnitude = new TextField();
		lowerMagnitude = new TextField();
		upperMagnitude.setPrefColumnCount(5);
		lowerMagnitude.setPrefColumnCount(5);
		search = new Button("検索");
		upperDate = new DatePicker(LocalDate.now());
		lowerDate = new DatePicker(LocalDate.of(1900, 1, 1));
		initTables();
	}
	private void setPrefectureList() {
		prefecture=new ComboBox<String>();
		prefecture.setItems(FXCollections.observableArrayList(
				"北海道",
				"青森県",
				"岩手県",
				"宮城県",
				"秋田県",
				"山形県",
				"福島県",
				"茨城県",
				"栃木県",
				"群馬県",
				"埼玉県",
				"千葉県",
				"東京都",
				"神奈川県",
				"新潟県",
				"富山県",
				"石川県",
				"福井県",
				"山梨県",
				"長野県",
				"岐阜県",
				"静岡県",
				"愛知県",
				"三重県",
				"滋賀県",
				"京都府",
				"大阪府",
				"兵庫県",
				"奈良県",
				"和歌山県",
				"鳥取県",
				"島根県",
				"岡山県",
				"広島県",
				"山口県",
				"徳島県",
				"香川県",
				"愛媛県",
				"高知県",
				"福岡県",
				"佐賀県",
				"長崎県",
				"熊本県",
				"大分県",
				"宮崎県",
				"鹿児島県",
				"沖縄県"));
	}
	private void setLevelsList() {
		ObservableList<String> levelList = FXCollections.observableArrayList(
				"震度1",
				"震度2",
				"震度3",
				"震度4",
				"震度5弱",
				"震度5強",
				"震度6弱",
				"震度6強",
				"震度7"
				);
		upperLevels = new ComboBox<String>();
		lowerLevels = new ComboBox<String>();
		upperLevels.setItems(levelList);
		lowerLevels.setItems(levelList);
	}
	@SuppressWarnings("unchecked")
	private void initTables() {
		mainTable = new TableView<RowDataMain>();
		subTable = new TableView<RowDataSub>();
		tsunamiTable = new TableView<RowDataTsunami>();
		
		TableColumn<RowDataMain, String> mainColumn1 = new TableColumn<RowDataMain, String>("日時");
		TableColumn<RowDataMain, String> mainColumn2 = new TableColumn<RowDataMain, String>("都道府県");
		TableColumn<RowDataMain, String> mainColumn3 = new TableColumn<RowDataMain, String>("震央");
		TableColumn<RowDataMain, Double> mainColumn4 = new TableColumn<RowDataMain, Double>("緯度");
		TableColumn<RowDataMain, Double> mainColumn5 = new TableColumn<RowDataMain, Double>("経度");
		TableColumn<RowDataMain, String> mainColumn6 = new TableColumn<RowDataMain, String>("最大震度");
		TableColumn<RowDataMain, Double> mainColumn7 = new TableColumn<RowDataMain, Double>("マグニチュード");
		TableColumn<RowDataMain, Double> mainColumn8 = new TableColumn<RowDataMain, Double>("深さ");
		
		mainColumn1.setCellValueFactory(new PropertyValueFactory<RowDataMain, String>("date"));
		mainColumn2.setCellValueFactory(new PropertyValueFactory<RowDataMain, String>("prefecture"));
		mainColumn3.setCellValueFactory(new PropertyValueFactory<RowDataMain, String>("centre"));
		mainColumn4.setCellValueFactory(new PropertyValueFactory<RowDataMain, Double>("latitude"));
		mainColumn5.setCellValueFactory(new PropertyValueFactory<RowDataMain, Double>("longitude"));
		mainColumn6.setCellValueFactory(new PropertyValueFactory<RowDataMain, String>("maxlv"));
		mainColumn7.setCellValueFactory(new PropertyValueFactory<RowDataMain, Double>("magnitude"));
		mainColumn8.setCellValueFactory(new PropertyValueFactory<RowDataMain, Double>("dapth"));
		
		TableColumn<RowDataSub, String> subColumn1 = new TableColumn<RowDataSub, String>("震度");
		TableColumn<RowDataSub, String> subColumn2 = new TableColumn<RowDataSub, String>("都道府県");
		TableColumn<RowDataSub, String> subColumn3 = new TableColumn<RowDataSub, String>("地域");
		
		subColumn1.setCellValueFactory(new PropertyValueFactory<RowDataSub, String>("level"));
		subColumn2.setCellValueFactory(new PropertyValueFactory<RowDataSub, String>("prefecture"));
		subColumn3.setCellValueFactory(new PropertyValueFactory<RowDataSub, String>("area"));
		
		TableColumn<RowDataTsunami, String> tsunamiColumn1 = new TableColumn<RowDataTsunami, String>("都道府県");
		TableColumn<RowDataTsunami, String> tsunamiColumn2 = new TableColumn<RowDataTsunami, String>("地域");
		TableColumn<RowDataTsunami, String> tsunamiColumn3 = new TableColumn<RowDataTsunami, String>("第1波観測時刻");
		TableColumn<RowDataTsunami, String> tsunamiColumn4 = new TableColumn<RowDataTsunami, String>("最大波高さ");
		TableColumn<RowDataTsunami, String> tsunamiColumn5 = new TableColumn<RowDataTsunami, String>("最大波到達時刻");
		
		tsunamiColumn1.setCellValueFactory(new PropertyValueFactory<RowDataTsunami, String>("prefecture"));
		tsunamiColumn2.setCellValueFactory(new PropertyValueFactory<RowDataTsunami, String>("area"));
		tsunamiColumn3.setCellValueFactory(new PropertyValueFactory<RowDataTsunami, String>("time"));
		tsunamiColumn4.setCellValueFactory(new PropertyValueFactory<RowDataTsunami, String>("maxheight"));
		tsunamiColumn5.setCellValueFactory(new PropertyValueFactory<RowDataTsunami, String>("maxtime"));
		
		mainTable.getColumns().addAll(mainColumn1, mainColumn2, mainColumn3, mainColumn4,
				mainColumn5, mainColumn6, mainColumn7, mainColumn8);
		mainTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		subTable.getColumns().addAll(subColumn1, subColumn2, subColumn3);
		subTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		tsunamiTable.getColumns().addAll(tsunamiColumn1, tsunamiColumn2,
				tsunamiColumn3, tsunamiColumn4, tsunamiColumn5);
		tsunamiTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	}
	private void layoutComponents(Stage stage) {
		HBox pre = new HBox(0.5);
		HBox lv = new HBox(0.5);
		HBox date = new HBox(0.5);
		HBox magni  = new HBox(2);
		VBox all = new VBox(0.5);
		
		pre.getChildren().addAll(new Label("都道府県:"), prefecture);
		lv.getChildren().addAll(new Label("最大震度:"), lowerLevels, new Label("～"), upperLevels);
		date .getChildren().addAll(new Label("日付:"), lowerDate, new Label("～"), upperDate);
		magni.getChildren().addAll(new Label("マグニチュード"), lowerMagnitude, new Label("～"), upperMagnitude, search);
		
		all.getChildren().addAll(pre, lv, date ,magni, mainTable, subTable, tsunamiTable);
		Scene sc = new Scene(all, 1280, 720);
		stage.setScene(sc);
	}
	private void setEvents() {
		
	}
}
