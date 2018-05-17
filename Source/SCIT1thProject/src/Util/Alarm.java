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
				Client.MainApp.timeAlert.setHeaderText("내용이 존재하지 않음");
				Client.MainApp.timeAlert.setContentText("내용을 입력해주시기 바랍니다.");
				Client.MainApp.timeAlert.showAndWait();
			}
		});
	}
}
