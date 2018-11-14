package home.ngocdong.easysmarthome.controller;

import java.util.List;

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

import home.ngocdong.easysmarthome.dao.ArduinocontrollerDAO;
import home.ngocdong.easysmarthome.entity.Arduinocontroller;
import home.ngocdong.easysmarthome.form.ArduinocontrollerForm;
import home.ngocdong.easysmarthome.model.ArduinocontrollerInfo;

@Controller
@EnableTransactionManagement
public class ArduinoController {

	@Autowired
	ArduinocontrollerDAO arduinocontrollerDAO;

	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
	}

	@RequestMapping({ "/admin/cauhinh" })
	public String cauhinhHandler(Model model, //
			@RequestParam(value = "name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "ItemSelected", defaultValue = "0") int ItemSelected,
			@RequestParam(value = "subpagemode", defaultValue = "0", required = false) int subpagemode) {
		List<Arduinocontroller> listArduino = arduinocontrollerDAO.getArduinocontrollers();
		model.addAttribute("listArduino", listArduino);
		model.addAttribute("ItemSelected", ItemSelected);
		model.addAttribute("subpagemode", subpagemode);
		return "cauhinh";
	}

	@RequestMapping(value = { "/admin/arduino" }, method = RequestMethod.GET)
	public String accessFormarduinoAddsetupHandler(Model model,
			@RequestParam(value = "id_Arduino", required = false) String id_Arduino) throws Exception {
		ArduinocontrollerForm arduinocontrollerForm = null;

		if (id_Arduino != null && id_Arduino.length() > 0) {
			ArduinocontrollerInfo arduinocontroller = arduinocontrollerDAO
					.findArduinocontrollerInfo(Integer.valueOf(id_Arduino));
			if (arduinocontroller != null) {
				arduinocontrollerForm = new ArduinocontrollerForm(arduinocontroller);
			}
		}
		if (arduinocontrollerForm == null) {
			arduinocontrollerForm = new ArduinocontrollerForm();
			arduinocontrollerForm.setNewArduinocontroller(true);
		}
		model.addAttribute("arduinocontrollerForm", arduinocontrollerForm);
		model.addAttribute("id_Arduino", id_Arduino);
		return "arduinoAdd";
	}

	// POST: Save
	@RequestMapping(value = { "/admin/arduino" }, method = RequestMethod.POST)
	public String svearduinoAddsetupHandler(Model model,
			@ModelAttribute("arduinocontrollerForm") @Validated ArduinocontrollerForm arduinocontrollerForm,
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
			return "/admin/cauhinh";
		}
		if (arduinocontrollerForm != null)
			try {
				arduinocontrollerDAO.save(arduinocontrollerForm);
			} catch (Exception e) {
				System.out.println(e);
				Throwable rootCause = ExceptionUtils.getRootCause(e);
				String message = rootCause.getMessage();
				model.addAttribute("errorMessage", message);
				// Show thietbi form.
				return "redirect:/admin/cauhinh";
			}

		return "redirect:/admin/cauhinh";
	}

	@RequestMapping("/admin/xoaarduino")
	public String removearduino(Model model, @RequestParam(value = "code", defaultValue = "") String id) {
		try {
			arduinocontrollerDAO.removeArduino(id);
		} catch (Exception e) {
			return "resultFail";
		}
		return "resultOk";
	}

}
