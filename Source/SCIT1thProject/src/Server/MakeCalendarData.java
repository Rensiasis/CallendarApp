package Server;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Parser.EventDayParser;
import VO.Day;
import VO.EventDay;

public class MakeCalendarData {

	private Map<Integer, ArrayList<Day>> calList;

	public Map<Integer, ArrayList<Day>> getCalList() {
		return calList;
	}

	public void makeCalandar() {
		
		calList=new HashMap<>();
		
		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);
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
}
