package home.ngocdong.easysmarthome.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lichkhoidongthietbitrongnam")
public class Lichkhoidongthietbitrongnam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8814799324507211918L;

	int Id_Lichkhoidongthietbitrongnam;
	Date Tungay;
	Date Denngay;
	int Id_Thietbi;

	@Id
	@Column(name = "Id_Lichkhoidongthietbitrongnam", nullable = false)
	public int getId_Lichkhoidongthietbitrongnam() {
		return Id_Lichkhoidongthietbitrongnam;
	}

	public void setId_Lichkhoidongthietbitrongnam(int id_Lichkhoidongthietbitrongnam) {
		Id_Lichkhoidongthietbitrongnam = id_Lichkhoidongthietbitrongnam;
	}

	@Column(name = "Tungay", nullable = false)
	public Date getTungay() {
		return Tungay;
	}

	public void setTungay(Date tungay) {
		Tungay = tungay;
	}

	@Column(name = "Denngay", nullable = false)
	public Date getDenngay() {
		return Denngay;
	}

	public void setDenngay(Date denngay) {
		Denngay = denngay;
	}

	@Column(name = "Id_Thietbi", nullable = false)
	public int getId_Thietbi() {
		return Id_Thietbi;
	}

	public void setId_Thietbi(int id_Thietbi) {
		Id_Thietbi = id_Thietbi;
	}

}
