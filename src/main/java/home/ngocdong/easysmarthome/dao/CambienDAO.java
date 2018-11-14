package home.ngocdong.easysmarthome.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import home.ngocdong.easysmarthome.entity.Cambien;
import home.ngocdong.easysmarthome.form.CambienForm;
import home.ngocdong.easysmarthome.model.CambienInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Transactional
@Repository
public class CambienDAO {

	// bien dich duoc session factory ma khong loi tuc la da tao duoc Bean
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public PaginationResult<CambienInfo> queryItems(int page, int maxResult, int maxNavigationPage, String likeName) {
		String sql = "Select new " + CambienInfo.class.getName()
				+ " (e.id_Cambien, e.tencambien, e.id_Vitri, e.id_Arduinocontroller, e.loaicambien) from "
				+ Cambien.class.getName() + " e order by e.loaicambien desc";
		Session session = this.sessionFactory.getCurrentSession();
		Query<CambienInfo> query = session.createQuery(sql, CambienInfo.class);
		return new PaginationResult<CambienInfo>(query, page, maxResult, maxNavigationPage);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public PaginationResult<CambienInfo> queryItems(int loaicambien, int page, int maxResult, int maxNavigationPage,
			String likeName) {
		String sql = "Select new " + CambienInfo.class.getName()
				+ " (e.id_Cambien, e.tencambien, e.id_Vitri, e.id_Arduinocontroller, e.loaicambien) from "
				+ Cambien.class.getName() + " e where  e.loaicambien =" + loaicambien + " order by e.loaicambien desc ";
		Session session = this.sessionFactory.getCurrentSession();
		Query<CambienInfo> query = session.createQuery(sql, CambienInfo.class);
		return new PaginationResult<CambienInfo>(query, page, maxResult, maxNavigationPage);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public PaginationResult<CambienInfo> queryItems_byid_Arduino(int id_Arduino, int page, int maxResult,
			int maxNavigationPage, String likeName) {
		String sql = "Select new " + CambienInfo.class.getName()
				+ " (e.id_Cambien, e.tencambien, e.id_Vitri, e.id_Arduinocontroller, e.loaicambien) from "
				+ Cambien.class.getName() + " e where  e.id_Arduinocontroller =" + id_Arduino
				+ " order by e.loaicambien desc ";
		Session session = this.sessionFactory.getCurrentSession();
		Query<CambienInfo> query = session.createQuery(sql, CambienInfo.class);
		return new PaginationResult<CambienInfo>(query, page, maxResult, maxNavigationPage);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public Cambien findCambien(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Cambien.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void save(CambienForm cambienForm) {
		Session session = this.sessionFactory.getCurrentSession();
		int id = cambienForm.getId_Cambien();

		Cambien cambien = null;
		boolean isNew = false;

		if (id > 0) {
			cambien = this.findCambien(id);
		}

		if (cambien == null) {
			isNew = true;
			cambien = new Cambien();
		}

		cambien.setId_Cambien(id);
		cambien.setTencambien(cambienForm.getTencambien());
		cambien.setId_Vitri(cambienForm.getId_Vitri());
		cambien.setLoaicambien(cambienForm.getLoaicambien());
		cambien.setId_Arduinocontroller(cambienForm.getId_Arduinocontroller());

		if (isNew) {
			session.persist(cambien);
		} else {
			session.save(cambien);
		}
		// Nếu có lỗi tại DB, ngoại lệ sẽ ném ra ngay lập tức
		session.flush();

	}

}