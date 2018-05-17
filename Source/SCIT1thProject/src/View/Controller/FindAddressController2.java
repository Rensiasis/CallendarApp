package View.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Parser.SearchPostNumber;
import VO.Address;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class FindAddressController2 implements Initializable {

	@FXML
	private TextField Input_address2;

	@FXML
	private Button Input_add_btn;

	@FXML
	private Button Chk_address_btn;

	@FXML
	private MenuItem Choose_add;

	@FXML
	private ListView<Address> Add_list;

	@FXML
	private Label resultLabel;

	@FXML
	public void Click_find_add(ActionEvent event) {
		ObservableList<Address> addlist = FXCollections.observableArrayList();
		SearchPostNumber spn = new SearchPostNumber();
		ArrayList<Address> aList = spn.searchAddress(Input_address2.getText());
		resultLabel.setText("총 " + spn.getTotalCount() + "개의 검색결과가 있습니다.");
		for (int i = 0; i < aList.size(); i++) {
			addlist.add(aList.get(i));
		}
		Add_list.setItems(addlist);
	}

	@FXML
	public void addressInput(ActionEvent event) {
		if (Add_list.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("주소 검색 에러");
			alert.setHeaderText("주소 선택 안함.");
			alert.setContentText("주소를 선택해주시기 바랍니다.");
			alert.showAndWait();
		} else {
			Platform.runLater(new Runnable() {
				Address selectedAddress = Add_list.getSelectionModel().getSelectedItem();

				@Override
				public void run() {
					// TODO Auto-generated method stub
					View.Controller.CorrectMemController.staticPostNo.setText(selectedAddress.getPostNumber());
					View.Controller.CorrectMemController.staticAddress.setText(selectedAddress.getNewAddress());
					View.Controller.CorrectMemController.oldAddress = selectedAddress.getOldAddress();
					View.Controller.CorrectMemController.stage.close();
				}

			});
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Input_address2.setOnKeyPressed(event -> {
			switch (event.getCode()) {
			case ENTER:
				ObservableList<Address> addlist = FXCollections.observableArrayList();
				SearchPostNumber spn = new SearchPostNumber();
				ArrayList<Address> aList = spn.searchAddress(Input_address2.getText());
				resultLabel.setText("총 " + spn.getTotalCount() + "개의 검색결과가 있습니다.");
				for (int i = 0; i < aList.size(); i++) {
					addlist.add(aList.get(i));
				}
				Add_list.setItems(addlist);
				break;
			}
		});
	}

}
