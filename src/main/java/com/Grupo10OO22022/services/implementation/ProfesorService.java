package com.Grupo10OO22022.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Grupo10OO22022.entities.Profesor;
import com.Grupo10OO22022.repositories.IProfesorRepository;
import com.Grupo10OO22022.services.IProfesorService;

@Service
public class ProfesorService implements IProfesorService {

	
	@Autowired
	@Qualifier("profesorRepository")
	IProfesorRepository profesorRepository;

	@Override
	public List<Profesor> getAll() {
		return profesorRepository.findAll();
	}

	@Override
	public Profesor guardarProfesor(Profesor p) {
		return profesorRepository.save(p);
	}

	@Override
	public void eliminarProfesor(int id) {
		profesorRepository.deleteById(id);
		
	}
	
}
