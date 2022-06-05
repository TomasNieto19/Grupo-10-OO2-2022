package com.Grupo10OO22022.services.implementation;


import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.Grupo10OO22022.entities.Curso;
import com.Grupo10OO22022.entities.Fecha;

import com.Grupo10OO22022.repositories.ICursoRepository;
import com.Grupo10OO22022.services.ICursoService;

@Service("cursoService")
public class CursoService implements ICursoService{

	
	@Autowired
	@Qualifier("cursoRepository")
	private ICursoRepository cursoRepository;
	
	
	@Override
	public List<Curso> listAll(String keyword) {

		if (keyword != null) {

			return cursoRepository.search(keyword);
		}

		return cursoRepository.findAll();
	}


	@Override

	public Curso guardarCurso(Curso curso) {
		return cursoRepository.save(curso);
	}


	@Override
	public void eliminarCurso(int id) {
		cursoRepository.deleteById(id);
		
	}


	@Override
	public Curso getById(int id) {
		return cursoRepository.getById(id);
	}



	@Override
	public void verificarPendiente(Curso curso) {
		List<Fecha> fechas = new ArrayList<Fecha>(curso.getFechas());
		int i=0;
		boolean completado = true;
		while ((completado)&&(i<fechas.size())) {
			if (fechas.get(i).getEspacioAsignado()==null)
				completado = false;
			i++;
		}
		if (completado) {
			curso.setPendiente(false);
			cursoRepository.save(curso);
		}
	}


	


}
