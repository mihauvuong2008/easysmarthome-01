package home.ngocdong.easysmarthome.model;

import java.util.Date;

public class Lich_Nhiemvu_thuongxuyenInfo {
	int Id_Lich_Nhiemvu;
	int Id_Nhiemvu_thuongxuyen;
	Date Thoigianthuchien;
	String TenNhiemvuthuongxuyen;
	int Id_Thietbi;
	int Thoigian;
	String Tenthietbi;

	public Lich_Nhiemvu_thuongxuyenInfo(int id_Lich_Nhiemvu, int id_Nhiemvu_thuongxuyen, Date thoigianthuchien,
			String tenNhiemvuthuongxuyen, int id_Thietbi, int thoigian, String tenthietbi) {
		super();
		Id_Lich_Nhiemvu = id_Lich_Nhiemvu;
		Id_Nhiemvu_thuongxuyen = id_Nhiemvu_thuongxuyen;
		Thoigianthuchien = thoigianthuchien;
		TenNhiemvuthuongxuyen = tenNhiemvuthuongxuyen;
		Id_Thietbi = id_Thietbi;
		Thoigian = thoigian;
		Tenthietbi = tenthietbi;
	}

	public Lich_Nhiemvu_thuongxuyenInfo(int id_Lich_Nhiemvu, int id_Nhiemvu_thuongxuyen, Date thoigianthuchien) {
		super();
		Id_Lich_Nhiemvu = id_Lich_Nhiemvu;
		Id_Nhiemvu_thuongxuyen = id_Nhiemvu_thuongxuyen;
		Thoigianthuchien = thoigianthuchien;
	}

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

	public String getTenNhiemvuthuongxuyen() {
		return TenNhiemvuthuongxuyen;
	}

	public void setTenNhiemvuthuongxuyen(String tenNhiemvuthuongxuyen) {
		TenNhiemvuthuongxuyen = tenNhiemvuthuongxuyen;
	}

	public int getId_Thietbi() {
		return Id_Thietbi;
	}

	public void setId_Thietbi(int id_Thietbi) {
		Id_Thietbi = id_Thietbi;
	}

	public int getThoigian() {
		return Thoigian;
	}

	public void setThoigian(int thoigian) {
		Thoigian = thoigian;
	}

	public String getTenthietbi() {
		return Tenthietbi;
	}

	public void setTenthietbi(String tenthietbi) {
		Tenthietbi = tenthietbi;
	}

}
