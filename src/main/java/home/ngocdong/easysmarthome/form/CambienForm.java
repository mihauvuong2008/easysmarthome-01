package home.ngocdong.easysmarthome.form;

import home.ngocdong.easysmarthome.entity.Cambien;

public class CambienForm {
	private int Id_Cambien;
	private String Tencambien;
	private int Id_Vitri;
	private int Id_Arduinocontroller;
	private int Loaicambien;

	private boolean newCambien = false;

	public CambienForm() {
		// TODO Auto-generated constructor stub
	}

	public CambienForm(Cambien cambien) {
		if (cambien != null) {
			this.Id_Cambien = cambien.getId_Cambien();
			this.Tencambien = cambien.getTencambien();
			this.Id_Vitri = cambien.getId_Vitri();
			this.Id_Arduinocontroller = cambien.getId_Arduinocontroller();
			this.Loaicambien = cambien.getLoaicambien();
		}

	}

	public int getId_Cambien() {
		return Id_Cambien;
	}

	public void setId_Cambien(int id_Cambien) {
		Id_Cambien = id_Cambien;
	}

	public String getTencambien() {
		return Tencambien;
	}

	public void setTencambien(String tencambien) {
		Tencambien = tencambien;
	}

	public int getId_Vitri() {
		return Id_Vitri;
	}

	public void setId_Vitri(int id_vitri) {
		Id_Vitri = id_vitri;
	}

	public int getLoaicambien() {
		return Loaicambien;
	}

	public void setLoaicambien(int loaicambien) {
		Loaicambien = loaicambien;
	}

	public int getId_Arduinocontroller() {
		return Id_Arduinocontroller;
	}

	public void setId_Arduinocontroller(int id_Arduinocontroller) {
		Id_Arduinocontroller = id_Arduinocontroller;
	}

	public void setNewCambien(boolean b) {
		newCambien = b;
	}

	public boolean isNewCambien() {
		return newCambien;
	}

}
