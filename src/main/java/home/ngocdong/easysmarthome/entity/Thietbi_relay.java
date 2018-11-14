package home.ngocdong.easysmarthome.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Thietbi_relay")
public class Thietbi_relay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2419733159746873433L;

	@Id
	@Column(name = "Id_Thietbi", nullable = false)
	int id_Thietbi;
	@Id
	@Column(name = "Id_relay", nullable = false)
	int id_relay;

	public int getId_Thietbi() {
		return id_Thietbi;
	}

	public void setId_Thietbi(int id_Thietbi) {
		this.id_Thietbi = id_Thietbi;
	}

	public int getId_relay() {
		return id_relay;
	}

	public void setId_relay(int id_relay) {
		this.id_relay = id_relay;
	}

}
