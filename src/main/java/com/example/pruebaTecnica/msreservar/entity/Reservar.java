package com.example.pruebaTecnica.msreservar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@Table(name="reservar")
@EntityListeners(AuditingEntityListener.class)
public class Reservar {

    @Id
    private String id;
    private String name;
    private String lastname;
    private int age;
    private String phoneNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private String houseId;
    private String discountCode;

    public Reservar(String id, String name, String lastname, int age, String phoneNumber, LocalDate startDate, LocalDate endDate, String houseId, String discountCode) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.houseId = houseId;
        this.discountCode = discountCode;
    }

    public Reservar() {

    }
}
