package com.Grupo10OO22022.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.Grupo10OO22022.entities.Perfil;
import com.Grupo10OO22022.repositories.IPerfilRepository;
import com.Grupo10OO22022.services.IPerfilService;

@Service("perfilService")
public class PerfilService implements IPerfilService{

	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;
	
	
	@Override
	public List<Perfil> getAll() {

		return this.perfilRepository.findAll();
	}


}
