package com.Grupo10OO22022.services;

import java.util.List;
import com.Grupo10OO22022.entities.Curso;

public interface ICursoService {


	// TRAER
	
	public List<Curso> listAll(String keyword);

	public Curso getById(int id);
	
	
	// GUARDAR/MODIFICAR
	
	public Curso guardarCurso(Curso curso);
	
	
	// VARIOS
	
	public void verificarPendiente(Curso curso);
}
