package View.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import VO.HouseHolds;
import VO.SocketDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;

public class HouseHoldController implements Initializable {
	@FXML
	private TextField product;
	@FXML
	private TextField price;
	@FXML
	private TextArea content;
	@FXML
	private Button add;
	@FXML
	private Button delete;
	@FXML
	private Button fix;

	@FXML
	private ComboBox<String> searchCombo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		searchCombo.getItems().addAll("최근 1개월 이내 검색", "최근 3개월 이내 검색", "최근 6개월 이내 검색", "최근 12개월 이내 검색", "특정 기간 검색");

		searchCombo.setValue("검색옵션");
		searchCombo.setVisibleRowCount(5);

	}

	public void comboSelectedEvent(ContextMenuEvent event) {

		System.out.println(event.getPickResult().toString());
		System.out.println(event.getPickResult().toString());
		System.out.println(event.getPickResult().toString());

	}

}
