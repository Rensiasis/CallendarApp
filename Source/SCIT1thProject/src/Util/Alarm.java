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
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("입력 에러");
		alert.setHeaderText("내용이 존재하지 않음");
		alert.setContentText("내용을 입력해주시기 바랍니다.");
		alert.showAndWait();
	}

}
