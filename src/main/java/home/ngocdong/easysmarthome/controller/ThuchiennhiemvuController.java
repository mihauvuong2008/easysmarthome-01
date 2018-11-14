package home.ngocdong.easysmarthome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import home.ngocdong.easysmarthome.model.NhiemvuInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Controller
@EnableTransactionManagement
public class ThuchiennhiemvuController {

	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
	}

	@RequestMapping({ "/admin/thuchienNhiemvu" })
	public String thuchienNhiemvuHandler(Model model, //
			@RequestParam(value = "name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page) throws Exception {

		PaginationResult<NhiemvuInfo> result = null;

		model.addAttribute("paginationNhiemvu", result);
		return "Ok";
	}

	@RequestMapping({ "/admin/nhiemvuManager" })
	public String quanlyNhiemvuHandler(Model model, //
			@RequestParam(value = "name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page) throws Exception {
		return "nhiemvuManager";
	}
}
