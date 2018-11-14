package home.ngocdong.easysmarthome.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import home.ngocdong.easysmarthome.entity.Thietbi;
import home.ngocdong.easysmarthome.form.ThietbiForm;
import home.ngocdong.easysmarthome.model.ThietbiInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Transactional
@Repository
public class ThietbiDAO {

	// bien dich duoc session factory ma khong loi tuc la da tao duoc Bean
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public PaginationResult<ThietbiInfo> queryItems(int page, int maxResult, int maxNavigationPage, String likeName) {
		String sql = "Select new " + ThietbiInfo.class.getName()
				+ " (e.id_Thietbi, e.tenthietbi, e.trangthai, e.id_Vitri) from " + Thietbi.class.getName() + " e ";
		Session session = this.sessionFactory.getCurrentSession();
		Query<ThietbiInfo> query = session.createQuery(sql, ThietbiInfo.class);
		return new PaginationResult<ThietbiInfo>(query, page, maxResult, maxNavigationPage);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public PaginationResult<ThietbiInfo> queryItems(int id_vitri, int page, int maxResult, int maxNavigationPage,
			String likeName) {
		String sql = "Select new " + ThietbiInfo.class.getName()
				+ " (e.id_Thietbi, e.tenthietbi, e.trangthai, e.id_Vitri) from " + Thietbi.class.getName()
				+ " e where e.id_Vitri =" + id_vitri;
		Session session = this.sessionFactory.getCurrentSession();
		Query<ThietbiInfo> query = session.createQuery(sql, ThietbiInfo.class);
		return new PaginationResult<ThietbiInfo>(query, page, maxResult, maxNavigationPage);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public Thietbi findThietbi(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Thietbi.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void save(ThietbiForm thietbiForm) {
		Session session = this.sessionFactory.getCurrentSession();
		int id = thietbiForm.getId_Thietbi();

		Thietbi thietbi = null;
		boolean isNew = false;

		if (id > 0) {
			thietbi = this.findThietbi(id);
		}

		if (thietbi == null) {
			isNew = true;
			thietbi = new Thietbi();
		}

		thietbi.setId_Thietbi(id);
		thietbi.setTenthietbi(thietbiForm.getTenthietbi());
		thietbi.setTrangthai(thietbiForm.getTrangthai());
		thietbi.setId_Vitri(thietbiForm.getId_Vitri());

		if (isNew) {
			session.persist(thietbi);
		} else {
			session.save(thietbi);
		}
		// Nếu có lỗi tại DB, ngoại lệ sẽ ném ra ngay lập tức
		session.flush();

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public List<Thietbi> getThietbis() {
		Session session = sessionFactory.getCurrentSession();
		Query<Thietbi> query = session.createQuery("from Thietbi", Thietbi.class);
		List<Thietbi> list = query.list();
		return list;
	}

	public List<ThietbiInfo> getThietbis_withoutRelay() {
		Session session = sessionFactory.getCurrentSession();
		Query<ThietbiInfo> query = session.createQuery("Select new " + ThietbiInfo.class.getName()
				+ " (t.id_Thietbi, t.tenthietbi, t.trangthai, t.id_Vitri)  from Thietbi t left join Thietbi_relay tr on t.id_Thietbi=tr.id_Thietbi where tr.id_Thietbi is null",
				ThietbiInfo.class);
		List<ThietbiInfo> list = query.list();
		return list;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void removeThietbi(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "delete from Thietbi e where e.id_Thietbi=" + id;
		Query<?> query = session.createQuery(sql);
		query.executeUpdate();
	}

}
