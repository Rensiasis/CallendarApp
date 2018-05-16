package VO;

public class Weather {
	private String date;
	private String sky;
	private String skyCode;
	private String tmax;
	private String tmin;

	
	public Weather(String date, String sky, String skyCode, String tmax, String tmin) {
		super();
		this.date = date;
		this.sky = sky;
		this.skyCode = skyCode;
		this.tmax = tmax;
		this.tmin = tmin;
	}

	public Weather() {
		super();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSky() {
		return sky;
	}

	public void setSky(String sky) {
		this.sky = sky;
	}

	public String getTmax() {
		return tmax;
	}

	public void setTmax(String tmax) {
		this.tmax = tmax;
	}

	public String getTmin() {
		return tmin;
	}

	public void setTmin(String tmin) {
		this.tmin = tmin;
	}

	public String getSkyCode() {
		return skyCode;
	}

	public void setSkyCode(String skyCode) {
		this.skyCode = skyCode;
	}

	@Override
	public String toString() {
		return "Weather [date=" + date + ", sky=" + sky + ", skyCode=" + skyCode + ", tmax=" + tmax + ", tmin=" + tmin
				+ "]";
	}
	
}
