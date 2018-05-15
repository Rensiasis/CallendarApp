import java.util.ArrayList;

import Parser.EventDayParser;
import VO.EventDay;

public class TestMain {
	public static void main(String[] args) {
		ArrayList<EventDay> list = EventDayParser.parshing("e", "2018");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
}
