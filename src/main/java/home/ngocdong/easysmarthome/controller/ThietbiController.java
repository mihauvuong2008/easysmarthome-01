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

import home.ngocdong.easysmarthome.arduinocommunication.SmarthomeNetworkCommunication;
import home.ngocdong.easysmarthome.dao.ArduinocontrollerDAO;
import home.ngocdong.easysmarthome.dao.RelayDAO;
import home.ngocdong.easysmarthome.dao.ThietbiDAO;
import home.ngocdong.easysmarthome.dao.Thietbi_relayDAO;
import home.ngocdong.easysmarthome.dao.VitriDAO;
import home.ngocdong.easysmarthome.entity.Thietbi;
import home.ngocdong.easysmarthome.entity.Vitri;
import home.ngocdong.easysmarthome.form.ThietbiForm;
import home.ngocdong.easysmarthome.model.ArduinocontrollerInfo;
import home.ngocdong.easysmarthome.model.RelayInfo;
import home.ngocdong.easysmarthome.model.ThietbiInfo;
import home.ngocdong.easysmarthome.model.Thietbi_relayInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Controller
@EnableTransactionManagement
public class ThietbiController {

	@Autowired
	VitriDAO vitriDAO;

	@Autowired
	ThietbiDAO thietbiDAO;
	
	@Autowired
	RelayDAO relayDAO;

	@Autowired
	Thietbi_relayDAO thietbi_relayDAO;

	@Autowired
	ArduinocontrollerDAO arduinocontrollerDAO;

	Object temp;

	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}

	}

	@RequestMapping({ "/admin/ThietbiList" })
	public String listThietbiHandler(Model model, //
			@RequestParam(value = "name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "id_vitri", defaultValue = "0") int id_vitri) {
		final int maxResult = 6;
		final int maxNavigationPage = 10;

		PaginationResult<ThietbiInfo> result = null;
		if (id_vitri == 0) {
			result = thietbiDAO.queryItems(page, //
					maxResult, maxNavigationPage, likeName);
		} else {
			result = thietbiDAO.queryItems(id_vitri, page, //
					maxResult, maxNavigationPage, likeName);
		}

		model.addAttribute("paginationThietbi", result);
		return "thietbiList";
	}

	// GET: Hiển thị thietbi
	@RequestMapping(value = { "/admin/thietbi" }, method = RequestMethod.GET)
	public String thietbi(Model model, @RequestParam(value = "code", defaultValue = "") String id,
			@RequestParam(value = "commExeResults", defaultValue = "") String commExeResults) {
		ThietbiForm thietbiForm = null;

		if (id != null && id.length() > 0) {
			Thietbi thietbi = thietbiDAO.findThietbi(Integer.valueOf(id));
			if (thietbi != null) {
				thietbiForm = new ThietbiForm(thietbi);
			}
		}
		if (thietbiForm == null) {
			thietbiForm = new ThietbiForm();
			thietbiForm.setNewThietbi(true);
		}
		List<Vitri> list = vitriDAO.getVitris();
		model.addAttribute("thietbiForm", thietbiForm);
		model.addAttribute("vitris", list);
		model.addAttribute("commExeResults", commExeResults);
		return "thietbi";
	}

	// POST: Save thietbi
	@RequestMapping(value = { "/admin/thietbi" }, method = RequestMethod.POST)
	public String thietbiSave(Model model, //
			@ModelAttribute("thietbiForm") @Validated ThietbiForm thietbiForm, //
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
			return "thietbi";
		}
		try {
			Thietbi thietbi = thietbiDAO.findThietbi(thietbiForm.getId_Thietbi());
			if (thietbi != null)
				if (thietbiForm.getTrangthai() != thietbi.getTrangthai()) {
					// tat - bat dong co
					temp = thietbiForm;
					return "redirect:/arduino/dieukhienthietbi?id_Thietbi=" + thietbi.getId_Thietbi() + "&on_off="
							+ thietbiForm.getTrangthai();
				}
			thietbiDAO.save(thietbiForm);
		} catch (Exception e) {
			Throwable rootCause = ExceptionUtils.getRootCause(e);
			String message = rootCause.getMessage();
			model.addAttribute("errorMessage", message);
			model.addAttribute("thietbiForm", thietbiForm);
			// Show thietbi form.
			return "thietbi";
		}
		if (thietbiForm.getId_Thietbi() == 0)
			return "redirect:/admin/ThietbiList";
		else
			return "redirect:/admin/thietbi?code=" + thietbiForm.getId_Thietbi();
	}

	@RequestMapping("/admin/xoathietbi")
	public String removethietbi(Model model, @RequestParam(value = "code", defaultValue = "") String id) {
		thietbiDAO.removeThietbi(id);
		return "redirect:/admin/ThietbiList";
	}

	@RequestMapping({ "/arduino/dieukhienthietbi" })
	public String changeStateRelay(Model model, @RequestParam(value = "id_Thietbi", defaultValue = "") int id_Thietbi,
			@RequestParam(value = "on_off", defaultValue = "0") String on_off_str) throws Exception {

		Thietbi_relayInfo tr = thietbi_relayDAO.findThietbi_relay(id_Thietbi);
		RelayInfo rl = relayDAO.findRelayInfo(tr.getId_relay());
		ArduinocontrollerInfo ac = arduinocontrollerDAO.findArduinocontrollerInfo(rl.getId_Arduinocontroller());
		int on_off = Integer.valueOf(on_off_str);
		String success = "";
		ThietbiForm getTemp = (ThietbiForm) temp;
		try {
			if (on_off == 1) {
				SmarthomeNetworkCommunication.sendGetHttpCommand_turnOn(ac.getDiachiIP(), rl);
			} else {
				SmarthomeNetworkCommunication.sendGetHttpCommand_turnOff(ac.getDiachiIP(), rl);
			}
			success = "OK";
		} catch (Exception e) {
			// TODO: handle exception
			success = "Lenh gui di that bai";
			getTemp.setTrangthai(getTemp.getTrangthai() == 0 ? 1 : 0);
		}
		thietbiDAO.save(getTemp);
		return "redirect:/admin/thietbi?code=" + id_Thietbi + "&commExeResults=" + success;
	}
}
