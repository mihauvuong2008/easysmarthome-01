package home.ngocdong.easysmarthome.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Dulieucambien")
public class Dulieucambien implements Serializable {

	private static final long serialVersionUID = -2054386655979281969L;

	private int Id_Cambien;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date Ngaygiokichhoat;
	private int Giatri;

	// public Lichsucambien(LichsucambienInfo lichsucambienInfo) {
	// this.Id_Cambien = lichsucambienInfo.getId_Cambien();
	// this.Ngaygiokichhoat = lichsucambienInfo.getNgaygiokichhoat();
	// this.Giatri = lichsucambienInfo.getGiatri();
	// }

	@Id
	@Column(name = "Id_Cambien", nullable = false)
	public int getId_Cambien() {
		return Id_Cambien;
	}

	public void setId_Cambien(int Id_Cambien) {
		this.Id_Cambien = Id_Cambien;
	}

	@Column(name = "Ngaygiokichhoat", nullable = false)
	public Date getNgaygiokichhoat() {
		return Ngaygiokichhoat;
	}

	public void setNgaygiokichhoat(Date Ngaygiokichhoat) {
		this.Ngaygiokichhoat = Ngaygiokichhoat;
	}

	@Column(name = "Giatri", nullable = false)
	public int getGiatri() {
		return Giatri;
	}

	public void setGiatri(int Giatri) {
		this.Giatri = Giatri;
	}

	@Override
	public String toString() {
		return "[" + this.Id_Cambien + "," + this.Ngaygiokichhoat + "," + this.Giatri + "]";
	}
}