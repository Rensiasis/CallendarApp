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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
	public Stage stage = new Stage();

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
		} 	else if(tfId.getText().length() == 0 || pfPw.getText().length() == 0) {
			lblMessage.setText(" ID 나 PASSWORD가 \n 입력되지 않았습니다! \n 다시 입력바랍니다.");
			
		}	else {
		
			lblMessage.setText(" ID 나 PASSWORD가 \n 일치하지 않거나 \n 존재하지 않습니다. \n 다시 입력바랍니다.");

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
	public void btnExitAction(ActionEvent event) {
		System.exit(0);
	}

    @FXML
    public void openHelp(ActionEvent event) {
    	Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {
					AnchorPane memberPane = FXMLLoader.load(getClass().getResource("/View/Help.fxml"));
					Scene scene = new Scene(memberPane);
					stage = new Stage();
					stage.setScene(scene);
					stage.setTitle("도움말");
					stage.setResizable(false);
					stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
    }

	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}
}
