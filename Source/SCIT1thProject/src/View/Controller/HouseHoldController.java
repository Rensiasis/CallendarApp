package View.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import VO.HouseHolds;
import VO.SocketDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		refreshList();
		add.setOnMouseClicked(event -> add());
		delete.setOnMouseClicked(event -> delete());
		fix.setOnMouseClicked(event -> fix());
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

}
