package home.ngocdong.easysmarthome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import home.ngocdong.easysmarthome.form.CambienForm;
import home.ngocdong.easysmarthome.model.VitriInfo;

@Controller
@EnableTransactionManagement
public class MainController {

	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		System.out.println("Target=" + target);

		// Trường hợp update SL trên giỏ hàng.
		// (@ModelAttribute("cartForm") @Validated CartInfo cartForm)
		if (target.getClass() == VitriInfo.class) {

		}

		// Trường hợp save thông tin khách hàng.
		// (@ModelAttribute @Validated CustomerInfo customerForm)
		else if (target.getClass() == CambienForm.class) {
			// dataBinder.setValidator(cambienValidator);
		}

	}

	@RequestMapping("/403")
	public String accessDenied() {
		return "/403";
	}

	@RequestMapping("/")
	public String home() {
		return "index";
	}// Danh sách sản phẩm.

	@RequestMapping(value = { "/nhandulieutuClient" }, method = RequestMethod.GET)
	public String clientGuidulieu(Model model, //
			@ModelAttribute("data") @Validated String data, //
			BindingResult result, //
			final RedirectAttributes redirectAttributes) {
		System.out.println(data);
		return "ok";
	}

}
