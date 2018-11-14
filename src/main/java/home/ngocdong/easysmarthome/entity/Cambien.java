package home.ngocdong.easysmarthome.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cambien")
public class Cambien implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6280603399705504046L;

	private int Id_Cambien;
	private String Tencambien;
	private int Id_Vitri;
	private int Id_Arduinocontroller;
	private int Loaicambien;

	public Cambien() {
	}

	@Id
	@Column(name = "Id_Cambien", nullable = false)
	public int getId_Cambien() {
		return Id_Cambien;
	}

	public void setId_Cambien(int Id_Cambien) {
		this.Id_Cambien = Id_Cambien;
	}

	@Column(name = "Tencambien", nullable = false)
	public String getTencambien() {
		return Tencambien;
	}

	public void setTencambien(String Tencambien) {
		this.Tencambien = Tencambien;
	}

	@Column(name = "Id_Vitri", nullable = false)
	public int getId_Vitri() {
		return Id_Vitri;
	}

	public void setId_Vitri(int Id_vitri) {
		this.Id_Vitri = Id_vitri;
	}

	@Column(name = "Loaicambien", nullable = false)
	public int getLoaicambien() {
		return Loaicambien;
	}

	public void setLoaicambien(int Loaicambien) {
		this.Loaicambien = Loaicambien;
	}

	@Column(name = "Id_Arduinocontroller", nullable = false)
	public int getId_Arduinocontroller() {
		return Id_Arduinocontroller;
	}

	public void setId_Arduinocontroller(int Id_Arduinocontroller) {
		this.Id_Arduinocontroller = Id_Arduinocontroller;
	}

	@Override
	public String toString() {
		return "[" + this.Id_Cambien + "," + this.Tencambien + "," + this.Id_Vitri + "," + this.Loaicambien + "]";
	}

}