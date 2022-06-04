package com.Grupo10OO22022.services;


import java.util.List;
import com.Grupo10OO22022.entities.Curso;
import com.Grupo10OO22022.models.CursoModel;

public interface ICursoService {

	
	public List<Curso> listAll(String keyword);
	
	
	public Curso guardarCurso(Curso curso);
	
	
	public void eliminarCurso(int id);

	public Curso getById(int id);

	
	public void verificarPendiente(Curso curso);

}
