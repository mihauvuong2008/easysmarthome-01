package home.ngocdong.easysmarthome.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lichkhoidongthietbitrongngay")
public class Lichkhoidongthietbitrongngay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6921934850618598970L;

	int Id_Lichkhoidongthietbi;
	Date Thoigianbatdau;
	Date Thoigianketthuc;
	int Id_Lichkhoidongthietbitrongtuan;

	@Id
	@Column(name = "Id_Lichkhoidongthietbi", nullable = false)
	public int getId_Lichkhoidongthietbi() {
		return Id_Lichkhoidongthietbi;
	}

	public void setId_Lichkhoidongthietbi(int id_Lichkhoidongthietbi) {
		Id_Lichkhoidongthietbi = id_Lichkhoidongthietbi;
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

	@Column(name = "Id_Lichkhoidongthietbitrongtuan", nullable = false)
	public int getId_Lichkhoidongthietbitrongtuan() {
		return Id_Lichkhoidongthietbitrongtuan;
	}

	public void setId_Lichkhoidongthietbitrongtuan(int id_Lichkhoidongthietbitrongtuan) {
		Id_Lichkhoidongthietbitrongtuan = id_Lichkhoidongthietbitrongtuan;
	}

}
