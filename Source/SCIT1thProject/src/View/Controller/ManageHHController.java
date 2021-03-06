package View.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Client.User;
import DAO.MemberDAO;
import VO.Account;
import VO.SocketDB;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class ManageHHController implements Initializable {
	@FXML
	private TextField savesalary;

	@FXML
	private TextField totalmoney;

	@FXML
	private TextField monthsalary;

	@FXML
	private AnchorPane CorrectMember;

	MemberDAO dao = new MemberDAO();
	Account a_vo = new Account();
	User user = new User();

	@FXML
	public void btnExitAction(ActionEvent event) {

	}

	@FXML
	public void InputHHinfo(ActionEvent event) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (isNumber(totalmoney.getText()) && isNumber(monthsalary.getText())
						&& isNumber(savesalary.getText())) {
					a_vo.setMember_seq(user.getUser().getMember_seq());// 로그인되어있는아이디시퀀스!
					a_vo.setAccount(totalmoney.getText());
					a_vo.setMontly_salary(monthsalary.getText());
					a_vo.setMontly_save(savesalary.getText());
					a_vo.setInuser(user.getUser().getId());

					Client.Client.summit(new SocketDB("updateAccount", a_vo));
					View.Controller.CalendarController.stage.close();
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("가계부 설정 에러");
					alert.setHeaderText("정보 오류 입력");
					alert.setContentText("가계부 정보를 숫자로 입력해주세요.");
					alert.showAndWait();
				}
			}
		});

	}

	public boolean isNumber(String str) {
		boolean check = true;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') {
				check = false;
			}
		}
		return check;
	}

	@FXML
	public void returnCalendar(ActionEvent event) {
		View.Controller.CalendarController.stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
