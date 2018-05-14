package View.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Client.User;
import DAO.MemberDAO;
import VO.Members;
import VO.SocketDB;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CorrectMemController implements Initializable {
	@FXML
	private TextField rePassChk;// 비밀번호체크

	@FXML
	private TextField re_phone;// 전화번호

	@FXML
	private TextField re_add;// 주소

	@FXML
	private TextField reName;// 이름

	@FXML
	private TextField rePassword;// 비밀번호

	@FXML
	private TextField re_postnum;// 우편번호

	@FXML
	private TextField re_detailadd;// 상세주소

	@FXML
	private TextField re_email;// 이메일

	@FXML
	private AnchorPane CorrectMember;// 앵크로팬

	public static Receiver receiver;
	public static Stage stage;
	public static TextField staticPostNo;
	public static TextField staticAddress;
	public static String oldAddress;
	MemberDAO dao = new MemberDAO();
	Members m_vo = new Members();
	User user = new User();

	@FXML // 메뉴바 프로그램 종료
	public void btnExitAction(ActionEvent event) {
		System.exit(0);
	}

	@FXML // 주소검색버튼
	public void research_add(ActionEvent event) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				receiver = new Receiver();

				try {
					AnchorPane memberPane = FXMLLoader.load(getClass().getResource("/View/FindAddress2.fxml"));
					staticAddress = re_add;
					staticPostNo = re_postnum;
					oldAddress = null;
					Scene scene = new Scene(memberPane);
					stage = new Stage();
					stage.setScene(scene);
					stage.setTitle("우편번호 검색");
					stage.setResizable(false);
					stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	@FXML // 회원정보수정버튼
	public void recorrectMem(ActionEvent event) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub

				if (rePassword.getText().equals(rePassChk.getText())) {
					m_vo.setMember_seq(user.getUser().getMember_seq());// 로그인되어있는아이디시퀀스!
					m_vo.setId(user.getUser().getId());
					m_vo.setName(reName.getText());
					m_vo.setPassword(rePassword.getText());

					m_vo.setPostNumber(re_postnum.getText());
					m_vo.setNewAddress(re_add.getText());

					String[] splitadd = oldAddress.split("\\s");
					System.out.println(oldAddress);
					String city = splitadd[0];
					String county = splitadd[1];
					String village = splitadd[2];

					m_vo.setCity(city);
					m_vo.setCounty(county);
					m_vo.setVillage(village);

					m_vo.setPhone_number(re_phone.getText());
					m_vo.setEmail(re_email.getText());

					Client.Client.summit(new SocketDB("updateMemInfo", m_vo));
					View.Controller.CalendarController.stage.close();

				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("비밀번호 오류");
					alert.setHeaderText("비밀번호가 일치하지 않습니다.");
					alert.setContentText("다시 입력해주세요.");
					alert.showAndWait();
				}
			}
		});
	}

	@FXML // 달력으로 돌아가기
	public void returnCalendar(ActionEvent event) {
		View.Controller.CalendarController.stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}
