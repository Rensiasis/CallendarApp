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
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalendarController implements Initializable {
	@FXML
	private GridPane gridPane;
	@FXML
	private Label year;
	@FXML
	private Label month;
	@FXML
	private Button yearAfter;
	@FXML
	private Button yearBefore;
	@FXML
	private Button monthAfter;
	@FXML
	private Button monthBefore;
	@FXML
	private Label day1;
	@FXML
	private Label day2;
	@FXML
	private Label day3;
	@FXML
	private Label day4;
	@FXML
	private Label day5;
	@FXML
	private Label day6;
	@FXML
	private Label day7;
	@FXML
	private Label day8;
	@FXML
	private Label day9;
	@FXML
	private Label day10;
	@FXML
	private Label day11;
	@FXML
	private Label day12;
	@FXML
	private Label day13;
	@FXML
	private Label day14;
	@FXML
	private Label day15;
	@FXML
	private Label day16;
	@FXML
	private Label day17;
	@FXML
	private Label day18;
	@FXML
	private Label day19;
	@FXML
	private Label day20;
	@FXML
	private Label day21;
	@FXML
	private Label day22;
	@FXML
	private Label day23;
	@FXML
	private Label day24;
	@FXML
	private Label day25;
	@FXML
	private Label day26;
	@FXML
	private Label day27;
	@FXML
	private Label day28;
	@FXML
	private Label day29;
	@FXML
	private Label day30;
	@FXML
	private Label day31;
	@FXML
	private Label day32;
	@FXML
	private Label day33;
	@FXML
	private Label day34;
	@FXML
	private Label day35;
	@FXML
	private Label day36;
	@FXML
	private Label day37;
	@FXML
	private Label day38;
	@FXML
	private Label day39;
	@FXML
	private Label day40;
	@FXML
	private Label day41;
	@FXML
	private Label day42;

	private Label[] labelList;

	private Map<Integer, ArrayList<Day>> calList;

	@FXML
	private AnchorPane calendarPane;

	@FXML
	public void btnExitAction(ActionEvent event) {
		System.exit(0);
	}

	public static Stage stage;

	@FXML
	public void btnLogout(ActionEvent event) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					AnchorPane memberPane = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
					Client.MainApp.primaryStage.setHeight(420);
					Client.MainApp.primaryStage.setWidth(600);
					Client.MainApp.primaryStage.setX(100);
					Client.MainApp.primaryStage.setY(100);
					calendarPane.getChildren().setAll(memberPane);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	@FXML // 메뉴바 회원정보 수정
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

	@FXML // 메뉴바 가계부설정
	public void btnHhManage(ActionEvent event) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {
					AnchorPane memberPane = FXMLLoader.load(getClass().getResource("/View/ManageHH.fxml"));
					Scene scene = new Scene(memberPane);
					stage = new Stage();
					stage.setScene(scene);
					stage.setTitle("가계부 설정");
					stage.setResizable(false);
					stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		labelList = new Label[42];
		labelList[0] = day1;
		labelList[1] = day2;
		labelList[2] = day3;
		labelList[3] = day4;
		labelList[4] = day5;
		labelList[5] = day6;
		labelList[6] = day7;
		labelList[7] = day8;
		labelList[8] = day9;
		labelList[9] = day10;
		labelList[10] = day11;
		labelList[11] = day12;
		labelList[12] = day13;
		labelList[13] = day14;
		labelList[14] = day15;
		labelList[15] = day16;
		labelList[16] = day17;
		labelList[17] = day18;
		labelList[18] = day19;
		labelList[19] = day20;
		labelList[20] = day21;
		labelList[21] = day22;
		labelList[22] = day23;
		labelList[23] = day24;
		labelList[24] = day25;
		labelList[25] = day26;
		labelList[26] = day27;
		labelList[27] = day28;
		labelList[28] = day29;
		labelList[29] = day30;
		labelList[30] = day31;
		labelList[31] = day32;
		labelList[32] = day33;
		labelList[33] = day34;
		labelList[34] = day35;
		labelList[35] = day36;
		labelList[36] = day37;
		labelList[37] = day38;
		labelList[38] = day39;
		labelList[39] = day40;
		labelList[40] = day41;
		labelList[41] = day42;

		gridPane.setGridLinesVisible(true);
		gridPane.setAlignment(Pos.TOP_LEFT);

		yearAfter.setOnMouseClicked(event -> yearAfter());
		yearBefore.setOnMouseClicked(event -> yearBefore());
		monthAfter.setOnMouseClicked(event -> monthAfter());
		monthBefore.setOnMouseClicked(event -> monthBefore());

		calList = new HashMap<>();
		makeCalandar();
	}

	public void makeCalandar() {
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int day = today.get(Calendar.DATE);
		setYearMonthLabel(year, month + 1);

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
		for (int k = 0; k < 13; k++) {
			ca.clear();
			ca.set(year + k, 0, 1);
			for (int i = 0; i < 12; i++) {
				ca.set(year + k, i, 1);
				monthly = ca.getTime();
				keyStr = format.format(monthly);
				key = Integer.parseInt(keyStr);
				calList.put(key, new ArrayList<>());
				for (int j = 1; j <= ca.getActualMaximum(Calendar.DAY_OF_MONTH); j++) {
					ca.set(Calendar.DATE, j);
					Day dayVO = new Day();
					dayVO.setDate(ca.getTime());
					calList.get(key).add(dayVO);
				}
			}
		}

		// 후년 1월 데이터
		ca.clear();
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
		/*
		 * for(Entry<Integer, ArrayList<Day>> a: calList.entrySet()) { for(int
		 * i=0;i<a.getValue().size();i++) { SimpleDateFormat format2=new
		 * SimpleDateFormat("YYYYMMdd");
		 * System.out.println(format2.format(a.getValue().get(i).getDate())); } }
		 */
		/*
		 * ArrayList<Day> arrayDay=calList.get(201906); for(int
		 * i=0;i<arrayDay.size();i++) { System.out.println(arrayDay.get(i).getDate()); }
		 */
		Date todayDate = new Date();
		keyStr = format.format(todayDate);
		refreshCalendar(keyStr);
	}

	public void refreshCalendar(String keyStr) {
		int key = Integer.parseInt(keyStr);
		ArrayList<Day> dayList = calList.get(key);
		Date firstDay = dayList.get(0).getDate();
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(firstDay);

		// 이번달 세팅
		int firstIndex = cal.get(Calendar.DAY_OF_WEEK) - 1;
		for (int i = firstIndex; i < dayList.size() + firstIndex; i++) {
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
		System.out.println(dayList);
		for (int i = 0; i < dayList.size(); i++) {
			System.out.println(dayList.get(i).getDate());
		}
		for (int i = 0; i < firstIndex; i++) {
			Calendar calendar = Calendar.getInstance();
			calendar.clear();
			calendar.setTime(dayList.get(dayList.size() - firstIndex + i).getDate());
			labelList[i].setText(calendar.get(Calendar.DATE) + "");
		}

		// 다음달 세팅
		if (cal.get(Calendar.MONTH) == 12) {
			cal.set(cal.get(Calendar.YEAR) + 1, 1, 1);
		}
		cal.add(Calendar.MONTH, 1);
		monthly = cal.getTime();
		keyStr = format.format(monthly);
		key = Integer.parseInt(keyStr);
		dayList = calList.get(key);
		for (int i = lastIndex; i < 42; i++) {
			labelList[i].setText((int) (i - lastIndex + 1) + "");
		}
	}

	public void setYearMonthLabel(int year, int month) {
		this.year.setText(year + "");
		this.month.setText(month + "");
	}

	@FXML
	public void monthAfter() {
		String keyStr = "";
		int month = Integer.parseInt(this.month.getText());
		int year = Integer.parseInt(this.year.getText());
		month = month + 1;
		if (month > 12) {
			month = 1;
			year++;
		}
		if (year > 2030) {
			return;
		}
		if (month < 10) {
			keyStr += Integer.toString(year) + "0" + Integer.toString(month);
		} else {
			keyStr += Integer.toString(year) + Integer.toString(month);
		}
		int key = Integer.parseInt(keyStr);
		if (calList.get(key) != null) {
			refreshCalendar(keyStr);
		}
		this.year.setText(year + "");
		this.month.setText(month + "");
	}

	@FXML
	public void monthBefore() {
		String keyStr = "";
		int month = Integer.parseInt(this.month.getText());
		int year = Integer.parseInt(this.year.getText());
		month = month - 1;
		if (month < 1) {
			month = 12;
			year--;
		}
		if (year < 2018) {
			return;
		}
		if (month < 10) {
			keyStr += Integer.toString(year) + "0" + Integer.toString(month);
		} else {
			keyStr += Integer.toString(year) + Integer.toString(month);
		}
		int key = Integer.parseInt(keyStr);
		if (calList.get(key) != null) {
			refreshCalendar(keyStr);
		}
		this.year.setText(year + "");
		this.month.setText(month + "");
	}

	@FXML
	public void yearAfter() {
		String keyStr = "";
		int month = Integer.parseInt(this.month.getText());
		int year = Integer.parseInt(this.year.getText());
		year = year + 1;
		if (year > 2030) {
			return;
		}
		if (month < 10) {
			keyStr += Integer.toString(year) + "0" + Integer.toString(month);
		} else {
			keyStr += Integer.toString(year) + Integer.toString(month);
		}
		int key = Integer.parseInt(keyStr);
		if (calList.get(key) != null) {
			refreshCalendar(keyStr);
		}
		this.year.setText(year + "");
	}

	@FXML
	public void yearBefore() {
		String keyStr = "";
		int month = Integer.parseInt(this.month.getText());
		int year = Integer.parseInt(this.year.getText());
		year = year - 1;
		if (year < 2018) {
			return;
		}
		if (month < 10) {
			keyStr += Integer.toString(year) + "0" + Integer.toString(month);
		} else {
			keyStr += Integer.toString(year) + Integer.toString(month);
		}
		int key = Integer.parseInt(keyStr);
		if (calList.get(key) != null) {
			refreshCalendar(keyStr);
		}
		this.year.setText(year + "");
	}
}
