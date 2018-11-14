package home.ngocdong.easysmarthome.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import home.ngocdong.easysmarthome.entity.Nhiemvu;
import home.ngocdong.easysmarthome.entity.Thietbi;
import home.ngocdong.easysmarthome.entity.Vitri;
import home.ngocdong.easysmarthome.form.NhiemvuForm;
import home.ngocdong.easysmarthome.model.NhiemvuInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Transactional
@Repository
public class NhiemvuDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public PaginationResult<NhiemvuInfo> queryItems(Date dateFrom, Date dateTo, boolean thuchien, int page,
			int maxResult, int maxNavigationPage, String likeName) {
		String sql = "Select new " + NhiemvuInfo.class.getName()
				+ " (n.id_Nhiemvu, n.id_Thietbi, t.tenthietbi, v.vitri, n.thoigianbatdau, n.thoigianketthuc, n.dathuchien) from "
				+ Nhiemvu.class.getName() + " n inner join " + Thietbi.class.getName()
				+ " t on  n.id_Thietbi = t.id_Thietbi inner join " + Vitri.class.getName()
				+ " v on v.id_Vitri=t.id_Vitri order by n.thoigianketthuc";
		Session session = this.sessionFactory.getCurrentSession();
		Query<NhiemvuInfo> query = session.createQuery(sql, NhiemvuInfo.class);
		return new PaginationResult<NhiemvuInfo>(query, page, maxResult, maxNavigationPage);
	}

	public Nhiemvu findNhiemvu(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Nhiemvu.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void save(NhiemvuForm nhiemvuForm) {
		Session session = this.sessionFactory.getCurrentSession();
		int id = nhiemvuForm.getId_Nhiemvu();

		Nhiemvu nhiemvu = null;
		boolean isNew = false;

		if (id > 0) {
			nhiemvu = this.findNhiemvu(id);
		}

		if (nhiemvu == null) {
			isNew = true;
			nhiemvu = new Nhiemvu();
		}

		nhiemvu.setId_Nhiemvu(id);
		nhiemvu.setId_Thietbi(nhiemvuForm.getId_Thietbi());
		nhiemvu.setThoigianbatdau(nhiemvuForm.getThoigianbatdau());
		nhiemvu.setThoigianketthuc(nhiemvuForm.getThoigianketthuc());

		if (isNew) {
			session.persist(nhiemvu);
		} else {
			session.save(nhiemvu);
		}
		// Nếu có lỗi tại DB, ngoại lệ sẽ ném ra ngay lập tức
		session.flush();

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)

	public void removeNhiemvu(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "delete from Nhiemvu e where e.id_Nhiemvu =" + id;
		Query<?> query = session.createQuery(sql);
		query.executeUpdate();
	}

}
