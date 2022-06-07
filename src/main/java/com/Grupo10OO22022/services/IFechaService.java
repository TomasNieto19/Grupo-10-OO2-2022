package com.Grupo10OO22022.services;

import java.util.List;
import com.Grupo10OO22022.entities.Fecha;

public interface IFechaService {

	// TRAER

	public List<Fecha> getAll();

	public Fecha getbyId(int id);

	// GUARDAR/MODIFICAR
	public Fecha guardar(Fecha fechaModificada);

}
