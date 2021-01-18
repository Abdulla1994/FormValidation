package az.kyf.validator;

import az.kyf.form.RequestForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class RequestFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(RequestForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
    RequestForm form=(RequestForm ) o;

        System.out.println("Request Form validator Isledi");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name ","requestForm.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"surname ","requestForm.surname.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phone","requestForm.phone.empty");
    }
}
