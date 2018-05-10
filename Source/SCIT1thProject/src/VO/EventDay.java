package VO;

public class EventDay {
	private String year;
	private String month;
	private String day;
	private String type;
	private String name;
	public EventDay(String year, String month, String day, String type, String name) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.type = type;
		this.name = name;
	}
	public EventDay() {
		super();
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "EventDay [year=" + year + ", month=" + month + ", day=" + day + ", type=" + type + ", name=" + name
				+ "]";
	}
	
}
	

