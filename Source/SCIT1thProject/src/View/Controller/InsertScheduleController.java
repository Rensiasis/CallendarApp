package View.Controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.util.StringConverter;

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
		cancel.setOnMouseClicked(event -> cancel());
		
		// DatePicker 초기화
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Date today=new Date();
		SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd");
		String formatedDay=format.format(today);
		LocalDate localDate = LocalDate.parse(formatedDay, formatter);
		from.setValue(localDate);
		to.setValue(localDate);
	}

	public void insert() {
		String fromDate = parseString(from.getValue());
		String toDate = parseString(to.getValue());

		if (Integer.parseInt(fromDate) <= Integer.parseInt(toDate)) {
			if (!content.getText().equals("")) {
				System.out.println(from.getValue());
				System.out.println(to.getValue());

				View.Controller.CalendarController.stage.close();
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("입력 에러");
				alert.setHeaderText("내용이 존재하지 않음");
				alert.setContentText("내용을 입력해주시기 바랍니다.");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("날짜 에러");
			alert.setHeaderText("종료날짜가 시작날짜보다 빠름");
			alert.setContentText("올바른 날짜를 선택해주시기 바랍니다.");
			alert.showAndWait();
		}
	}

	public void cancel() {
		View.Controller.CalendarController.stage.close();
	}

	public String parseString(LocalDate date) {
		return date.toString().split("-")[0] + date.toString().split("-")[1] + date.toString().split("-")[2];
	}

}
