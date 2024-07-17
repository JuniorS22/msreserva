package com.example.pruebaTecnica.msreservar.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDate;

@Getter
@Setter
@ToString
public class ReservarRequest {
    @Size(min = 9, max = 10)
    @NotBlank(message = "required property Id")
    private String id;

    @NotBlank(message = "required property Name")
    @Size(min = 2, max = 50)
    private String name;

    @NotBlank(message = "required property lastname")
    @Size(min = 2, max = 50)
    private String lastname;

    @Positive(message = "Age must be positive")
    @NotNull(message = "required property Age")
    @Min(18)
    @Max(100)
    private Integer age;

    @NotBlank(message = "required property phoneNumber")
    @Size(min = 9, max = 20)
    private String phoneNumber;

    @NotNull(message = "required property startDate")
    private LocalDate startDate;

    @NotNull(message = "required property endDate ")
    private LocalDate endDate;

    @NotBlank(message = "required property houseId")
    @Size(min = 6, max = 15)
    private String houseId;

    @NotBlank(message = "required property discountCode")
    @Size(min = 8, max = 8)
    private String discountCode;
}
