package com.devsu.cuenta_service.cuenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsu.cuenta_service.cuenta.entities.Cuenta;

public interface ICuentaRepository extends JpaRepository<Cuenta, Integer>{

}
