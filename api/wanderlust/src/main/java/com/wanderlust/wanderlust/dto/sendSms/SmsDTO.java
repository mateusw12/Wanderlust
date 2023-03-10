package com.wanderlust.wanderlust.dto.sendSms;

import com.wanderlust.wanderlust.validator.decorator.phoneNumber.PhoneNumber;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record SmsDTO(
        @NotNull @NotBlank @PhoneNumber String phoneNumber,
        @NotNull @NotBlank @Length(min = 1, max = 200) String message,
        @NotNull @NotBlank @Length(min = 1, max = 200) String subject
) {
}
