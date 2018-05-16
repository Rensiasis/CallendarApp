package View.Controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;


import VO.Schedule;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
		Schedule vo=new Schedule();
		vo.setMember_seq(Client.User.user.getMember_seq());
		vo.setData_type("M");
		vo.setContent(this.content.getText());
		vo.setInuser(Client.User.user.getName());
		View.Controller.CalendarController.schedule=vo;
		View.Controller.CalendarController.insertMemoReceiver(vo);
		View.Controller.CalendarController.stage.close();
	}

	public void cancel() {
		View.Controller.CalendarController.stage.close();
	}

}
