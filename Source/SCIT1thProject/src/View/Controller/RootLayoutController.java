package View.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class RootLayoutController implements Initializable{
	@FXML
	private Button button;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		button.setOnAction(event->buttonAction(event));
	}
	public void buttonAction(ActionEvent event) {
		System.out.println("버튼 클릭");
	}
	
}
