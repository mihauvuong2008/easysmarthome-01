package home.ngocdong.easysmarthome.model;

import java.util.Date;

public class DulieucambienInfo {
	int id_Cambien;
	int Loaicambien;
	String Vitri;
	int Id_Arduinocontroller;
	Date Ngaygiokichhoat;
	int Giatri;

	public DulieucambienInfo(int id_Cambien, int loaicambien, String vitri, int id_Arduinocontroller,
			Date ngaygiokichhoat, int giatri) {
		super();
		this.id_Cambien = id_Cambien;
		Loaicambien = loaicambien;
		Vitri = vitri;
		this.Id_Arduinocontroller = id_Arduinocontroller;
		Ngaygiokichhoat = ngaygiokichhoat;
		Giatri = giatri;
	}

	public int getId_Cambien() {
		return id_Cambien;
	}

	public void setId_Cambien(int id_Cambien) {
		this.id_Cambien = id_Cambien;
	}

	public int getLoaicambien() {
		return Loaicambien;
	}

	public void setLoaicambien(int loaicambien) {
		Loaicambien = loaicambien;
	}

	public String getVitri() {
		return Vitri;
	}

	public void setVitri(String vitri) {
		Vitri = vitri;
	}

	public int getId_Arduinocontroller() {
		return Id_Arduinocontroller;
	}

	public void setId_Arduinocontroller(int id_Arduinocontroller) {
		Id_Arduinocontroller = id_Arduinocontroller;
	}

	public Date getNgaygiokichhoat() {
		return Ngaygiokichhoat;
	}

	public void setNgaygiokichhoat(Date ngaygiokichhoat) {
		Ngaygiokichhoat = ngaygiokichhoat;
	}

	public int getGiatri() {
		return Giatri;
	}

	public void setGiatri(int giatri) {
		Giatri = giatri;
	}

}
