package View.Controller;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import Client.User;
import Parser.GeoCodingParser;
import Parser.WeatherPlanetParser;
import VO.ShortWeather;
import VO.Weather;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WeatherController implements Initializable{

    @FXML
    private ImageView icon1;

    @FXML
    private ImageView icon2;

    @FXML
    private ImageView icon3;

    @FXML
    private ImageView icon4;

    @FXML
    private ImageView icon5;

    @FXML
    private ImageView icon6;

    @FXML
    private ImageView icon7;

    @FXML
    private ImageView icon8;

    @FXML
    private ImageView icon9;

    @FXML
    private ImageView icon10;

    @FXML
    private ImageView icon11;

    @FXML
    private ImageView icon12;

    @FXML
    private ImageView icon13;

    @FXML
    private ImageView icon14;

    @FXML
    private ImageView icon15;

    @FXML
    private Label tempo1;

    @FXML
    private Label tempo2;

    @FXML
    private Label tempo3;

    @FXML
    private Label tempo4;

    @FXML
    private Label tempo5;

    @FXML
    private Label tempo6;

    @FXML
    private Label tempo7;

    @FXML
    private Label tempo8;

    @FXML
    private Label tempo9;

    @FXML
    private Label tempo10;

    @FXML
    private Label tempo11;

    @FXML
    private Label tempo12;

    @FXML
    private Label tempo13;

    @FXML
    private Label tempo14;

    @FXML
    private Label tempo15;

    @FXML
    private Label hum1;

    @FXML
    private Label hum2;

    @FXML
    private Label hum3;

    @FXML
    private Label hum4;

    @FXML
    private Label hum5;

    @FXML
    private Label hum6;

    @FXML
    private Label hum7;

    @FXML
    private Label hum8;

    @FXML
    private Label hum9;

    @FXML
    private Label hum10;

    @FXML
    private Label hum11;

    @FXML
    private Label hum12;

    @FXML
    private Label hum13;

    @FXML
    private Label hum14;

    @FXML
    private Label hum15;

    @FXML
    private Label prdb1;

    @FXML
    private Label prdb2;

    @FXML
    private Label prdb3;

    @FXML
    private Label prdb4;

    @FXML
    private Label prdb5;

    @FXML
    private Label prdb6;

    @FXML
    private Label prdb7;

    @FXML
    private Label prdb8;

    @FXML
    private Label prdb9;

    @FXML
    private Label prdb10;

    @FXML
    private Label prdb11;

    @FXML
    private Label prdb12;

    @FXML
    private Label prdb13;

    @FXML
    private Label prdb14;

    @FXML
    private Label prdb15;

    @FXML
    private Label time1;

    @FXML
    private Label time2;

    @FXML
    private Label time3;

    @FXML
    private Label time4;

    @FXML
    private Label time5;

    @FXML
    private Label time6;

    @FXML
    private Label time7;

    @FXML
    private Label time8;

    @FXML
    private Label time9;

    @FXML
    private Label time10;

    @FXML
    private Label time11;

    @FXML
    private Label time12;

    @FXML
    private Label time13;

    @FXML
    private Label time14;

    @FXML
    private Label time15;
    
    @FXML
    private Label title;
    
    private Label[] timeList;
    private ImageView[] iconList;
    private Label[] tempoList;
    private Label[] humList;
    private Label[] prdbList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		timeList=new Label[15];
		iconList=new ImageView[15];
		tempoList=new Label[15];
		humList=new Label[15];
		prdbList=new Label[15];
		
		timeList[0]=time1;
		timeList[1]=time2;
		timeList[2]=time3;
		timeList[3]=time4;
		timeList[4]=time5;
		timeList[5]=time6;
		timeList[6]=time7;
		timeList[7]=time8;
		timeList[8]=time9;
		timeList[9]=time10;
		timeList[10]=time11;
		timeList[11]=time12;
		timeList[12]=time13;
		timeList[13]=time14;
		timeList[14]=time15;
		
		iconList[0]=icon1;
		iconList[1]=icon2;
		iconList[2]=icon3;
		iconList[3]=icon4;
		iconList[4]=icon5;
		iconList[5]=icon6;
		iconList[6]=icon7;
		iconList[7]=icon8;
		iconList[8]=icon9;
		iconList[9]=icon10;
		iconList[10]=icon11;
		iconList[11]=icon12;
		iconList[12]=icon13;
		iconList[13]=icon14;
		iconList[14]=icon15;
		
		tempoList[0]=tempo1;
		tempoList[1]=tempo2;
		tempoList[2]=tempo3;
		tempoList[3]=tempo4;
		tempoList[4]=tempo5;
		tempoList[5]=tempo6;
		tempoList[6]=tempo7;
		tempoList[7]=tempo8;
		tempoList[8]=tempo9;
		tempoList[9]=tempo10;
		tempoList[10]=tempo11;
		tempoList[11]=tempo12;
		tempoList[12]=tempo13;
		tempoList[13]=tempo14;
		tempoList[14]=tempo15;
		
		humList[0]=hum1;
		humList[1]=hum2;
		humList[2]=hum3;
		humList[3]=hum4;
		humList[4]=hum5;
		humList[5]=hum6;
		humList[6]=hum7;
		humList[7]=hum8;
		humList[8]=hum9;
		humList[9]=hum10;
		humList[10]=hum11;
		humList[11]=hum12;
		humList[12]=hum13;
		humList[13]=hum14;
		humList[14]=hum15;
		
		prdbList[0]=prdb1;
		prdbList[1]=prdb2;
		prdbList[2]=prdb3;
		prdbList[3]=prdb4;
		prdbList[4]=prdb5;
		prdbList[5]=prdb6;
		prdbList[6]=prdb7;
		prdbList[7]=prdb8;
		prdbList[8]=prdb9;
		prdbList[9]=prdb10;
		prdbList[10]=prdb11;
		prdbList[11]=prdb12;
		prdbList[12]=prdb13;
		prdbList[13]=prdb14;
		prdbList[14]=prdb15;
	
		title.setText(Client.User.getUser().getCity()+" "+Client.User.getUser().getCounty()+" "+Client.User.getUser().getVillage());
		
		getWeatherData();
	}
	
	public void getWeatherData() {
		WeatherPlanetParser phaser = new WeatherPlanetParser();
		GeoCodingParser geo = new GeoCodingParser();
		geo.setAddress(User.user.getNewAddress());
		double lat=geo.getLat();
		double lon=geo.getLon();
		phaser.setCoordinates(lat, lon);
		ArrayList<ShortWeather> wList=phaser.getShortWeather();
		SimpleDateFormat format=new SimpleDateFormat("yy/MM/dd\n(E) hh:mm ");
		Calendar ca=Calendar.getInstance();
		Date observeTime=wList.get(0).getTimeRelease();
		ca.setTime(observeTime);
		ca.add(Calendar.HOUR, 4);
		observeTime=ca.getTime();
		for(int i=0;i<15;i++) {
			timeList[i].setText(format.format(observeTime));
			setWeatherView(iconList[i],wList.get(i));
			tempoList[i].setText(wList.get(i).getTempo());
			humList[i].setText(wList.get(i).getHum());
			prdbList[i].setText(wList.get(i).getPrdb());
			ca.add(Calendar.HOUR, 3);
			observeTime=ca.getTime();
		}
	}
	
	public void setWeatherView(ImageView view, ShortWeather weather) {
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

}
