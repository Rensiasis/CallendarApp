package VO;

import java.util.Date;

public class ShortWeather {
	private Date timeRelease; // 발표시간
	private String skyCode; // 개황
	private String tempo; // 기온
	private String hum; // 상대습도
	private String prdb; // 강수확률

	public ShortWeather(Date timeRelease, String skyCode, String tempo, String hum, String prdb) {
		super();
		this.timeRelease = timeRelease;
		this.skyCode = skyCode;
		this.tempo = tempo;
		this.hum = hum;
		this.prdb = prdb;
	}

	public ShortWeather() {
		super();
	}

	public Date getTimeRelease() {
		return timeRelease;
	}

	public void setTimeRelease(Date timeRelease) {
		this.timeRelease = timeRelease;
	}

	public String getSkyCode() {
		return skyCode;
	}

	public void setSkyCode(String skyCode) {
		this.skyCode = skyCode;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public String getHum() {
		return hum;
	}

	public void setHum(String hum) {
		this.hum = hum;
	}

	public String getPrdb() {
		return prdb;
	}

	public void setPrdb(String prdb) {
		this.prdb = prdb;
	}

	@Override
	public String toString() {
		return "ShortWeather [timeRelease=" + timeRelease + ", skyCode=" + skyCode + ", tempo=" + tempo + ", hum=" + hum
				+ ", prdb=" + prdb + "]";
	}

}
