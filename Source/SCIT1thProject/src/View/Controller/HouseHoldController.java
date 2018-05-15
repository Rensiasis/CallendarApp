package View.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Client.User;
import DAO.MemberDAO;
import VO.HouseHolds;
import VO.SocketDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;

public class HouseHoldController implements Initializable {
	User user = new User();
	MemberDAO dao= new MemberDAO();
	
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

	@FXML
	private TableColumn<HouseHolds, String> TVproduct;

	@FXML
	private TableColumn<HouseHolds, String> TVprice;

	@FXML
	private TableColumn<HouseHolds, String> TVdate;

	@FXML
	private TableColumn<HouseHolds, String> TVcontent;

	@FXML
	private TableView<HouseHolds> showHouseHold;

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

	@FXML
	public void btnAddTView(ActionEvent event) {
		HouseHolds hh = new HouseHolds();		
		hh.setMember_seq(user.getUser().getMember_seq());
		hh.setProduct(product.getText());
		hh.setPrice(price.getText());
		hh.setContent(content.getText());
		hh.setInuser(user.getUser().getId());
		
		dao.insertHouseHold(hh);
		
		
	}

	@FXML
	public void btnDeleteTView(ActionEvent event) {

	}

	@FXML
	public void btnCorrectTView(ActionEvent event) {

	}

}
