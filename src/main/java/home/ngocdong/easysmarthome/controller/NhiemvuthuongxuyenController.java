package home.ngocdong.easysmarthome.controller;

import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

import home.ngocdong.easysmarthome.dao.Nhiemvu_thuongxuyenDAO;
import home.ngocdong.easysmarthome.entity.Nhiemvu_thuongxuyen;
import home.ngocdong.easysmarthome.form.Nhiemvu_thuongxuyenForm;
import home.ngocdong.easysmarthome.model.Nhiemvu_thuongxuyenInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Controller
@Transactional
public class NhiemvuthuongxuyenController {

	@Autowired
	private Nhiemvu_thuongxuyenDAO nhiemvu_thuongxuyenDAO;

	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}

	}

	@RequestMapping({ "/admin/danhsachnhiemvuthuongxuyen" })
	public String lichthietbiHandler(Model model, //
			@RequestParam(value = "name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page) throws Exception {
		final int maxResult = 5000;
		final int maxNavigationPage = 10;
		PaginationResult<Nhiemvu_thuongxuyenInfo> result = null;
		result = nhiemvu_thuongxuyenDAO.queryItems(page, //
				maxResult, maxNavigationPage, likeName);
		model.addAttribute("paginationNhiemvu_thuongxuyen", result);
		return "nhiemvuthuongxuyenList";
	}

	// GET: Hiển thị nhiemvuthuongxuyen
	@RequestMapping(value = { "/admin/nhiemvuthuongxuyen" }, method = RequestMethod.GET)
	public String nhiemvuthuongxuyen(Model model, @RequestParam(value = "code", defaultValue = "") String id,
			@RequestParam(value = "loaicambien", defaultValue = "0") int loaicambien) {
		Nhiemvu_thuongxuyenForm nhiemvuthuongxuyenForm = null;

		if (id != null && id.length() > 0) {
			Nhiemvu_thuongxuyen nhiemvu_thuongxuyen = nhiemvu_thuongxuyenDAO
					.findNhiemvu_thuongxuyen(Integer.valueOf(id));
			if (nhiemvu_thuongxuyen != null) {
				nhiemvuthuongxuyenForm = new Nhiemvu_thuongxuyenForm(nhiemvu_thuongxuyen);
			}
		}
		if (nhiemvuthuongxuyenForm == null) {
			nhiemvuthuongxuyenForm = new Nhiemvu_thuongxuyenForm();
			nhiemvuthuongxuyenForm.setNewNhiemvu_thuongxuyen(true);
		}
		model.addAttribute("Nhiemvu_thuongxuyenForm", nhiemvuthuongxuyenForm);
		return "nhiemvuthuongxuyen";
	}

	// POST: Save nhiemvuthuongxuyen
	@RequestMapping(value = { "/admin/nhiemvuthuongxuyen" }, method = RequestMethod.POST)
	public String nhiemvuthuongxuyenSave(Model model, //
			@ModelAttribute("nhiemvuthuongxuyenForm") @Validated Nhiemvu_thuongxuyenForm nhiemvuthuongxuyenForm, // ,
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
			return "nhiemvuthuongxuyenList";
		}
		try {
			nhiemvu_thuongxuyenDAO.save(nhiemvuthuongxuyenForm);
		} catch (Exception e) {
			Throwable rootCause = ExceptionUtils.getRootCause(e);
			String message = rootCause.getMessage();
			model.addAttribute("errorMessage", message);
			model.addAttribute("Nhiemvu_thuongxuyenForm", nhiemvuthuongxuyenForm);
			// Show cambien form.
			return "nhiemvuthuongxuyen";
		}
		return "redirect:/admin/nhiemvuManager";
	}

	@RequestMapping("/admin/xoanhiemvuthuongxuyen")
	public String removenhiemvuthuongxuyen(Model model, @RequestParam(value = "code", defaultValue = "") String id) {
		nhiemvu_thuongxuyenDAO.removeNhiemvu_thuongxuyen(id);
		return "redirect:/admin/nhiemvuManager";
	}

}
