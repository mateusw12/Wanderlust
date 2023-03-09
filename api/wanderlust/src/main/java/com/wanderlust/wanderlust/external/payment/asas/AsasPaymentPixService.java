package com.wanderlust.wanderlust.external.payment.asas;

import com.wanderlust.wanderlust.external.payment.asas.model.pix.dataPix.Pix;
import com.wanderlust.wanderlust.external.payment.asas.model.pix.generatePix.GeneratePix;
import com.wanderlust.wanderlust.external.payment.asas.model.pix.qrCodeDecode.QRCodeDecode;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class AsasPaymentPixService {

    private final String apiKey = "API_KEY";

    public GeneratePix GeneratePixKey() throws JSONException {
        String apiUrl = "https://www.asaas.com/api/v3/pix/addressKeys";
        try {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer "+apiKey);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("type", "EVP");
            HttpEntity<String> entity = new HttpEntity<>(jsonObject.toString(), headers);

            ResponseEntity<GeneratePix> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    GeneratePix.class
            );
            GeneratePix generatePix = response.getBody();
            return generatePix;

        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            return ResponseEntity.status(status).body(new GeneratePix()).getBody();
        }
    }

    public ResponseEntity<String> RemovePixKey(String pixId) throws JSONException {
        String apiUrl = "https://www.asaas.com/api/v3/pix/addressKeys/"+pixId;
        try {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer "+apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<GeneratePix> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.DELETE,
                    entity,
                    GeneratePix.class
            );
            response.getBody();
            return ResponseEntity.status(HttpStatus.CREATED).body("A chave pix foi removida com sucesso!");
        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            String errorMessage = ex.getMessage();
            return ResponseEntity.status(status).body(errorMessage);
        }
    }

    public ResponseEntity<Pix> findPixKey() throws JSONException {
        String apiUrl = "https://www.asaas.com/api/v3/pix/addressKeys";
        try {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer "+apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);


            ResponseEntity<Pix> response;

            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    entity,
                    Pix.class
            );
            Pix pix = response.getBody();
            return ResponseEntity.status(HttpStatus.CREATED).body(pix);

        } catch (HttpClientErrorException ex) {
            HttpStatus status = ex.getStatusCode();
            return ResponseEntity.status(status).body(new Pix());
        }
    }

    public ResponseEntity<QRCodeDecode> qrdCodeDecode(String payLoad) throws JSONException {
        String apiUrl = "https://www.asaas.com/api/v3/pix/qrCodes/pay";
        try {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer "+apiKey);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("payload", payLoad);

        HttpEntity<String> entity = new HttpEntity<>(jsonObject.toString(), headers);

        ResponseEntity<QRCodeDecode> response;

        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                entity,
                QRCodeDecode.class
        );
        QRCodeDecode qrCodeDecode = response.getBody();
        return ResponseEntity.status(HttpStatus.CREATED).body(qrCodeDecode);
        } catch (HttpClientErrorException ex) {
        HttpStatus status = ex.getStatusCode();
        return ResponseEntity.status(status).body(new QRCodeDecode());
        }
    }

}
