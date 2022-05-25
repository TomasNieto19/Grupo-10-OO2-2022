package com.Grupo10OO22022.services.implementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Grupo10OO22022.entities.Aula;
import com.Grupo10OO22022.entities.Espacio;
import com.Grupo10OO22022.repositories.IEspacioRepository;
import com.Grupo10OO22022.services.IAulaService;
import com.Grupo10OO22022.services.IEspacioService;

@Service
public class EspacioService implements IEspacioService {

	@Autowired
	@Qualifier("espacioRepository")
	private IEspacioRepository espacioRepository;
	
	@Autowired
	@Qualifier("aulaService")
	private IAulaService aulaService;
	

	@Override
	public boolean agregarEspaciosParaUnDia(LocalDate fecha, Aula aula) {
		espacioRepository.save(new Espacio(fecha, 'M', aula, true));
		espacioRepository.save(new Espacio(fecha, 'T', aula, true));
		espacioRepository.save(new Espacio(fecha, 'N', aula, true));
		return true;
	}



	@Override
	public boolean agregarEspaciosEntreFechas(LocalDate fechaInicial, LocalDate fechaFinal, Aula aula) {
		LocalDate fechaActual = fechaInicial;
		while (!fechaActual.isAfter(fechaFinal)) {
			agregarEspaciosParaUnDia(fechaActual, aula);
			fechaActual=fechaActual.plusDays(1);
		}
		return true;		
	}



	@Override
	public boolean agregarEspaciosParaTodasLasAulas(LocalDate fechaInicial, LocalDate fechaFinal) {
		List<Aula> aulas = aulaService.getAll(); 
		for (Aula a: aulas) {
			agregarEspaciosEntreFechas(fechaInicial, fechaFinal, a);
		}
		return true;
	}



	@Override
	public List<Espacio> getAll() {
		return espacioRepository.findAll();
	}

	
	
}
