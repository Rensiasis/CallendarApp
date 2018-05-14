package VO;

import java.util.ArrayList;
import java.util.Date;

public class Day {
	public Date date;
	public ArrayList<EventDay> event;
	public ArrayList<Schedule> schedule;

	public Day(Date date, ArrayList<EventDay> event, ArrayList<Schedule> schedule) {
		super();
		this.date = date;
		this.event = event;
		this.schedule = schedule;
	}

	public Day() {
		super();
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

	@Override
	public String toString() {
		return "Day [date=" + date + ", event=" + event + ", schedule=" + schedule + "]";
	}

}
