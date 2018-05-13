package View.Controller;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import Parser.Switcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HomeController implements Initializable{

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
	private void btnLogInAction(ActionEvent event) throws Exception {


		if(tfId.getText().equals("test") && pfPw.getText().equals("test")) {

			lblMessage.setText("환영합니다! "+tfId.getText()+" 님!");

			//((Node) (event.getSource())).getScene().getWindow().hide();			 

			//new Popup("ȯ���մϴ�! "+tfId.getText()+" ��!").start(null);

			Switcher.switchWindow((Stage)logIn.getScene().getWindow(), new Calendar());
		} else {
			lblMessage.setText("ID 나 PASSWORD가 일치하지 않습니다! \n 다시 입력바랍니다.");


		}



	}

	@FXML	
	private void btnSignInAction(ActionEvent event) {

		//ȭ����ȯ ���� - ��Ʈ�ѷ��� ����
		//signIn �ڸ��� ��ư�̳� ������ ���Ե� ������Ʈ ����
		//signInb �ڸ��� ��ȯ�Ǿ����� â�� ��Ÿ���� Ŭ���� �̸� ����
		
		//Switcher.switchWindow((Stage)signIn.getScene().getWindow(), new signInb());

	}

	@FXML
	private void btnExitAction(ActionEvent event) {
		System.exit(0); 



	}

	@FXML	
	//ù ȭ������ ���ư��� �޼ҵ�
	private void backToMain(ActionEvent event) {
	}

	@FXML
	//ȸ�� ���� �������� ���� �޼ҵ�
	public void signIn(ActionEvent event) {
		
	}

	@FXML	
	//�α��� �� ���̾�� �̵�
	public void goToLogIn(ActionEvent event) {
		Switcher.switchWindow((Stage)logIn.getScene().getWindow(), new Calendar());
	}
	
	@FXML	
	//ȸ�������������� �̵�
	public void goToSignIn(ActionEvent event) {
		Switcher.switchWindow((Stage)signIn.getScene().getWindow(), new Calendar());
	}

	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}	
}
