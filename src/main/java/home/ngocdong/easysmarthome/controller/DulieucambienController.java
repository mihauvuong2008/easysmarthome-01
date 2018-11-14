package home.ngocdong.easysmarthome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import home.ngocdong.easysmarthome.dao.DulieucambienDAO;
import home.ngocdong.easysmarthome.model.DulieucambienInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Controller
@EnableTransactionManagement
public class DulieucambienController {
	@Autowired
	DulieucambienDAO dulieucambienDAO;

	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
	}

	@RequestMapping({ "/admin/lichsucambien" })
	public String listLichsucambienHandler(Model model, //
			@RequestParam(value = "name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		final int maxResult = 6;
		final int maxNavigationPage = 10;

		PaginationResult<DulieucambienInfo> result = dulieucambienDAO.queryItems(page, //
				maxResult, maxNavigationPage, likeName);

		model.addAttribute("paginationDulieucambienInfo", result);
		return "dulieucambien";
	}
}
