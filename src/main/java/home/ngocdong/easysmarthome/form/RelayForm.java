package home.ngocdong.easysmarthome.form;

import home.ngocdong.easysmarthome.entity.Relay;
import home.ngocdong.easysmarthome.model.RelayInfo;

public class RelayForm {
	int Id_relay;
	String Tenrelay;
	int Id_Arduinocontroller;
	boolean newRelay = false;

	public RelayForm(Relay relay) {
		Id_relay = relay.getId_relay();
		Tenrelay = relay.getTenrelay();
		Id_Arduinocontroller = relay.getId_Arduinocontroller();
	}

	public RelayForm(RelayInfo relay) {
		Id_relay = relay.getId_relay();
		Tenrelay = relay.getTenrelay();
		Id_Arduinocontroller = relay.getId_Arduinocontroller();
	}

	public RelayForm() {
		// TODO Auto-generated constructor stub
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

	public boolean isNewRelay() {
		return newRelay;
	}

	public void setNewRelay(boolean newRelay) {
		this.newRelay = newRelay;
	}

}
