package VO;

import java.util.ArrayList;
import java.util.Date;

public class Day {
	public Date date;
	public ArrayList<EventDay> event;
	public ArrayList<Schedule> schedule;
	public Weather weather;


	public Day(Date date, ArrayList<EventDay> event, ArrayList<Schedule> schedule, Weather weather) {
		super();
		this.date = date;
		this.event = event;
		this.schedule = schedule;
		this.weather = weather;
	}

	public Day() {
		super();
		event=new ArrayList<>();
		schedule=new ArrayList<>();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<EventDay> getEvent() {
		return event;
	}

	public void setEvent(ArrayList<EventDay> event) {
		this.event = event;
	}

	public ArrayList<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<Schedule> schedule) {
		this.schedule = schedule;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	@Override
	public String toString() {
		return "Day [date=" + date + ", event=" + event + ", schedule=" + schedule + ", weather=" + weather + "]";
	}
	
	

}
