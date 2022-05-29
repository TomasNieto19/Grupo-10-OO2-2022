package com.Grupo10OO22022.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo10OO22022.entities.Departamento;
import com.Grupo10OO22022.repositories.IDepartamentoRepository;
import com.Grupo10OO22022.services.IDepartamentoService;

@Service
public class DepartamentoService implements IDepartamentoService{

	@Autowired
	private IDepartamentoRepository departamentoRepositorio;
	
	@Override
	public List<Departamento> listaDeTodosLosDepartamentos() {
		
		return departamentoRepositorio.findAll();
	}

	@Override
	public Departamento guardarDepartamento(Departamento d) {
		
		return departamentoRepositorio.save(d);
	}

	@Override
	public Departamento optenerDepartamentoPorId(int id) {
		
		return departamentoRepositorio.findById(id).get();
	}

	@Override
	public Departamento actualizarDepartamento(Departamento d) {
		
		return departamentoRepositorio.save(d);
	}

	@Override
	public void eliminarDepartamento(int id) {
		departamentoRepositorio.deleteById(id);
		
	}

}
