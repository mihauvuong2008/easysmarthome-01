package home.ngocdong.easysmarthome.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import home.ngocdong.easysmarthome.entity.Arduinocontroller;
import home.ngocdong.easysmarthome.form.ArduinocontrollerForm;
import home.ngocdong.easysmarthome.model.ArduinocontrollerInfo;

@Transactional
@Repository
public class ArduinocontrollerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public ArduinocontrollerInfo findArduinocontrollerInfo(int id_Arduinocontroller) {
		String sql = "Select new " + ArduinocontrollerInfo.class.getName()
				+ " (e.id_Arduinocontroller, e.tenArduinocontroller, e.diachiIP) from "
				+ Arduinocontroller.class.getName() + " e where e.id_Arduinocontroller=" + id_Arduinocontroller;
		Session session = sessionFactory.getCurrentSession();
		Query<ArduinocontrollerInfo> query = session.createQuery(sql, ArduinocontrollerInfo.class);
		List<ArduinocontrollerInfo> list = query.list();
		return (list.isEmpty() ? null : list.get(0));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public Arduinocontroller findArduinocontroller(Integer id_Arduinocontroller) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Arduinocontroller.class, id_Arduinocontroller);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public List<Arduinocontroller> getArduinocontrollers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Arduinocontroller> query = session.createQuery("from Arduinocontroller", Arduinocontroller.class);
		List<Arduinocontroller> list = query.list();
		return list;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void save(ArduinocontrollerForm arduinocontrollerForm) {
		Session session = this.sessionFactory.getCurrentSession();
		int id = arduinocontrollerForm.getId_Arduinocontroller();

		Arduinocontroller arduinocontroller = null;
		boolean isNew = false;
		if (id > 0) {
			arduinocontroller = this.findArduinocontroller(id);
		}

		if (arduinocontroller == null) {
			isNew = true;
			arduinocontroller = new Arduinocontroller();
		}

		arduinocontroller.setId_Arduinocontroller(id);
		arduinocontroller.setTenArduinocontroller(arduinocontrollerForm.getTenArduinocontroller());
		arduinocontroller.setDiachiIP(arduinocontrollerForm.getDiachiIP());

		if (isNew) {
			session.persist(arduinocontroller);
		} else {
			session.save(arduinocontroller);
			System.out.println("saved");
		}

		// Nếu có lỗi tại DB, ngoại lệ sẽ ném ra ngay lập tức
		session.flush();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void removeArduino(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "delete from Arduinocontroller e where e.id_Arduinocontroller=" + id;
		Query<?> query = session.createQuery(sql);
		query.executeUpdate();
	}

}
