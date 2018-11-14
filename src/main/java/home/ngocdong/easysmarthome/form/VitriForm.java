package home.ngocdong.easysmarthome.form;

import home.ngocdong.easysmarthome.model.VitriInfo;
import home.ngocdong.easysmarthome.entity.Vitri;

public class VitriForm {
	private int Id_Vitri;
	private String Vitri;
	private boolean newVitri = false;

	public boolean isNewVitri() {
		return newVitri;
	}

	public void setNewVitri(boolean newVitri) {
		this.newVitri = newVitri;
	}

	public VitriForm() {
		// TODO Auto-generated constructor stub
	}

	public VitriForm(VitriInfo vitriInfo) {
		this.Id_Vitri = vitriInfo.getId_Vitri();
		this.Vitri = vitriInfo.getVitri();
	}

	public VitriForm(Vitri vitri) {
		this.Id_Vitri = vitri.getId_Vitri();
		this.Vitri = vitri.getVitri();
	}

	public int getId_Vitri() {
		return Id_Vitri;
	}

	public void setId_Vitri(int id_Vitri) {
		Id_Vitri = id_Vitri;
	}

	public String getVitri() {
		return Vitri;
	}

	public void setVitri(String vitri) {
		Vitri = vitri;
	}

}
