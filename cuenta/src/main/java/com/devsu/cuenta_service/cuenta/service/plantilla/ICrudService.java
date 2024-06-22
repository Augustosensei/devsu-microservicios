package com.devsu.cuenta_service.cuenta.service.plantilla;

import java.util.List;

public interface ICrudService<T, ID> {

	List<T> listarTodo();

	T obtenerPorId(final ID id);

	T acciones(final T t);

	void eliminarPorId(final ID id);

}
