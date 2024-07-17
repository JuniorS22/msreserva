package com.example.pruebaTecnica.msreservar.repository;

import com.example.pruebaTecnica.msreservar.entity.Reservar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservarRepository extends JpaRepository<Reservar, String> {
}
