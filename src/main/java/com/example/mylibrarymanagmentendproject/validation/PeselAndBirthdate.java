package com.example.mylibrarymanagmentendproject.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PeselAndBirthdateValidator.class)
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PeselAndBirthdate {
    String message() default "bad pesel";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}


