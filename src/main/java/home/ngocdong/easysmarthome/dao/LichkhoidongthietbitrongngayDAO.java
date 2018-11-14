package home.ngocdong.easysmarthome.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import home.ngocdong.easysmarthome.entity.Lichkhoidongthietbitrongnam;
import home.ngocdong.easysmarthome.entity.Lichkhoidongthietbitrongngay;
import home.ngocdong.easysmarthome.entity.Lichkhoidongthietbitrongtuan;
import home.ngocdong.easysmarthome.entity.Thietbi;
import home.ngocdong.easysmarthome.entity.Vitri;
import home.ngocdong.easysmarthome.model.DanhsachthietbihoatdongtrongngayInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Transactional
@Repository
public class LichkhoidongthietbitrongngayDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public PaginationResult<DanhsachthietbihoatdongtrongngayInfo> queryItems(Date day, int page, int maxResult,
			int maxNavigationPage, String likeName) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		// day String:
		String stringDay = df.format(day);
		stringDay = "'" + stringDay + "'";

		Calendar c = Calendar.getInstance();
		c.setTime(day);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		String expr = "";
		switch (dayOfWeek) {
		case 1:// dayOfWeek la chu nhat
			expr = " and l2.chunhat=TRUE ";
			break;
		case 2:// dayOfWeek la thu hai
			expr = " and l2.thuhai=TRUE ";
			break;
		case 3:// dayOfWeek la thu bat
			expr = " and l2.thuba=TRUE ";
			break;
		case 4:// dayOfWeek la thu tu
			expr = " and l2.thutu=TRUE ";
			break;
		case 5:// dayOfWeek la thu nam
			expr = " and l2.thunam=TRUE ";
			break;
		case 6:// dayOfWeek la thu sau
			expr = " and l2.thusau=TRUE ";
			break;
		case 7:// dayOfWeek la thu bay
			expr = " and l2.thubay=TRUE ";
			break;

		default:
			break;
		}

		String sql = "Select new " + DanhsachthietbihoatdongtrongngayInfo.class.getName()//
				+ "(n.thoigianbatdau, n.thoigianketthuc, v.vitri, t.tenthietbi) " + " from " + Vitri.class.getName()
				+ " v, " + Thietbi.class.getName() + " t , " + Lichkhoidongthietbitrongnam.class.getName() + " l1, "
				+ Lichkhoidongthietbitrongtuan.class.getName() + " l2, " + Lichkhoidongthietbitrongngay.class.getName()
				+ " n where n.id_Lichkhoidongthietbitrongtuan = l2.id_Lichkhoidongthietbitrongtuan and"
				+ " l2.id_Lichkhoidongthietbitrongnam=l1.id_Lichkhoidongthietbitrongnam and t.id_Thietbi=l1.id_Thietbi and "
				+ " t.id_Vitri=v.id_Vitri " + expr + " and " + stringDay + " BETWEEN l1.tungay AND l1.denngay "//
				+ " order by n.thoigianbatdau desc";
		Session session = this.sessionFactory.getCurrentSession();
		Query<DanhsachthietbihoatdongtrongngayInfo> query = session.createQuery(sql,
				DanhsachthietbihoatdongtrongngayInfo.class);
		System.out.println(query.getQueryString());
		if (likeName != null && likeName.length() > 0) {
			query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
		}
		return new PaginationResult<DanhsachthietbihoatdongtrongngayInfo>(query, page, maxResult, maxNavigationPage);
	}

	// @RequestMapping({ "/admin/Lichhoatdongthietbi" })
	// public String lichhoatdongthietbiHandler(Model model, //
	// @RequestParam(value = "name", defaultValue = "") String likeName,
	// @RequestParam(value = "page", defaultValue = "1") int page,
	// @RequestParam(value = "date", required = false) String date) {
	// final int maxResult = 6;
	// final int maxNavigationPage = 10;
	// Date paramDate = new Date();
	// if (date != null) {
	// String _sDate = date.substring(date.length() - 10, date.length());
	// DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	// try {
	// paramDate = df.parse(_sDate);
	// } catch (ParseException e) {
	// paramDate = null;
	// e.printStackTrace();
	// }
	// }
	// PaginationResult<DanhsachthietbihoatdongtrongngayInfo> result =
	// lichkhoidongthietbitrongngayDAO.queryItems(
	// paramDate, page, //
	// maxResult, maxNavigationPage, likeName);
	// DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	// String stringDay = df.format(paramDate);
	// Calendar c = Calendar.getInstance();
	// c.setTime(paramDate);
	// int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
	// model.addAttribute("paginationLichkhoidongthietbitrongngay", result);
	// model.addAttribute("classParam", date);
	// model.addAttribute("dateSelected", "Lịch Hoạt động " + weekDay(dayOfWeek) +
	// ", ngày: " + stringDay);
	// return"lichhoatdongthietbi";
	//
	// }

	// String weekDay(int date) {
	// switch (date) {
	// case 1:
	// return "chủ nhật";
	// case 2:
	// return "thứ hai";
	// case 3:
	// return "thứ ba";
	// case 4:
	// return "thứ tư";
	// case 5:
	// return "thứ năm";
	// case 6:
	// return "thứ sáu";
	// case 7:
	// return "thứ 7";
	//
	// default:
	// return "-----";
	// }
	// }
}
