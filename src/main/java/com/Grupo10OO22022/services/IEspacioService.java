package com.Grupo10OO22022.services;

import java.time.LocalDate;
import java.util.List;

import com.Grupo10OO22022.entities.Aula;
import com.Grupo10OO22022.entities.Espacio;
import com.Grupo10OO22022.helpers.EspacioFiltros;

public interface IEspacioService {

	
	public boolean agregarEspaciosParaUnDia(LocalDate fecha, Aula aula);
	
	public boolean agregarEspaciosEntreFechas(LocalDate fechaInicial, LocalDate fechaFinal, Aula aula);
	
	public boolean agregarEspaciosParaTodasLasAulas(LocalDate fechaInicial, LocalDate fechaFinal);
	
	public Espacio getById(int id);
	
	public List<Espacio> getAll();
		
	public List<Espacio> getEntreFechas(LocalDate fechaInicial, LocalDate fechaFinal);
	
	public List<Espacio> traerPorFiltros(EspacioFiltros filtros);
	
	public void modificarEspacio(Espacio e);
}
