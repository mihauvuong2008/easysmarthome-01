package home.ngocdong.easysmarthome.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import home.ngocdong.easysmarthome.entity.Cambien;
import home.ngocdong.easysmarthome.entity.Dulieucambien;
import home.ngocdong.easysmarthome.entity.Vitri;
import home.ngocdong.easysmarthome.model.DulieucambienInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Transactional
@Repository
public class DulieucambienDAO {
	// bien dich duoc session factory ma khong loi tuc la da tao duoc Bean
	@Autowired
	private SessionFactory sessionFactory;

	public PaginationResult<DulieucambienInfo> queryItems(int page, int maxResult, int maxNavigationPage,
			String likeName) {
		String sql = "Select new " + DulieucambienInfo.class.getName() //
				+ "(c.id_Cambien, c.loaicambien, v.vitri, c.id_Arduinocontroller, l.ngaygiokichhoat, l.giatri) " + " from "//
				+ Cambien.class.getName() + " c, " + Vitri.class.getName() + " v, " + Dulieucambien.class.getName()
				+ " l where c.id_Vitri=v.id_Vitri and c.id_Cambien=l.id_Cambien";
		Session session = this.sessionFactory.getCurrentSession();
		Query<DulieucambienInfo> query = session.createQuery(sql, DulieucambienInfo.class);
		if (likeName != null && likeName.length() > 0) {
			query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
		}
		return new PaginationResult<DulieucambienInfo>(query, page, maxResult, maxNavigationPage);
	}

}
