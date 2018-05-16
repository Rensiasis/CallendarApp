package View.Controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import VO.Schedule;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;

public class InsertDayScheduleController implements Initializable {
	@FXML
	Spinner<Integer> hour;
	@FXML
	Spinner<Integer> minute;
	@FXML
	TextArea content;
	@FXML
	Button insert;
	@FXML
	Button cancel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Calendar today = Calendar.getInstance();
		SpinnerValueFactory<Integer> hourFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23,
				today.get(Calendar.HOUR_OF_DAY));
		SpinnerValueFactory<Integer> minuteFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59,
				today.get(Calendar.MINUTE));
		hour.setValueFactory(hourFactory);
		minute.setValueFactory(minuteFactory);

		insert.setOnMouseClicked(event -> insert());
		cancel.setOnMouseClicked(event -> cancel());
	}

	public void insert() {
		Schedule vo = new Schedule();
		Calendar ca = Calendar.getInstance();
		String selectedDay = View.Controller.CalendarController.selectedDay;
		vo.setMember_seq(Client.User.user.getMember_seq());
		vo.setData_type("D");
		vo.setFrom_date(selectedDay);
		vo.setTime(Integer.toString(hour.getValue())+Integer.toString(minute.getValue()));
		vo.setContent(content.getText());
		vo.setInuser(Client.User.user.getName());
		View.Controller.CalendarController.schedule = vo;
		View.Controller.CalendarController.insertDayScheduleReceiver(vo);
		View.Controller.CalendarController.stage.close();
	}

	public void cancel() {
		View.Controller.CalendarController.stage.close();
	}

}
