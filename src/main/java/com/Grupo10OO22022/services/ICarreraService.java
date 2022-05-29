package com.Grupo10OO22022.services;

import java.util.List;

import com.Grupo10OO22022.entities.Carrera;


public interface ICarreraService {
	
	public List<Carrera> lista();
	public Carrera guardarCarrera(Carrera c);
	public void eliminarCarrera(int id);
}
