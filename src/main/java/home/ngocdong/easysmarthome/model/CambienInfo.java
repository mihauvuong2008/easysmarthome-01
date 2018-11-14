package home.ngocdong.easysmarthome.model;

public class CambienInfo {

	private int Id_Cambien;
	private String Tencambien;
	private int Id_Vitri;
	private int Id_Arduinocontroller;
	private int Loaicambien;

	public CambienInfo(int id_Cambien, String tencambien, int id_Vitri, int id_Arduinocontroller, int loaicambien) {
		super();
		this.Id_Cambien = id_Cambien;
		this.Tencambien = tencambien;
		this.Id_Vitri = id_Vitri;
		this.Id_Arduinocontroller = id_Arduinocontroller;
		this.Loaicambien = loaicambien;
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

	public int getId_Arduinocontroller() {
		return Id_Arduinocontroller;
	}

	public void setId_Arduinocontroller(int id_Arduinocontroller) {
		Id_Arduinocontroller = id_Arduinocontroller;
	}

	public int getLoaicambien() {
		return Loaicambien;
	}

	public void setLoaicambien(int loaicambien) {
		Loaicambien = loaicambien;
	}

}
