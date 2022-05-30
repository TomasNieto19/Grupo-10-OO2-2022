package com.Grupo10OO22022.services;

import java.util.List;

import com.Grupo10OO22022.entities.Profesor;

public interface IProfesorService {

	public List<Profesor> getAll();
	
	public Profesor guardarProfesor(Profesor p);
	
	public void eliminarProfesor(int id);
	
	
	
}
