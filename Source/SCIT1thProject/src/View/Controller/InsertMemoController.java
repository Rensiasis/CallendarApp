package View.Controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import Client.User;
import Parser.WeatherPlanetParser;
import VO.Schedule;
import VO.Weather;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class InsertMemoController implements Initializable {
	@FXML
	private TextArea content;
	@FXML
	private Button insert;
	@FXML
	private Button cancel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		insert.setOnMouseClicked(event -> insert());
		cancel.setOnMouseClicked(event -> cancel());
	}

	public void insert() {
		if (!content.getText().equals("")) {
			Schedule vo = new Schedule();
			vo.setMember_seq(Client.User.user.getMember_seq());
			vo.setData_type("M");
			vo.setContent(this.content.getText());
			vo.setInuser(Client.User.user.getName());
			View.Controller.CalendarController.schedule = vo;
			View.Controller.CalendarController.insertMemoReceiver(vo);
			View.Controller.CalendarController.stage.close();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("입력 에러");
			alert.setHeaderText("내용이 존재하지 않음");
			alert.setContentText("내용을 입력해주시기 바랍니다.");
			alert.showAndWait();
		}
	}

	public void cancel() {
		View.Controller.CalendarController.stage.close();
	}

}
