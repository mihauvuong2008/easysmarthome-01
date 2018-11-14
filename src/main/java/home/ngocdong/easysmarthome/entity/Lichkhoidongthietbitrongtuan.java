package home.ngocdong.easysmarthome.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lichkhoidongthietbitrongtuan")
public class Lichkhoidongthietbitrongtuan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8605498064470903615L;

	int Id_Lichkhoidongthietbitrongtuan;
	boolean Thuhai;
	boolean Thuba;
	boolean Thutu;
	boolean Thunam;
	boolean Thusau;
	boolean Thubay;
	boolean Chunhat;
	int Id_Lichkhoidongthietbitrongnam;

	@Id
	@Column(name = "Id_Lichkhoidongthietbitrongtuan", nullable = false)
	public int getId_Lichkhoidongthietbitrongtuan() {
		return Id_Lichkhoidongthietbitrongtuan;
	}

	public void setId_Lichkhoidongthietbitrongtuan(int id_Lichkhoidongthietbitrongtuan) {
		Id_Lichkhoidongthietbitrongtuan = id_Lichkhoidongthietbitrongtuan;
	}

	@Column(name = "Thuhai", nullable = false)
	public boolean isThuhai() {
		return Thuhai;
	}

	public void setThuhai(boolean thuhai) {
		Thuhai = thuhai;
	}

	@Column(name = "Thuba", nullable = false)
	public boolean isThuba() {
		return Thuba;
	}

	public void setThuba(boolean thuba) {
		Thuba = thuba;
	}

	@Column(name = "Thutu", nullable = false)
	public boolean isThutu() {
		return Thutu;
	}

	public void setThutu(boolean thutu) {
		Thutu = thutu;
	}

	@Column(name = "Thunam", nullable = false)
	public boolean isThunam() {
		return Thunam;
	}

	public void setThunam(boolean thunam) {
		Thunam = thunam;
	}

	@Column(name = "Thusau", nullable = false)
	public boolean isThusau() {
		return Thusau;
	}

	public void setThusau(boolean thusau) {
		Thusau = thusau;
	}

	@Column(name = "Thubay", nullable = false)
	public boolean isThubay() {
		return Thubay;
	}

	public void setThubay(boolean thubay) {
		Thubay = thubay;
	}

	@Column(name = "Chunhat", nullable = false)
	public boolean isChunhat() {
		return Chunhat;
	}

	public void setChunhat(boolean chunhat) {
		Chunhat = chunhat;
	}

	@Column(name = "Id_Lichkhoidongthietbitrongnam", nullable = false)
	public int getId_Lichkhoidongthietbitrongnam() {
		return Id_Lichkhoidongthietbitrongnam;
	}

	public void setId_Lichkhoidongthietbitrongnam(int id_Lichkhoidongthietbitrongnam) {
		Id_Lichkhoidongthietbitrongnam = id_Lichkhoidongthietbitrongnam;
	}

	@Override
	public String toString() {
		return "[" + this.Id_Lichkhoidongthietbitrongtuan + "," + this.Thuhai + "]";
	}
}
