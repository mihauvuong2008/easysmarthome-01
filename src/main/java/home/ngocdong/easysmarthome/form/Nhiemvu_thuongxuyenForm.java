package home.ngocdong.easysmarthome.form;

import home.ngocdong.easysmarthome.entity.Nhiemvu_thuongxuyen;

public class Nhiemvu_thuongxuyenForm {

	int Id_Nhiemvu_thuongxuyen;
	String TenNhiemvuthuongxuyen;
	int Id_Thietbi;
	int Thoigian;
	boolean NewNhiemvu_thuongxuyen = false;

	public Nhiemvu_thuongxuyenForm(Nhiemvu_thuongxuyen nhiemvu_thuongxuyen) {
		this.Id_Nhiemvu_thuongxuyen = nhiemvu_thuongxuyen.getId_Nhiemvu_thuongxuyen();
		this.TenNhiemvuthuongxuyen = nhiemvu_thuongxuyen.getTenNhiemvuthuongxuyen();
		this.Id_Thietbi = nhiemvu_thuongxuyen.getId_Thietbi();
		this.Thoigian = nhiemvu_thuongxuyen.getThoigian();
	}

	public Nhiemvu_thuongxuyenForm() {
		// TODO Auto-generated constructor stub
	}

	public int getId_Nhiemvu_thuongxuyen() {
		return Id_Nhiemvu_thuongxuyen;
	}

	public void setId_Nhiemvu_thuongxuyen(int id_Nhiemvu_thuongxuyen) {
		Id_Nhiemvu_thuongxuyen = id_Nhiemvu_thuongxuyen;
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

	public boolean isNewNhiemvu_thuongxuyen() {
		return NewNhiemvu_thuongxuyen;
	}

	public void setNewNhiemvu_thuongxuyen(boolean newNhiemvu_thuongxuyen) {
		NewNhiemvu_thuongxuyen = newNhiemvu_thuongxuyen;
	}

}
