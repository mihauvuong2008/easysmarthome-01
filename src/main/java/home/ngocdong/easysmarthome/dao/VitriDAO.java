package home.ngocdong.easysmarthome.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import home.ngocdong.easysmarthome.entity.Vitri;
import home.ngocdong.easysmarthome.form.VitriForm;
import home.ngocdong.easysmarthome.model.VitriInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Transactional
@Repository
public class VitriDAO {

	// bien dich duoc session factory ma khong loi tuc la da tao duoc Bean
	@Autowired
	private SessionFactory sessionFactory;

	public PaginationResult<VitriInfo> queryItems(int page, int maxResult, int maxNavigationPage, String likeName) {
		String sql = "Select new " + VitriInfo.class.getName() + " (e.id_Vitri, e.vitri) from "
				+ /* kieu o day */ Vitri.class.getName() + " e order by e.id_Vitri desc";
		Session session = this.sessionFactory.getCurrentSession();
		Query<VitriInfo/* se la kieu o day */> query = session.createQuery(sql, VitriInfo.class);
		return new PaginationResult<VitriInfo>(query, page, maxResult, maxNavigationPage);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void save(VitriForm vitriForm) {
		Session session = this.sessionFactory.getCurrentSession();
		int id = vitriForm.getId_Vitri();

		Vitri vitri = null;
		boolean isNew = false;

		if (id > 0) {
			vitri = this.findVitri(id);
		}

		if (vitri == null) {
			isNew = true;
			vitri = new Vitri();
		}

		vitri.setId_Vitri(id);
		vitri.setVitri(vitriForm.getVitri());

		if (isNew) {
			session.persist(vitri);
		} else {
			session.save(vitri);
		}
		// Nếu có lỗi tại DB, ngoại lệ sẽ ném ra ngay lập tức
		session.flush();

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public Vitri findVitri(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Vitri.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public List<Vitri> getVitris() {
		Session session = sessionFactory.getCurrentSession();
		Query<Vitri> query = session.createQuery("from Vitri", Vitri.class);
		List<Vitri> list = query.list();
		return list;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void removeVitri(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "delete from Vitri e where e.id_Vitri=" + id;
		Query<?> query = session.createQuery(sql);
		query.executeUpdate();
	}

}
