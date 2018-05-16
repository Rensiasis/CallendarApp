package View.Controller;

import java.io.IOException;
import java.lang.management.PlatformManagedObject;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import Client.User;
import Parser.EventDayParser;
import Parser.SearchPostNumber;
import Parser.WeatherPlanetParser;
import VO.Address;
import VO.Day;
import VO.EventDay;
import VO.HouseHolds;
import VO.Schedule;
import VO.SocketDB;
import VO.Weather;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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
	@FXML
	private TextArea textArea1;
	@FXML
	private TextArea textArea2;
	@FXML
	private TextArea textArea3;
	@FXML
	private TextArea textArea4;
	@FXML
	private TextArea textArea5;
	@FXML
	private TextArea textArea6;
	@FXML
	private TextArea textArea7;
	@FXML
	private TextArea textArea8;
	@FXML
	private TextArea textArea9;
	@FXML
	private TextArea textArea10;
	@FXML
	private TextArea textArea11;
	@FXML
	private TextArea textArea12;
	@FXML
	private TextArea textArea13;
	@FXML
	private TextArea textArea14;
	@FXML
	private TextArea textArea15;
	@FXML
	private TextArea textArea16;
	@FXML
	private TextArea textArea17;
	@FXML
	private TextArea textArea18;
	@FXML
	private TextArea textArea19;
	@FXML
	private TextArea textArea20;
	@FXML
	private TextArea textArea21;
	@FXML
	private TextArea textArea22;
	@FXML
	private TextArea textArea23;
	@FXML
	private TextArea textArea24;
	@FXML
	private TextArea textArea25;
	@FXML
	private TextArea textArea26;
	@FXML
	private TextArea textArea27;
	@FXML
	private TextArea textArea28;
	@FXML
	private TextArea textArea29;
	@FXML
	private TextArea textArea30;
	@FXML
	private TextArea textArea31;
	@FXML
	private TextArea textArea32;
	@FXML
	private TextArea textArea33;
	@FXML
	private TextArea textArea34;
	@FXML
	private TextArea textArea35;
	@FXML
	private TextArea textArea36;
	@FXML
	private TextArea textArea37;
	@FXML
	private TextArea textArea38;
	@FXML
	private TextArea textArea39;
	@FXML
	private TextArea textArea40;
	@FXML
	private TextArea textArea41;
	@FXML
	private TextArea textArea42;
	@FXML
	private ImageView weather1;
	@FXML
	private ImageView weather2;
	@FXML
	private ImageView weather3;
	@FXML
	private ImageView weather4;
	@FXML
	private ImageView weather5;
	@FXML
	private ImageView weather6;
	@FXML
	private ImageView weather7;
	@FXML
	private ImageView weather8;
	@FXML
	private ImageView weather9;
	@FXML
	private ImageView weather10;
	@FXML
	private ImageView weather11;
	@FXML
	private ImageView weather12;
	@FXML
	private ImageView weather13;
	@FXML
	private ImageView weather14;
	@FXML
	private ImageView weather15;
	@FXML
	private ImageView weather16;
	@FXML
	private ImageView weather17;
	@FXML
	private ImageView weather18;
	@FXML
	private ImageView weather19;
	@FXML
	private ImageView weather20;
	@FXML
	private ImageView weather21;
	@FXML
	private ImageView weather22;
	@FXML
	private ImageView weather23;
	@FXML
	private ImageView weather24;
	@FXML
	private ImageView weather25;
	@FXML
	private ImageView weather26;
	@FXML
	private ImageView weather27;
	@FXML
	private ImageView weather28;
	@FXML
	private ImageView weather29;
	@FXML
	private ImageView weather30;
	@FXML
	private ImageView weather31;
	@FXML
	private ImageView weather32;
	@FXML
	private ImageView weather33;
	@FXML
	private ImageView weather34;
	@FXML
	private ImageView weather35;
	@FXML
	private ImageView weather36;
	@FXML
	private ImageView weather37;
	@FXML
	private ImageView weather38;
	@FXML
	private ImageView weather39;
	@FXML
	private ImageView weather40;
	@FXML
	private ImageView weather41;
	@FXML
	private ImageView weather42;
	@FXML
	private Label contentLabel;
	@FXML
	private Button insertMemo;
	@FXML
	private Button deleteButton;
	@FXML
	private Button insertSchedule;
	@FXML
	private Button insertTodo;
	@FXML
	private ListView<Object> contentListView;

	private static Label[] labelList;
	private static TextArea[] areaList;
	private static ImageView[] weatherViewList;

	private static Map<Integer, ArrayList<Day>> calList;
	private static ListView<Object> staticListView;

	@FXML
	private AnchorPane calendarPane;

	@FXML
	public void btnExitAction(ActionEvent event) {
		System.exit(0);
	}

	public static Stage stage;
	public static Schedule schedule;

	public static String selectedDay;
	private static String selectedPage;

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

		areaList = new TextArea[42];
		areaList[0] = textArea1;
		areaList[1] = textArea2;
		areaList[2] = textArea3;
		areaList[3] = textArea4;
		areaList[4] = textArea5;
		areaList[5] = textArea6;
		areaList[6] = textArea7;
		areaList[7] = textArea8;
		areaList[8] = textArea9;
		areaList[9] = textArea10;
		areaList[10] = textArea11;
		areaList[11] = textArea12;
		areaList[12] = textArea13;
		areaList[13] = textArea14;
		areaList[14] = textArea15;
		areaList[15] = textArea16;
		areaList[16] = textArea17;
		areaList[17] = textArea18;
		areaList[18] = textArea19;
		areaList[19] = textArea20;
		areaList[20] = textArea21;
		areaList[21] = textArea22;
		areaList[22] = textArea23;
		areaList[23] = textArea24;
		areaList[24] = textArea25;
		areaList[25] = textArea26;
		areaList[26] = textArea27;
		areaList[27] = textArea28;
		areaList[28] = textArea29;
		areaList[29] = textArea30;
		areaList[30] = textArea31;
		areaList[31] = textArea32;
		areaList[32] = textArea33;
		areaList[33] = textArea34;
		areaList[34] = textArea35;
		areaList[35] = textArea36;
		areaList[36] = textArea37;
		areaList[37] = textArea38;
		areaList[38] = textArea39;
		areaList[39] = textArea40;
		areaList[40] = textArea41;
		areaList[41] = textArea42;
		
		for (int i = 0; i < 42; i++) {
			areaList[i].setEditable(false);
			areaList[i].setOnMouseClicked(event -> selectDay(event));
		}
		
		weatherViewList=new ImageView[42];
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather2;
		weatherViewList[0]=weather3;
		weatherViewList[0]=weather4;
		weatherViewList[0]=weather5;
		weatherViewList[0]=weather6;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		weatherViewList[0]=weather1;
		
		
		

		gridPane.setGridLinesVisible(true);
		gridPane.setAlignment(Pos.TOP_LEFT);

		yearAfter.setOnMouseClicked(event -> yearAfter());
		yearBefore.setOnMouseClicked(event -> yearBefore());
		monthAfter.setOnMouseClicked(event -> monthAfter());
		monthBefore.setOnMouseClicked(event -> monthBefore());

		insertMemo.setOnMouseClicked(event -> insertMemo());
		deleteButton.setOnMouseClicked(event -> delete());
		insertSchedule.setOnMouseClicked(event -> insertSchedule());
		insertTodo.setOnMouseClicked(event -> insertDaySchedule());

		calList = new HashMap<>();
		staticListView = contentListView;

		makeCalandar();
		
		setWeather();
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
		for (int k = 0; k < 5; k++) {
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
		ca.set(year + 5, 0, 1);
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

		setEventDay();
		setSchedule();

		refreshCalendar(keyStr);
	}
	
	public void setWeather() {
		WeatherPlanetParser w=new WeatherPlanetParser();
		w.setAddress(User.user.getCity(), User.user.getCounty(), User.user.getVillage());
		w.parshing();
		ArrayList<Weather> wList=w.getWeatherList();
		Date today= new Date();
		SimpleDateFormat format = new SimpleDateFormat("YYYYMM");
		String keyStr = format.format(today);
		format= new SimpleDateFormat("dd");
		String dayStr=format.format(today);
		int key=Integer.parseInt(keyStr);
		int startIndex=0;
		if (dayStr.charAt(0) == '0') {
			startIndex=Integer.parseInt(dayStr.substring(0, 1))-1;
		} else {
			startIndex=Integer.parseInt(dayStr)-1;
		}
		for(int i=0;i<wList.size();i++) {
			calList.get(key).get(startIndex++).setWeather(wList.get(i));
			if(startIndex>=calList.get(key).size()) {
				key++;
				if ((key % 100) > 12) {
					key += 100;
					key -= 12;
				}
				startIndex=0;
			}
		}
	}

	public static void refreshCalendar(String keyStr) {
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
			ArrayList<EventDay> eventList = dayList.get(i - firstIndex).getEvent();
			areaList[i].setText("");
			if (i % 7 == 0)
				labelList[i].setTextFill(Color.RED);
			else if (i % 7 == 6)
				labelList[i].setTextFill(Color.BLUE);
			else
				labelList[i].setTextFill(Color.BLACK);
			for (int j = 0; j < eventList.size(); j++) {
				if (eventList.get(j).getType().contains("h")) {
					labelList[i].setTextFill(Color.RED);
				}
				areaList[i].appendText(eventList.get(j).getName() + "\n");
			}

			ArrayList<Schedule> scheList = dayList.get(i - firstIndex).getSchedule();
			for (int j = 0; j < scheList.size(); j++) {
				areaList[i].appendText(scheList.get(j).getContent() + "\n");

			}
			
			Weather weather = dayList.get(i - firstIndex).getWeather();
			if(weather!=null) {
				weather.getSkyCode();
			}
		}
		int lastIndex = dayList.size() + firstIndex;
		// 전달 세팅
		cal.add(Calendar.MONTH, -1);
		Date monthly = cal.getTime();
		SimpleDateFormat format = new SimpleDateFormat("YYYYMM");
		keyStr = format.format(monthly);
		key = Integer.parseInt(keyStr);
		dayList = calList.get(key);
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		for (int i = 0; i < firstIndex; i++) {
			calendar.setTime(dayList.get(dayList.size() - firstIndex + i).getDate());
			labelList[i].setText(calendar.get(Calendar.DATE) + "");
			ArrayList<EventDay> eventList = dayList.get(dayList.size() - firstIndex + i).getEvent();
			areaList[i].setText("");
			if (i % 7 == 0)
				labelList[i].setTextFill(Color.RED);
			else if (i % 7 == 6)
				labelList[i].setTextFill(Color.BLUE);
			else
				labelList[i].setTextFill(Color.BLACK);
			for (int j = 0; j < eventList.size(); j++) {
				if (eventList.get(j).getType().contains("h")) {
					labelList[i].setTextFill(Color.RED);
				}
				areaList[i].appendText(eventList.get(j).getName() + "\n");
			}

			ArrayList<Schedule> scheList = dayList.get(dayList.size() - firstIndex + i).getSchedule();
			for (int j = 0; j < scheList.size(); j++) {
				areaList[i].appendText(scheList.get(j).getContent() + "\n");
			}
		}

		// 다음달 세팅
		if (cal.get(Calendar.MONTH) == 12) {
			cal.set(cal.get(Calendar.YEAR) + 1, 1, 1);
		}
		cal.add(Calendar.MONTH, 2);
		monthly = cal.getTime();
		keyStr = format.format(monthly);
		key = Integer.parseInt(keyStr);
		dayList = calList.get(key);
		for (int i = lastIndex; i < 42; i++) {
			labelList[i].setText((int) (i - lastIndex + 1) + "");
			ArrayList<EventDay> eventList = dayList.get(i - lastIndex).getEvent();
			areaList[i].setText("");
			if (i % 7 == 0)
				labelList[i].setTextFill(Color.RED);
			else if (i % 7 == 6)
				labelList[i].setTextFill(Color.BLUE);
			else
				labelList[i].setTextFill(Color.BLACK);
			for (int j = 0; j < eventList.size(); j++) {
				if (eventList.get(j).getType().contains("h")) {
					labelList[i].setTextFill(Color.RED);
				}
				areaList[i].appendText(eventList.get(j).getName() + "\n");
			}

			ArrayList<Schedule> scheList = dayList.get(i - lastIndex).getSchedule();
			for (int j = 0; j < scheList.size(); j++) {
				areaList[i].appendText(scheList.get(j).getContent() + "\n");
			}
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
		if (year > 2022) {
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
		if (year > 2022) {
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

	public void setEventDay() {
		for (int year = 2018; year <= 2022; year++) {
			ArrayList<EventDay> holidayList = EventDayParser.parshing("h", Integer.toString(year)); // 법정공휴일
			ArrayList<EventDay> adayList = EventDayParser.parshing("a", Integer.toString(year)); // 법정기념일
			ArrayList<EventDay> sdayList = EventDayParser.parshing("s", Integer.toString(year)); // 24절기
			ArrayList<EventDay> tdayList = EventDayParser.parshing("t", Integer.toString(year)); // 그 외 절기
			ArrayList<EventDay> pdayList = EventDayParser.parshing("p", Integer.toString(year)); // 대중 기념일
			ArrayList<EventDay> edayList = EventDayParser.parshing("e", Integer.toString(year)); // 기타 기념일
			setHoliday(holidayList);
			setEvent(adayList);
			setEvent(sdayList);
			setEvent(tdayList);
			setEvent(pdayList);
			setEvent(edayList);
		}
		calList.get(202301).get(0).getEvent().add(new EventDay("2023", "1", "1", "h", "신정"));
		calList.get(202301).get(4).getEvent().add(new EventDay("2023", "1", "5", "s", "소한"));
	}

	public void setEvent(ArrayList<EventDay> eventList) {
		for (int i = 0; i < eventList.size(); i++) {
			EventDay event = eventList.get(i);
			switch (event.getName()) {
			case "설날":
			case "어린이날":
			case "추석":
			case "현충일":
				break;
			default:
				String keyStr = event.getYear() + event.getMonth();
				int key = Integer.parseInt(keyStr);
				int day = Integer.parseInt(event.getDay());
				calList.get(key).get(day - 1).getEvent().add(event);
				break;
			}
		}
	}

	public void setHoliday(ArrayList<EventDay> eventList) {
		for (int i = 0; i < eventList.size(); i++) {
			EventDay event = eventList.get(i);
			String keyStr = event.getYear() + event.getMonth();
			int key = Integer.parseInt(keyStr);
			int day = Integer.parseInt(event.getDay());
			calList.get(key).get(day - 1).getEvent().add(event);
		}
	}

	public void setSchedule() {
		ArrayList<Schedule> sList = (ArrayList<Schedule>) Client.Client
				.summit(new SocketDB("getSchedule", Client.User.user));
		if (sList != null) {
			for (int i = 0; i < sList.size(); i++) {
				switch (sList.get(i).getData_type()) {
				case "M":
					String fullDate = sList.get(i).getFrom_date();
					String keyStr = fullDate.substring(0, 6);
					int key = Integer.parseInt(keyStr);
					int date = 0;
					if (fullDate.charAt(6) == '0') {
						date = Integer.parseInt(fullDate.substring(7, 8));
					} else {
						date = Integer.parseInt(fullDate.substring(6, 8));
					}
					calList.get(key).get(date - 1).getSchedule().add(sList.get(i));
					break;
				case "S":
					String fromFullDate = sList.get(i).getFrom_date();
					String fromKeyStr = fromFullDate.substring(0, 6);
					int fromKey = Integer.parseInt(fromKeyStr);
					int fromDate = 0;
					if (fromFullDate.charAt(6) == '0') {
						fromDate = Integer.parseInt(fromFullDate.substring(7, 8));
					} else {
						fromDate = Integer.parseInt(fromFullDate.substring(6, 8));
					}
					String toFullDate = sList.get(i).getTo_date();
					String toKeyStr = toFullDate.substring(0, 6);
					int toKey = Integer.parseInt(toKeyStr);
					int toDate = 0;
					if (toFullDate.charAt(6) == '0') {
						toDate = Integer.parseInt(toFullDate.substring(7, 8));
					} else {
						toDate = Integer.parseInt(toFullDate.substring(6, 8));
					}

					fromDate--;
					toDate--;

					boolean first = true;
					while (fromKey <= toKey) {
						ArrayList<Day> dList = calList.get(fromKey);
						if (fromKey < toKey) {
							if (first = true) {
								first = false;
								for (int j = fromDate; j < dList.size(); j++) {
									dList.get(j).getSchedule().add(sList.get(i));
								}
								fromDate = 0;
							} else {
								for (int j = 0; j < dList.size(); j++) {
									dList.get(j).getSchedule().add(sList.get(i));
								}
							}
						} else {
							for (int j = fromDate; j <= toDate; j++) {
								dList.get(j).getSchedule().add(sList.get(i));
							}
						}
						fromKey++;
						if ((fromKey % 100) > 12) {
							fromKey += 100;
							fromKey -= 12;
						}
					}

					break;
				case "D":
					fullDate = sList.get(i).getFrom_date();
					keyStr = fullDate.substring(0, 6);
					key = Integer.parseInt(keyStr);
					date = 0;
					if (fullDate.charAt(6) == '0') {
						date = Integer.parseInt(fullDate.substring(7, 8));
					} else {
						date = Integer.parseInt(fullDate.substring(6, 8));
					}
					calList.get(key).get(date - 1).getSchedule().add(sList.get(i));
				}
			}
		}
	}

	public void selectDay(MouseEvent event) {
		String year = this.year.getText();
		String month = this.month.getText();
		if (Integer.parseInt(month) < 10) {
			selectedPage = year + "0" + month;
		} else {
			selectedPage = year + month;
		}
		int index = Integer.parseInt(event.getSource().toString().substring(20).split(",")[0]) - 1;
		String day = labelList[index].getText();
		if (index < 14 && Integer.parseInt(day) > 14) {
			month = Integer.toString(Integer.parseInt(month) - 1);
		} else if (index > 28 && Integer.parseInt(day) <= 14) {
			month = Integer.toString(Integer.parseInt(month) + 1);
		}
		if (Integer.parseInt(month) > 12) {
			year = Integer.toString(Integer.parseInt(year) + 1);
			month = "1";
		} else if (Integer.parseInt(month) < 1) {
			year = Integer.toString(Integer.parseInt(year) - 1);
			month = "12";
		}

		String keyStr = "";
		if (Integer.parseInt(month) < 10) {
			selectedDay = year + "0" + month;
			keyStr = year + "0" + month;
		} else {
			selectedDay = year + month;
			keyStr = year + month;
		}

		if (Integer.parseInt(day) < 10) {
			selectedDay += "0" + day;
		} else {
			selectedDay += day;
		}

		int key = Integer.parseInt(keyStr);
		int dayIndex = Integer.parseInt(day) - 1;

		ArrayList<EventDay> eventList = calList.get(key).get(dayIndex).getEvent();
		ArrayList<Schedule> scheList = calList.get(key).get(dayIndex).getSchedule();

		ObservableList<Object> observeList = FXCollections.observableArrayList();

		for (int i = 0; i < eventList.size(); i++) {
			observeList.add(eventList.get(i));
		}
		for (int i = 0; i < scheList.size(); i++) {
			observeList.add(scheList.get(i));
		}

		contentListView.setItems(observeList);

		contentLabel.setText(year + "년 " + month + "월 " + day + "일의 세부 일정");
	}

	public void insertMemo() {
		AnchorPane memoPane;
		try {
			memoPane = FXMLLoader.load(getClass().getResource("/View/InsertMemo.fxml"));
			Scene scene = new Scene(memoPane);
			stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("메모 입력");
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertMemoReceiver(Schedule vo) {
		if (selectedDay == null)
			return;
		if (vo.getContent().equals(""))
			return;

		vo.setFrom_date(selectedDay);
		Client.Client.summit(new SocketDB("insertMemo", vo));
		String keyStr = vo.getFrom_date().substring(0, 6);
		int key = Integer.parseInt(keyStr);
		int date = 0;
		if (vo.getFrom_date().charAt(6) == '0') {
			date = Integer.parseInt(vo.getFrom_date().substring(7, 8));
		} else {
			date = Integer.parseInt(vo.getFrom_date().substring(6, 8));
		}
		calList.get(key).get(date - 1).getSchedule().add(vo);

		refreshDaySchedule();

		refreshContentList();

		refreshCalendar(selectedPage);
	}

	public void insertSchedule() {
		AnchorPane schedulePane;
		try {
			schedulePane = FXMLLoader.load(getClass().getResource("/View/InsertSchedule.fxml"));
			Scene scene = new Scene(schedulePane);
			stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("스케줄 입력");
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertScheduleReceiver(Schedule vo) {
		String seq = (String) Client.Client.summit(new SocketDB("insertSchedule", vo));
		vo.setSchedule_seq(seq);

		String from = vo.getFrom_date();
		String to = vo.getTo_date();
		String fromKeyStr = from.substring(0, 6);
		String toKeyStr = to.substring(0, 6);
		int fromKey = Integer.parseInt(fromKeyStr);
		int toKey = Integer.parseInt(toKeyStr);
		int fromDate = 0;
		int toDate = 0;
		if (from.charAt(6) == '0') {
			fromDate = Integer.parseInt(from.substring(7, 8));
		} else {
			fromDate = Integer.parseInt(from.substring(6, 8));
		}
		if (to.charAt(6) == '0') {
			toDate = Integer.parseInt(to.substring(7, 8));
		} else {
			toDate = Integer.parseInt(to.substring(6, 8));
		}
		fromDate--;
		toDate--;

		boolean first = true;
		while (fromKey <= toKey) {
			ArrayList<Day> dList = calList.get(fromKey);
			if (fromKey < toKey) {
				if (first = true) {
					first = false;
					for (int i = fromDate; i < dList.size(); i++) {
						dList.get(i).getSchedule().add(vo);
					}
					fromDate = 0;
				} else {
					for (int i = 0; i < dList.size(); i++) {
						dList.get(i).getSchedule().add(vo);
					}
				}
			} else {
				for (int i = fromDate; i <= toDate; i++) {
					dList.get(i).getSchedule().add(vo);
				}
			}
			fromKey++;
			if ((fromKey % 100) > 12) {
				fromKey += 100;
				fromKey -= 12;
			}
		}

		refreshContentList();

		refreshCalendar(selectedPage);
	}

	public void insertDaySchedule() {
		AnchorPane daySchedulePane;
		try {
			daySchedulePane = FXMLLoader.load(getClass().getResource("/View/InsertDaySchedule.fxml"));
			Scene scene = new Scene(daySchedulePane);
			stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("일정 입력");
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertDayScheduleReceiver(Schedule vo) {
		if (selectedDay == null)
			return;

		Client.Client.summit(new SocketDB("insertDaySchedule", vo));
		String keyStr = vo.getFrom_date().substring(0, 6);
		int key = Integer.parseInt(keyStr);
		int date = 0;
		if (vo.getFrom_date().charAt(6) == '0') {
			date = Integer.parseInt(vo.getFrom_date().substring(7, 8));
		} else {
			date = Integer.parseInt(vo.getFrom_date().substring(6, 8));
		}
		calList.get(key).get(date - 1).getSchedule().add(vo);

		refreshDaySchedule();

		refreshContentList();

		refreshCalendar(selectedPage);
	}

	public void delete() {
		Object item = contentListView.getSelectionModel().getSelectedItem();
		if (item == null)
			return;
		if (item instanceof Schedule) {
			Schedule vo = (Schedule) item;
			switch (vo.getData_type()) {
			case "M":
				Client.Client.summit(new SocketDB("deleteSchedule", vo));
				refreshDaySchedule();
				break;
			case "S":
				Client.Client.summit(new SocketDB("deleteSchedule", vo));
				String from = vo.getFrom_date();
				String to = vo.getTo_date();
				String fromKeyStr = from.substring(0, 6);
				String toKeyStr = to.substring(0, 6);
				int fromKey = Integer.parseInt(fromKeyStr);
				int toKey = Integer.parseInt(toKeyStr);
				int fromDate = 0;
				int toDate = 0;
				if (from.charAt(6) == '0') {
					fromDate = Integer.parseInt(from.substring(7, 8));
				} else {
					fromDate = Integer.parseInt(from.substring(6, 8));
				}
				if (to.charAt(6) == '0') {
					toDate = Integer.parseInt(to.substring(7, 8));
				} else {
					toDate = Integer.parseInt(to.substring(6, 8));
				}
				fromDate--;
				toDate--;

				boolean first = true;
				while (fromKey <= toKey) {
					ArrayList<Day> dList = calList.get(fromKey);
					if (fromKey < toKey) {
						if (first = true) {
							first = false;
							for (int i = fromDate; i < dList.size(); i++) {
								dList.get(i).getSchedule().remove(vo);
							}
							fromDate = 0;
						} else {
							for (int i = 0; i < dList.size(); i++) {
								dList.get(i).getSchedule().remove(vo);
							}
						}
					} else {
						for (int i = fromDate; i <= toDate; i++) {
							dList.get(i).getSchedule().remove(vo);
						}
					}
					fromKey++;
					if ((fromKey % 100) > 12) {
						fromKey += 100;
						fromKey -= 12;
					}
				}
				break;
			case "D":
				Client.Client.summit(new SocketDB("deleteSchedule", vo));
				refreshDaySchedule();
				break;
			}

		}

		refreshContentList();

		refreshCalendar(selectedPage);
	}

	public static void refreshDaySchedule() {
		Schedule vo = new Schedule();
		vo.setFrom_date(selectedDay);
		ArrayList<Schedule> newSchedule = (ArrayList<Schedule>) Client.Client
				.summit(new SocketDB("getDaySchedule", vo));

		if (newSchedule == null)
			newSchedule = new ArrayList<>();
		String dateStr = vo.getFrom_date();
		String keyStr = dateStr.substring(0, 6);
		int key = Integer.parseInt(keyStr);
		int date = 0;
		if (dateStr.charAt(6) == '0') {
			date = Integer.parseInt(dateStr.substring(7, 8));
		} else {
			date = Integer.parseInt(dateStr.substring(6, 8));
		}
		calList.get(key).get(date - 1).setSchedule(newSchedule);
	}

	public static void refreshContentList() {

		String keyStr = selectedDay.substring(0, 6);
		int key = Integer.parseInt(keyStr);
		int date = 0;
		if (selectedDay.charAt(6) == '0') {
			date = Integer.parseInt(selectedDay.substring(7, 8));
		} else {
			date = Integer.parseInt(selectedDay.substring(6, 8));
		}

		ArrayList<EventDay> eventList = calList.get(key).get(date - 1).getEvent();
		ArrayList<Schedule> scheList = calList.get(key).get(date - 1).getSchedule();

		ObservableList<Object> observeList = FXCollections.observableArrayList();

		for (int i = 0; i < eventList.size(); i++) {
			observeList.add(eventList.get(i));
		}
		for (int i = 0; i < scheList.size(); i++) {
			observeList.add(scheList.get(i));
		}

		staticListView.setItems(observeList);
	}

	@FXML
	public void btnOnHH(ActionEvent event) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					AnchorPane memoPane = FXMLLoader.load(getClass().getResource("/View/HouseHold.fxml"));
					Scene scene = new Scene(memoPane);
					stage = new Stage();
					stage.setScene(scene);
					stage.setTitle("가계부");
					stage.setResizable(false);
					stage.show();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}
