package Server;

import java.util.ArrayList;

import Parser.EventDayParser;
import Parser.WeatherPlanetParser;
import VO.EventDay;
import VO.Weather;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("this is Server");
		
		
		// 파싱 테스트용
		EventDayParser eventDayParser=new EventDayParser();
		eventDayParser.parshing();
		ArrayList<EventDay> eventList=eventDayParser.getEventList();
		for(int i=0;i<eventList.size();i++) {
			System.out.println(eventList.get(i));
		}
		WeatherPlanetParser weatherParser=new WeatherPlanetParser();
		weatherParser.parshing();
		ArrayList<Weather> weatherList=weatherParser.getWeatherList();
		for(int i=0;i<weatherList.size();i++) {
			System.out.println(weatherList.get(i));
		}
	}

}
