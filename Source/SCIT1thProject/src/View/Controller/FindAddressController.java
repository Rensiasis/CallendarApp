package View.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Parser.SearchPostNumber;
import VO.Address;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FindAddressController implements Initializable {

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
		Address selectedAddress = Add_list.getSelectionModel().getSelectedItem();
		View.Controller.MakeMemController.staticPostNo.setText(selectedAddress.getPostNumber());
		View.Controller.MakeMemController.staticAddress.setText(selectedAddress.getNewAddress());
		View.Controller.MakeMemController.stage.close();
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
