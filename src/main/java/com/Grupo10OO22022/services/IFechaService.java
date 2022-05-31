package com.Grupo10OO22022.services;

import com.Grupo10OO22022.entities.Fecha;

public interface IFechaService {

	
	public Fecha getbyId(int id);
	
	public Fecha modificarFecha(Fecha fechaModificada);
	
}
