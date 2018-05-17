package Util;

import java.util.TimerTask;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Alarm extends TimerTask {
	private String message;

	public Alarm(String message) {
		super();
		this.message = message;
	}
	
	public Alarm() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				Client.MainApp.timeAlert = new Alert(AlertType.INFORMATION);
				Client.MainApp.timeAlert.setTitle("알람");
				Client.MainApp.timeAlert.setHeaderText("알람 메시지");
				Client.MainApp.timeAlert.setContentText(message);
				Client.MainApp.timeAlert.showAndWait();
			}
		});
	}
}
