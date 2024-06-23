package com.devsu.cuenta_service.cuenta.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsu.cuenta_service.cuenta.DTO.ReporteMovimientoDTO;
import com.devsu.cuenta_service.cuenta.client.IClienteClient;
import com.devsu.cuenta_service.cuenta.entities.Cuenta;
import com.devsu.cuenta_service.cuenta.entities.Movimiento;
import com.devsu.cuenta_service.cuenta.enums.TipoCuentaEnum;
import com.devsu.cuenta_service.cuenta.exception.FondosNoEncontradosException;
import com.devsu.cuenta_service.cuenta.repository.IMovimientoRepository;
import com.devsu.cuenta_service.cuenta.repository.plantilla.IRepository;
import com.devsu.cuenta_service.cuenta.service.ICuentaService;
import com.devsu.cuenta_service.cuenta.service.IMovimientoService;
import com.devsu.cuenta_service.cuenta.service.plantilla.CrudServiceImpl;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovimientoServiceImpl extends CrudServiceImpl<Movimiento, Integer> implements IMovimientoService {

	private IMovimientoRepository movimientoRepository;
	private ICuentaService cuentaService;
	private IClienteClient clienteClient;

	@Override
	public IRepository<Movimiento, Integer> getRepo() {
		return movimientoRepository;
	}

	@Override
	public void realizarMovimiento(Movimiento movimiento) {

		Cuenta cuenta = cuentaService.obtenerPorId(movimiento.getCuenta().getIdCuenta());

		if (cuenta.getIdCuenta() == null) {
			throw new IllegalArgumentException("La cuenta debe tener un ID válido antes de asociarla a un movimiento.");
		}

		BigDecimal saldoInicial = cuenta.getSaldoInicial() != null ? cuenta.getSaldoInicial() : BigDecimal.ZERO;
		BigDecimal nuevoSaldoCuenta = saldoInicial.add(movimiento.getValor());

		if (nuevoSaldoCuenta.compareTo(BigDecimal.ZERO) < 0) {
			throw new FondosNoEncontradosException("Saldo no disponible.");
		}

		cuenta.setSaldoInicial(nuevoSaldoCuenta);
		cuentaService.acciones(cuenta);

		LocalDate fechaActual = LocalDate.now();

		movimiento.setFecha(fechaActual);
		movimiento.setSaldo(nuevoSaldoCuenta);
		movimientoRepository.save(movimiento);

	}

	@Override
	public List<ReporteMovimientoDTO> listarMovimientosPorClienteYFecha(Integer idCliente, LocalDate fechaInicio,
			LocalDate fechaFin) {

		List<ReporteMovimientoDTO> listarMovimientos = new ArrayList<>();
		movimientoRepository.listarMovimientosPorClienteYFecha(idCliente, fechaInicio, fechaFin).forEach(consulta -> {
			Integer clienteId = (Integer) consulta[1];
			String nombreCliente = clienteClient.obtenerNombreCliente(clienteId);

			Byte tipoCuentaByte = (Byte) consulta[5];
			Integer tipoCuentaIndex = tipoCuentaByte.intValue();
			TipoCuentaEnum tipoCuentaEnum = TipoCuentaEnum.values()[tipoCuentaIndex];

			java.sql.Date fechaSql = (java.sql.Date) consulta[7];
			LocalDateTime fechaLocalDateTime = fechaSql.toLocalDate().atStartOfDay();
			String fechaFormateada = fechaLocalDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			ReporteMovimientoDTO reporteDTO = ReporteMovimientoDTO.builder().nombre(nombreCliente)
					.estado((Boolean) consulta[2]).numeroCuenta((Integer) consulta[3])
					.saldoInicial((BigDecimal) consulta[4]).tipo(tipoCuentaEnum.name()).fecha(fechaFormateada)
					.movimiento((BigDecimal) consulta[10]).saldoDisponible((BigDecimal) consulta[8]).build();

			listarMovimientos.add(reporteDTO);
		});

		return listarMovimientos;

	}
}
