package home.ngocdong.easysmarthome.form;

import java.util.Date;

public class LichkhoidongthietbitrongnamForm {
	int Id_Lichkhoidongthietbitrongnam;
	Date Tungay;
	Date Denngay;
	int Id_Thietbi;
	boolean newLichkhoidongthietbitrongnam;

	public int getId_Lichkhoidongthietbitrongnam() {
		return Id_Lichkhoidongthietbitrongnam;
	}

	public void setId_Lichkhoidongthietbitrongnam(int id_Lichkhoidongthietbitrongnam) {
		Id_Lichkhoidongthietbitrongnam = id_Lichkhoidongthietbitrongnam;
	}

	public Date getTungay() {
		return Tungay;
	}

	public void setTungay(Date tungay) {
		Tungay = tungay;
	}

	public Date getDenngay() {
		return Denngay;
	}

	public void setDenngay(Date denngay) {
		Denngay = denngay;
	}

	public int getId_Thietbi() {
		return Id_Thietbi;
	}

	public void setId_Thietbi(int id_Thietbi) {
		Id_Thietbi = id_Thietbi;
	}

	public boolean isNewLichkhoidongthietbitrongnam() {
		return newLichkhoidongthietbitrongnam;
	}

	public void setNewLichkhoidongthietbitrongnam(boolean newLichkhoidongthietbitrongnam) {
		this.newLichkhoidongthietbitrongnam = newLichkhoidongthietbitrongnam;
	}

}
