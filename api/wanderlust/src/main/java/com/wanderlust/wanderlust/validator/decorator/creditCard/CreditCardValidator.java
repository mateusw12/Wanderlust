package com.wanderlust.wanderlust.validator.decorator.creditCard;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

@Component
public class CreditCardValidator implements ConstraintValidator<CreditCard, String> {

    private static final Pattern CREDIT_CARD_PATTERN = Pattern.compile("^\\d{13,19}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        // Remove todos os caracteres que não são dígitos
        String cleanedValue = value.replaceAll("\\D", "");

        // Verifica se o número do cartão de crédito tem o tamanho correto e se é numérico
        if (!CREDIT_CARD_PATTERN.matcher(cleanedValue).matches()) {
            return false;
        }

        // Verifica o dígito de verificação usando o algoritmo de Luhn
        int sum = 0;
        boolean alternate = false;
        for (int i = cleanedValue.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cleanedValue.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

}
