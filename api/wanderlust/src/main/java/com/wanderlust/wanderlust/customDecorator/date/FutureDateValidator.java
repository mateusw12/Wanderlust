package com.wanderlust.wanderlust.customDecorator.date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class FutureDateValidator implements ConstraintValidator<FutureDate, Date> {

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        Date today = new Date();
        return value.after(today);
    }

}
