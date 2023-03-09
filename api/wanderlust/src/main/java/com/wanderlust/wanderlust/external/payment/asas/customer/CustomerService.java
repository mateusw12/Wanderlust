package com.wanderlust.wanderlust.external.payment.asas.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanderlust.wanderlust.external.payment.asas.customer.model.CustomerCreate;
import com.wanderlust.wanderlust.external.payment.asas.customer.model.CustomerResponse;
import com.wanderlust.wanderlust.external.payment.asas.customer.model.CustomersResponse;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    private final String apiKey = "";

    public ResponseEntity<CustomerResponse> createCustomer(CustomerCreate customerCreate) throws JSONException {
        String apiUrl = "https://www.asaas.com/api/v3/customers";
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer "+apiKey);
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(customerCreate);
            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<CustomerResponse> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    CustomerResponse.class
            );
            CustomerResponse customerResponse = response.getBody();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(customerResponse);
        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            return ResponseEntity.status(status).body(new CustomerResponse());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> removeCustomer(String customerId) {
        String apiUrl = "https://www.asaas.com/api/v3/customers/"+customerId;
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer "+apiKey);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<CustomerResponse> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.DELETE,
                    entity,
                    CustomerResponse.class
            );
            CustomerResponse customerResponse = response.getBody();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Cliente excluído com sucesso!");
        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            return ResponseEntity.status(status).body(ex.getMessage());
        }
    }

    public ResponseEntity<CustomersResponse> findCustomers() {
        String apiUrl = "https://www.asaas.com/api/v3/customers";
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer "+apiKey);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<CustomersResponse> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<CustomersResponse>() {}
            );
            CustomersResponse customerResponse = response.getBody();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(customerResponse);
        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            return ResponseEntity.status(status).body(new CustomersResponse());
        }
    }

}
