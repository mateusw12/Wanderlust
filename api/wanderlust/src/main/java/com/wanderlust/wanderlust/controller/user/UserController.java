package com.wanderlust.wanderlust.controller.user;

import com.wanderlust.wanderlust.dto.user.UserDTO;
import com.wanderlust.wanderlust.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/cadastro/usuario")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public @ResponseBody List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable @NotNull @Positive Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDTO create(@RequestBody @Valid @NotNull UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable @NotNull @Positive Long id,
                            @RequestBody @Valid @NotNull UserDTO userDTO) {
        return userService.update(id, userDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        userService.delete(id);
    }

}
