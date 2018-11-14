package home.ngocdong.easysmarthome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import home.ngocdong.easysmarthome.dao.Thietbi_relayDAO;

@Controller
@Transactional
public class ArduinoCommandController {

	@Autowired
	Thietbi_relayDAO thietbi_relayDAO;

	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		System.out.println("Target=" + target);

	}

}
