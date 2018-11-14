package home.ngocdong.easysmarthome.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import home.ngocdong.easysmarthome.form.VitriForm;

@Component
public class VitriValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == VitriForm.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// Kiểm tra các trường (field) của VitriForm.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Id_vitri", "NotEmpty.VitriForm.id");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Vitri", "NotEmpty.VitriForm.vitri");

	}

}
