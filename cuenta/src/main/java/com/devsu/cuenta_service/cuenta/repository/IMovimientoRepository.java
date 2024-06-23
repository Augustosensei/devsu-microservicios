package com.devsu.cuenta_service.cuenta.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devsu.cuenta_service.cuenta.entities.Movimiento;
import com.devsu.cuenta_service.cuenta.repository.plantilla.IRepository;

public interface IMovimientoRepository extends IRepository<Movimiento, Integer> {



        
        @Query(value = """
                select * from devsucuentadb.cuenta c 
                join devsucuentadb.movimientos m
                on m.cuenta_id = c.id_cuenta
                where m.fecha between :fechaInicio and :fechaFin
                and c.cliente_id = :idCliente
                """, nativeQuery = true)
        List<Object[]> listarMovimientosPorClienteYFecha(@Param("idCliente") Integer idCliente, 
                                                         @Param("fechaInicio") LocalDate fechaInicio, 
                                                         @Param("fechaFin") LocalDate fechaFin);

	
	
	/*
	
	  @Query(value = """
SELECT 
    c.*,
    m.*,
    CASE c.tipo_cuenta
        WHEN 'CORRIENTE' THEN 'CUENTA CORRIENTE'
        WHEN 'AHORRO' THEN 'CUENTA DE AHORRO'
        WHEN 'DEBITO' THEN 'CUENTA DE DEBITO'
        ELSE 'Desconocido'
    END AS tipo_cuenta_modificado
FROM 
    devsucuentadb.cuenta c
JOIN 
    devsucuentadb.movimientos m ON m.cuenta_id = c.id_cuenta
WHERE 
    m.fecha BETWEEN :fechaInicio AND :fechaFin
    AND c.cliente_id = :idCliente


              """, nativeQuery = true)
      List<Object[]> listarMovimientosPorClienteYFecha(@Param("idCliente") Integer idCliente, 
                                                       @Param("fechaInicio") LocalDate fechaInicio, 
                                                       @Param("fechaFin") LocalDate fechaFin);*/
}
