package com.Grupo10OO22022.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Grupo10OO22022.entities.Curso;
import com.Grupo10OO22022.repositories.ICursoRepository;
import com.Grupo10OO22022.services.ICursoService;

@Service("cursoService")
public class CursoService implements ICursoService{

	
	@Autowired
	@Qualifier("cursoRepository")
	private ICursoRepository cursoRepository;
	
	
	@Override
	public List<Curso> getAll() {

		return this.cursoRepository.findAll();
		
	}

}
