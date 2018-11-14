package home.ngocdong.easysmarthome.form;

import home.ngocdong.easysmarthome.entity.Thietbi_relay;

public class Thietbi_relayForm {
	int Id_Thietbi;
	int Id_relay;
	boolean isnewForm = false;

	public Thietbi_relayForm(Thietbi_relay thietbi_relay) {
		Id_Thietbi = thietbi_relay.getId_Thietbi();
		Id_relay = thietbi_relay.getId_relay();
	}

	public Thietbi_relayForm() {
		// TODO Auto-generated constructor stub
	}

	public int getId_Thietbi() {
		return Id_Thietbi;
	}

	public void setId_Thietbi(int id_Thietbi) {
		this.Id_Thietbi = id_Thietbi;
	}

	public int getId_relay() {
		return Id_relay;
	}

	public void setId_relay(int id_relay) {
		this.Id_relay = id_relay;
	}

	public boolean isIsnewForm() {
		return isnewForm;
	}

	public void setIsnewForm(boolean isnewForm) {
		this.isnewForm = isnewForm;
	}

}
