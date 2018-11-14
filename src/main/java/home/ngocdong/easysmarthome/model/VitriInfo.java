package home.ngocdong.easysmarthome.model;

public class VitriInfo {
	private int Id_Vitri;
	private String Vitri;

	public VitriInfo(int id_Vitri, String vitri) {
		super();
		Id_Vitri = id_Vitri;
		Vitri = vitri;
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
