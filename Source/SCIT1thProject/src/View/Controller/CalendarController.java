package View.Controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import VO.Day;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalendarController implements Initializable {
	@FXML
	private GridPane gridPane;
	Map<Integer, ArrayList<Day>> calList;

	@FXML
	private AnchorPane calendarPane;

	@FXML
	public void btnExitAction(ActionEvent event) {
		System.exit(0);
	}

	public static Stage stage;

	@FXML
	public void btnLogout(ActionEvent event) {
		//
		// try {
		// AnchorPane memberPane =
		// FXMLLoader.load(getClass().getResource("/View/Calendar.fxml"));
		// Client.MainApp.primaryStage.setHeight(650);
		// Client.MainApp.primaryStage.setWidth(1200);
		// Client.MainApp.primaryStage.setX(30);
		// Client.MainApp.primaryStage.setY(10);
		// calendarPane.getChildren().setAll(memberPane);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	@FXML
	public void btnMemCorrect(ActionEvent event) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {
					AnchorPane memberPane = FXMLLoader.load(getClass().getResource("/View/CorrectMember.fxml"));
					Scene scene = new Scene(memberPane);
					stage = new Stage();
					stage.setScene(scene);
					stage.setTitle("회원정보 수정");
					stage.setResizable(false);
					stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	@FXML
	public void btnHhManage(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		gridPane.setGridLinesVisible(true);
		calList = new HashMap<>();
		makeCalandar();
	}

	public void makeCalandar() {
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int day = today.get(Calendar.DATE);
		Calendar ca = Calendar.getInstance();
		ca.clear();

		// 전년 12월 데이터
		ca.set(year - 1, 11, 1);
		Date monthly = ca.getTime();
		SimpleDateFormat format = new SimpleDateFormat("YYYYMM");
		String keyStr = format.format(monthly);
		int key = Integer.parseInt(keyStr);
		calList.put(key, new ArrayList<>());
		for (int i = 1; i <= ca.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			ca.set(Calendar.DATE, i);
			Day dayVO = new Day();
			dayVO.setDate(ca.getTime());
			calList.get(key).add(dayVO);
		}

		// 전체 데이터
		for (int k = 0; k <= 10; k++) {
			ca.set(year + k, 1, 1);
			for (int i = 0; i < 12; i++) {
				ca.add(Calendar.MONTH, 1);
				monthly = ca.getTime();
				keyStr = format.format(monthly);
				key = Integer.parseInt(keyStr);
				calList.put(key, new ArrayList<>());
				for (int j = 1; j <= ca.getActualMaximum(Calendar.DAY_OF_MONTH); j++) {
					ca.set(Calendar.DATE, j);
					Day dayVO = new Day();
					dayVO.setDate(ca.getTime());
					calList.get(key).add(dayVO);
					System.out.println(ca.getTime());
				}
			}
		}

		// 후년 1월 데이터
		ca.set(year + 11, 1, 1);
		monthly = ca.getTime();
		keyStr = format.format(monthly);
		key = Integer.parseInt(keyStr);
		calList.put(key, new ArrayList<>());
		for (int i = 1; i <= ca.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			ca.set(Calendar.DATE, i);
			Day dayVO = new Day();
			dayVO.setDate(ca.getTime());
			calList.get(key).add(dayVO);
		}

		Date todayDate = new Date();
		keyStr = format.format(todayDate);
		refreshCalandar(keyStr);
	}

	public void refreshCalandar(String keyStr) {
		Label[] labelList = new Label[35];
		int key = Integer.parseInt(keyStr);
		ArrayList<Day> dayList = calList.get(key);
		Date firstDay = dayList.get(0).getDate();
		Calendar cal = Calendar.getInstance();
		cal.setTime(firstDay);

		// 이번달 세팅
		int firstIndex = cal.get(Calendar.DAY_OF_WEEK) - 1;
		for (int i = firstIndex; i < dayList.size() + firstIndex; i++) {
			labelList[i] = new Label();
			labelList[i].setText((int) (i - firstIndex + 1) + "");
		}
		int lastIndex = dayList.size() + firstIndex;
		// 전달 세팅
		cal.add(Calendar.MONTH, -1);
		Date monthly = cal.getTime();
		SimpleDateFormat format = new SimpleDateFormat("YYYYMM");
		keyStr = format.format(monthly);
		key = Integer.parseInt(keyStr);
		dayList = calList.get(key);
		for (int i = 0; i < firstIndex; i++) {
			labelList[i] = new Label();
			Calendar calendar = Calendar.getInstance();
			calendar.clear();
			calendar.setTime(dayList.get(dayList.size() - 1).getDate());
			labelList[i].setText(calendar.get(Calendar.DATE) + "");
		}

		// 다음달 세팅
		cal.add(Calendar.MONTH, 2);
		monthly = cal.getTime();
		keyStr = format.format(monthly);
		key = Integer.parseInt(keyStr);
		dayList = calList.get(key);
		for (int i = lastIndex; i < 35; i++) {
			labelList[i] = new Label();
			labelList[i].setText((int) (i - lastIndex + 1) + "");
		}

		// 라벨 추가
		for (int i = 0; i < 35; i++) {
			gridPane.add(labelList[i], i % 7, 1 + (i / 7));
		}
	}
}
