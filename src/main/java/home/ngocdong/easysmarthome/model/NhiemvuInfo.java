package home.ngocdong.easysmarthome.model;

import java.util.Date;

public class NhiemvuInfo {

	int Id_Nhiemvu;
	int Id_Thietbi;
	String Tenthietbi;
	String Vitri;
	Date Thoigianbatdau;
	Date Thoigianketthuc;
	boolean Dathuchien;

	public NhiemvuInfo(int id_Nhiemvu, int id_Thietbi, String tenthietbi, String vitri, Date thoigianbatdau,
			Date thoigianketthuc, boolean Dathuchien) {
		super();
		Id_Nhiemvu = id_Nhiemvu;
		Id_Thietbi = id_Thietbi;
		Tenthietbi = tenthietbi;
		Vitri = vitri;
		Thoigianbatdau = thoigianbatdau;
		Thoigianketthuc = thoigianketthuc;
		this.Dathuchien = Dathuchien;
	}

	public NhiemvuInfo(int id_Nhiemvu, int id_Thietbi, Date thoigianbatdau, Date thoigianketthuc, boolean Dathuchien) {
		super();
		Id_Nhiemvu = id_Nhiemvu;
		Id_Thietbi = id_Thietbi;
		Thoigianbatdau = thoigianbatdau;
		Thoigianketthuc = thoigianketthuc;
		this.Dathuchien = Dathuchien;
	}

	public int getId_Nhiemvu() {
		return Id_Nhiemvu;
	}

	public void setId_Nhiemvu(int id_Nhiemvu) {
		Id_Nhiemvu = id_Nhiemvu;
	}

	public int getId_Thietbi() {
		return Id_Thietbi;
	}

	public void setId_Thietbi(int id_Thietbi) {
		Id_Thietbi = id_Thietbi;
	}

	public Date getThoigianbatdau() {
		return Thoigianbatdau;
	}

	public void setThoigianbatdau(Date thoigianbatdau) {
		Thoigianbatdau = thoigianbatdau;
	}

	public Date getThoigianketthuc() {
		return Thoigianketthuc;
	}

	public void setThoigianketthuc(Date thoigianketthuc) {
		Thoigianketthuc = thoigianketthuc;
	}

	public String getTenthietbi() {
		return Tenthietbi;
	}

	public void setTenthietbi(String tenthietbi) {
		Tenthietbi = tenthietbi;
	}

	public String getVitri() {
		return Vitri;
	}

	public void setVitri(String vitri) {
		Vitri = vitri;
	}

	public boolean isDathuchien() {
		return Dathuchien;
	}

	public void setDathuchien(boolean dathuchien) {
		Dathuchien = dathuchien;
	}

}
