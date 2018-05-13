package View.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.MemberDAO;
import VO.Members;
import VO.SocketDB;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MakeMemController implements Initializable {
	@FXML
	private AnchorPane mPane;

	@FXML
	private TextField Input_Adress;

	@FXML
	private ComboBox<String> Chk_Gender;

	@FXML
	private TextField Chk_Pass;

	@FXML
	private TextField Input_Email;

	@FXML
	private Button Chk_address;

	@FXML
	private TextField Input_Pass;

	@FXML
	private Button Return_Menu;

	@FXML
	private Button Chk_ID;

	@FXML
	private TextField Input_name;

	@FXML
	private TextField Input_ID;

	@FXML
	private Label 사용자약관;

	@FXML
	private Button Input_Member;

	@FXML
	private CheckBox Chk_true_agree;

	@FXML
	private CheckBox Chk_false_agree;

	@FXML
	private TextField Input_Phone;
	
	public static Receiver receiver;

	private Stage as;
	MemberDAO m_dao = new MemberDAO(); // DAO호출

	@FXML
	public void operand(ActionEvent event) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Members m_vo = new Members();

				if (Chk_true_agree.isSelected()) {
					if (Input_ID.getText().length() == 0 || Input_Pass.getText().length() == 0
							|| Input_Adress.getText().length() == 0 || Chk_Pass.getText().length() == 0) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("회원가입 실패");
						alert.setHeaderText("회원가입에 실패하셨습니다.");
						alert.setContentText("필수정보를 입력해주세요.(아이디, 패스워드, 주소)");
						alert.showAndWait();

					} else {
						m_vo.setId(Input_ID.getText());

						if (Input_Pass.getText().equals(Chk_Pass.getText())) {
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

						Client.Client.summit(new SocketDB("insertMember", m_vo));
						try {
							AnchorPane parent = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
							mPane.getChildren().setAll(parent);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else if(Chk_false_agree.isSelected()){
					try {
						AnchorPane parent = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
						mPane.getChildren().setAll(parent);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
		receiver=new Receiver();
		try {
			AnchorPane memberPane = FXMLLoader.load(getClass().getResource("/View/FindAddress.fxml"));
			mPane.getChildren().setAll(memberPane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	}

	@FXML
	public void ChkrepeatID(ActionEvent event) {
		if ((int) Client.Client.summit(new SocketDB("chkRepeatID", Input_ID.getText())) != 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("아이디 중복");
			alert.setHeaderText("아이디 중복 오류");
			alert.setContentText("중복되는 아이디가 존재합니다.");
			alert.showAndWait();
		}
	}

}
