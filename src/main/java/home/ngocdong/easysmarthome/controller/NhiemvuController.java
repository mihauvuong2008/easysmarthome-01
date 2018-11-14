package home.ngocdong.easysmarthome.controller;

import java.util.Date;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import home.ngocdong.easysmarthome.dao.NhiemvuDAO;
import home.ngocdong.easysmarthome.entity.Nhiemvu;
import home.ngocdong.easysmarthome.form.NhiemvuForm;
import home.ngocdong.easysmarthome.model.NhiemvuInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Controller
@EnableTransactionManagement
public class NhiemvuController {

	@Autowired
	NhiemvuDAO nhiemvuDAO;

	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
	}

	@RequestMapping({ "/admin/nhiemvuList" })
	public String listNhiemvuHandler(Model model, //
			@RequestParam(value = "name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page) throws Exception {
		return "nhiemvuList";
	}

	@RequestMapping({ "/admin/nhiemvuData" })
	public String sublistNhiemvuHandler(Model model, //
			@RequestParam(value = "name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "dateFrom", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
			@RequestParam(value = "dateTo", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo,
			@RequestParam(value = "thuchien", defaultValue = "1") String thuchien) throws Exception {
		final int maxResult = 5000;
		final int maxNavigationPage = 10;
		PaginationResult<NhiemvuInfo> result = null;
		result = nhiemvuDAO.queryItems(dateFrom, dateTo, Boolean.valueOf(thuchien), page, //
				maxResult, maxNavigationPage, likeName);
		model.addAttribute("paginationNhiemvu", result);
		return "nhiemvu_table";
	}

	// GET: Hiển thị Nhiemvu
	@RequestMapping(value = { "/admin/hengiothietbi" }, method = RequestMethod.GET)
	public String nhiemvuthuongxuyen(Model model, @RequestParam(value = "code", defaultValue = "") String id) {
		NhiemvuForm nhiemvuForm = null;

		if (id != null && id.length() > 0) {
			Nhiemvu nhiemvu = nhiemvuDAO.findNhiemvu(Integer.valueOf(id));
			if (nhiemvu != null) {
				nhiemvuForm = new NhiemvuForm(nhiemvu);
			}
		}
		if (nhiemvuForm == null) {
			nhiemvuForm = new NhiemvuForm();
			nhiemvuForm.setNewNhiemvu(true);
		}
		model.addAttribute("NhiemvuForm", nhiemvuForm);
		return "nhiemvu";
	}

	// POST: Save Nhiemvu
	@RequestMapping(value = { "/admin/hengiothietbi" }, method = RequestMethod.POST)
	public String nhiemvuthuongxuyenSave(Model model, //
			@ModelAttribute("NhiemvuForm") @Validated NhiemvuForm nhiemvuForm, // ,
			BindingResult result, //
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			for (Object object : result.getAllErrors()) {
				if (object instanceof FieldError) {
					FieldError fieldError = (FieldError) object;
					System.out.println(fieldError.getCode());
				}

				if (object instanceof ObjectError) {
					ObjectError objectError = (ObjectError) object;
					System.out.println(objectError.getCode());
				}
			}
			return "nhiemvuList";
		}
		try {
			nhiemvuDAO.save(nhiemvuForm);
		} catch (Exception e) {
			Throwable rootCause = ExceptionUtils.getRootCause(e);
			String message = rootCause.getMessage();
			model.addAttribute("errorMessage", message);
			model.addAttribute("NhiemvuForm", nhiemvuForm);
			// Show cambien form.
			return "nhiemvu";
		}
		return "redirect:/admin/nhiemvuManager";
	}

	@RequestMapping("/admin/xoanhiemvu")
	public String removethietbi(Model model, @RequestParam(value = "code", defaultValue = "") String id) {
		nhiemvuDAO.removeNhiemvu(id);
		return "redirect:/admin/nhiemvuManager";
	}
}
