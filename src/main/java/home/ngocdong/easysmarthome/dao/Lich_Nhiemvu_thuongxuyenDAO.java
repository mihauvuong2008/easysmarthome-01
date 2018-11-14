package home.ngocdong.easysmarthome.dao;

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
import home.ngocdong.easysmarthome.model.Lich_Nhiemvu_thuongxuyenInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Transactional
@Repository
public class Lich_Nhiemvu_thuongxuyenDAO {

	// bien dich duoc session factory ma khong loi tuc la da tao duoc Bean
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public PaginationResult<Lich_Nhiemvu_thuongxuyenInfo> queryItems(int page, int maxResult, int maxNavigationPage,
			String likeName) {
		String sql = "Select new " + Lich_Nhiemvu_thuongxuyenInfo.class.getName()
				+ " (e.id_Lich_Nhiemvu, e.id_Nhiemvu_thuongxuyen, e.thoigianthuchien, f.tenNhiemvuthuongxuyen, f.id_Thietbi, f.thoigian, g.tenthietbi) from "
				+ Lich_Nhiemvu_thuongxuyen.class.getName() + " e, " + Nhiemvu_thuongxuyen.class.getName() + " f, "
				+ Thietbi.class.getName()
				+ " g where e.Id_Nhiemvu_thuongxuyen = f.Id_Nhiemvu_thuongxuyen and f.id_Thietbi = g.id_Thietbi order by e.loaiLich_Nhiemvu_thuongxuyen desc";
		Session session = this.sessionFactory.getCurrentSession();
		Query<Lich_Nhiemvu_thuongxuyenInfo> query = session.createQuery(sql, Lich_Nhiemvu_thuongxuyenInfo.class);
		return new PaginationResult<Lich_Nhiemvu_thuongxuyenInfo>(query, page, maxResult, maxNavigationPage);
	}

	public void save(Nhiemvu_thuongxuyenForm nhiemvu_thuongxuyenForm) {
		// TODO Auto-generated method stub
		
	}
}
