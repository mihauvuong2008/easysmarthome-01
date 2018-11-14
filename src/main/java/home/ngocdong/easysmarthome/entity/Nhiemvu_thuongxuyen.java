package home.ngocdong.easysmarthome.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Nhiemvu_thuongxuyen")
public class Nhiemvu_thuongxuyen {
	int Id_Nhiemvu_thuongxuyen;
	String TenNhiemvuthuongxuyen;
	int Id_Thietbi;
	int Thoigian;

	@Id
	@Column(name = "Id_Nhiemvu_thuongxuyen", nullable = false)
	public int getId_Nhiemvu_thuongxuyen() {
		return Id_Nhiemvu_thuongxuyen;
	}

	public void setId_Nhiemvu_thuongxuyen(int id_Nhiemvu_thuongxuyen) {
		Id_Nhiemvu_thuongxuyen = id_Nhiemvu_thuongxuyen;
	}

	@Column(name = "TenNhiemvuthuongxuyen", nullable = false)
	public String getTenNhiemvuthuongxuyen() {
		return TenNhiemvuthuongxuyen;
	}

	public void setTenNhiemvuthuongxuyen(String tenNhiemvuthuongxuyen) {
		TenNhiemvuthuongxuyen = tenNhiemvuthuongxuyen;
	}

	@Column(name = "Id_Thietbi", nullable = false)
	public int getId_Thietbi() {
		return Id_Thietbi;
	}

	public void setId_Thietbi(int id_Thietbi) {
		Id_Thietbi = id_Thietbi;
	}

	@Column(name = "Thoigian", nullable = false)
	public int getThoigian() {
		return Thoigian;
	}

	public void setThoigian(int thoigian) {
		Thoigian = thoigian;
	}

}
