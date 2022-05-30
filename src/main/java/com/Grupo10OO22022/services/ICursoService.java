package com.Grupo10OO22022.services;


import java.util.List;
import com.Grupo10OO22022.entities.Curso;

public interface ICursoService {

	
	public List<Curso> getAll();
	
	
	public Curso guardarCurso(Curso curso);
	
	
	public void eliminarCurso(int id);
}
