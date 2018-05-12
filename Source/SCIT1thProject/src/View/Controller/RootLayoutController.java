package View.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import VO.Members;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RootLayoutController implements Initializable {
	@FXML
	Button Return_Menu;
	@FXML
	Button Input_Member;
	@FXML
	Button Chk_ID;

	@FXML
	CheckBox Chk_true_agree;
	@FXML
	CheckBox Chk_false_agree;
	@FXML
	TextField Input_ID;
	@FXML
	TextField Input_Pass;
	@FXML
	TextField Chk_Pass;
	@FXML
	TextField Input_Adress;
	@FXML
	TextField Input_Email;
	@FXML
	TextField Input_Phone;
	@FXML
	ComboBox<String> Chk_Gender;

	@FXML
	public void operand(ActionEvent event) {
		Members m_vo = new Members();
		
		Input_Pass.getText();
		Chk_Pass.getText();
		Input_Adress.getText();
		Input_Email.getText();
		Input_Phone.getText();
		
		System.out.println(Chk_Gender.getValue());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Chk_Gender.getItems().addAll("남자", "여자");
	}

}
