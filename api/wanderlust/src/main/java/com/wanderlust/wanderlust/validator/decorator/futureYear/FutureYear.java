package com.wanderlust.wanderlust.validator.decorator.futureYear;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { FutureYearValidator.class })
public @interface FutureYear {

    String message() default "O ano informada deve ser maior que o ano atual";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}