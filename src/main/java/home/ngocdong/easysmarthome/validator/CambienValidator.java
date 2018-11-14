package home.ngocdong.easysmarthome.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import home.ngocdong.easysmarthome.form.CambienForm;

@Component
public class CambienValidator implements Validator {
	// private EmailValidator emailValidator = EmailValidator.getInstance();

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == CambienForm.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// CambienForm custInfo = (CambienForm) target;
		// Kiểm tra các trường (field) của CambienForm.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Id_Cambien", "NotEmpty.CambienForm.id");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Tencambien", "NotEmpty.CambienForm.tencambien");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Id_Vitri", "NotEmpty.CambienForm.vitri");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Loaicambien", "NotEmpty.CambienForm.loaicambien");
	}

}
