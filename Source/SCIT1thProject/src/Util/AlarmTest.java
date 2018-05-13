package Util;

import java.util.Date;
import java.util.Timer;

public class AlarmTest {
	public static void main(String[] args) {
		Alarm a = new Alarm();
		Timer t = new Timer();
		Date today = new Date();
		Date alarmTime = new Date(today.getYear(), today.getMonth(), today.getDate(), 11, 19, 0);
		t.schedule(a, alarmTime);
	}
}
