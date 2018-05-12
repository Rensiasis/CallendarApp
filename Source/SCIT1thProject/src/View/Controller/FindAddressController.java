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
	public void Click_find_add(ActionEvent event) {
		ObservableList<Address> addlist = FXCollections.observableArrayList();
		SearchPostNumber spn = new SearchPostNumber();
		ArrayList<Address> aList = spn.searchAddress(Input_address2.getText());
		for (int i = 0; i < aList.size(); i++) {
			addlist.add(aList.get(i));
		}
		Add_list.setItems(addlist);
	}

	class addressInput extends Button {
		public addressInput(String text) {

		}
	}

	@FXML
	public void addressInput(ActionEvent event) {
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
