import java.util.ArrayList;

import Client.User;
import Parser.EventDayParser;
import Parser.WeatherPlanetParser;
import VO.EventDay;
import VO.Weather;

public class TestMain {
	public static void main(String[] args) {
		WeatherPlanetParser w=new WeatherPlanetParser();
		w.setAddress(User.user.getCity(), User.user.getCounty(), User.user.getVillage());
		w.parshing();
		ArrayList<Weather> wList=w.getWeatherList();
		for(int i=0;i<wList.size();i++) {
			System.out.println(wList.get(i));
		}

	}
	
}
