package View.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CorrectMemController implements Initializable {
	@FXML
	private TextField rePassChk;

	@FXML
	private TextField re_phone;

	@FXML
	private TextField re_add;

	@FXML
	private TextField reName;

	@FXML
	private TextField rePassword;

	@FXML
	private TextField re_postnum;

	@FXML
	private TextField re_detailadd;

	@FXML
	private TextField re_email;

	@FXML
	private AnchorPane CorrectMember;

	@FXML
	void btnExitAction(ActionEvent event) {

	}

	@FXML
	void research_add(ActionEvent event) {

	}

	@FXML
	void recorrectMem(ActionEvent event) {

	}

	@FXML
	void returnCalendar(ActionEvent event) {
		View.Controller.CalendarController.stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}
