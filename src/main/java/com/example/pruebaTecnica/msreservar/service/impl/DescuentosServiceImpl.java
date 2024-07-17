package com.example.pruebaTecnica.msreservar.service.impl;


import com.example.pruebaTecnica.msreservar.dto.DiscountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class DescuentosServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    public DiscountResponse validarDescuento(String id, String houseId, String discountCode) {


        String apiUrl = "https://sbv2bumkomidlxwffpgbh4k6jm0ydskh.lambda-url.us-east-1.on.aws/";

        HttpHeaders headers = new HttpHeaders();

        Map<String,String> body=new HashMap<>();
        body.put("userId",id);
        body.put("houseId",houseId);
        body.put("discountCode",discountCode);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);


        ResponseEntity<DiscountResponse> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, DiscountResponse.class);


        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {

            return null;
        }
    }
}


