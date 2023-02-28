package com.wanderlust.wanderlust.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public record UserDTO(
        @Id Long id,
        @NotBlank @NotNull @Length(max = 200) String name,
        @NotBlank @NotNull @Length(max = 200) String userName,
        @NotBlank @NotNull @Length(max = 300) @Email String email,
        @NotBlank @NotNull @Length(max = 15) String cep,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @NotBlank @NotNull @Length(max = 200) String password,
        @NotNull @Positive Long role,
        Boolean isActive)
{ }