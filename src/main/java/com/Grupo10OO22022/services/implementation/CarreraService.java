package com.Grupo10OO22022.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo10OO22022.entities.Carrera;
import com.Grupo10OO22022.repositories.ICarreraRepository;
import com.Grupo10OO22022.services.ICarreraService;

@Service
public class CarreraService implements ICarreraService {

	@Autowired
	private ICarreraRepository carreraRepository;
	
	@Override
	public List<Carrera> lista() {
		
		return carreraRepository.findAll();
	}

	@Override
	public Carrera guardarCarrera(Carrera c) {
		return carreraRepository.save(c);
	}

	@Override
	public void eliminarCarrera(int id) {
		carreraRepository.deleteById(id);
		
	}

}
