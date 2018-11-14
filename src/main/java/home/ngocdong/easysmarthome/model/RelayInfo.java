package home.ngocdong.easysmarthome.model;

public class RelayInfo {
	int Id_relay;
	String Tenrelay;
	int Id_Arduinocontroller;

	public RelayInfo(int id_relay, String tenrelay, int id_Arduinocontroller) {
		super();
		Id_relay = id_relay;
		Tenrelay = tenrelay;
		Id_Arduinocontroller = id_Arduinocontroller;
	}

	public int getId_relay() {
		return Id_relay;
	}

	public void setId_relay(int id_relay) {
		Id_relay = id_relay;
	}

	public String getTenrelay() {
		return Tenrelay;
	}

	public void setTenrelay(String tenrelay) {
		Tenrelay = tenrelay;
	}

	public int getId_Arduinocontroller() {
		return Id_Arduinocontroller;
	}

	public void setId_Arduinocontroller(int id_Arduinocontroller) {
		Id_Arduinocontroller = id_Arduinocontroller;
	}

}
