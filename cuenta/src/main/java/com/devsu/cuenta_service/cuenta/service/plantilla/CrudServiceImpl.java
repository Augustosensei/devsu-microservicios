package com.devsu.cuenta_service.cuenta.service.plantilla;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devsu.cuenta_service.cuenta.repository.plantilla.IRepository;



public abstract class CrudServiceImpl<T, ID> implements ICrudService<T, ID> {


    public abstract IRepository<T, ID> getRepo();

	@Override
	public List<T> listarTodo() {
		return getRepo().findAll();
	}

	@Override
	public T obtenerPorId(final ID id) {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public T acciones(final T t) {
		return getRepo().save(t);
	}

	@Override
	public void eliminarPorId(final ID id) {
		getRepo().deleteById(id);
	}
}