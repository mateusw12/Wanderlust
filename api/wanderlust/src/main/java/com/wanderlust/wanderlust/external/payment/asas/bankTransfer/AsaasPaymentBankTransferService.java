package com.wanderlust.wanderlust.external.payment.asas.bankTransfer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanderlust.wanderlust.external.payment.asas.bankTransfer.model.asaasTransferAccount.AsaasTransferAccount;
import com.wanderlust.wanderlust.external.payment.asas.bankTransfer.model.pixSchedule.PixScheduleTransfer;
import com.wanderlust.wanderlust.external.payment.asas.bankTransfer.model.ted.TedBankTransfer;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class AsaasPaymentBankTransferService {

    private final String apiKey = "";

    public ResponseEntity<String> tedBankTransfer(TedBankTransfer tedBankTransfer) throws JSONException {
        String apiUrl = "https://www.asaas.com/api/v3/transfers";
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer "+apiKey);
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(tedBankTransfer);
            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<TedBankTransfer> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    TedBankTransfer.class
            );
            response.getBody();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("A transferencia bancária via TED foi realizada sucesso!");
        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            String errorMessage = ex.getMessage();
            return ResponseEntity.status(status).body(errorMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> manualPixBankTransfer(TedBankTransfer tedBankTransfer) throws JSONException {
        String apiUrl = "https://www.asaas.com/api/v3/transfers";
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer "+apiKey);
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(tedBankTransfer);
            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<TedBankTransfer> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    TedBankTransfer.class
            );
            response.getBody();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("A transferencia bancária via PIX manual foi realizada sucesso!");
        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            String errorMessage = ex.getMessage();
            return ResponseEntity.status(status).body(errorMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> manualPixScheduleBankTransfer(PixScheduleTransfer pixScheduleTransfer) throws JSONException {
        String apiUrl = "https://www.asaas.com/api/v3/transfers";
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer "+apiKey);
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(pixScheduleTransfer);
            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<PixScheduleTransfer> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    PixScheduleTransfer.class
            );
            response.getBody();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("A transferencia bancária via PIX manual foi realizada sucesso!");
        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            String errorMessage = ex.getMessage();
            return ResponseEntity.status(status).body(errorMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> asaasTransferAccount(AsaasTransferAccount asaasTransferAccount) throws JSONException {
        String apiUrl = "https://www.asaas.com/api/v3/transfers";
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer "+apiKey);
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(asaasTransferAccount);
            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<AsaasTransferAccount> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    AsaasTransferAccount.class
            );
            response.getBody();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("A transferencia bancária para conta ASAAS foi realizada sucesso!");
        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            String errorMessage = ex.getMessage();
            return ResponseEntity.status(status).body(errorMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
