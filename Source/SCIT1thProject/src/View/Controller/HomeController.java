package View.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import DAO.MemberDAO;
import VO.Members;
import VO.SocketDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class HomeController implements Initializable {

	@FXML
	private Label lId;
	@FXML
	private Label lPassword;
	@FXML
	private Label lblMessage;
	@FXML
	private TextField tfId;
	@FXML
	private PasswordField pfPw;
	@FXML
	private Button logIn;
	@FXML
	private Button signIn;
	@FXML
	private Button exit;
	@FXML
	private AnchorPane mPane;

	MemberDAO dao = new MemberDAO();

	@FXML // 로그인버튼
	private void btnLogInAction(ActionEvent event) throws Exception {
		Members m_vo = new Members();
		m_vo.setId(tfId.getText());
		m_vo.setPassword(pfPw.getText());

		Members member = null;
		if ((member = (Members) Client.Client.summit(new SocketDB("loginID", m_vo))) != null) {

			Client.User.user = member;
			lblMessage.setText("환영합니다! " + tfId.getText() + " 님!");

			try {
				AnchorPane memberPane = FXMLLoader.load(getClass().getResource("/View/Calendar.fxml"));
				Client.MainApp.primaryStage.setHeight(678);
				Client.MainApp.primaryStage.setWidth(1200);
				Client.MainApp.primaryStage.setX(30);
				Client.MainApp.primaryStage.setY(10);
				mPane.getChildren().setAll(memberPane);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			lblMessage.setText("ID 나 PASSWORD가 일치하지 않습니다! \n 다시 입력바랍니다.");

		}

	}

	@FXML // 회원가입버튼
	private void btnSignInAction(ActionEvent event) {
		try {
			AnchorPane memberPane = FXMLLoader.load(getClass().getResource("/View/MakeMember.fxml"));
			mPane.getChildren().setAll(memberPane);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void btnExitAction(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	// 메뉴바에 FILE에 메뉴바로 돌아가는 기능
	private void backToMain(ActionEvent event) {
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}
}
