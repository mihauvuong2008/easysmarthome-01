package home.ngocdong.easysmarthome.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import home.ngocdong.easysmarthome.entity.Nhiemvu;

public class NhiemvuForm {
	int Id_Nhiemvu;
	int Id_Thietbi;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	Date Thoigianbatdau;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	Date Thoigianketthuc;
	boolean Dathuchien;
	boolean newNhiemvu = false;

	public NhiemvuForm(Nhiemvu nhiemvu) {
		super();
		this.Id_Nhiemvu = nhiemvu.getId_Nhiemvu();
		this.Id_Thietbi = nhiemvu.getId_Thietbi();
		this.Thoigianbatdau = nhiemvu.getThoigianbatdau();
		this.Thoigianketthuc = nhiemvu.getThoigianketthuc();
	}

	public NhiemvuForm() {
		// TODO Auto-generated constructor stub
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

	public boolean isNewNhiemvu() {
		return newNhiemvu;
	}

	public void setNewNhiemvu(boolean newNhiemvu) {
		this.newNhiemvu = newNhiemvu;
	}

	public boolean isDathuchien() {
		return Dathuchien;
	}

	public void setDathuchien(boolean dathuchien) {
		Dathuchien = dathuchien;
	}

}
