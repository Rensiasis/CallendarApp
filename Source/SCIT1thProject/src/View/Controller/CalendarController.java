package View.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;

import VO.Day;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class CalendarController implements Initializable {
	@FXML
	private GridPane gridPane;
	Map<Date, ArrayList<Day>> calList;

	@FXML
	private AnchorPane calendarPane;

	@FXML
	public void btnExitAction(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	public void btnLogout(ActionEvent event) {
	}

	@FXML
	public void btnMemCorrect(ActionEvent event) {

	}

	@FXML
	public void btnHhManage(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		gridPane.setGridLinesVisible(true);
		makeCalandar();
	}

	public void makeCalandar() {
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int day = today.get(Calendar.DATE);
		Calendar ca = Calendar.getInstance();
		ca.clear();
		for (int k = 0; k <= 10; k++) {
			ca.set(year + k, 1, 1);
			for (int i = 0; i < 12; i++) {
				ca.set(Calendar.MONTH, i);
				for (int j = 1; j <= ca.getActualMaximum(Calendar.DAY_OF_MONTH); j++) {
					ca.set(Calendar.DATE, j);
					System.out.println(ca.getTime());
				}
			}
		}
	}
}
