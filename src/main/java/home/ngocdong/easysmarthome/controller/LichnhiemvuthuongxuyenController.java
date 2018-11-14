package home.ngocdong.easysmarthome.controller;

import java.util.Date;
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

import home.ngocdong.easysmarthome.dao.Lich_Nhiemvu_thuongxuyenDAO;
import home.ngocdong.easysmarthome.dao.Nhiemvu_thuongxuyenDAO;
import home.ngocdong.easysmarthome.entity.Nhiemvu_thuongxuyen;
import home.ngocdong.easysmarthome.form.Nhiemvu_thuongxuyenForm;
import home.ngocdong.easysmarthome.model.Nhiemvu_thuongxuyenInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Controller
@Transactional
public class LichnhiemvuthuongxuyenController {

	@Autowired
	private Nhiemvu_thuongxuyenDAO nhiemvu_thuongxuyenDAO;

	@Autowired
	private Lich_Nhiemvu_thuongxuyenDAO lich_Nhiemvu_thuongxuyenDAO;
	
	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}

	}


	@RequestMapping({ "/admin/laplichnhiemvuthuongxuyen" })
	public String laplichnhiemvuthuongxuyenHandler(Model model) throws Exception {
		List<Nhiemvu_thuongxuyen> list = nhiemvu_thuongxuyenDAO.getNhiemvu_thuongxuyens();
		model.addAttribute("Nhiemvu_thuongxuyens", list);
		return "laplichnhiemvuthuongxuyen";
	}
	// POST: Save nhiemvuthuongxuyen
	@RequestMapping(value = { "/admin/lichnhiemvuthuongxuyen" })
	public String lichnhiemvuthuongxuyenSave(Model model, //
			@ModelAttribute("dateFrom") @Validated Date dateFrom, // ,
			@ModelAttribute("dateTo") @Validated Date dateTo, // ,
			@ModelAttribute("t2") @Validated String t2, // ,
			@ModelAttribute("t3") @Validated String t3, // ,
			@ModelAttribute("t4") @Validated String t4, // ,
			@ModelAttribute("t5") @Validated String t5, // ,
			@ModelAttribute("t6") @Validated String t6, // ,
			@ModelAttribute("t7") @Validated String t7, // ,
			@ModelAttribute("cn") @Validated String cn, // ,
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
		Nhiemvu_thuongxuyenForm nhiemvu_thuongxuyenForm = new Nhiemvu_thuongxuyenForm();
		try {
			lich_Nhiemvu_thuongxuyenDAO.save(nhiemvu_thuongxuyenForm);
		} catch (Exception e) {
			Throwable rootCause = ExceptionUtils.getRootCause(e);
			String message = rootCause.getMessage();
			model.addAttribute("errorMessage", message);
			model.addAttribute("Nhiemvu_thuongxuyenForm", nhiemvu_thuongxuyenForm);
			// Show cambien form.
			return "nhiemvuthuongxuyen";
		}
		return "redirect:/admin/nhiemvuManager";
	}
}
