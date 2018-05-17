package View.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Timer;

import Client.User;
import DAO.MemberDAO;
import Parser.EventDayParser;
import Parser.WeatherPlanetParser;
import Util.Alarm;
import VO.Day;
import VO.EventDay;
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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
	private Label min1;
	@FXML
	private Label min2;
	@FXML
	private Label min3;
	@FXML
	private Label min4;
	@FXML
	private Label min5;
	@FXML
	private Label min6;
	@FXML
	private Label min7;
	@FXML
	private Label min8;
	@FXML
	private Label min9;
	@FXML
	private Label min10;
	@FXML
	private Label min11;
	@FXML
	private Label min12;
	@FXML
	private Label min13;
	@FXML
	private Label min14;
	@FXML
	private Label min15;
	@FXML
	private Label min16;
	@FXML
	private Label min17;
	@FXML
	private Label min18;
	@FXML
	private Label min19;
	@FXML
	private Label min20;
	@FXML
	private Label min21;
	@FXML
	private Label min22;
	@FXML
	private Label min23;
	@FXML
	private Label min24;
	@FXML
	private Label min25;
	@FXML
	private Label min26;
	@FXML
	private Label min27;
	@FXML
	private Label min28;
	@FXML
	private Label min29;
	@FXML
	private Label min30;
	@FXML
	private Label min31;
	@FXML
	private Label min32;
	@FXML
	private Label min33;
	@FXML
	private Label min34;
	@FXML
	private Label min35;
	@FXML
	private Label min36;
	@FXML
	private Label min37;
	@FXML
	private Label min38;
	@FXML
	private Label min39;
	@FXML
	private Label min40;
	@FXML
	private Label min41;
	@FXML
	private Label min42;
	@FXML
	private Label max1;
	@FXML
	private Label max2;
	@FXML
	private Label max3;
	@FXML
	private Label max4;
	@FXML
	private Label max5;
	@FXML
	private Label max6;
	@FXML
	private Label max7;
	@FXML
	private Label max8;
	@FXML
	private Label max9;
	@FXML
	private Label max10;
	@FXML
	private Label max11;
	@FXML
	private Label max12;
	@FXML
	private Label max13;
	@FXML
	private Label max14;
	@FXML
	private Label max15;
	@FXML
	private Label max16;
	@FXML
	private Label max17;
	@FXML
	private Label max18;
	@FXML
	private Label max19;
	@FXML
	private Label max20;
	@FXML
	private Label max21;
	@FXML
	private Label max22;
	@FXML
	private Label max23;
	@FXML
	private Label max24;
	@FXML
	private Label max25;
	@FXML
	private Label max26;
	@FXML
	private Label max27;
	@FXML
	private Label max28;
	@FXML
	private Label max29;
	@FXML
	private Label max30;
	@FXML
	private Label max31;
	@FXML
	private Label max32;
	@FXML
	private Label max33;
	@FXML
	private Label max34;
	@FXML
	private Label max35;
	@FXML
	private Label max36;
	@FXML
	private Label max37;
	@FXML
	private Label max38;
	@FXML
	private Label max39;
	@FXML
	private Label max40;
	@FXML
	private Label max41;
	@FXML
	private Label max42;
	@FXML
	private AnchorPane dayPane1;
	@FXML
	private AnchorPane dayPane2;
	@FXML
	private AnchorPane dayPane3;
	@FXML
	private AnchorPane dayPane4;
	@FXML
	private AnchorPane dayPane5;
	@FXML
	private AnchorPane dayPane6;
	@FXML
	private AnchorPane dayPane7;
	@FXML
	private AnchorPane dayPane8;
	@FXML
	private AnchorPane dayPane9;
	@FXML
	private AnchorPane dayPane10;
	@FXML
	private AnchorPane dayPane11;
	@FXML
	private AnchorPane dayPane12;
	@FXML
	private AnchorPane dayPane13;
	@FXML
	private AnchorPane dayPane14;
	@FXML
	private AnchorPane dayPane15;
	@FXML
	private AnchorPane dayPane16;
	@FXML
	private AnchorPane dayPane17;
	@FXML
	private AnchorPane dayPane18;
	@FXML
	private AnchorPane dayPane19;
	@FXML
	private AnchorPane dayPane20;
	@FXML
	private AnchorPane dayPane21;
	@FXML
	private AnchorPane dayPane22;
	@FXML
	private AnchorPane dayPane23;
	@FXML
	private AnchorPane dayPane24;
	@FXML
	private AnchorPane dayPane25;
	@FXML
	private AnchorPane dayPane26;
	@FXML
	private AnchorPane dayPane27;
	@FXML
	private AnchorPane dayPane28;
	@FXML
	private AnchorPane dayPane29;
	@FXML
	private AnchorPane dayPane30;
	@FXML
	private AnchorPane dayPane31;
	@FXML
	private AnchorPane dayPane32;
	@FXML
	private AnchorPane dayPane33;
	@FXML
	private AnchorPane dayPane34;
	@FXML
	private AnchorPane dayPane35;
	@FXML
	private AnchorPane dayPane36;
	@FXML
	private AnchorPane dayPane37;
	@FXML
	private AnchorPane dayPane38;
	@FXML
	private AnchorPane dayPane39;
	@FXML
	private AnchorPane dayPane40;
	@FXML
	private AnchorPane dayPane41;
	@FXML
	private AnchorPane dayPane42;
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
	private Button openWeather;
	@FXML
	private ListView<Object> contentListView;

	private static Label[] labelList;
	private static TextArea[] areaList;
	private static ImageView[] weatherViewList;
	private static Label[] minList;
	private static Label[] maxList;
	private static AnchorPane[] dayPaneList;

	private static Map<Integer, ArrayList<Day>> calList;
	private static ListView<Object> staticListView;
	private static Map<Integer, Alarm> alarmManager;

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

		weatherViewList = new ImageView[42];
		weatherViewList[0] = weather1;
		weatherViewList[1] = weather2;
		weatherViewList[2] = weather3;
		weatherViewList[3] = weather4;
		weatherViewList[4] = weather5;
		weatherViewList[5] = weather6;
		weatherViewList[6] = weather7;
		weatherViewList[7] = weather8;
		weatherViewList[8] = weather9;
		weatherViewList[9] = weather10;
		weatherViewList[10] = weather11;
		weatherViewList[11] = weather12;
		weatherViewList[12] = weather13;
		weatherViewList[13] = weather14;
		weatherViewList[14] = weather15;
		weatherViewList[15] = weather16;
		weatherViewList[16] = weather17;
		weatherViewList[17] = weather18;
		weatherViewList[18] = weather19;
		weatherViewList[19] = weather20;
		weatherViewList[20] = weather21;
		weatherViewList[21] = weather22;
		weatherViewList[22] = weather23;
		weatherViewList[23] = weather24;
		weatherViewList[24] = weather25;
		weatherViewList[25] = weather26;
		weatherViewList[26] = weather27;
		weatherViewList[27] = weather28;
		weatherViewList[28] = weather29;
		weatherViewList[29] = weather30;
		weatherViewList[30] = weather31;
		weatherViewList[31] = weather32;
		weatherViewList[32] = weather33;
		weatherViewList[33] = weather34;
		weatherViewList[34] = weather35;
		weatherViewList[35] = weather36;
		weatherViewList[36] = weather37;
		weatherViewList[37] = weather38;
		weatherViewList[38] = weather39;
		weatherViewList[39] = weather40;
		weatherViewList[40] = weather41;
		weatherViewList[41] = weather42;

		minList = new Label[42];
		minList[0] = min1;
		minList[1] = min2;
		minList[2] = min3;
		minList[3] = min4;
		minList[4] = min5;
		minList[5] = min6;
		minList[6] = min7;
		minList[7] = min8;
		minList[8] = min9;
		minList[9] = min10;
		minList[10] = min11;
		minList[11] = min12;
		minList[12] = min13;
		minList[13] = min14;
		minList[14] = min15;
		minList[15] = min16;
		minList[16] = min17;
		minList[17] = min18;
		minList[18] = min19;
		minList[19] = min20;
		minList[20] = min21;
		minList[21] = min22;
		minList[22] = min23;
		minList[23] = min24;
		minList[24] = min25;
		minList[25] = min26;
		minList[26] = min27;
		minList[27] = min28;
		minList[28] = min29;
		minList[29] = min30;
		minList[30] = min31;
		minList[31] = min32;
		minList[32] = min33;
		minList[33] = min34;
		minList[34] = min35;
		minList[35] = min36;
		minList[36] = min37;
		minList[37] = min38;
		minList[38] = min39;
		minList[39] = min40;
		minList[40] = min41;
		minList[41] = min42;

		maxList = new Label[42];
		maxList[0] = max1;
		maxList[1] = max2;
		maxList[2] = max3;
		maxList[3] = max4;
		maxList[4] = max5;
		maxList[5] = max6;
		maxList[6] = max7;
		maxList[7] = max8;
		maxList[8] = max9;
		maxList[9] = max10;
		maxList[10] = max11;
		maxList[11] = max12;
		maxList[12] = max13;
		maxList[13] = max14;
		maxList[14] = max15;
		maxList[15] = max16;
		maxList[16] = max17;
		maxList[17] = max18;
		maxList[18] = max19;
		maxList[19] = max20;
		maxList[20] = max21;
		maxList[21] = max22;
		maxList[22] = max23;
		maxList[23] = max24;
		maxList[24] = max25;
		maxList[25] = max26;
		maxList[26] = max27;
		maxList[27] = max28;
		maxList[28] = max29;
		maxList[29] = max30;
		maxList[30] = max31;
		maxList[31] = max32;
		maxList[32] = max33;
		maxList[33] = max34;
		maxList[34] = max35;
		maxList[35] = max36;
		maxList[36] = max37;
		maxList[37] = max38;
		maxList[38] = max39;
		maxList[39] = max40;
		maxList[40] = max41;
		maxList[41] = max42;

		dayPaneList = new AnchorPane[42];
		dayPaneList[0] = dayPane1;
		dayPaneList[1] = dayPane2;
		dayPaneList[2] = dayPane3;
		dayPaneList[3] = dayPane4;
		dayPaneList[4] = dayPane5;
		dayPaneList[5] = dayPane6;
		dayPaneList[6] = dayPane7;
		dayPaneList[7] = dayPane8;
		dayPaneList[8] = dayPane9;
		dayPaneList[9] = dayPane10;
		dayPaneList[10] = dayPane11;
		dayPaneList[11] = dayPane12;
		dayPaneList[12] = dayPane13;
		dayPaneList[13] = dayPane14;
		dayPaneList[14] = dayPane15;
		dayPaneList[15] = dayPane16;
		dayPaneList[16] = dayPane17;
		dayPaneList[17] = dayPane18;
		dayPaneList[18] = dayPane19;
		dayPaneList[19] = dayPane20;
		dayPaneList[20] = dayPane21;
		dayPaneList[21] = dayPane22;
		dayPaneList[22] = dayPane23;
		dayPaneList[23] = dayPane24;
		dayPaneList[24] = dayPane25;
		dayPaneList[25] = dayPane26;
		dayPaneList[26] = dayPane27;
		dayPaneList[27] = dayPane28;
		dayPaneList[28] = dayPane29;
		dayPaneList[29] = dayPane30;
		dayPaneList[30] = dayPane31;
		dayPaneList[31] = dayPane32;
		dayPaneList[32] = dayPane33;
		dayPaneList[33] = dayPane34;
		dayPaneList[34] = dayPane35;
		dayPaneList[35] = dayPane36;
		dayPaneList[36] = dayPane37;
		dayPaneList[37] = dayPane38;
		dayPaneList[38] = dayPane39;
		dayPaneList[39] = dayPane40;
		dayPaneList[40] = dayPane41;
		dayPaneList[41] = dayPane42;

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
		openWeather.setOnMouseClicked(event -> openWeather());

		calList = new HashMap<>();
		alarmManager = new HashMap<>();
		staticListView = contentListView;

		calList = (Map<Integer, ArrayList<Day>>) Client.Client.summit(new SocketDB("requestCalendar", ""));

		setInitialPage();

		setSchedule();

		setWeather();

		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("YYYYMM");
		String keyStr = format.format(today);
		refreshCalendar(keyStr);
	}

	public void setInitialPage() {
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int day = today.get(Calendar.DATE);
		setYearMonthLabel(year, month + 1);
	}

	public void setWeather() {
		WeatherPlanetParser w = new WeatherPlanetParser();
		w.setAddress(User.user.getCity(), User.user.getCounty(), User.user.getVillage());
		w.parshing();
		ArrayList<Weather> wList = w.getWeatherList();
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("YYYYMM");
		String keyStr = format.format(today);
		format = new SimpleDateFormat("dd");
		String dayStr = format.format(today);
		int key = Integer.parseInt(keyStr);
		int startIndex = 0;
		if (dayStr.charAt(0) == '0') {
			startIndex = Integer.parseInt(dayStr.substring(1, 2)) - 1;
		} else {
			startIndex = Integer.parseInt(dayStr) - 1;
		}
		for (int i = 0; i < wList.size(); i++) {
			calList.get(key).get(startIndex++).setWeather(wList.get(i));
			if (startIndex >= calList.get(key).size()) {
				key++;
				if ((key % 100) > 12) {
					key += 100;
					key -= 12;
				}
				startIndex = 0;
			}
		}
	}

	public static void setWeatherView(ImageView view, Weather weather) {
		if (weather == null) {
			view.setVisible(false);
		} else {
			File file = null;
			if (weather.getSkyCode().substring(5, 7).equals("01")) {
				file = new File("src/Image/SKY_A01.PNG");
			} else if (weather.getSkyCode().substring(5, 7).equals("02")) {
				file = new File("src/Image/SKY_A02.PNG");
			} else if (weather.getSkyCode().substring(5, 7).equals("03")) {
				file = new File("src/Image/SKY_A03.PNG");
			} else if (weather.getSkyCode().substring(5, 7).equals("04")) {
				file = new File("src/Image/SKY_A04.PNG");
			} else if (weather.getSkyCode().substring(5, 7).equals("05")) {
				file = new File("src/Image/SKY_A05.PNG");
			} else if (weather.getSkyCode().substring(5, 7).equals("06")) {
				file = new File("src/Image/SKY_A06.PNG");
			} else if (weather.getSkyCode().substring(5, 7).equals("07")) {
				file = new File("src/Image/SKY_A07.PNG");
			} else if (weather.getSkyCode().substring(5, 7).equals("08")) {
				file = new File("src/Image/SKY_A08.PNG");
			} else if (weather.getSkyCode().substring(5, 7).equals("09")) {
				file = new File("src/Image/SKY_A09.PNG");
			} else if (weather.getSkyCode().substring(5, 7).equals("10")) {
				file = new File("src/Image/SKY_A10.PNG");
			} else if (weather.getSkyCode().substring(5, 7).equals("11")) {
				file = new File("src/Image/SKY_A11.PNG");
			} else if (weather.getSkyCode().substring(5, 7).equals("12")) {
				file = new File("src/Image/SKY_A12.PNG");
			} else if (weather.getSkyCode().substring(5, 7).equals("13")) {
				file = new File("src/Image/SKY_A13.PNG");
			} else if (weather.getSkyCode().substring(5, 7).equals("14")) {
				file = new File("src/Image/SKY_A14.PNG");
			}
			Image image = new Image(file.toURI().toString());
			view.setImage(image);
			view.setVisible(true);
		}
	}

	public static void refreshCalendar(String keyStr) {
		int key = Integer.parseInt(keyStr);
		ArrayList<Day> dayList = calList.get(key);
		Date firstDay = dayList.get(0).getDate();
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(firstDay);

		Date today = new Date();
		SimpleDateFormat formatToday = new SimpleDateFormat("YYYYMM");
		String todayKeyStr = formatToday.format(today);
		formatToday = new SimpleDateFormat("dd");
		String todayStr = formatToday.format(today);
		int todayKey = Integer.parseInt(todayKeyStr);
		int todayIndex = 0;
		if (todayStr.charAt(0) == '0') {
			todayIndex = Integer.parseInt(todayStr.substring(1, 2)) - 1;
		} else {
			todayIndex = Integer.parseInt(todayStr) - 1;
		}
		// 이번달 세팅
		int firstIndex = cal.get(Calendar.DAY_OF_WEEK) - 1;
		for (int i = firstIndex; i < dayList.size() + firstIndex; i++) {
			labelList[i].setText((int) (i - firstIndex + 1) + "");

			if (key == todayKey && todayIndex == (i - firstIndex)) {
				areaList[i].setStyle("-fx-border-width: 4; -fx-border-color : #ff1818;");
			} else {
				areaList[i].setStyle(";");
			}

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
			setWeatherView(weatherViewList[i], weather);
			if (weather != null) {
				minList[i].setText(weather.getTmin());
				minList[i].setTextFill(Color.BLUE);
				maxList[i].setText(weather.getTmax());
				maxList[i].setTextFill(Color.RED);
			} else {
				minList[i].setText("");
				maxList[i].setText("");
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

			if (key == todayKey && todayIndex == (dayList.size() - firstIndex + i)) {
				areaList[i].setStyle("-fx-border-width: 4; -fx-border-color : #ff1818;");
			} else {
				areaList[i].setStyle(";");
			}

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

			Weather weather = dayList.get(dayList.size() - firstIndex + i).getWeather();
			setWeatherView(weatherViewList[i], weather);
			if (weather != null) {
				minList[i].setText(weather.getTmin());
				minList[i].setTextFill(Color.BLUE);
				maxList[i].setText(weather.getTmax());
				maxList[i].setTextFill(Color.RED);
			} else {
				minList[i].setText("");
				maxList[i].setText("");
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

			if (key == todayKey && todayIndex == (i - lastIndex)) {
				areaList[i].setStyle("-fx-border-width: 4; -fx-border-color : #ff1818;");
			} else {
				areaList[i].setStyle(";");
			}

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

			Weather weather = dayList.get(i - lastIndex).getWeather();
			setWeatherView(weatherViewList[i], weather);
			if (weather != null) {
				minList[i].setText(weather.getTmin());
				minList[i].setTextFill(Color.BLUE);
				maxList[i].setText(weather.getTmax());
				maxList[i].setTextFill(Color.RED);
			} else {
				minList[i].setText("");
				maxList[i].setText("");
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
					String times = sList.get(i).getTimes();
					keyStr = fullDate.substring(0, 6);
					key = Integer.parseInt(keyStr);
					date = 0;
					if (fullDate.charAt(6) == '0') {
						date = Integer.parseInt(fullDate.substring(7, 8));
					} else {
						date = Integer.parseInt(fullDate.substring(6, 8));
					}
					String dateStr = fullDate + times;
					SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
					Date inputDate = null;
					try {
						inputDate = format.parse(dateStr);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					calList.get(key).get(date - 1).getSchedule().add(sList.get(i));

					String content = sList.get(i).getContent();
					if (inputDate.after(new Date()))
						setAlarm(content, inputDate, sList.get(i).getSchedule_seq());
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
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
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
		});
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
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
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
		});
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
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
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
		});
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

		String dateStr = vo.getFrom_date() + vo.getTimes();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
		Date inputDate = null;
		try {
			inputDate = format.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		refreshDaySchedule();

		ArrayList<Schedule> sList = calList.get(key).get(date - 1).getSchedule();
		for (int i = 0; i < sList.size(); i++) {
			if (sList.get(i).getData_type().equals("D") && sList.get(i).getFrom_date().equals(vo.getFrom_date())
					&& sList.get(i).getContent().equals(vo.getContent())
					&& sList.get(i).getTimes().equals(vo.getTimes())) {
				vo = sList.get(i);
			}
		}
		String content = vo.getContent();
		if (inputDate.after(new Date()))
			setAlarm(content, inputDate, vo.getSchedule_seq());

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
				if (alarmManager.get(Integer.parseInt(vo.getSchedule_seq())) != null)
					alarmManager.get(Integer.parseInt(vo.getSchedule_seq())).cancel();
				if (alarmManager.get(-Integer.parseInt(vo.getSchedule_seq())) != null)
					alarmManager.get(-Integer.parseInt(vo.getSchedule_seq())).cancel();
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

	public void openWeather() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				AnchorPane weatherPane;
				try {
					weatherPane = FXMLLoader.load(getClass().getResource("/View/Weather.fxml"));
					Scene scene = new Scene(weatherPane);
					stage = new Stage();
					stage.setScene(scene);
					stage.setTitle("날씨 현황");
					stage.setResizable(false);
					stage.show();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public static void setAlarm(String content, Date date, String key) {
		String[] splitContent = content.split("\\s");
		String alarmMessage = "";
		int intKey = Integer.parseInt(key);
		for (int j = 1; j < splitContent.length; j++) {
			alarmMessage += " " + splitContent[j];
		}
		Timer beforeTimer = new Timer();
		Timer afterTimer = new Timer();
		String beforeMessage = alarmMessage + " 한 시간 전입니다.";
		String afterMessage = alarmMessage + " 할 시간 입니다.";

		// 정시 알람 설정
		Alarm afterAlarm = new Alarm();
		afterAlarm.setMessage(afterMessage);
		afterTimer.schedule(afterAlarm, date);
		alarmManager.put(intKey, afterAlarm);

		// 1시간전 알람 설정
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.HOUR, -1);
		if (ca.after(Calendar.getInstance())) {
			Alarm beforeAlarm = new Alarm();
			Date beforeDate = ca.getTime();
			beforeAlarm.setMessage(beforeMessage);
			System.out.println(beforeAlarm);
			beforeTimer.schedule(beforeAlarm, beforeDate);
			alarmManager.put(-intKey, beforeAlarm);
		}
	}

	@FXML//가계부 열기
	public void btnOnHH(ActionEvent event) {
		
		
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int i= (int) Client.Client.summit(new SocketDB("beforeOpenAcc",User.getUser().getMember_seq()));
				if( i == 0){
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("가계부 미설정 오류");
					alert.setHeaderText("가계부 정보 입력필요");
					alert.setContentText("가계부 설정에서 정보를 입력해주세요.");
					alert.showAndWait();
					return;
				}else {
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
				
				
			}
		});
	}
}
