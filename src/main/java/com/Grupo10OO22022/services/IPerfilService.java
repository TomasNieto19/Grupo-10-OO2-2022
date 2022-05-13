package com.Grupo10OO22022.services;

import java.util.List;

import com.Grupo10OO22022.entities.Perfil;
import com.Grupo10OO22022.models.PerfilModel;

public interface IPerfilService {

	
	public List<Perfil> getAll();
	
	
	public PerfilModel insertOrUpdate(PerfilModel perfilModel);
	
	
	
	
	
	
}
