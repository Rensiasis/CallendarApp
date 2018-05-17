package Util;

import java.util.TimerTask;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
		Alert timeAlert = new Alert(AlertType.ERROR);
		timeAlert.setTitle("알람");
		timeAlert.setHeaderText("내용이 존재하지 않음");
		timeAlert.setContentText("내용을 입력해주시기 바랍니다.");
		timeAlert.showAndWait();
	}

}
