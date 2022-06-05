package com.Grupo10OO22022.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Grupo10OO22022.entities.Materia;
import com.Grupo10OO22022.repositories.IMateriaRepository;
import com.Grupo10OO22022.services.IMateriaService;

@Service
public class MateriaService implements IMateriaService{

	@Autowired
	@Qualifier("materiaRepository")
	private IMateriaRepository materiaRepository;
	
	@Override
	public List<Materia> getAll() {
		return materiaRepository.findAll();
	}

}
