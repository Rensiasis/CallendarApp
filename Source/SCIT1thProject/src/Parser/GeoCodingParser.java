package Parser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GeoCodingParser {
	private final static String apiURL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
	private final static String apiKey = "AIzaSyCQ5MdKDR9MFIVwNczdSeRFWKawZBX8cC8";
	private String address;
	private double lat;
	private double lon;
	
	public GeoCodingParser(String address) {
		super();
		this.address = address;
	}

	public GeoCodingParser() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public void parshing() {
		StringBuffer inputData = null;
		try {
			URL url = new URL(apiURL + URLEncoder.encode(address, "UTF-8") + "&key=" + apiKey);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setDoOutput(false);
			con.setDoInput(true);
			con.setUseCaches(false);
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
		JsonObject root = new JsonParser().parse(json).getAsJsonObject();
		JsonArray subnode = root.get("results").getAsJsonArray();
		JsonObject geometry = subnode.get(0).getAsJsonObject().get("geometry").getAsJsonObject();
		JsonObject location = geometry.get("location").getAsJsonObject();
		lat = location.get("lat").getAsDouble();
		lon = location.get("lng").getAsDouble();
		System.out.println(lat + " " + lon);
	}
}
