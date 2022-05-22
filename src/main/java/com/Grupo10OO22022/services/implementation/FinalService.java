package com.Grupo10OO22022.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo10OO22022.entities.Final;
import com.Grupo10OO22022.repositories.IFinalRepository;
import com.Grupo10OO22022.services.IFinalService;

@Service
public class FinalService implements IFinalService{
	@Autowired
	private IFinalRepository repositorio;
	
	@Override
	public List<Final> listaDeFinales() {
		return repositorio.findAll();
	}
	
	public Final guardarFinal(Final f) {
		return repositorio.save(f);
	}
}
