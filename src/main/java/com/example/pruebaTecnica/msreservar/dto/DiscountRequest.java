package com.example.pruebaTecnica.msreservar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DiscountRequest {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("house_id")
    private String houseId;

    @JsonProperty("discount_code")
    private String discountCode;
}
