package View.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RootLayoutController implements Initializable {
	@FXML
	private AnchorPane mainPane;

	@FXML
	public void makeMember(ActionEvent event) {
		try {
			AnchorPane memberPane = FXMLLoader.load(getClass().getResource("/View/MakeMember.fxml"));
			mainPane.getChildren().setAll(memberPane);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
}
