package com.wanderlust.wanderlust.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wanderlust.wanderlust.converter.role.RoleConverter;
import com.wanderlust.wanderlust.model.role.Role;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity(name= "usuario")
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @NotNull
    @NotBlank
    @Length(max = 200)
    @Column(name="nome", nullable = false, length = 200)
    public String name;

    @NotNull
    @NotBlank
    @Length(max = 200)
    @Column(name="nomeUsuario", nullable = false, length = 200, unique = true)
    public String userName;

    @Email
    @NotNull
    @NotBlank
    @Length(max = 300)
    @Column(name="email", length = 300)
    public String email;

    @NotNull
    @NotBlank
    @Length(max = 200)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name="senha", nullable = false, length = 200)
    public String password;

    @Column(name="ativo")
    public Boolean isActive;

    @NotNull
    @Convert(converter = RoleConverter.class)
    @Column(name="perfil", nullable = false, length = 100)
    public Role role;

    @Length(max = 15)
    @NotBlank
    @NotNull
    @Column(name="cep")
    public String cep;

}
