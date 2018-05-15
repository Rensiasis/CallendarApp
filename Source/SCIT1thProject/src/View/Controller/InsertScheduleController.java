package View.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class InsertScheduleController implements Initializable {
	@FXML
	DatePicker to;
	@FXML
	DatePicker from;
	@FXML
	TextArea content;
	@FXML
	Button insert;
	@FXML
	Button cancel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		insert.setOnMouseClicked(event -> insert());
		insert.setOnMouseClicked(event -> cancel());
	}
	
	public void insert() {
		View.Controller.CalendarController.stage.close();
	}
	
	public void cancel() {
		View.Controller.CalendarController.stage.close();
	}
}
