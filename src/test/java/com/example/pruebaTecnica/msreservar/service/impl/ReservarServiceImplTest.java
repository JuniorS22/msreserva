package com.example.pruebaTecnica.msreservar.service.impl;

import com.example.pruebaTecnica.msreservar.dto.DiscountResponse;
import com.example.pruebaTecnica.msreservar.dto.ReservarRequest;
import com.example.pruebaTecnica.msreservar.entity.Reservar;
import com.example.pruebaTecnica.msreservar.exception.InvalidDiscountException;
import com.example.pruebaTecnica.msreservar.repository.ReservarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ReservarServiceImplTest {

    @Mock
    private ReservarRepository reservarRepository;

    @Mock
    private DescuentosServiceImpl descuentosService;

    @InjectMocks
    private ReservarServiceImpl reservarService;

    private ReservarRequest reservarRequest;
    private DiscountResponse discountResponse;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        reservarRequest = new ReservarRequest();
        reservarRequest.setId("14564088-7");
        reservarRequest.setName("Junior");
        reservarRequest.setLastname("Salinas");
        reservarRequest.setAge(24);
        reservarRequest.setPhoneNumber("954303346");
        reservarRequest.setStartDate(LocalDate.now());
        reservarRequest.setEndDate(LocalDate.now());
        reservarRequest.setHouseId("213132");
        reservarRequest.setDiscountCode("D0542A23");

        discountResponse = new DiscountResponse();
        discountResponse.setStatus(true);
    }

    @Test
    public void testCreateReservation_ValidDiscount() {
        Reservar reservar=new Reservar("14564088-7", "Junior","Salinas",24,"954303346",LocalDate.now(),LocalDate.now(),"213132","D0542A23");

        Mockito.when(descuentosService.validarDescuento(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(discountResponse);
        Mockito.when(reservarRepository.save(Mockito.any(Reservar.class))).thenReturn(reservar);

        Reservar reservation = reservarService.createReservation(reservarRequest);

        assertNotNull(reservation);
        assertEquals(reservarRequest.getId(),reservation.getId());
        assertEquals(reservarRequest.getHouseId(),reservation.getHouseId());
        assertEquals(reservarRequest.getDiscountCode(),reservation.getDiscountCode());
    }

    @Test
    public void testCreateReservation_InvalidDiscount() {
        discountResponse.setStatus(false);
        Mockito.when(descuentosService.validarDescuento(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(discountResponse);

        InvalidDiscountException exception = assertThrows(InvalidDiscountException.class, () -> {
            reservarService.createReservation(reservarRequest);
        });

        assertEquals("Invalid discount", exception.getMessage());
    }
}