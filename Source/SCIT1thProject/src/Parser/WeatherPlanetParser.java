package Parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherPlanetParser {
	private final static String appKey = "4abe6551-2de1-4a44-b099-5f35ace58669";
	private final static String apiURL = "https://api2.sktelecom.com/weather/forecast/6days?version=2";

	public void parshing() {
		String city = "서울";
		String county = "강남구";
		String village = "도곡동";
		String foretxt = "N";
		StringBuilder sb = null;
		try {
			URL url = new URL(apiURL + "&city=" + encodeURL(city) + "&county=" + encodeURL(county) + "&village="
					+ encodeURL(village) + "&foretxt=" + encodeURL(foretxt));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
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
			System.out.println(sb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json=sb.toString();
		Gson gson = new Gson();
		JsonObject root=new JsonParser().parse(json).getAsJsonObject();
		JsonObject weather=root.get("weather").getAsJsonObject();
		JsonArray forecast6days=weather.get("forecast6days").getAsJsonArray();
		JsonObject sky=forecast6days.get(0).getAsJsonObject().get("sky").getAsJsonObject();
		System.out.println(sky.get("amName2day").toString());
		System.out.println(sky.get("amName3day").toString());
		JsonObject temperature=forecast6days.get(0).getAsJsonObject().get("temperature").getAsJsonObject();
	}

	public String encodeURL(String url) {
		try {
			return URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
