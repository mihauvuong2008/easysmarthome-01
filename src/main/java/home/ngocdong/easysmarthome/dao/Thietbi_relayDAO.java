package home.ngocdong.easysmarthome.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import home.ngocdong.easysmarthome.model.Thietbi_relayInfo;

@Transactional
@Repository
public class Thietbi_relayDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Thietbi_relayInfo findThietbi_relay(Integer id_thietbi) {
		String sql = "select new " + Thietbi_relayInfo.class.getName()
				+ " (e.id_relay, e.id_Thietbi)  from Thietbi_relay e where e.id_Thietbi = " + id_thietbi + "";
		Session session = sessionFactory.getCurrentSession();
		Query<Thietbi_relayInfo> query = session.createQuery(sql, Thietbi_relayInfo.class);
		List<Thietbi_relayInfo> list = query.list();
		return (list.isEmpty() ? null : list.get(0));
	}
}
