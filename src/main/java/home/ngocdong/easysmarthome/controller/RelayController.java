package home.ngocdong.easysmarthome.controller;

import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.hibernate.JDBCException;
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
import home.ngocdong.easysmarthome.dao.RelayDAO;
import home.ngocdong.easysmarthome.dao.ThietbiDAO;
import home.ngocdong.easysmarthome.dao.Thietbi_relayDAO;
import home.ngocdong.easysmarthome.entity.Relay;
import home.ngocdong.easysmarthome.entity.Thietbi;
import home.ngocdong.easysmarthome.entity.Thietbi_relay;
import home.ngocdong.easysmarthome.form.RelayForm;
import home.ngocdong.easysmarthome.form.Thietbi_relayForm;
import home.ngocdong.easysmarthome.model.RelayInfo;
import home.ngocdong.easysmarthome.model.Thietbi_relayInfo;
import home.ngocdong.easysmarthome.pagination.PaginationResult;

@Controller
@EnableTransactionManagement
public class RelayController {

	@Autowired
	RelayDAO relayDAO;

	@Autowired
	Thietbi_relayDAO thietbi_relayDAO;

	@Autowired
	ArduinocontrollerDAO arduinocontrollerDAO;

	@Autowired
	ThietbiDAO thietbiDAO;
 
	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
	}


	@RequestMapping({ "/admin/relaysetup" })
	public String relaysetupHandler(Model model, //
			@RequestParam(value = "name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "id_Arduino", required = true) String id_Arduino) throws Exception {
		final int maxResult = 100;
		final int maxNavigationPage = 10;
		PaginationResult<Thietbi_relayInfo> PaginationThietbi_relay = relayDAO.getThietbi_relays_byArduinoID(id_Arduino,
				page, //
				maxResult, maxNavigationPage, likeName);
		List<Thietbi> listThietbi = thietbiDAO.getThietbis();
		model.addAttribute("PaginationThietbi_relay", PaginationThietbi_relay);
		model.addAttribute("listThietbi", listThietbi);
		model.addAttribute("id_Arduino", id_Arduino);
		return "relaysetup";
	}

	@RequestMapping({ "admin/luu_Thietbi_relay" })
	public String saveRelaysetupHandler(Model model, @RequestParam(value = "id_relay", required = true) String id_relay,
			@RequestParam(value = "id_Thietbi", required = true) String id_Thietbi) {
		Thietbi_relay tr = new Thietbi_relay();
		try {
			tr.setId_relay(Integer.valueOf(id_relay));
			tr.setId_Thietbi(Integer.valueOf(id_Thietbi));
			relayDAO.saveThietbi_relay(tr);
			return "resultOK";
		} catch (Exception e) {
			return "resultFail";
		}
	}

	@RequestMapping({ "/admin/removerelaysetup" })
	public String removeRelaysetupHandler(Model model,
			@RequestParam(value = "id_relay", required = true) String id_relay) {
		try {
			relayDAO.removeThietbi_relay(id_relay);
			return "resultOK";
		} catch (Exception e) {
			return "resultFail";
		}
	}

	@RequestMapping({ "/admin/accessFormrelaysetupAdd" })
	public String accessFormRelaysetupHandler(Model model,
			@RequestParam(value = "id_Arduino", required = true) String id_Arduino) throws Exception {
		List<Relay> listRelay = relayDAO.getRelays(id_Arduino);
		List<Thietbi> listThietbi = thietbiDAO.getThietbis();
		model.addAttribute("listRelay", listRelay);
		model.addAttribute("listThietbi", listThietbi);
		model.addAttribute("id_Arduino", id_Arduino);
		return "relaysetupAdd";
	}

	@RequestMapping({ "/admin/relaysetupAdd" })
	public String addRelayHandler(Model model, @RequestParam(value = "id_relay", required = true) int id_relay,
			@RequestParam(value = "id_Thietbi", required = true) int id_Thietbi) throws JDBCException {
		try {
			Thietbi_relayForm tr = new Thietbi_relayForm();
			tr.setId_relay(id_relay);
			tr.setId_Thietbi(id_Thietbi);
			relayDAO.addThietbi_relay(tr);
			return "resultOK";
		} catch (Exception e) {
			return "resultFail";
		}
	}

	@RequestMapping({ "/admin/relayList" })
	public String listRelayHandler(Model model, //
			@RequestParam(value = "name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "id_Arduino", required = true) int id_Arduino) throws Exception {
		final int maxResult = 100;
		final int maxNavigationPage = 10;

		PaginationResult<RelayInfo> result = null;
		result = relayDAO.queryItems(id_Arduino, page, //
				maxResult, maxNavigationPage, likeName);

		model.addAttribute("paginationRelay", result);
		model.addAttribute("id_Arduino", id_Arduino);
		return "relayList";
	}

	// GET: Hiển thị relay
	@RequestMapping(value = { "/admin/relay" }, method = RequestMethod.GET)
	public String relay(Model model, @RequestParam(value = "code", defaultValue = "") String id,
			@RequestParam(value = "id_Arduino", required = true) int id_Arduino)
			throws NumberFormatException, Exception {
		RelayForm relayForm = null;

		if (id != null && id.length() > 0) {
			RelayInfo relay = relayDAO.findRelayInfo(Integer.valueOf(id));
			if (relay != null) {
				relayForm = new RelayForm(relay);
			}
		}
		if (relayForm == null) {
			relayForm = new RelayForm();
			relayForm.setNewRelay(true);
		}
		// pass paramater
		model.addAttribute("relayForm", relayForm);
		model.addAttribute("id_Arduino", id_Arduino);
		return "relay";
	}

	// POST: Save relay
	@RequestMapping(value = { "/admin/relay" }, method = RequestMethod.POST)
	public String relaySave(Model model, //
			@ModelAttribute("relayForm") @Validated RelayForm relayForm, //
			@RequestParam(value = "id_Arduino", required = true) int id_Arduino, BindingResult result, //
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
			return "redirect:/admin/cauhinh?subpagemode=1&ItemSelected=" + id_Arduino;
		}
		try {
			relayForm.setId_Arduinocontroller(id_Arduino);
			relayDAO.save(relayForm);
		} catch (Exception e) {
			Throwable rootCause = ExceptionUtils.getRootCause(e);
			String message = rootCause.getMessage();
			model.addAttribute("errorMessage", message);
			// Show relay form.
			return "redirect:/admin/cauhinh?subpagemode=1&ItemSelected=" + id_Arduino;
		}
		return "redirect:/admin/cauhinh?subpagemode=1&ItemSelected=" + id_Arduino;
	}

	@RequestMapping("/admin/xoarelay")
	public String removerelay(Model model, @RequestParam(value = "code", defaultValue = "") String id,
			@RequestParam(value = "id_Arduino", defaultValue = "") int id_Arduino) throws Exception {
		try {
			relayDAO.removeRelay(id);
		} catch (Exception e) {
			return "resultFail";
		}
		return "resultOk";
	}
}
