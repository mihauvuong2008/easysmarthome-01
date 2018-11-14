package home.ngocdong.easysmarthome.model;

public class Thietbi_relayInfo {
	int Id_Thietbi;
	int Id_relay;
	String Tenthietbi;
	int trangthai;
	int id_Vitri;
	String Tenrelay;
	int Id_Arduinocontroller;

	public Thietbi_relayInfo(int id_relay, int id_Thietbi) {
		super();
		Id_Thietbi = id_Thietbi;
		Id_relay = id_relay;
	}

	public Thietbi_relayInfo(int id_Thietbi, int id_relay, String tenthietbi, int trangthai, int id_Vitri,
			String tenrelay, int id_Arduinocontroller) {
		super();
		Id_Thietbi = id_Thietbi;
		Id_relay = id_relay;
		Tenthietbi = tenthietbi;
		this.trangthai = trangthai;
		this.id_Vitri = id_Vitri;
		Tenrelay = tenrelay;
		Id_Arduinocontroller = id_Arduinocontroller;
	}

	public int getId_Thietbi() {
		return Id_Thietbi;
	}

	public void setId_Thietbi(int id_Thietbi) {
		Id_Thietbi = id_Thietbi;
	}

	public int getId_relay() {
		return Id_relay;
	}

	public void setId_relay(int id_relay) {
		Id_relay = id_relay;
	}

	public String getTenthietbi() {
		return Tenthietbi;
	}

	public void setTenthietbi(String tenthietbi) {
		Tenthietbi = tenthietbi;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public int getId_Vitri() {
		return id_Vitri;
	}

	public void setId_Vitri(int id_Vitri) {
		this.id_Vitri = id_Vitri;
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
