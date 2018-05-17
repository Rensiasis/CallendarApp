package Parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import VO.ShortWeather;
import VO.Weather;

public class WeatherPlanetParser {
//	private final static String appKey = "4abe6551-2de1-4a44-b099-5f35ace58669";
	private final static String appKey = "f0fb15d6-19d0-4e4d-960b-28cf859732f5";
	private final static String currentApiURL = "https://api2.sktelecom.com/weather/current/minutely?version=2";
	private final static String ShortTermApiURL = "https://api2.sktelecom.com/weather/forecast/3days?version=version=2";
	private final static String LongTermApiURL = "https://api2.sktelecom.com/weather/forecast/6days?version=2";
	private ArrayList<Weather> weatherList;
	private double lat;
	private double lon;
	private final static String foretxt = "N";

	public WeatherPlanetParser(ArrayList<Weather> weatherList) {
		super();
		this.weatherList = weatherList;
	}

	public WeatherPlanetParser() {
		super();
		weatherList = new ArrayList<>();
	}

	public ArrayList<Weather> getWeatherList() {
		return weatherList;
	}
	
	public void setCoordinates(double lat,double lon) {
		this.lat=lat;
		this.lon=lon;
	}

	public void parshing() {
		getTodayData();
		getShortTermData();
		getLongTermData();
	}

	private void getTodayData() {
		weatherList.add(parseToday());
	}

	private Weather parseToday() {
		StringBuilder sb = null;
		HttpURLConnection con = null;
		try {
			URL url = new URL(currentApiURL + "&lat=" + lat + "&lon=" + lon + "&foretxt=" + encodeURL(foretxt));
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("appKey", appKey);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			sb = new StringBuilder();
			String input;
			while ((input = in.readLine()) != null) {
				sb.append(input);
			}
		} catch (Exception e) {
			con.disconnect();
		}
		String json = sb.toString();
		JsonObject root = new JsonParser().parse(json).getAsJsonObject();
		JsonObject weather = root.get("weather").getAsJsonObject();
		JsonArray minutely = weather.get("minutely").getAsJsonArray();
		JsonObject sky = minutely.get(0).getAsJsonObject().get("sky").getAsJsonObject();
		JsonObject temperature = minutely.get(0).getAsJsonObject().get("temperature").getAsJsonObject();
		String currentSky = parseString(sky.get("name").toString());
		String currentSkyCode = parseString(sky.get("code").toString());
		String tmax = parseString(temperature.get("tmax").toString()).split("\\.")[0];
		String tmin = parseString(temperature.get("tmin").toString()).split("\\.")[0];

		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String date = dateFormat.format(today);

		Weather result = new Weather(date, currentSky, currentSkyCode, tmax, tmin);
		return result;
	}

	private void getShortTermData() {
		StringBuilder sb = null;
		HttpURLConnection con = null;
		try {
			URL url = new URL(currentApiURL + "&lat=" + lat + "&lon=" + lon + "&foretxt=" + encodeURL(foretxt));
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("appKey", appKey);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			sb = new StringBuilder();
			String input;
			while ((input = in.readLine()) != null) {
				sb.append(input);
			}
		} catch (Exception e) {
			con.disconnect();
		}
		String json = sb.toString();
		JsonObject root = new JsonParser().parse(json).getAsJsonObject();
		JsonObject weather = root.get("weather").getAsJsonObject();
		JsonArray forecast3days = weather.get("forecast3days").getAsJsonArray();
		JsonObject fcstdaily = forecast3days.get(0).getAsJsonObject().get("fcstdaily").getAsJsonObject();
		JsonObject temperature = fcstdaily.get("temperature").getAsJsonObject();
		JsonObject sky = forecast3days.get(0).getAsJsonObject().get("fcst3hour").getAsJsonObject().get("sky")
				.getAsJsonObject();
		parseShortTermWeather(temperature, sky);
	}

	private void parseShortTermWeather(JsonObject temperatureObj, JsonObject skyObj) {
		Date today = new Date();
		SimpleDateFormat time = new SimpleDateFormat("HH");
		int currenthour = Integer.parseInt(time.format(today));
		int fromhour = 4;
		while ((currenthour + fromhour) < 24)
			fromhour += 3;
		String skyCode = "SKY_S01";
		for (int i = 0; i < 8; i++) {
			if (skyCodeToInteger(skyCode) < skyCodeToInteger(
					skyObj.get("code" + Integer.toString(fromhour) + "hour").toString()))
				skyCode = skyObj.get("code" + Integer.toString(fromhour) + "hour").toString();
			fromhour += 3;
		}

		String tmax = parseString(temperatureObj.get("tmax2day").toString()).split("\\.")[0];
		String tmin = parseString(temperatureObj.get("tmin2day").toString()).split("\\.")[0];
		String sky = skyToString(parseString(skyCode));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String date = dateFormat.format(calendar.getTime());
		weatherList.add(new Weather(date, sky, parseString(skyCode), tmax, tmin));
	}

	private void getLongTermData() {

		StringBuilder sb = null;
		HttpURLConnection con = null;
		try {
			URL url = new URL(currentApiURL + "&lat=" + lat + "&lon=" + lon + "&foretxt=" + encodeURL(foretxt));
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("appKey", appKey);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			sb = new StringBuilder();
			String input;
			while ((input = in.readLine()) != null) {
				sb.append(input);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.disconnect();
		}
		String json = sb.toString();
		JsonObject root = new JsonParser().parse(json).getAsJsonObject();
		JsonObject weather = root.get("weather").getAsJsonObject();
		JsonArray forecast6days = weather.get("forecast6days").getAsJsonArray();
		JsonObject sky = forecast6days.get(0).getAsJsonObject().get("sky").getAsJsonObject();
		JsonObject temperature = forecast6days.get(0).getAsJsonObject().get("temperature").getAsJsonObject();
		parseLongTermWeather(sky, temperature);
	}

	private void parseLongTermWeather(JsonObject skyObj, JsonObject temperatureObj) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 2);
		for (int i = 2; i <= 10; i++) {
			Date today = calendar.getTime();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			String date = dateFormat.format(today);
			String sky = parseString(skyObj.get("amName" + Integer.toString(i) + "day").toString());
			String skyCode = parseString(skyObj.get("amCode" + Integer.toString(i) + "day").toString());
			String tmax = parseString(temperatureObj.get("tmax" + Integer.toString(i) + "day").toString());
			String tmin = parseString(temperatureObj.get("tmin" + Integer.toString(i) + "day").toString());
			weatherList.add(new Weather(date, sky, skyCode, tmax, tmin));
			calendar.add(Calendar.DATE, 1);
		}
	}

	private String encodeURL(String url) {
		try {
			return URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private String skyToString(String code) {
		switch (code) {
		case "SKY_S01":
			return "맑음";
		case "SKY_S02":
			return "구름조금";
		case "SKY_S03":
			return "구름많음";
		case "SKY_S04":
			return "구름많고 비";
		case "SKY_S05":
			return "구름많고 눈";
		case "SKY_S06":
			return "구름많고 비 또는 눈";
		case "SKY_S07":
			return "흐림";
		case "SKY_S08":
			return "흐리고 비";
		case "SKY_S09":
			return "흐리고 눈";
		case "SKY_S10":
			return "흐리고 비 또는 눈";
		case "SKY_S11":
			return "흐리고 낙뢰";
		case "SKY_S12":
			return "뇌우/비";
		case "SKY_S13":
			return "뇌우/눈";
		case "SKY_S14":
			return "뇌우/비 또는 눈";
		}
		return null;
	}

	private int skyCodeToInteger(String skyCode) {
		int a = (int) skyCode.charAt(5) - '0';
		int b = (int) skyCode.charAt(6) - '0';
		return a * 10 + b;
	}

	private String parseString(String str) {
		return str.substring(1, str.length() - 1);
	}

	public ArrayList<ShortWeather> getShortWeather() {
		ArrayList<ShortWeather> wList = new ArrayList<>();
		StringBuilder sb = null;
		HttpURLConnection con = null;
		try {
			URL url = new URL(currentApiURL + "&lat=" + lat + "&lon=" + lon + "&foretxt=" + encodeURL(foretxt));
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("appKey", appKey);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			sb = new StringBuilder();
			String input;
			while ((input = in.readLine()) != null) {
				sb.append(input);
			}
			sb.toString();
		} catch (Exception e) {
			con.disconnect();
		}
		String json = sb.toString();
		JsonObject root = new JsonParser().parse(json).getAsJsonObject();
		JsonObject weather = root.get("weather").getAsJsonObject();
		JsonArray forecast3days = weather.get("forecast3days").getAsJsonArray();
		JsonObject precipitation = forecast3days.get(0).getAsJsonObject().get("fcst3hour").getAsJsonObject()
				.get("precipitation").getAsJsonObject();
		JsonObject sky = forecast3days.get(0).getAsJsonObject().get("fcst3hour").getAsJsonObject().get("sky")
				.getAsJsonObject();
		JsonObject temperature = forecast3days.get(0).getAsJsonObject().get("fcst3hour").getAsJsonObject()
				.get("temperature").getAsJsonObject();
		JsonObject humidity = forecast3days.get(0).getAsJsonObject().get("fcst3hour").getAsJsonObject().get("humidity")
				.getAsJsonObject();
		
		String timeRelease =forecast3days.get(0).getAsJsonObject().get("timeRelease").toString();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(timeRelease);
		Date today = null;
		try {
			today=format.parse(parseString(timeRelease.toString()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int hour=4;
		for(int i=0;i<15;i++) {
			ShortWeather weatherVO=new ShortWeather();
			weatherVO.setTimeRelease(today);
			weatherVO.setHum(parseString(humidity.get("rh"+Integer.toString(hour)+"hour").toString()));
			weatherVO.setSkyCode(parseString(sky.get("code"+Integer.toString(hour)+"hour").toString()));
			weatherVO.setPrdb(parseString(precipitation.get("prob"+Integer.toString(hour)+"hour").toString()));
			weatherVO.setTempo(parseString(temperature.get("temp"+Integer.toString(hour)+"hour").toString()));
			wList.add(weatherVO);
			hour+=3;
		}
		return wList;
	}
}
