package home.ngocdong.easysmarthome.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import home.ngocdong.easysmarthome.entity.Relay;
import home.ngocdong.easysmarthome.entity.Thietbi;
import home.ngocdong.easysmarthome.entity.Thietbi_relay;
import home.ngocdong.easysmarthome.form.RelayForm;
import home.ngocdong.easysmarthome.form.Thietbi_relayForm;
import home.ngocdong.easysmarthome.model.RelayInfo;
import home.ngocdong.easysmarthome.model.Thietbi_relayInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Transactional
@Repository
public class RelayDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public PaginationResult<RelayInfo> queryItems(int id_Arduino, int page, int maxResult, int maxNavigationPage,
			String likeName) throws Exception {
		String sql = "Select new " + RelayInfo.class.getName()
				+ " (e.id_relay, e.tenrelay, e.id_Arduinocontroller) from " + Relay.class.getName()
				+ " e where e.id_Arduinocontroller=" + id_Arduino;
		Session session = this.sessionFactory.getCurrentSession();
		Query<RelayInfo> query = session.createQuery(sql, RelayInfo.class);
		return new PaginationResult<RelayInfo>(query, page, maxResult, maxNavigationPage);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public PaginationResult<RelayInfo> queryItems(String id_Arduino, int page, int maxResult, int maxNavigationPage,
			String likeName) throws Exception {
		String sql = "Select new " + RelayInfo.class.getName()
				+ " (e.id_relay, e.tenrelay, e.id_Arduinocontroller) from " + Relay.class.getName()
				+ " e where e.e.id_Arduinocontroller=" + id_Arduino;
		Session session = this.sessionFactory.getCurrentSession();
		Query<RelayInfo> query = session.createQuery(sql, RelayInfo.class);
		return new PaginationResult<RelayInfo>(query, page, maxResult, maxNavigationPage);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public RelayInfo findRelayInfo(int id_relay) throws Exception {
		String sql = "Select new " + RelayInfo.class.getName()
				+ " (e.id_relay, e.tenrelay, e.id_Arduinocontroller) from " + Relay.class.getName()
				+ " e  where e.id_relay=" + id_relay;
		Session session = sessionFactory.getCurrentSession();
		Query<RelayInfo> query = session.createQuery(sql, RelayInfo.class);
		List<RelayInfo> list = query.list();
		return (list.isEmpty() ? null : list.get(0));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public Relay findRelay(int id_relay) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Relay.class, id_relay);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public List<Relay> getRelays(String id_Arduino) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Query<Relay> query = session.createQuery("from Relay where Id_Arduinocontroller = " + id_Arduino, Relay.class);
		List<Relay> list = query.list();
		return list;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public PaginationResult<Thietbi_relayInfo> getThietbi_relays_byArduinoID(String id_Arduino, int page, int maxResult,
			int maxNavigationPage, String likeName) throws Exception {
		String sql = "Select new " + Thietbi_relayInfo.class.getName()
				+ " (e.id_Thietbi, e.id_relay, g.tenthietbi, g.trangthai, g.id_Vitri,f.tenrelay, f.id_Arduinocontroller ) from "
				+ Thietbi_relay.class.getName() + " e inner join " + Relay.class.getName()
				+ " f on e.id_relay=f.id_relay inner join " + Thietbi.class.getName()
				+ " g on  e.id_Thietbi=g.id_Thietbi where f.id_Arduinocontroller=" + id_Arduino;
		Session session = this.sessionFactory.getCurrentSession();
		Query<Thietbi_relayInfo> query = session.createQuery(sql, Thietbi_relayInfo.class);
		return new PaginationResult<Thietbi_relayInfo>(query, page, maxResult, maxNavigationPage);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void saveThietbi_relay(Thietbi_relay tr) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		int id_relay = tr.getId_relay();

		Thietbi_relayInfo ck = null;

		if (id_relay > 0) {
			ck = this.findThietbi_relay(id_relay);
			if (ck.getId_Thietbi() != tr.getId_Thietbi()) {
				this.removeThietbi_relay(String.valueOf(id_relay));
			}
		}
		session.persist(tr);
		// Nếu có lỗi tại DB, ngoại lệ sẽ ném ra ngay lập tức
		session.flush();

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	private Thietbi_relayInfo findThietbi_relay(int id_relay) throws Exception {
		String sql = "Select new " + Thietbi_relayInfo.class.getName() + " (e.id_relay, e.id_Thietbi) from "
				+ Thietbi_relay.class.getName() + " e where e.id_relay=" + id_relay;
		Session session = this.sessionFactory.getCurrentSession();
		Query<Thietbi_relayInfo> query = session.createQuery(sql, Thietbi_relayInfo.class);
		List<Thietbi_relayInfo> list = query.list();
		return (list.isEmpty() ? null : list.get(0));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void removeThietbi_relay(String id_relay) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "delete from Thietbi_relay e where e.id_relay=" + id_relay;
		Query<?> query = session.createQuery(sql);
		query.executeUpdate();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void removeRelay(String id_relay) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "delete from Relay e where e.id_relay=" + id_relay;
		Query<?> query = session.createQuery(sql);
		query.executeUpdate();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void addThietbi_relay(Thietbi_relayForm tr) throws Exception {
		Thietbi_relay trtble = new Thietbi_relay();
		trtble.setId_relay(tr.getId_relay());
		trtble.setId_Thietbi(tr.getId_Thietbi());
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(trtble);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void save(RelayForm relayForm) {
		Session session = this.sessionFactory.getCurrentSession();
		int id = relayForm.getId_relay();

		Relay relay = null;
		boolean isNew = false;

		if (id > 0) {
			relay = this.findRelay(id);
		}

		if (relay == null) {
			isNew = true;
			relay = new Relay();
		}

		relay.setId_relay(id);
		relay.setTenrelay(relayForm.getTenrelay());
		relay.setId_Arduinocontroller(relayForm.getId_Arduinocontroller());

		if (isNew) {
			session.persist(relay);
		} else {
			session.save(relay);
		}
		// Nếu có lỗi tại DB, ngoại lệ sẽ ném ra ngay lập tức
		session.flush();

	}
}
