package home.ngocdong.easysmarthome.form;

import java.util.Date;

public class Lich_Nhiemvu_thuongxuyenForm {
	int Id_Lich_Nhiemvu;
	int Id_Nhiemvu_thuongxuyen;
	Date Thoigianthuchien;
	boolean newLich_Nhiemvu_thuongxuyenForm;

	public int getId_Lich_Nhiemvu() {
		return Id_Lich_Nhiemvu;
	}

	public void setId_Lich_Nhiemvu(int id_Lich_Nhiemvu) {
		Id_Lich_Nhiemvu = id_Lich_Nhiemvu;
	}

	public int getId_Nhiemvu_thuongxuyen() {
		return Id_Nhiemvu_thuongxuyen;
	}

	public void setId_Nhiemvu_thuongxuyen(int id_Nhiemvu_thuongxuyen) {
		Id_Nhiemvu_thuongxuyen = id_Nhiemvu_thuongxuyen;
	}

	public Date getThoigianthuchien() {
		return Thoigianthuchien;
	}

	public void setThoigianthuchien(Date thoigianthuchien) {
		Thoigianthuchien = thoigianthuchien;
	}

	public boolean isNewLich_Nhiemvu_thuongxuyenForm() {
		return newLich_Nhiemvu_thuongxuyenForm;
	}

	public void setNewLich_Nhiemvu_thuongxuyenForm(boolean newLich_Nhiemvu_thuongxuyenForm) {
		this.newLich_Nhiemvu_thuongxuyenForm = newLich_Nhiemvu_thuongxuyenForm;
	}

}
