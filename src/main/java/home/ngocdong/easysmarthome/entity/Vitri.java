package home.ngocdong.easysmarthome.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vitri")
public class Vitri implements Serializable {

	private static final long serialVersionUID = -2054386655979281969L;

	private int Id_Vitri;
	private String Vitri;

	// public Vitri(VitriInfo vitriInfo) {
	// this.Id_vitri = vitriInfo.getId_vitri();
	// this.Vitri = vitriInfo.getVitri();
	// }

	@Id
	@Column(name = "Id_Vitri", nullable = false)
	public int getId_Vitri() {
		return Id_Vitri;
	}

	public void setId_Vitri(int id_Vitri) {
		Id_Vitri = id_Vitri;
	}

	@Column(name = "Vitri", nullable = false)
	public String getVitri() {
		return Vitri;
	}

	public void setVitri(String Vitri) {
		this.Vitri = Vitri;
	}

	@Override
	public String toString() {
		return "[" + this.Id_Vitri + "," + this.Vitri + "]";
	}
}