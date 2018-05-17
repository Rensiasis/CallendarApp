package View.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Client.User;
import DAO.MemberDAO;
import VO.Address;
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
import javafx.scene.control.ButtonType;
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
	public static Address addressVO;
	MemberDAO dao = new MemberDAO();
	Members m_vo = new Members();
	User user = new User();

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
					addressVO = null;
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
				if (reName.getText().length() == 0 || rePassword.getText().length() == 0
						|| re_postnum.getText().length() == 0) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("회원정보 수정 오류");
					alert.setHeaderText("수정정보 미입력 오류");
					alert.setContentText("아이디, 비밀번호, 주소는 반드시 입력해주세요.");
					alert.showAndWait();
				} else {
					if (rePassword.getText().equals(rePassChk.getText())) {
						m_vo.setMember_seq(user.getUser().getMember_seq());// 로그인되어있는아이디시퀀스!
						m_vo.setId(user.getUser().getId());
						m_vo.setName(reName.getText());
						m_vo.setPassword(rePassword.getText());

						m_vo.setPostNumber(re_postnum.getText());
						m_vo.setNewAddress(re_add.getText());
						m_vo.setOldAddress(addressVO.getOldAddress());

						String[] splitadd = addressVO.getOldAddress().split("\\s");
						System.out.println(addressVO.getOldAddress());
						String city = splitadd[0];
						String county = splitadd[1];
						String village = splitadd[2];

						m_vo.setCity(city);
						m_vo.setCounty(county);
						m_vo.setVillage(village);

						m_vo.setPhone_number(re_phone.getText());
						m_vo.setEmail(re_email.getText());

						Client.User.user = m_vo;
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
			}
		});
	}

	@FXML // 달력으로 돌아가기
	public void returnCalendar(ActionEvent event) {
		View.Controller.CalendarController.stage.close();
	}

	@FXML
	public void deletemember(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("회원탈퇴");
		alert.setHeaderText("회원탈퇴 확인메세지");
		alert.setContentText("회원탈퇴를 하시겠습니까?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			String member_seq = user.getUser().getMember_seq();
			Client.Client.summit(new SocketDB("deleteID", member_seq));

			System.exit(0);

		} else {
			return;
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}
