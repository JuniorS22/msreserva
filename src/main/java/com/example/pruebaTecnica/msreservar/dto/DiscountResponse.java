package com.example.pruebaTecnica.msreservar.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DiscountResponse {

    private String houseId;
    private String discountCode;
    private int id;
    private String userId;
    private Boolean status;

}
