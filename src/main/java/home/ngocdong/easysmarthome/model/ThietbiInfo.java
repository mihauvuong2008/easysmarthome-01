package home.ngocdong.easysmarthome.model;

public class ThietbiInfo {
	int Id_Thietbi;
	String Tenthietbi;
	int Trangthai;
	int Id_Vitri;

	public ThietbiInfo(int id_Thietbi, String tenthietbi, int trangthai, int id_Vitri) {
		super();
		Id_Thietbi = id_Thietbi;
		Tenthietbi = tenthietbi;
		Trangthai = trangthai;
		Id_Vitri = id_Vitri;
	}

	public int getId_Thietbi() {
		return Id_Thietbi;
	}

	public void setId_Thietbi(int id_Thietbi) {
		Id_Thietbi = id_Thietbi;
	}

	public String getTenthietbi() {
		return Tenthietbi;
	}

	public void setTenthietbi(String tenthietbi) {
		Tenthietbi = tenthietbi;
	}

	public int getTrangthai() {
		return Trangthai;
	}

	public void setTrangthai(int trangthai) {
		Trangthai = trangthai;
	}

	public int getId_Vitri() {
		return Id_Vitri;
	}

	public void setId_Vitri(int id_Vitri) {
		Id_Vitri = id_Vitri;
	}

}
