package home.ngocdong.easysmarthome.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import home.ngocdong.easysmarthome.model.ArduinocontrollerInfo;

@Entity
@Table(name = "Arduinocontroller")
public class Arduinocontroller implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -733016554070925607L;
	@Id
	@Column(name = "Id_Arduinocontroller", nullable = false)
	private int id_Arduinocontroller;

	@Column(name = "TenArduinocontroller", length = 100, nullable = false)
	private String tenArduinocontroller;

	@Column(name = "DiachiIP", length = 50, nullable = false)
	private String diachiIP;

	public Arduinocontroller() {
		super();
	}

	public Arduinocontroller(ArduinocontrollerInfo arduinocontroller) {
		this.id_Arduinocontroller = arduinocontroller.getId_Arduinocontroller();
		this.tenArduinocontroller = arduinocontroller.getTenArduinocontroller();
		this.diachiIP = arduinocontroller.getDiachiIP();
	}

	public int getId_Arduinocontroller() {
		return id_Arduinocontroller;
	}

	public void setId_Arduinocontroller(int id_Arduinocontroller) {
		this.id_Arduinocontroller = id_Arduinocontroller;
	}

	public String getTenArduinocontroller() {
		return tenArduinocontroller;
	}

	public void setTenArduinocontroller(String tenArduinocontroller) {
		this.tenArduinocontroller = tenArduinocontroller;
	}

	public String getDiachiIP() {
		return diachiIP;
	}

	public void setDiachiIP(String diachiIP) {
		this.diachiIP = diachiIP;
	}

	@Override
	public String toString() {
		return "[" + this.id_Arduinocontroller + "," + this.tenArduinocontroller + "," + this.diachiIP + "]";
	}

}
