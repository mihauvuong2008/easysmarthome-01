package home.ngocdong.easysmarthome.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import home.ngocdong.easysmarthome.entity.Lich_Nhiemvu_thuongxuyen;
import home.ngocdong.easysmarthome.entity.Nhiemvu_thuongxuyen;
import home.ngocdong.easysmarthome.entity.Thietbi;
import home.ngocdong.easysmarthome.form.Nhiemvu_thuongxuyenForm;
import home.ngocdong.easysmarthome.model.Nhiemvu_thuongxuyenInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Transactional
@Repository
public class Nhiemvu_thuongxuyenDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public PaginationResult<Nhiemvu_thuongxuyenInfo> lichNhiemvuthuongxuyenItems(int page, int maxResult,
			int maxNavigationPage, String likeName) {
		String sql = "Select new " + Nhiemvu_thuongxuyenInfo.class.getName()
				+ " (e.id_Lich_Nhiemvu, e.id_Nhiemvu_thuongxuyen, e.thoigianthuchien, f.tenNhiemvuthuongxuyen, f.id_Thietbi, f.thoigian, g.tenthietbi) from "
				+ Lich_Nhiemvu_thuongxuyen.class.getName() + " e, " + Nhiemvu_thuongxuyen.class.getName() + " f, "
				+ Thietbi.class.getName()
				+ " g where e.id_Nhiemvu_thuongxuyen = f.id_Nhiemvu_thuongxuyen and f.id_Thietbi = g.id_Thietbi order by e.thoigianthuchien desc";
		Session session = this.sessionFactory.getCurrentSession();
		Query<Nhiemvu_thuongxuyenInfo> query = session.createQuery(sql, Nhiemvu_thuongxuyenInfo.class);
		return new PaginationResult<Nhiemvu_thuongxuyenInfo>(query, page, maxResult, maxNavigationPage);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public PaginationResult<Nhiemvu_thuongxuyenInfo> queryItems(int page, int maxResult, int maxNavigationPage,
			String likeName) {
		String sql = "Select new " + Nhiemvu_thuongxuyenInfo.class.getName()
				+ " ( e.id_Nhiemvu_thuongxuyen, e.tenNhiemvuthuongxuyen, e.id_Thietbi, e.thoigian, g.tenthietbi) from "
				+ Nhiemvu_thuongxuyen.class.getName() + " e, " + Thietbi.class.getName()
				+ " g where e.id_Thietbi = g.id_Thietbi order by e.id_Nhiemvu_thuongxuyen desc";
		Session session = this.sessionFactory.getCurrentSession();
		Query<Nhiemvu_thuongxuyenInfo> query = session.createQuery(sql, Nhiemvu_thuongxuyenInfo.class);
		return new PaginationResult<Nhiemvu_thuongxuyenInfo>(query, page, maxResult, maxNavigationPage);
	}

	public Nhiemvu_thuongxuyen findNhiemvu_thuongxuyen(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Nhiemvu_thuongxuyen.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void save(Nhiemvu_thuongxuyenForm nhiemvuthuongxuyenForm) {
		Session session = this.sessionFactory.getCurrentSession();
		int id = nhiemvuthuongxuyenForm.getId_Nhiemvu_thuongxuyen();

		Nhiemvu_thuongxuyen nhiemvu_thuongxuyen = null;
		boolean isNew = false;

		if (id > 0) {
			nhiemvu_thuongxuyen = this.findNhiemvu_thuongxuyen(id);
		}

		if (nhiemvu_thuongxuyen == null) {
			isNew = true;
			nhiemvu_thuongxuyen = new Nhiemvu_thuongxuyen();
		}

		nhiemvu_thuongxuyen.setId_Nhiemvu_thuongxuyen(id);
		nhiemvu_thuongxuyen.setTenNhiemvuthuongxuyen(nhiemvuthuongxuyenForm.getTenNhiemvuthuongxuyen());
		nhiemvu_thuongxuyen.setId_Thietbi(nhiemvuthuongxuyenForm.getId_Thietbi());
		nhiemvu_thuongxuyen.setThoigian(nhiemvuthuongxuyenForm.getThoigian());

		if (isNew) {
			session.persist(nhiemvu_thuongxuyen);
		} else {
			session.save(nhiemvu_thuongxuyen);
		}
		// Nếu có lỗi tại DB, ngoại lệ sẽ ném ra ngay lập tức
		session.flush();

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)

	public void removeNhiemvu_thuongxuyen(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "delete from Nhiemvu_thuongxuyen e where e.id_Nhiemvu_thuongxuyen =" + id;
		Query<?> query = session.createQuery(sql);
		query.executeUpdate();
	}

	public List<Nhiemvu_thuongxuyen> getNhiemvu_thuongxuyens() {
		Session session = sessionFactory.getCurrentSession();
		Query<Nhiemvu_thuongxuyen> query = session.createQuery("from Nhiemvu_thuongxuyen", Nhiemvu_thuongxuyen.class);
		List<Nhiemvu_thuongxuyen> list = query.list();
		return list;
	}
	
}
