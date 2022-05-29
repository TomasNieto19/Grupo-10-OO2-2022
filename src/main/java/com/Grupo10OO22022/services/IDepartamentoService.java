package com.Grupo10OO22022.services;

import java.util.List;

import com.Grupo10OO22022.entities.Departamento;

public interface IDepartamentoService {
	
	public List<Departamento> listaDeTodosLosDepartamentos();
	public Departamento guardarDepartamento(Departamento d);
	public Departamento optenerDepartamentoPorId(int id);
	public Departamento actualizarDepartamento(Departamento d);
	public void eliminarDepartamento(int id);
}
