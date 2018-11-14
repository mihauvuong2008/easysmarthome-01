package home.ngocdong.easysmarthome.arduinocommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import home.ngocdong.easysmarthome.model.RelayInfo;

public class SmarthomeNetworkCommunication {

	public static void sendGetHttpCommand_turnOn(String ip, RelayInfo rl) throws IOException {
		String changeState = "http://" + ip + "/?control" + rl.getTenrelay() + "_on";

		URL obj = new URL(changeState);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET 
		con.setRequestMethod("GET");
		con.setConnectTimeout(5000);
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + changeState);
		System.out.println("Response Code : " + responseCode);
		BufferedReader br;
		if (200 <= con.getResponseCode() && con.getResponseCode() <= 299) {
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		String line = "";
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}

	public static void sendGetHttpCommand_turnOff(String ip, RelayInfo rl) throws IOException {
		String changeState = "http://" + ip + "/?control" + rl.getTenrelay() + "_off";

		URL obj = new URL(changeState);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		con.setConnectTimeout(5000);
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + changeState);
		System.out.println("Response Code : " + responseCode);
	}

}
