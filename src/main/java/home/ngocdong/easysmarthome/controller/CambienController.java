package home.ngocdong.easysmarthome.controller;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import home.ngocdong.easysmarthome.dao.CambienDAO;
import home.ngocdong.easysmarthome.entity.Cambien;
import home.ngocdong.easysmarthome.form.CambienForm;
import home.ngocdong.easysmarthome.model.CambienInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Controller
@EnableTransactionManagement
public class CambienController {

	@Autowired
	CambienDAO cambienDAO;

	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
	}

	@RequestMapping({ "/admin/CambienList" })
	public String listCambienHandler(Model model,
			@RequestParam(value = "loaicambien", defaultValue = "0") int loaicambien,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		model.addAttribute("loaicambien", loaicambien);
		model.addAttribute("page", page);
		return "cambienList";
	}

	@RequestMapping({ "/admin/cambienList_table" })
	public String listCambien_tableHandler(Model model, //
			@RequestParam(value = "name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "loaicambien", defaultValue = "0") int loaicambien) {
		final int maxResult = 6;
		final int maxNavigationPage = 10;

		PaginationResult<CambienInfo> result = null;
		if (loaicambien == 0)
			result = cambienDAO.queryItems(page, //
					maxResult, maxNavigationPage, likeName);
		else
			result = cambienDAO.queryItems(loaicambien, page, //
					maxResult, maxNavigationPage, likeName);
		model.addAttribute("paginationCambien", result);
		model.addAttribute("loaicambien", loaicambien);
		return "cambienList_table";
	}

	@RequestMapping({ "/admin/cambienList_arduino" })
	public String listCambien_arduinoHandler(Model model, //
			@RequestParam(value = "name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "id_Arduino", defaultValue = "0") int id_Arduino) {
		final int maxResult = 100;
		final int maxNavigationPage = 10;

		PaginationResult<CambienInfo> result = null;
		result = cambienDAO.queryItems_byid_Arduino(id_Arduino, page, //
				maxResult, maxNavigationPage, likeName);
		model.addAttribute("paginationCambien", result);
		model.addAttribute("id_Arduino", id_Arduino);
		return "cambienList_arduino";
	}

	// GET: Hiển thị product
	@RequestMapping(value = { "/admin/cambien" }, method = RequestMethod.GET)
	public String cambien(Model model, @RequestParam(value = "code", defaultValue = "") String id,
			@RequestParam(value = "loaicambien", defaultValue = "0") int loaicambien) {
		CambienForm cambienForm = null;

		if (id != null && id.length() > 0) {
			Cambien cambien = cambienDAO.findCambien(Integer.valueOf(id));
			if (cambien != null) {
				cambienForm = new CambienForm(cambien);
			}
		}
		if (cambienForm == null) {
			cambienForm = new CambienForm();
			cambienForm.setNewCambien(true);
		}
		model.addAttribute("cambienForm", cambienForm);
		model.addAttribute("loaicambien", loaicambien);
		return "cambien";
	}

	// POST: Save product
	@RequestMapping(value = { "/admin/cambien" }, method = RequestMethod.POST)
	public String cambienSave(Model model, //
			@ModelAttribute("cambienForm") @Validated CambienForm cambienForm, // ,
			@RequestParam(value = "loaicambien", defaultValue = "0") int loaicambien, BindingResult result, //
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
			return "cambien";
		}
		try {
			cambienDAO.save(cambienForm);
		} catch (Exception e) {
			Throwable rootCause = ExceptionUtils.getRootCause(e);
			String message = rootCause.getMessage();
			model.addAttribute("errorMessage", message);
			model.addAttribute("cambienForm", cambienForm);
			// Show cambien form.
			return "cambien";
		}
		return "redirect:/admin/CambienList?loaicambien=" + loaicambien;
	}

}
