package View.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MakeMemController implements Initializable {
	@FXML
	private AnchorPane mPane;

	@FXML
	private TextField Input_name;

	@FXML
	private PasswordField Input_Pass;

	@FXML
	private PasswordField Chk_password;

	@FXML
	private TextField postNum;

	@FXML
	private TextField address;

	@FXML
	private TextField detailAddress;

	@FXML
	private ComboBox<String> Chk_Gender;

	@FXML
	private TextField Input_Email;

	@FXML
	private Button Chk_address;

	@FXML
	private Button Return_Menu;

	@FXML
	private Button Chk_ID;

	@FXML
	private TextField Input_ID;

	@FXML
	private Label 사용자약관;

	@FXML
	private Button Input_Member;

	@FXML
	private CheckBox Chk_true_agree;

	@FXML
	private TextField Input_Phone;

	public static Receiver receiver;
	public static Stage stage;
	public static TextField staticPostNo;
	public static TextField staticAddress;
	public static String oldAddress;

	private boolean chkID;

	// DAO호출
	MemberDAO m_dao = new MemberDAO();

	@FXML
	public void btnActionExit(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	public void operand(ActionEvent event) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Members m_vo = new Members();
				Address a_vo = new Address();

				if (Chk_true_agree.isSelected()) {
					if (Input_ID.getText().length() == 0 || Input_Pass.getText().length() == 0
							|| postNum.getText().length() == 0) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("회원가입 실패");
						alert.setHeaderText("회원가입에 실패하셨습니다.");
						alert.setContentText("필수정보를 입력해주세요.(아이디, 패스워드, 주소)");
						alert.showAndWait();

					} else if (!chkID) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("회원가입 실패");
						alert.setHeaderText("아이디 중복검사 오류");
						alert.setContentText("아이디 중복검사를 해주세요.");
						alert.showAndWait();
					} else {
						m_vo.setId(Input_ID.getText());

						if (Input_Pass.getText().equals(Chk_password.getText())) {
							m_vo.setPassword(Input_Pass.getText());
						} else {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("비밀번호 오류");
							alert.setHeaderText("비밀번호가 일치하지 않습니다.");
							alert.setContentText("다시 입력해주세요.");
							alert.showAndWait();
						}

						if (Chk_Gender.getValue().equals("남자")) {
							m_vo.setGender("M");
						} else {
							m_vo.setGender("F");
						}

						m_vo.setName(Input_name.getText());
						m_vo.setEmail(Input_Email.getText());
						m_vo.setPhone_number(Input_Phone.getText());
						m_vo.setPostNumber(postNum.getText());
						m_vo.setNewAddress(address.getText() + " " + detailAddress.getText());

						String[] splitadd = oldAddress.split("\\s");
						System.out.println(oldAddress);
						String city = splitadd[0];
						String county = splitadd[1];
						String village = splitadd[2];

						m_vo.setCity(city);
						m_vo.setCounty(county);
						m_vo.setVillage(village);

						Client.Client.summit(new SocketDB("insertMember", m_vo)); // 회원정보 DB등록

						try {
							AnchorPane parent = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
							mPane.getChildren().setAll(parent);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("사용자 약관");
					alert.setHeaderText("사용자 약관 선택 안함.");
					alert.setContentText("사용자 약관을 선택해주시기 바랍니다.");
					alert.showAndWait();
				}
			}
		});
	}

	@FXML
	public void Open_add_page(ActionEvent event) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				receiver = new Receiver();

				try {
					AnchorPane memberPane = FXMLLoader.load(getClass().getResource("/View/FindAddress.fxml"));
					staticAddress = address;
					staticPostNo = postNum;
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

	@FXML
	public void returnMenu(ActionEvent event) {
		try {
			AnchorPane parent = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
			mPane.getChildren().setAll(parent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Chk_Gender.getItems().addAll("남자", "여자");
		chkID = false;
	}

	@FXML
	public void ChkrepeatID(ActionEvent event) {
		if (Input_ID.getText().length() == 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("아이디 미입력");
			alert.setHeaderText("아이디 미입력 오류");
			alert.setContentText("아이디를 입력해주세요.");
			alert.showAndWait();
		} else {
			if (((int) Client.Client.summit(new SocketDB("chkRepeatID", Input_ID.getText()))) != 0) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("아이디 중복");
				alert.setHeaderText("아이디 중복 오류");
				alert.setContentText("중복되는 아이디가 존재합니다.");
				alert.showAndWait();
			} else {
				chkID = true;
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("아이디 중복");
				alert.setHeaderText("아이디 사용 가능");
				alert.setContentText("입력하신 아이디는 사용 가능한 아이디입니다.");
				alert.showAndWait();
			}
		}
	}

}
