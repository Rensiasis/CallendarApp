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
	private ListView contentList;
	@FXML
	private ComboBox<String> searchCombo;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		refreshList();
		add.setOnMouseClicked(event -> add());
		delete.setOnMouseClicked(event -> delete());
		fix.setOnMouseClicked(event -> fix());
		
		searchCombo.getItems().addAll(
                "최근 1개월 이내 검색",
                "최근 3개월 이내 검색",
                "최근 6개월 이내 검색",
                "최근 12개월 이내 검색",
                "특정 기간 검색");
				
		searchCombo.setValue("검색옵션");
		searchCombo.setVisibleRowCount(5);
		
	}

	public void add() {
		String product = this.product.getText();
		String price = this.price.getText();
		String content = this.price.getText();
		HouseHolds vo = new HouseHolds();
		vo.setProduct(product);
		vo.setPrice(price);
		vo.setContent(content);
		Client.Client.summit(new SocketDB("insertHouseHold", vo));
		refreshList();
	}

	public void delete() {
		HouseHolds vo = (HouseHolds) contentList.getSelectionModel().getSelectedItem();
		Client.Client.summit(new SocketDB("deleteHouseHold", vo));
		refreshList();
	}

	public void fix() {
		HouseHolds vo = (HouseHolds) contentList.getSelectionModel().getSelectedItem();
		String product = this.product.getText();
		String price = this.price.getText();
		String content = this.price.getText();
		vo.setProduct(product);
		vo.setPrice(price);
		vo.setContent(content);
		Client.Client.summit(new SocketDB("fixHouseHold", vo));
		refreshList();
	}

	public void refreshList() {
		ArrayList<HouseHolds> list = (ArrayList<HouseHolds>) Client.Client.summit(new SocketDB("getAll", Client.User.getUser()));
		ObservableList observelist = FXCollections.observableList(list);
		contentList.setItems(observelist);
	}
	public void searchOptions() {
		
		/*
		String value2 = (String) searchCombo.getValue();
		String value3 = (String) searchCombo.getValue();*/
		
		//*searchCombo.setOnContextMenuRequested(event-> comboSelectedEvent(event));
		
		/*searchCombo.setOnAction((e) -> {
            System.out.println(searchCombo.getSelectionModel().getSelectedItem());;;
		*/
	}
	
	public void comboSelectedEvent(ContextMenuEvent event) {
		
		System.out.println(event.getPickResult().toString());
		System.out.println(event.getPickResult().toString());
		System.out.println(event.getPickResult().toString());
		
		
		
		
	}

}
