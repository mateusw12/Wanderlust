package com.wanderlust.wanderlust.dto.login;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record LoginDTO(
        @NotNull @NotBlank @Length(max = 200) String userName,
        @NotNull @NotBlank @Length(max = 200) String password
) {
}
