package com.wanderlust.wanderlust.external.payment.asas.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanderlust.wanderlust.external.payment.asas.account.model.PaymentAccount;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentAccountService {

    private final String apiKey = "";

    public ResponseEntity<String> paymentAccount(PaymentAccount paymentAccount) throws JSONException {
        String apiUrl = "https://www.asaas.com/api/v3/bill";
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer "+apiKey);

            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(paymentAccount);
            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<PaymentAccount> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    PaymentAccount.class
            );
            return ResponseEntity.status(HttpStatus.CREATED).body("Pagamento efetuado com sucesso!");

        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            return ResponseEntity.status(status).body(ex.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> cancelationPaymentAccount(String paymentAccountId) throws JSONException {
        String apiUrl = "https://www.asaas.com/api/v3/bill/"+paymentAccountId+"/cancel";
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer "+apiKey);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<PaymentAccount> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    PaymentAccount.class
            );
            return ResponseEntity.status(HttpStatus.CREATED).body("Pagamento cancelado com sucesso!");

        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            return ResponseEntity.status(status).body(ex.getMessage());
        }
    }

}
