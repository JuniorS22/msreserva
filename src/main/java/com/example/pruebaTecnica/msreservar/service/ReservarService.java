package com.example.pruebaTecnica.msreservar.service;

import com.example.pruebaTecnica.msreservar.dto.ReservarRequest;
import com.example.pruebaTecnica.msreservar.entity.Reservar;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ReservarService {

    Reservar createReservation(ReservarRequest request);
}
