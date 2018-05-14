package Parser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import VO.EventDay;

public class EventDayParser {
	private final static String TDCProductKey = "c40fc6d5-daa6-4b00-8513-093434c8893b";
	private final static String apiURL = "https://apis.sktelecom.com/v1/eventday/days?type=";

	public static ArrayList<EventDay> parshing(String type, String year) {
		ArrayList<EventDay> eventList = new ArrayList<>();
		StringBuffer inputData = null;
		try {
			URL url = new URL(apiURL + type + "&year=" + year);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setDoOutput(false);
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setRequestProperty("tdcprojectkey", TDCProductKey);
			con.setRequestProperty("Accept", "application/json");
			InputStream ist = con.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(ist));
			StringBuilder sb = new StringBuilder();
			String input = "";
			inputData = new StringBuffer();
			while ((input = in.readLine()) != null) {
				inputData.append(input);
			}
			in.close();
			con.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json = inputData.toString();
		Gson gson = new Gson();
		JsonObject root = new JsonParser().parse(json).getAsJsonObject();
		JsonArray subnode = root.get("results").getAsJsonArray();
		for (int i = 0; i < subnode.size(); i++) {
			eventList.add(gson.fromJson(subnode.get(i), EventDay.class));
		}
		return eventList;
	}
}
