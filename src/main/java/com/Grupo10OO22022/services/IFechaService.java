package com.Grupo10OO22022.services;


import java.util.List;

import com.Grupo10OO22022.entities.Fecha;

public interface IFechaService {
	
	public List<Fecha> getAll();
	
	public Fecha getbyId(int id);
	
	public Fecha modificarFecha(Fecha fechaModificada);
	
	public Fecha guardarFecha(Fecha f);

}
