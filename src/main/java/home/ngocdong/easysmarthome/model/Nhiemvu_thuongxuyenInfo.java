package home.ngocdong.easysmarthome.model;

import java.util.Date;

public class Nhiemvu_thuongxuyenInfo {
	int id_Lich_Nhiemvu;
	int Id_Nhiemvu_thuongxuyen;
	Date thoigianthuchien;
	String TenNhiemvuthuongxuyen;
	int Id_Thietbi;
	int Thoigian;
	String TenThietbi;

	public Nhiemvu_thuongxuyenInfo(int id_Nhiemvu_thuongxuyen, String tenNhiemvuthuongxuyen, int id_Thietbi,
			int thoigian) {
		super();
		Id_Nhiemvu_thuongxuyen = id_Nhiemvu_thuongxuyen;
		TenNhiemvuthuongxuyen = tenNhiemvuthuongxuyen;
		Id_Thietbi = id_Thietbi;
		Thoigian = thoigian;
	}
	public Nhiemvu_thuongxuyenInfo(int id_Nhiemvu_thuongxuyen, String tenNhiemvuthuongxuyen, int id_Thietbi,
			int thoigian, String tenThietbi) {
		super();
		Id_Nhiemvu_thuongxuyen = id_Nhiemvu_thuongxuyen;
		TenNhiemvuthuongxuyen = tenNhiemvuthuongxuyen;
		Id_Thietbi = id_Thietbi;
		Thoigian = thoigian;
		TenThietbi = tenThietbi;
	}

	
	
	public Nhiemvu_thuongxuyenInfo(int id_Lich_Nhiemvu, int id_Nhiemvu_thuongxuyen, Date thoigianthuchien,
			String tenNhiemvuthuongxuyen, int id_Thietbi, int thoigian, String tenThietbi) {
		super();
		this.id_Lich_Nhiemvu = id_Lich_Nhiemvu;
		Id_Nhiemvu_thuongxuyen = id_Nhiemvu_thuongxuyen;
		this.thoigianthuchien = thoigianthuchien;
		TenNhiemvuthuongxuyen = tenNhiemvuthuongxuyen;
		Id_Thietbi = id_Thietbi;
		Thoigian = thoigian;
		TenThietbi = tenThietbi;
	}

	public int getId_Lich_Nhiemvu() {
		return id_Lich_Nhiemvu;
	}

	public void setId_Lich_Nhiemvu(int id_Lich_Nhiemvu) {
		this.id_Lich_Nhiemvu = id_Lich_Nhiemvu;
	}

	public int getId_Nhiemvu_thuongxuyen() {
		return Id_Nhiemvu_thuongxuyen;
	}

	public void setId_Nhiemvu_thuongxuyen(int id_Nhiemvu_thuongxuyen) {
		Id_Nhiemvu_thuongxuyen = id_Nhiemvu_thuongxuyen;
	}

	public Date getThoigianthuchien() {
		return thoigianthuchien;
	}

	public void setThoigianthuchien(Date thoigianthuchien) {
		this.thoigianthuchien = thoigianthuchien;
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

	public String getTenThietbi() {
		return TenThietbi;
	}

	public void setTenThietbi(String tenThietbi) {
		TenThietbi = tenThietbi;
	}
 
}
