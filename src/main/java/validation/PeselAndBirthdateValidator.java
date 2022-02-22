package validation;

import com.example.mylibrarymanagmentendproject.model.dto.UserRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeselAndBirthdateValidator implements
        ConstraintValidator<PeselAndBirthdate, UserRequest> {

    @Override
    public void initialize(PeselAndBirthdate constraintAnnotation) {
    }
    @Override
    public boolean isValid(UserRequest userRequest,
                           ConstraintValidatorContext constraintValidatorContext) {
        userRequest.getPesel();
        userRequest.getBirthday();
        return false;
    }
}
