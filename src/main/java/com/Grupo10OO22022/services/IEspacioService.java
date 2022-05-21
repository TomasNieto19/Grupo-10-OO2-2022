package com.Grupo10OO22022.services;

import java.time.LocalDate;

import com.Grupo10OO22022.entities.Aula;

public interface IEspacioService {

	
	public boolean agregarEspaciosParaUnDia(LocalDate fecha, Aula aula);
	
	public boolean agregarEspaciosEntreFechas(LocalDate fechaInicial, LocalDate fechaFinal, Aula aula);
	
	public boolean agregarEspaciosParaTodasLasAulas(LocalDate fechaInicial, LocalDate fechaFinal);
}
