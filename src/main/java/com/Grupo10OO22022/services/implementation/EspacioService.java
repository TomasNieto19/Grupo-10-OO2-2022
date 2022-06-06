package com.Grupo10OO22022.services.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Grupo10OO22022.entities.Aula;
import com.Grupo10OO22022.entities.Espacio;
import com.Grupo10OO22022.helpers.EspacioFiltros;
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
	


	@Override
	public List<Espacio> getEntreFechas(LocalDate fechaInicial, LocalDate fechaFinal) {
		return espacioRepository.findByFechaBetween(fechaInicial, fechaFinal);
	}

	public List<Espacio> traerPorFiltros(EspacioFiltros filtros){
		
		List<Espacio> lista = this.getAll();
		List<Espacio> listaRemover = new ArrayList<>();
		
		for (Espacio e: lista) {
			//filtro por fecha inicial
			if (filtros.getFechaInicial()!=null)
				if (filtros.getFechaInicial().isAfter(e.getFecha()))
					listaRemover.add(e);	
			//filtro por fecha final
			if (filtros.getFechaFinal()!=null)
				if (filtros.getFechaFinal().isBefore(e.getFecha()))
					listaRemover.add(e);	
			//filtros por disponibilidad
			if (!filtros.isLibre()&&(e.isLibre())) 
				listaRemover.add(e);
			if (!filtros.isOcupado()&&(!e.isLibre())) 
				listaRemover.add(e);	
			//filtros por turno
			if (!filtros.isManiana()&&e.getTurno()=='M')
				listaRemover.add(e);
			if (!filtros.isTarde()&&e.getTurno()=='T')
				listaRemover.add(e);
			if (!filtros.isNoche()&&e.getTurno()=='N')
				listaRemover.add(e);
			//filtro por aulas
			if (!filtros.getAulas().isEmpty()) {
				if (!filtros.getAulas().contains(e.getAula()))
					listaRemover.add(e);
			}
		}
		lista.removeAll(listaRemover);
		return lista;
	}



	@Override
	public Espacio getById(int id) {
		return espacioRepository.getById(id);
	}



	@Override
	public void modificarEspacio(Espacio e) {
		espacioRepository.save(e);
	}



	
	
}
