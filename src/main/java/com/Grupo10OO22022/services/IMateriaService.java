package com.Grupo10OO22022.services;

import java.util.List;

import com.Grupo10OO22022.entities.Materia;

public interface IMateriaService {
	
	public List<Materia> getAll();
	
	public Materia guardarMateria(Materia m);
	
	public void eliminarMateria(int id);
	
	

}
