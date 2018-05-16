package View.Controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import Client.User;
import DAO.MemberDAO;
import VO.HouseHolds;
import VO.SocketDB;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
	@FXML
	private DatePicker stardDay;
	@FXML
	private DatePicker endDay;

	public ObservableList<HouseHolds> hlist = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		String member_seq = user.getUser().getMember_seq();

		ArrayList<HouseHolds> hhList = (ArrayList<HouseHolds>) Client.Client
				.summit(new SocketDB("getHouseHoldList", member_seq));
		refreshList(hhList);

		if (HHListView.getSelectionModel().getSelectedItems() != null) {
			int i = (int) Client.Client.summit(new SocketDB("sumPrice", member_seq));
			int a = (int) Client.Client.summit(new SocketDB("nowtotalMoney", member_seq)) - i;

			String spendmoney = Integer.toString(i);
			String nowtotalMoney = Integer.toString(a);
			showSpend.setText(spendmoney);
			showTotalmoney.setText(nowtotalMoney);// 총 재산
		}
		;

		searchCombo.getItems().addAll("최근 1개월 이내 검색", "최근 3개월 이내 검색", "최근 6개월 이내 검색", "최근 12개월 이내 검색", "특정 기간 검색");
		searchCombo.setValue("검색옵션");
		searchCombo.setVisibleRowCount(5);

		// DatePicker 초기화
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
		String formatedDay = format.format(today);
		LocalDate localDate = LocalDate.parse(formatedDay, formatter);
		stardDay.setValue(localDate);
		endDay.setValue(localDate);

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

					try {
						AnchorPane memberPane = FXMLLoader.load(getClass().getResource("/View/HouseHold.fxml"));
						HouseHoldPane.getChildren().setAll(memberPane);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

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

						Client.Client.summit(new SocketDB("fixHouseHold", hh));
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

	@FXML
	public void exitProgram(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	public void searchComboClick(ActionEvent event) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				ArrayList<HouseHolds> hh = new ArrayList<HouseHolds>();
				int shMoney = 0;
				String shMoney2 = null;
				switch (searchCombo.getSelectionModel().getSelectedIndex()) {
				case 0:// 1개월내 검색
					hh = (ArrayList<HouseHolds>) Client.Client
							.summit(new SocketDB("searchForAMonth", user.getUser().getMember_seq()));
					refreshList(hh);
					for (int i = 0; i < hh.size(); i++) {
						shMoney += Integer.parseInt(hh.get(i).getPrice());
					}
					shMoney2 = Integer.toString(shMoney);
					showSpend.setText(shMoney2);
					break;
				case 1:// 3개월내 검색
					hh = (ArrayList<HouseHolds>) Client.Client
							.summit(new SocketDB("searchForThreeMonth", user.getUser().getMember_seq()));
					refreshList(hh);
					for (int i = 0; i < hh.size(); i++) {
						shMoney += Integer.parseInt(hh.get(i).getPrice());
					}
					shMoney2 = Integer.toString(shMoney);
					showSpend.setText(shMoney2);
					break;
				case 2:// 6개월내 검색
					hh = (ArrayList<HouseHolds>) Client.Client
							.summit(new SocketDB("searchForSixMonth", user.getUser().getMember_seq()));
					refreshList(hh);
					for (int i = 0; i < hh.size(); i++) {
						shMoney += Integer.parseInt(hh.get(i).getPrice());
					}
					shMoney2 = Integer.toString(shMoney);
					showSpend.setText(shMoney2);
					break;
				case 3:// 12개월내 검색
					hh = (ArrayList<HouseHolds>) Client.Client
							.summit(new SocketDB("searchForAnYear", user.getUser().getMember_seq()));
					refreshList(hh);
					for (int i = 0; i < hh.size(); i++) {
						shMoney += Integer.parseInt(hh.get(i).getPrice());
					}
					shMoney2 = Integer.toString(shMoney);
					showSpend.setText(shMoney2);
					break;
				case 4:// 특정기간검색
					HouseHolds vo = new HouseHolds();
					String fromDate = parseString(stardDay.getValue());
					String toDate = parseString(endDay.getValue());

					if (Integer.parseInt(fromDate) <= Integer.parseInt(toDate)) {
						vo.setMember_seq(user.getUser().getMember_seq());
						vo.setIndate(stardDay.getValue().toString());
						vo.setLdate(endDay.getValue().toString());

						hh = (ArrayList<HouseHolds>) Client.Client.summit(new SocketDB("speciPeriod", vo));
						refreshList(hh);
						for (int i = 0; i < hh.size(); i++) {
							shMoney += Integer.parseInt(hh.get(i).getPrice());
						}
						shMoney2 = Integer.toString(shMoney);
						showSpend.setText(shMoney2);
					} else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("선택 에러");
						alert.setHeaderText("날짜 선택 에러");
						alert.setContentText("오른쪽 날짜 값을 더 최근일자로 선택해 주시기 바랍니다.");
						alert.showAndWait();
					}
					break;
				}
			}
		});
	}

	public String parseString(LocalDate date) {
		return date.toString().split("-")[0] + date.toString().split("-")[1] + date.toString().split("-")[2];
	}

	public void refreshList(ArrayList<HouseHolds> List) {
		hlist.clear();
		for (int i = 0; i < List.size(); i++) {
			hlist.add(List.get(i));
		}

		HHListView.setItems(hlist);// 리스트뷰에 가계부목록 출력하기
		HHListView.refresh();
	}

}
