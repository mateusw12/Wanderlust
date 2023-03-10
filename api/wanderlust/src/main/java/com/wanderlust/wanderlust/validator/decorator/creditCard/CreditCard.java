package com.wanderlust.wanderlust.validator.decorator.creditCard;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { CreditCardValidator.class })
public @interface CreditCard {

    String message() default "Número do cartão de crédito inválido!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
