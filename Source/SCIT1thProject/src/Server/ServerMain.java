package Server;

import Parser.EventDayParser;
import Parser.WeatherPlanetParser;

public class ServerMain {

	// ���� Ŭ���̾�Ʈ CUI ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("this is Server");
		
		
		// 파싱 테스트용
		new EventDayParser();
		new WeatherPlanetParser().parshing();
	}

}
