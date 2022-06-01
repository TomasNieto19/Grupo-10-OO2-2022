package com.Grupo10OO22022.services;

import java.util.List;
import com.Grupo10OO22022.entities.Final;


public interface IFinalService {
	
	public List<Final> listaDeFinales();
	
	public Final guardarFinal(Final f);
	
	public void eliminarFinal(int id);

	public List<Final> listAll(String keyword);
	
	public Final getById(int id);
	
	
}
