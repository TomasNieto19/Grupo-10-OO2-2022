package com.Grupo10OO22022.services;


import java.util.List;

import com.Grupo10OO22022.entities.Fecha;

public interface IFechaService {
	
	public List<Fecha> getAll();

import com.Grupo10OO22022.entities.Fecha;

public interface IFechaService {

	
	public Fecha getbyId(int id);
	
	public Fecha modificarFecha(Fecha fechaModificada);
	

}