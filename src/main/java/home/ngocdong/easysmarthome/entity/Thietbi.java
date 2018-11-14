package home.ngocdong.easysmarthome.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Thietbi")
public class Thietbi implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5060384095032355844L;

	private int Id_Thietbi;
	private String Tenthietbi;
	private int Trangthai;
	private int Id_Vitri;

	@Id
	@Column(name = "Id_Thietbi", nullable = false)
	public int getId_Thietbi() {
		return Id_Thietbi;
	}

	public void setId_Thietbi(int id_Thietbi) {
		Id_Thietbi = id_Thietbi;
	}

	@Column(name = "Tenthietbi", length = 100, nullable = false)
	public String getTenthietbi() {
		return Tenthietbi;
	}

	public void setTenthietbi(String tenthietbi) {
		Tenthietbi = tenthietbi;
	}

	@Column(name = "Trangthai", nullable = false)
	public int getTrangthai() {
		return Trangthai;
	}

	public void setTrangthai(int trangthai) {
		Trangthai = trangthai;
	}

	@Column(name = "Id_Vitri", length = 100, nullable = false)
	public int getId_Vitri() {
		return Id_Vitri;
	}

	public void setId_Vitri(int id_Vitri) {
		Id_Vitri = id_Vitri;
	}

	@Override
	public String toString() {
		return "[" + this.Id_Thietbi + "," + this.Tenthietbi + "]";
	}
}
