package View.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Client.User;
import DAO.MemberDAO;
import VO.Account;
import VO.HouseHolds;
import VO.Members;
import VO.SocketDB;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;

public class HouseHoldController implements Initializable {
	User user = new User();
	MemberDAO dao = new MemberDAO();

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
	private AnchorPane HouseHoldPane;

	@FXML
	private ComboBox<String> searchCombo;

	@FXML
	private TextField showSpend;
	
	@FXML
	private TextField showTotalmoney;

	@FXML
	private ListView<HouseHolds> HHListView;

	public ObservableList<HouseHolds> hlist = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		String member_seq = user.getUser().getMember_seq();

		ArrayList<HouseHolds> hhList = (ArrayList<HouseHolds>) Client.Client
				.summit(new SocketDB("getHouseHoldList", member_seq));
		for (int i = 0; i < hhList.size(); i++) {
			hlist.add(hhList.get(i));
		}
		HHListView.setItems(hlist);// 리스트뷰에 가계부목록 출력하기

		Account a_result = new Account();
		a_result = (Account) Client.Client.summit(new SocketDB("getAccountInfo", member_seq));
//		String sSpend =(String)Client.Client.summit(new SocketDB("sumPrice",member_seq)); 
//		showSpend.setText(sSpend);// 소비금액
		showTotalmoney.setText(a_result.getAccount());// 총 재산

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
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (product.getText().length() == 0 && price.getText().length() == 0
						&& content.getText().length() == 0) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("가계부 추가 에러");
					alert.setHeaderText("추가 정보 미입력");
					alert.setContentText("추가할 정보를 모두 입력해 주시기 바랍니다.");
					alert.showAndWait();
				} else {
					HouseHolds hh = new HouseHolds();

					hh.setMember_seq(user.getUser().getMember_seq());
					hh.setProduct(product.getText());
					hh.setPrice(price.getText());
					hh.setContent(content.getText());
					hh.setInuser(user.getUser().getId());

					Client.Client.summit(new SocketDB("insertHouseHold", hh));
					product.clear();
					price.clear();
					content.clear();

					try {
						AnchorPane memberPane = FXMLLoader.load(getClass().getResource("/View/HouseHold.fxml"));
						HouseHoldPane.getChildren().setAll(memberPane);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

		});

	}

	@FXML
	public void btnDeleteTView(ActionEvent event) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (HHListView.getSelectionModel().getSelectedItem() != null) {
					Client.Client.summit(new SocketDB("deleteHouseHold",
							HHListView.getSelectionModel().getSelectedItem().getHousehold_seq()));
					HHListView.getItems().remove(HHListView.getSelectionModel().getSelectedIndex());
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("삭제 에러");
					alert.setHeaderText("삭제 정보 선택");
					alert.setContentText("삭제할 정보를 선택해 주시기 바랍니다.");
					alert.showAndWait();
				}

			}

		});

	}

	@FXML
	public void btnCorrectTView(ActionEvent event) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (product.getText().length() == 0 && price.getText().length() == 0
						&& content.getText().length() == 0) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("수정 에러");
					alert.setHeaderText("수정 정보 미입력");
					alert.setContentText("수정할 정보를 모두 입력해 주시기 바랍니다.");
					alert.showAndWait();
				} else {
					if (HHListView.getSelectionModel().getSelectedItem() != null) {
						HouseHolds hh = new HouseHolds();
						hh.setHousehold_seq(HHListView.getSelectionModel().getSelectedItem().getHousehold_seq());
						hh.setProduct(product.getText());
						hh.setPrice(price.getText());
						hh.setContent(content.getText());

						Client.Client.summit(new SocketDB("fixHouseHold",hh));
						product.clear();
						price.clear();
						content.clear();

						try {
							AnchorPane memberPane = FXMLLoader.load(getClass().getResource("/View/HouseHold.fxml"));
							HouseHoldPane.getChildren().setAll(memberPane);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("수정 에러");
						alert.setHeaderText("수정 정보 선택");
						alert.setContentText("수정할 정보를 선택해 주시기 바랍니다.");
						alert.showAndWait();
					}
				}
			}

		});

	}

}
