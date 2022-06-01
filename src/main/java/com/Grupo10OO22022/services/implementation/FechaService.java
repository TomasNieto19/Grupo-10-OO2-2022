package com.Grupo10OO22022.services.implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.Grupo10OO22022.entities.Fecha;
import com.Grupo10OO22022.repositories.IFechaRepository;
import com.Grupo10OO22022.services.IFechaService;

@Service
public class FechaService implements IFechaService{

	@Autowired
	private IFechaRepository fechaRepository;
	
	@Override
	public List<Fecha> getAll() {
		return fechaRepository.findAll();


	@Autowired
	@Qualifier("fechaRepository")
	IFechaRepository fechaRepository;
	
	@Override
	public Fecha getbyId(int id) {
		return fechaRepository.getById(id);
	}

	@Override
	public Fecha modificarFecha(Fecha fechaModificada) {
		return fechaRepository.save(fechaModificada);

	}

}
