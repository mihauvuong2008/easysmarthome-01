package home.ngocdong.easysmarthome.form;

import home.ngocdong.easysmarthome.entity.Thietbi;

public class ThietbiForm {

	private int Id_Thietbi;
	private String Tenthietbi;
	private int Trangthai;
	private int Id_Vitri;
	private boolean newThietbi = false;
	private boolean Active = false;

	public ThietbiForm(Thietbi thietbi) {
		Id_Thietbi = thietbi.getId_Thietbi();
		Tenthietbi = thietbi.getTenthietbi();
		Trangthai = thietbi.getTrangthai();
		Active = Trangthai == 0 ? false : true;
		Id_Vitri = thietbi.getId_Vitri();
	}

	public ThietbiForm() {
		// TODO Auto-generated constructor stub
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

	public boolean isNewThietbi() {
		return newThietbi;
	}

	public void setNewThietbi(boolean newThietbi) {
		this.newThietbi = newThietbi;
	}

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		this.Active = active;
		Trangthai = active ? 1 : 0;
	}

}
