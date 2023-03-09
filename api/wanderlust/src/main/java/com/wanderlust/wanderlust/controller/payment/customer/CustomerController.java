package com.wanderlust.wanderlust.controller.payment.customer;

import com.wanderlust.wanderlust.external.payment.asas.customer.CustomerService;
import com.wanderlust.wanderlust.external.payment.asas.customer.model.CustomerCreate;
import com.wanderlust.wanderlust.external.payment.asas.customer.model.CustomerResponse;
import com.wanderlust.wanderlust.external.payment.asas.customer.model.CustomersResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("api/pagamento/cliente")
@Tag(name = "Cadastro de cliente pagador")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    @Operation(summary = "Cadastro de cliente")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CustomerCreate customerCreate) throws JSONException {
        return customerService.createCustomer(customerCreate);
    }

    @DeleteMapping()
    @Operation(summary = "Remove de cliente")
    public ResponseEntity<String> removeCustomer(@PathVariable @NotNull @NotBlank String customerId) throws JSONException {
        return customerService.removeCustomer(customerId);
    }

    @GetMapping()
    @Operation(summary = "Consulta todos os cliente")
    public ResponseEntity<CustomersResponse> findCustomers() {
        return customerService.findCustomers();
    }

}
