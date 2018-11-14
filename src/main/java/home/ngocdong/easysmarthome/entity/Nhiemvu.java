package home.ngocdong.easysmarthome.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Nhiemvu")
public class Nhiemvu {
	int Id_Nhiemvu;
	int Id_Thietbi;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	Date Thoigianbatdau;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	Date Thoigianketthuc;
	boolean Dathuchien;

	@Id
	@Column(name = "Id_Nhiemvu", nullable = false)
	public int getId_Nhiemvu() {
		return Id_Nhiemvu;
	}

	public void setId_Nhiemvu(int id_Nhiemvu) {
		Id_Nhiemvu = id_Nhiemvu;
	}

	@Column(name = "Id_Thietbi", nullable = false)
	public int getId_Thietbi() {
		return Id_Thietbi;
	}

	public void setId_Thietbi(int id_Thietbi) {
		Id_Thietbi = id_Thietbi;
	}

	@Column(name = "Thoigianbatdau", nullable = false)
	public Date getThoigianbatdau() {
		return Thoigianbatdau;
	}

	public void setThoigianbatdau(Date thoigianbatdau) {
		Thoigianbatdau = thoigianbatdau;
	}

	@Column(name = "Thoigianketthuc", nullable = false)
	public Date getThoigianketthuc() {
		return Thoigianketthuc;
	}

	public void setThoigianketthuc(Date thoigianketthuc) {
		Thoigianketthuc = thoigianketthuc;
	}

	@Column(name = "Dathuchien", nullable = false)
	public boolean isDathuchien() {
		return Dathuchien;
	}

	public void setDathuchien(boolean dathuchien) {
		Dathuchien = dathuchien;
	}

}
