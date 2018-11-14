package home.ngocdong.easysmarthome.model;

public class ArduinocontrollerInfo {
	private int Id_Arduinocontroller;
	private String TenArduinocontroller;
	private String DiachiIP;

	public ArduinocontrollerInfo(int Id_Arduinocontroller, String TenArduinocontroller, String DiachiIP) {
		super();
		this.Id_Arduinocontroller = Id_Arduinocontroller;
		this.TenArduinocontroller = TenArduinocontroller;
		this.DiachiIP = DiachiIP;
	}

	public int getId_Arduinocontroller() {
		return Id_Arduinocontroller;
	}

	public void setId_Arduinocontroller(int id_Arduinocontroller) {
		Id_Arduinocontroller = id_Arduinocontroller;
	}

	public String getTenArduinocontroller() {
		return TenArduinocontroller;
	}

	public void setTenArduinocontroller(String tenArduinocontroller) {
		TenArduinocontroller = tenArduinocontroller;
	}

	public String getDiachiIP() {
		return DiachiIP;
	}

	public void setDiachiIP(String diachiIP) {
		DiachiIP = diachiIP;
	}

}
