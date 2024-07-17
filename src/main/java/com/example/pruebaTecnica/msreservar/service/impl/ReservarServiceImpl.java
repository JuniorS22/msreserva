package com.example.pruebaTecnica.msreservar.service.impl;

import com.example.pruebaTecnica.msreservar.dto.DiscountRequest;
import com.example.pruebaTecnica.msreservar.dto.DiscountResponse;
import com.example.pruebaTecnica.msreservar.dto.ReservarRequest;
import com.example.pruebaTecnica.msreservar.entity.Reservar;
import com.example.pruebaTecnica.msreservar.exception.InvalidDiscountException;
import com.example.pruebaTecnica.msreservar.repository.ReservarRepository;
import com.example.pruebaTecnica.msreservar.service.ReservarService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class ReservarServiceImpl implements ReservarService {

    @Autowired
    private ReservarRepository reservarRepository;

    @Autowired
    private DescuentosServiceImpl descuentosService;
    @Override
    public Reservar createReservation(ReservarRequest request) {
        DiscountResponse discountResponse=descuentosService.validarDescuento(request.getId(),request.getHouseId(),request.getDiscountCode());

        if (discountResponse.getStatus()) {
            Reservar reservation = new Reservar();
            reservation.setName(request.getName());
            reservation.setLastname(request.getLastname());
            reservation.setPhoneNumber(request.getPhoneNumber());
            reservation.setAge(request.getAge());
            reservation.setId(request.getId());
            reservation.setHouseId(request.getHouseId());
            reservation.setDiscountCode(request.getDiscountCode());
            reservation.setStartDate(request.getStartDate());
            reservation.setEndDate(request.getEndDate());
            return reservarRepository.save(reservation);

        } else {
            throw new InvalidDiscountException("Invalid discount");
        }
    }

}
