package home.ngocdong.easysmarthome.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Relay")
public class Relay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5649868904257186249L;

	@Id
	@Column(name = "Id_relay", nullable = false)
	private int id_relay;

	@Column(name = "Tenrelay", length = 100, nullable = false)
	private String tenrelay;

	@Column(name = "Id_Arduinocontroller", nullable = false)
	private int id_Arduinocontroller;

	public int getId_relay() {
		return id_relay;
	}

	public void setId_relay(int id_relay) {
		this.id_relay = id_relay;
	}

	public String getTenrelay() {
		return tenrelay;
	}

	public void setTenrelay(String tenrelay) {
		this.tenrelay = tenrelay;
	}

	public int getId_Arduinocontroller() {
		return id_Arduinocontroller;
	}

	public void setId_Arduinocontroller(int id_Arduinocontroller) {
		this.id_Arduinocontroller = id_Arduinocontroller;
	}

}
