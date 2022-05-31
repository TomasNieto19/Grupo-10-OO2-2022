package com.Grupo10OO22022.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Grupo10OO22022.entities.Final;
import com.Grupo10OO22022.repositories.IFinalRepository;
import com.Grupo10OO22022.services.IFinalService;

@Service
public class FinalService implements IFinalService {
	@Autowired
	private IFinalRepository repositorio;

	@Override
	public List<Final> listAll(String keyword) {

		if (keyword != null) {

			return repositorio.search(keyword);
		}

		return repositorio.findAll();
	}

	@Override
	public List<Final> listaDeFinales() {
		return repositorio.findAll();
	}

	@Override
	public Final guardarFinal(Final f) {

		return repositorio.save(f);
	}

	@Override
	public Final obtenerFinalPorId(int id) {

		return repositorio.findById(id).get();
	}

	@Override
	public Final actualizarFinal(Final f) {
		return repositorio.save(f);
	}

	@Override
	public void eliminarFinal(int id) {
		repositorio.deleteById(id);
	}

	@Override
	public Final getById(int id) {
		return repositorio.getById(id) ;
	}

}
