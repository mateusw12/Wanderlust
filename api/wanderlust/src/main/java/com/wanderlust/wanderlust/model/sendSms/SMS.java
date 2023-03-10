package com.wanderlust.wanderlust.model.sendSms;

import com.wanderlust.wanderlust.validator.user.decorator.phoneNumber.PhoneNumber;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SMS {

    @NotNull()
    @NotBlank()
    @PhoneNumber()
    private String phoneNumber;

    @NotNull()
    @NotBlank()
    @Length(min = 1, max = 200)
    private String message;

    @NotNull()
    @NotBlank()
    @Length(min = 1, max = 200)
    private String subject;

}
