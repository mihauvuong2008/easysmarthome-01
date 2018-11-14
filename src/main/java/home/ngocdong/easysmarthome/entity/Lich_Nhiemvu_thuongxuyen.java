package home.ngocdong.easysmarthome.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Nhiemvu_thuongxuyen")

public class Lich_Nhiemvu_thuongxuyen {

	int Id_Lich_Nhiemvu;
	int Id_Nhiemvu_thuongxuyen;
	Date Thoigianthuchien;

	@Id
	@Column(name = "Id_Lich_Nhiemvu", nullable = false)
	public int getId_Lich_Nhiemvu() {
		return Id_Lich_Nhiemvu;
	}

	public void setId_Lich_Nhiemvu(int id_Lich_Nhiemvu) {
		Id_Lich_Nhiemvu = id_Lich_Nhiemvu;
	}

	@Column(name = "Id_Nhiemvu_thuongxuyen", nullable = false)
	public int getId_Nhiemvu_thuongxuyen() {
		return Id_Nhiemvu_thuongxuyen;
	}

	public void setId_Nhiemvu_thuongxuyen(int id_Nhiemvu_thuongxuyen) {
		Id_Nhiemvu_thuongxuyen = id_Nhiemvu_thuongxuyen;
	}

	@Column(name = "Thoigianthuchien", nullable = false)
	public Date getThoigianthuchien() {
		return Thoigianthuchien;
	}

	public void setThoigianthuchien(Date thoigianthuchien) {
		Thoigianthuchien = thoigianthuchien;
	}

}
