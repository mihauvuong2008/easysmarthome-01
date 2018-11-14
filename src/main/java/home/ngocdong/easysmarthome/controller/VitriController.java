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

import home.ngocdong.easysmarthome.dao.VitriDAO;
import home.ngocdong.easysmarthome.entity.Vitri;
import home.ngocdong.easysmarthome.form.VitriForm;
import home.ngocdong.easysmarthome.model.VitriInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Controller
@EnableTransactionManagement
public class VitriController {

	@Autowired
	VitriDAO vitriDAO;

	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
	}

	@RequestMapping({ "/admin/VitriList" })
	public String listVitriHandler(Model model, //
			@RequestParam(value = "name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		final int maxResult = 6;
		final int maxNavigationPage = 10;

		PaginationResult<VitriInfo> result = vitriDAO.queryItems(page, //
				maxResult, maxNavigationPage, likeName);

		model.addAttribute("paginationVitri", result);
		return "vitriList";
	}

	// GET: Hiển thị vi tri
	@RequestMapping(value = { "/admin/vitri" }, method = RequestMethod.GET)
	public String vitri(Model model, @RequestParam(value = "code", defaultValue = "") String id) {
		VitriForm vitriForm = null;

		if (id != null && id.length() > 0) {
			Vitri vitri = vitriDAO.findVitri(Integer.valueOf(id));
			if (vitri != null) {
				vitriForm = new VitriForm(vitri);
			}
		}
		if (vitriForm == null) {
			vitriForm = new VitriForm();
			vitriForm.setNewVitri(true);
		}
		model.addAttribute("vitriForm", vitriForm);
		return "vitri";
	}

	// POST: Save vi tri
	@RequestMapping(value = { "/admin/vitri" }, method = RequestMethod.POST)
	public String vitriSave(Model model, //
			@ModelAttribute("vitriForm") @Validated VitriForm vitriForm, //
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
			return "vitri";
		}
		try {
			vitriDAO.save(vitriForm);
		} catch (Exception e) {
			Throwable rootCause = ExceptionUtils.getRootCause(e);
			String message = rootCause.getMessage();
			model.addAttribute("errorMessage", message);
			model.addAttribute("vitriForm", vitriForm);
			// Show cambien form.
			return "vitri";
		}

		return "redirect:/admin/VitriList";
	}

	@RequestMapping("/admin/xoavitri")
	public String removevitri(Model model, @RequestParam(value = "code", defaultValue = "") String id) {
		vitriDAO.removeVitri(id);
		return "redirect:/admin/VitriList";
	}
}
