package com.wanderlust.wanderlust.validator.user.decorator.futureYear;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

@Component
public class FutureYearValidator implements ConstraintValidator<FutureYear, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        LocalDate year = LocalDate.parse(value + "-01-01");
        return year.isAfter(LocalDate.now());
    }

}
