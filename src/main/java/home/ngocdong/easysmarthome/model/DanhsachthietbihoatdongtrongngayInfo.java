package home.ngocdong.easysmarthome.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DanhsachthietbihoatdongtrongngayInfo {
	String Vitri;
	Date Thoigianbatdau;
	Date Thoigianketthuc;
	String Tenthietbi;

	public DanhsachthietbihoatdongtrongngayInfo(Date thoigianbatdau, Date thoigianketthuc, String vitri,
			String tenthietbi) {
		super();
		Vitri = vitri;
		Thoigianbatdau = thoigianbatdau;
		Thoigianketthuc = thoigianketthuc;
		Tenthietbi = tenthietbi;
	}

	public String getVitri() {
		return Vitri;
	}

	public void setVitri(String vitri) {
		Vitri = vitri;
	}

	public String getThoigianbatdau() {
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
		String time = localDateFormat.format(Thoigianbatdau);
		return time;
	}

	public void setThoigianbatdau(Date thoigianbatdau) {
		Thoigianbatdau = thoigianbatdau;
	}

	public String getThoigianketthuc() {
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
		String time = localDateFormat.format(Thoigianketthuc);
		return time;
	}

	public void setThoigianketthuc(Date thoigianketthuc) {
		Thoigianketthuc = thoigianketthuc;
	}

	public String getTenthietbi() {
		return Tenthietbi;
	}

	public void setTenthietbi(String tenthietbi) {
		Tenthietbi = tenthietbi;
	}

}
