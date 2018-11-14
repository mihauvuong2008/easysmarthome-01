package home.ngocdong.easysmarthome.form;

import home.ngocdong.easysmarthome.entity.Arduinocontroller;
import home.ngocdong.easysmarthome.model.ArduinocontrollerInfo;

public class ArduinocontrollerForm {
	private int Id_Arduinocontroller;
	private String TenArduinocontroller;
	private String DiachiIP;

	private boolean newArduinocontroller = false;

	public ArduinocontrollerForm() {
		// TODO Auto-generated constructor stub
	}

	public ArduinocontrollerForm(Arduinocontroller arduinocontroller) {
		if (arduinocontroller != null) {
			this.Id_Arduinocontroller = arduinocontroller.getId_Arduinocontroller();
			this.TenArduinocontroller = arduinocontroller.getTenArduinocontroller();
			this.DiachiIP = arduinocontroller.getDiachiIP();
		}
	}

	public ArduinocontrollerForm(ArduinocontrollerInfo arduinocontroller) {
		if (arduinocontroller != null) {
			this.Id_Arduinocontroller = arduinocontroller.getId_Arduinocontroller();
			this.TenArduinocontroller = arduinocontroller.getTenArduinocontroller();
			this.DiachiIP = arduinocontroller.getDiachiIP();
		}
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

	public boolean isNewArduinocontroller() {
		return newArduinocontroller;
	}

	public void setNewArduinocontroller(boolean newArduinocontroller) {
		this.newArduinocontroller = newArduinocontroller;
	}

}
