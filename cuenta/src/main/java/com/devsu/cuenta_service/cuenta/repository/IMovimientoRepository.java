package com.devsu.cuenta_service.cuenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsu.cuenta_service.cuenta.entities.Cuenta;
import com.devsu.cuenta_service.cuenta.entities.Movimiento;
import com.devsu.cuenta_service.cuenta.repository.plantilla.IRepository;

public interface IMovimientoRepository extends IRepository<Movimiento, Integer> {

}
