package com.wanderlust.wanderlust.external.payment.asas.bankChargers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.charger.BankCharger;
import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.charger.response.BankChargerResponse;
import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.chargerInstallments.ChargerInstallments;
import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.chargerInstallments.response.ChargerInstallmentsResponse;
import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.creditCard.BankChargerCreditCard;
import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.qrCoreCharge.QRCodeCharger;
import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.reverseCharge.ReverseCharge;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class BankChargersService {

    private final String apiKey = "";

    public ResponseEntity<BankChargerResponse> createCharger(BankCharger bankCharger) throws JSONException {
        String apiUrl = "https://www.asaas.com/api/v3/payments";
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer "+apiKey);
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(bankCharger);
            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<BankChargerResponse> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    BankChargerResponse.class
            );
            BankChargerResponse bankChargerResponse =  response.getBody();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(bankChargerResponse);
        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            return ResponseEntity.status(status).body(new BankChargerResponse());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> createCreditCardCharger(BankChargerCreditCard bankChargerCreditCard) throws JSONException {
        String apiUrl = "https://www.asaas.com/api/v3/payments";
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer "+apiKey);
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(bankChargerCreditCard);
            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<BankChargerResponse> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    BankChargerResponse.class
            );
            response.getBody();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Transação autorizada com sucesso!");
        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            return ResponseEntity.status(status).body(ex.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<ChargerInstallmentsResponse> createCreditCardCharger(ChargerInstallments chargerInstallments) throws JSONException {
        String apiUrl = "https://www.asaas.com/api/v3/payments";
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer "+apiKey);
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(chargerInstallments);
            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<ChargerInstallmentsResponse> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    ChargerInstallmentsResponse.class
            );
            ChargerInstallmentsResponse chargerInstallmentsResponse = response.getBody();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(chargerInstallmentsResponse);
        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            return ResponseEntity.status(status).body(new ChargerInstallmentsResponse() );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> removeCharger(String chargerId) {
        String apiUrl = "https://www.asaas.com/api/v3/payments/"+chargerId;
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer "+apiKey);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<ChargerInstallmentsResponse> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.DELETE,
                    entity,
                    ChargerInstallmentsResponse.class
            );
            ChargerInstallmentsResponse chargerInstallmentsResponse = response.getBody();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Cobrança excluída com sucesso!");
        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            return ResponseEntity.status(status).body(ex.getMessage());
        }
    }

    public ResponseEntity<String> reverseCharge(ReverseCharge reverseCharge, String chargeId) {
        String apiUrl = "https://www.asaas.com/api/v3/payments/"+chargeId+"/refund";
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer "+apiKey);
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(reverseCharge);
            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<ReverseCharge> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    ReverseCharge.class
            );
            ReverseCharge charge = response.getBody();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Cobrança estornada com sucesso!");
        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            return ResponseEntity.status(status).body(ex.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<QRCodeCharger> findQrdCodeCharger(String chargerId) {
        String apiUrl = "https://www.asaas.com/api/v3/payments/"+chargerId+"/pixQrCodes";
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer "+apiKey);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<QRCodeCharger> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    entity,
                    QRCodeCharger.class
            );
            QRCodeCharger qrCodeCharger = response.getBody();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(qrCodeCharger);
        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            return ResponseEntity.status(status).body(new QRCodeCharger());
        }
    }

}
